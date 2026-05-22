<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/serveurs.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/healthcheck.css">

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Serveurs</h2>
      <p class="text-sm text-muted mt-1">Gérez l'infrastructure et les serveurs d'hébergement.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-serveur">
      <i data-lucide="server"></i>
      <span class="hide-mobile">Nouveau Serveur</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/admin/serveurs" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}" placeholder="Rechercher par IP, OS ou fournisseur" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/admin/serveurs">Réinitialiser</a>
    </c:if>
  </form>

  <c:if test="${not empty param.success}">
    <div class="alert alert-success">L'opération a été réalisée avec succès.</div>
  </c:if>
  <c:if test="${not empty erreur}">
    <div class="alert alert-danger"><c:out value="${erreur}" /></div>
  </c:if>

  <div class="card">
    <div class="table-responsive">
      <table class="data-table">
        <thead>
          <tr>
            <th>Adresse IP</th>
            <th>Caractéristiques</th>
            <th>Système d'Exploitation</th>
            <th>Environnements</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="serveurs-table-body">
          <c:choose>
            <c:when test="${not empty listeServeurs}">
              <c:forEach items="${listeServeurs}" var="serveur">
                <tr>
                  <td>
                    <div style="display: flex; align-items: center; gap: 8px;">
                      <span class="health-indicator status-pending" data-ip="${serveur.adressIP}"></span>
                      <i data-lucide="server" style="width: 16px; height: 16px; color: var(--primary);"></i>
                      <strong><c:out value="${serveur.adressIP}" /></strong>
                    </div>
                  </td>
                  <td>
                    <div style="display: flex; align-items: center; gap: 6px; flex-wrap: wrap;">
                      <c:if test="${not empty serveur.fournisseur}">
                        <span class="badge badge-outline"><c:out value="${serveur.fournisseur}" /></span>
                      </c:if>
                      <c:if test="${not empty serveur.cpuCores}">
                        <span class="badge badge-outline"><i data-lucide="cpu" style="width:12px; height:12px;"></i> <c:out value="${serveur.cpuCores}" /> Cœurs</span>
                      </c:if>
                      <c:if test="${not empty serveur.ramGb}">
                        <span class="badge badge-outline"><i data-lucide="memory-stick" style="width:12px; height:12px;"></i> <c:out value="${serveur.ramGb}" /> Go RAM</span>
                      </c:if>
                    </div>
                  </td>
                  <td><span class="badge badge-outline"><c:out value="${serveur.os}" /></span></td>
                  <td><span class="badge badge-outline"><c:out value="${serveur.nombreEnvironnements}" /></span></td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <button type="button" class="btn-icon btn-icon-sm edit-serveur-btn" title="Modifier"
                              data-serveur-id="${serveur.idServ}"
                              data-adressip="${serveur.adressIP}"
                              data-os="${serveur.os}"
                              data-cpu="${serveur.cpuCores}"
                              data-ram="${serveur.ramGb}"
                              data-fournisseur="${serveur.fournisseur}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-serveur-btn" title="Supprimer"
                              data-serveur-id="${serveur.idServ}"
                              data-serveur-ip="${serveur.adressIP}">
                        <i data-lucide="trash-2"></i>
                      </button>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="5" class="text-center text-muted" style="padding: 3rem;">
                  <i data-lucide="server" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucun serveur n'est enregistré dans le système.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script>const CONTEXT_PATH = '${pageContext.request.contextPath}';</script>
<script src="${pageContext.request.contextPath}/assets/js/healthcheck.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/serveur.js"></script>

<div id="serveur-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <div class="modal-header-content">
        <div class="modal-header-icon"><i data-lucide="server" id="serveur-modal-icon"></i></div>
        <div>
          <h2 id="serveur-modal-title">Ajouter un serveur</h2>
          <p id="serveur-modal-subtitle">Renseignez les informations du serveur.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-serveur-modal"><i data-lucide="x"></i></button>
    </header>
    
    <form id="serveur-modal-form" action="${pageContext.request.contextPath}/admin/serveurs" method="post">
      <input type="hidden" name="formAction" id="serveur-form-action" value="create" />
      <input type="hidden" name="serveurId" id="serveurId" />
      <div class="modal-body stack stack-sm">
        
        <div class="form-group">
          <label for="adressIP">Adresse IP *</label>
          <div class="input-with-icon">
            <i data-lucide="globe"></i>
            <input type="text" id="adressIP" name="adressIP" required class="form-control" placeholder="Ex: 192.168.1.100" />
          </div>
        </div>

        <div class="form-group">
          <label for="os">Système d'Exploitation (OS) *</label>
          <div class="input-with-icon">
            <i data-lucide="terminal"></i>
            <input type="text" id="os" name="os" required class="form-control" placeholder="Ex: Ubuntu 24.04 LTS" />
          </div>
        </div>

        <div class="form-group">
          <label for="fournisseur">Fournisseur (Optionnel)</label>
          <div class="input-with-icon">
            <i data-lucide="building"></i>
            <input type="text" id="fournisseur" name="fournisseur" class="form-control" placeholder="Ex: AWS, OVH, Azure" />
          </div>
        </div>

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;">
          <div class="form-group">
            <label for="cpuCores">Cœurs CPU (Optionnel)</label>
            <div class="input-with-icon">
              <i data-lucide="cpu"></i>
              <input type="number" id="cpuCores" name="cpuCores" min="1" class="form-control" placeholder="Ex: 4" />
            </div>
          </div>
          <div class="form-group">
            <label for="ramGb">RAM en Go (Optionnel)</label>
            <div class="input-with-icon">
              <i data-lucide="memory"></i>
              <input type="number" id="ramGb" name="ramGb" min="1" class="form-control" placeholder="Ex: 16" />
            </div>
          </div>
        </div>

      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-serveur-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="serveur-modal-submit">Enregistrer</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-serveur-modal" class="modal-overlay" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-serveur-modal"><i data-lucide="x"></i></button>
    </header>
    <form id="delete-serveur-form" action="${pageContext.request.contextPath}/admin/serveurs" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="serveurId" id="delete-serveur-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer le serveur <strong id="delete-serveur-ip"></strong> ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="delete-serveur-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>