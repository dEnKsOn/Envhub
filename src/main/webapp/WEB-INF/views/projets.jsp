<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/projets.css">

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Projets</h2>
      <p class="text-sm text-muted mt-1">Gérez vos projets, leur avancement et leurs environnements.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-projet">
      <i data-lucide="folder-plus"></i>
      <span class="hide-mobile">Nouveau Projet</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/projets" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}" placeholder="Rechercher par nom de projet ou client" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/projets">Réinitialiser</a>
    </c:if>
  </form>

  <div id="no-results-message" class="alert alert-danger search-result-message" style="display: none;">
    <div>
      <strong>Projet introuvable.</strong>
      <div>Aucun résultat pour "<span id="no-results-query"></span>".</div>
    </div>
    <button type="button" class="btn btn-primary open-projet-modal">Créer un projet</button>
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
            <th>Projet</th>
            <th>Client</th>
            <th>Progression</th>
            <th>Environnements</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="projets-table-body">
          <c:choose>
            <c:when test="${not empty listeProjets}">
              <c:forEach items="${listeProjets}" var="projet">
                <tr>
                  <td class="text-capitalize" style="font-weight: 500;">
                    <div style="display: flex; align-items: center; gap: 8px;">
                      <i data-lucide="folder" style="width: 16px; height: 16px; color: var(--primary);"></i>
                      <c:out value="${projet.nomProjet}" />
                    </div>
                  </td>
                  <td>
                    <c:out value="${projet.entrepriseClient}" />
                  </td>
                  <td>
                    <div class="progress-wrapper stack stack-xs">
                        <div style="display: flex; justify-content: space-between; align-items: center; font-size: 0.75rem;">
                            <span class="badge-status ${projet.statutProjet}">
                                <c:choose>
                                    <c:when test="${projet.statutProjet == 'EN_COURS'}">En cours</c:when>
                                    <c:when test="${projet.statutProjet == 'EN_PAUSE'}">En pause</c:when>
                                    <c:when test="${projet.statutProjet == 'LIVRE'}">Livré</c:when>
                                    <c:when test="${projet.statutProjet == 'ANNULE'}">Annulé</c:when>
                                    <c:otherwise><c:out value="${projet.statutProjet}"/></c:otherwise>
                                </c:choose>
                            </span>
                            <span style="font-weight: 500; color: var(--text-muted);"><c:out value="${projet.pourcentageAvancement}"/>%</span>
                        </div>
                        <div class="progress-container">
                            <div class="progress-bar" style="width: ${projet.pourcentageAvancement}%;"></div>
                        </div>
                    </div>
                  </td>
                  <td>
                    <span class="badge badge-outline" title="${projet.nombreEnvironnements} environnement(s) lié(s)">
                      <c:out value="${projet.nombreEnvironnements}" />
                    </span>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <a href="${pageContext.request.contextPath}/admin/projets/details?id=${projet.idProjet}" class="btn-icon btn-icon-sm" title="Détails" style="color: var(--text-main);">
                        <i data-lucide="eye"></i>
                      </a>
                      <button type="button" class="btn-icon btn-icon-sm edit-projet-btn" title="Modifier"
                              data-projet-id="${projet.idProjet}"
                              data-nom="${projet.nomProjet}"
                              data-client="${projet.idClient}"
                              data-statut="${projet.statutProjet}"
                              data-avancement="${projet.pourcentageAvancement}"
                              data-date-lancement="<fmt:formatDate value="${projet.dateLancement}" pattern="yyyy-MM-dd"/>"
                              data-date-livraison="<fmt:formatDate value="${projet.dateLivraisonEstimee}" pattern="yyyy-MM-dd"/>"
                              data-description="${projet.descriptionTech}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-projet-btn" title="Supprimer"
                              data-projet-id="${projet.idProjet}"
                              data-projet-name="${projet.nomProjet}">
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
                  <i data-lucide="folder-open" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucun projet n'est enregistré dans le système.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="projet-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="folder" id="projet-modal-icon"></i>
        </div>
        <div>
          <h2 id="projet-modal-title">Ajouter un projet</h2>
          <p id="projet-modal-subtitle" class="text-muted text-sm">Veuillez renseigner les informations du projet.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-projet-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    
    <form id="projet-modal-form" action="${pageContext.request.contextPath}/projets" method="post">
      <input type="hidden" name="formAction" id="projet-form-action" value="create" />
      <input type="hidden" name="projetId" id="projetId" />
      <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto;">
        
        <div class="form-group">
          <label for="nom">Nom du projet *</label>
          <div class="input-with-icon">
            <i data-lucide="folder"></i>
            <input type="text" id="nom" name="nom" required class="form-control" placeholder="Ex: EnvHub Refonte" />
          </div>
        </div>

        <div class="form-group">
          <label for="client">Client associé *</label>
          <select id="client" name="client" required class="form-control">
            <option value="">Sélectionnez un client...</option>
            <c:forEach items="${listeClients}" var="client">
                <option value="${client.idClient}">${client.entrepriseClient} (${client.nomClient})</option>
            </c:forEach>
          </select>
        </div>

        <div class="grid grid-2" id="status-progress-group">
            <div class="form-group">
                <label for="statut">Statut *</label>
                <select id="statut" name="statut" class="form-control">
                    <option value="EN_COURS">En cours</option>
                    <option value="EN_PAUSE">En pause</option>
                    <option value="LIVRE">Livré</option>
                    <option value="ANNULE">Annulé</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="avancement">Progression (%) *</label>
                <div class="input-with-icon">
                    <i data-lucide="percent"></i>
                    <input type="number" id="avancement" name="avancement" class="form-control" min="0" max="100" value="0" />
                </div>
            </div>
        </div>

        <div class="grid grid-2">
          <div class="form-group" id="date-lancement-group">
            <label for="dateLancement">Date de lancement *</label>
            <div class="input-with-icon">
              <i data-lucide="calendar"></i>
              <input type="date" id="dateLancement" name="dateLancement" class="form-control" />
            </div>
          </div>
          <div class="form-group">
            <label for="dateLivraison">Date de livraison estimée</label>
            <div class="input-with-icon">
              <i data-lucide="calendar"></i>
              <input type="date" id="dateLivraison" name="dateLivraison" class="form-control" />
            </div>
          </div>
        </div>
        
        <div class="form-group">
          <label for="description">Description technique</label>
          <textarea id="description" name="description" class="form-control" rows="3" placeholder="Informations techniques, stack, contexte..."></textarea>
        </div>

      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-projet-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="projet-modal-submit">Enregistrer le projet</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-projet-modal" class="modal-overlay" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-projet-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="delete-projet-form" action="${pageContext.request.contextPath}/projets" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="projetId" id="delete-projet-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer le projet <strong id="delete-projet-name"></strong> ?</p>
        <p class="text-sm text-red-500 mt-2">Attention, cela pourrait supprimer les environnements liés si une contrainte en cascade est activée.</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn" style="background: transparent; border: 1px solid var(--border-light); color: var(--text-main);" id="delete-projet-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>