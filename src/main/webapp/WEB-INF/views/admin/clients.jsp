<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/clients.css">

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Clients</h2>
      <p class="text-sm text-muted mt-1">Gérez les informations des clients et leurs entreprises.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-client">
      <i data-lucide="briefcase"></i>
      <span class="hide-mobile">Nouveau Client</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/clients" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}" placeholder="Rechercher par entreprise, nom ou prénom" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/clients">Réinitialiser</a>
    </c:if>
  </form>

  <div id="no-results-message" class="alert alert-danger search-result-message" style="display: none;">
    <div>
      <strong>Client introuvable.</strong>
      <div>Aucun résultat pour "<span id="no-results-query"></span>".</div>
    </div>
    <button type="button" class="btn btn-primary open-client-modal">Ajouter un client</button>
  </div>

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
            <th>Entreprise</th>
            <th>Représentant</th>
            <th>Projets Associés</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="clients-table-body">
          <c:choose>
            <c:when test="${not empty listeClients}">
              <c:forEach items="${listeClients}" var="client">
                <tr>
                  <td class="text-capitalize">
                    <div style="display: flex; align-items: center; gap: 8px;">
                      <i data-lucide="briefcase" style="width: 16px; height: 16px; color: var(--primary);"></i>
                      <c:out value="${client.entrepriseClient}" />
                    </div>
                  </td>
                  <td class="text-capitalize">
                    <c:out value="${client.nomClient}" />
                    <c:if test="${not empty client.prenomClient}">
                      <c:out value=" ${client.prenomClient}" />
                    </c:if>
                  </td>
                  <td>
                    <span class="badge badge-outline">
                      <c:out value="${client.nombreProjets}" />
                    </span>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <button type="button" class="btn-icon btn-icon-sm edit-client-btn" title="Modifier"
                              data-client-id="${client.idClient}"
                              data-entreprise="${client.entrepriseClient}"
                              data-nom="${client.nomClient}"
                              data-prenom="${client.prenomClient}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-client-btn" title="Supprimer"
                              data-client-id="${client.idClient}"
                              data-client-name="${client.entrepriseClient}">
                        <i data-lucide="trash-2"></i>
                      </button>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="4" class="text-center text-muted" style="padding: 3rem;">
                  <i data-lucide="briefcase" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucun client n'est enregistré dans le système.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="client-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="briefcase" id="client-modal-icon"></i>
        </div>
        <div>
          <h2 id="client-modal-title">Ajouter un client</h2>
          <p id="client-modal-subtitle">Veuillez renseigner les informations du client.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-client-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    
    <form id="client-modal-form" action="${pageContext.request.contextPath}/clients" method="post">
      <input type="hidden" name="formAction" id="client-form-action" value="create" />
      <input type="hidden" name="clientId" id="clientId" />
      <div class="modal-body stack stack-sm">
        
        <div class="form-group">
          <label for="entreprise">Entreprise</label>
          <div class="input-with-icon">
            <i data-lucide="building"></i>
            <input type="text" id="entreprise" name="entreprise" required class="form-control" placeholder="Ex: EnvHub Corp" />
          </div>
        </div>

        <div class="grid grid-2">
          <div class="form-group">
            <label for="nom">Nom du représentant</label>
            <div class="input-with-icon">
              <i data-lucide="user"></i>
              <input type="text" id="nom" name="nom" required class="form-control" placeholder="Ex: Dupont" />
            </div>
          </div>
          <div class="form-group">
            <label for="prenom">Prénom du représentant</label>
            <div class="input-with-icon">
              <i data-lucide="user"></i>
              <input type="text" id="prenom" name="prenom" class="form-control" placeholder="Ex: Jean (Optionnel)" />
            </div>
          </div>
        </div>

      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-client-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="client-modal-submit">Enregistrer le client</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-client-modal" class="modal-overlay" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-client-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="delete-client-form" action="${pageContext.request.contextPath}/clients" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="clientId" id="delete-client-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer le client <strong id="delete-client-name"></strong> ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn" style="background: transparent; border: 1px solid var(--border-light); color: var(--text-main);" id="delete-client-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>