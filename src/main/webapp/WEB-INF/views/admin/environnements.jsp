<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="stack stack-lg environnements-page">

  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Environnements</h2>
      <p class="text-sm text-muted mt-1">Vue transversale de tous les environnements de l'organisation.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-env">
      <i data-lucide="plus"></i>
      <span class="hide-mobile">Nouvel Environnement</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/admin/environnements" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}"
             placeholder="Rechercher par projet, adresse IP ou type d'environnement" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/admin/environnements">Réinitialiser</a>
    </c:if>
  </form>

  <div id="no-results-message" class="alert alert-danger search-result-message" style="display: none;">
    <div>
      <strong>Environnement introuvable.</strong>
      <div>Aucun résultat pour « <span id="no-results-query"></span> ».</div>
    </div>
    <button type="button" class="btn btn-primary open-env-modal">Créer un environnement</button>
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
            <th>Type</th>
            <th>Hébergement</th>
            <th>Base de données</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="environnements-table-body">
          <c:choose>
            <c:when test="${not empty listeEnvironnements}">
              <c:forEach items="${listeEnvironnements}" var="env">
                <tr>
                  <td>
                    <div class="env-projet-cell">
                      <i data-lucide="folder"></i>
                      <c:out value="${env.nomProjet}" />
                    </div>
                  </td>
                  <td>
                    <span class="env-badge env-badge-${env.typeEnv}">
                      <c:choose>
                        <c:when test="${env.typeEnv == 'LOCAL'}">Local</c:when>
                        <c:when test="${env.typeEnv == 'DEVELOPPEMENT'}">Développement</c:when>
                        <c:when test="${env.typeEnv == 'STAGING'}">Staging</c:when>
                        <c:when test="${env.typeEnv == 'PRODUCTION'}">Production</c:when>
                        <c:otherwise><c:out value="${env.typeEnv}"/></c:otherwise>
                      </c:choose>
                    </span>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${not empty env.serveur and not empty env.serveur.adressIP}">
                        <c:out value="${env.serveur.adressIP}" />
                      </c:when>
                      <c:otherwise>
                        <span class="env-host-empty">Aucun serveur</span>
                      </c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${not empty env.nomBaseDeDonnees}">
                        <code class="env-db-name"><c:out value="${env.nomBaseDeDonnees}" /></code>
                      </c:when>
                      <c:otherwise><span class="text-muted">—</span></c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <a href="${pageContext.request.contextPath}/admin/environnements/details?id=${env.idEnv}"
                         class="btn-icon btn-icon-sm" title="Gérer la stack">
                        <i data-lucide="cpu"></i>
                      </a>
                      <button type="button" class="btn-icon btn-icon-sm edit-env-btn" title="Modifier"
                              data-env-id="${env.idEnv}"
                              data-projet="${env.idProjet}"
                              data-type="${env.typeEnv}"
                              data-serveur="${env.idServ}"
                              data-nom-base="${env.nomBaseDeDonnees}"
                              data-url-front="${env.urlFront}"
                              data-url-back="${env.urlBack}"
                              data-notes="${env.notes}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-env-btn" title="Supprimer"
                              data-env-id="${env.idEnv}"
                              data-env-label="${env.nomProjet} — ${env.typeEnv}">
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
                  <i data-lucide="network" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucun environnement n'est enregistré dans le système.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="network" id="env-modal-icon"></i>
        </div>
        <div>
          <h2 id="env-modal-title">Ajouter un environnement</h2>
          <p id="env-modal-subtitle" class="text-muted text-sm">Renseignez les informations de l'environnement.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-env-modal">
        <i data-lucide="x"></i>
      </button>
    </header>

    <form id="env-modal-form" action="${pageContext.request.contextPath}/admin/environnements" method="post">
      <input type="hidden" name="formAction" id="env-form-action" value="create" />
      <input type="hidden" name="envId" id="envId" />
      <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto;">

        <div class="form-group">
          <label for="projet">Projet associé *</label>
          <select id="projet" name="projet" required class="form-control">
            <option value="">Sélectionnez un projet...</option>
            <c:forEach items="${listeProjets}" var="p">
              <option value="${p.idProjet}"><c:out value="${p.nomProjet}" /></option>
            </c:forEach>
          </select>
        </div>

        <div class="grid grid-2">
          <div class="form-group">
            <label for="typeEnv">Type d'environnement *</label>
            <select id="typeEnv" name="typeEnv" required class="form-control">
              <option value="DEVELOPPEMENT">Développement</option>
              <option value="STAGING">Staging</option>
              <option value="PRODUCTION">Production</option>
              <option value="LOCAL">Local</option>
            </select>
          </div>
          <div class="form-group">
            <label for="serveur">Serveur hôte</label>
            <select id="serveur" name="serveur" class="form-control">
              <option value="">Aucun serveur</option>
              <c:forEach items="${listeServeurs}" var="s">
                <option value="${s.idServ}">
                  <c:out value="${s.adressIP}" /> (<c:out value="${s.os}" />)
                </option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="form-group">
          <label for="nomBaseDeDonnees">Nom de la base de données</label>
          <div class="input-with-icon">
            <i data-lucide="database"></i>
            <input type="text" id="nomBaseDeDonnees" name="nomBaseDeDonnees" class="form-control"
                   placeholder="Ex: envhub_prod" />
          </div>
        </div>

        <div class="grid grid-2">
          <div class="form-group">
            <label for="urlFront">URL Front</label>
            <div class="input-with-icon">
              <i data-lucide="monitor"></i>
              <input type="url" id="urlFront" name="urlFront" class="form-control" placeholder="https://..." />
            </div>
          </div>
          <div class="form-group">
            <label for="urlBack">URL Back / API</label>
            <div class="input-with-icon">
              <i data-lucide="plug"></i>
              <input type="url" id="urlBack" name="urlBack" class="form-control" placeholder="https://api..." />
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="notes">Notes d'infrastructure</label>
          <textarea id="notes" name="notes" class="form-control" rows="3"
                    placeholder="Informations complémentaires, accès VPN, certificats..."></textarea>
        </div>

      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-env-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="env-modal-submit">Enregistrer</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-env-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="delete-env-form" action="${pageContext.request.contextPath}/admin/environnements" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="envId" id="delete-env-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer l'environnement <strong id="delete-env-label"></strong> ?</p>
        <p class="text-sm text-red-500 mt-2">Les versions de technologies liées seront également supprimées.</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn" style="background: transparent; border: 1px solid var(--border-light); color: var(--text-main);" id="delete-env-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>
