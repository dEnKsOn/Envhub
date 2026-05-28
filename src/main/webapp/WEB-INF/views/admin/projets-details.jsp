<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="stack stack-lg projet-details-page">

  <div class="flex items-center justify-between gap-4 wrap projet-details-toolbar">
    <div>
      <a href="${pageContext.request.contextPath}/projets" class="back-link text-sm text-muted">
        <i data-lucide="arrow-left"></i>
        Retour aux projets
      </a>
    </div>
    <c:if test="${canEditProjet}">
      <button type="button" class="btn btn-secondary" id="btn-edit-projet-details">
        <i data-lucide="edit-2"></i>
        <span class="hide-mobile">Modifier le projet</span>
      </button>
    </c:if>
  </div>

  <c:if test="${not empty param.success}">
    <div class="alert alert-success">L'opération a été réalisée avec succès.</div>
  </c:if>
  <c:if test="${not empty erreur}">
    <div class="alert alert-danger"><c:out value="${erreur}" /></div>
  </c:if>

  <div class="projet-details-grid">

    <div class="projet-details-main stack stack-lg">

      <header class="card projet-header-card">
        <div class="projet-header-top">
          <div class="projet-header-title">
            <i data-lucide="folder" class="projet-header-icon"></i>
            <div>
              <h1 class="projet-title"><c:out value="${projet.nomProjet}" /></h1>
              <p class="text-sm text-muted mt-1">
                Client : <strong><c:out value="${projet.entrepriseClient}" /></strong>
                <c:if test="${not empty projet.nomClient}">
                  — <c:out value="${projet.nomClient}" />
                </c:if>
              </p>
            </div>
          </div>
          <span class="badge-status ${projet.statutProjet}">
            <c:choose>
              <c:when test="${projet.statutProjet == 'EN_COURS'}">En cours</c:when>
              <c:when test="${projet.statutProjet == 'EN_PAUSE'}">En pause</c:when>
              <c:when test="${projet.statutProjet == 'LIVRE'}">Livré</c:when>
              <c:when test="${projet.statutProjet == 'ANNULE'}">Annulé</c:when>
              <c:otherwise><c:out value="${projet.statutProjet}"/></c:otherwise>
            </c:choose>
          </span>
        </div>

        <div class="progress-wrapper stack stack-xs mt-4">
          <div class="flex items-center justify-between text-sm">
            <span class="text-muted">Avancement</span>
            <span style="font-weight: 600;"><c:out value="${projet.pourcentageAvancement}"/>%</span>
          </div>
          <div class="progress-container">
            <div class="progress-bar" style="width: ${projet.pourcentageAvancement}%;"></div>
          </div>
        </div>

        <c:if test="${not empty projet.descriptionTech}">
          <p class="projet-description text-sm mt-4"><c:out value="${projet.descriptionTech}" /></p>
        </c:if>

        <div class="projet-dates grid grid-2 mt-4">
          <div class="projet-date-item">
            <span class="text-xs text-muted">Date de lancement</span>
            <p class="text-sm" style="font-weight: 500; margin: 4px 0 0;">
              <fmt:formatDate value="${projet.dateLancement}" pattern="dd/MM/yyyy" />
            </p>
          </div>
          <c:if test="${not empty projet.dateLivraisonEstimee}">
            <div class="projet-date-item">
              <span class="text-xs text-muted">Livraison estimée</span>
              <p class="text-sm" style="font-weight: 500; margin: 4px 0 0;">
                <fmt:formatDate value="${projet.dateLivraisonEstimee}" pattern="dd/MM/yyyy" />
              </p>
            </div>
          </c:if>
        </div>
      </header>

      <section class="card stack stack-sm">
        <div class="flex items-center justify-between">
          <h2 class="section-title" style="margin: 0;">Environnements</h2>
          <span class="badge badge-outline">
            <c:out value="${projet.nombreEnvironnements}" /> environnement(s)
          </span>
        </div>

        <div class="table-responsive env-table-wrapper">
          <table class="data-table env-table">
            <thead>
              <tr>
                <th>Type</th>
                <th>Serveur hôte</th>
                <th>Points d'accès</th>
                <th>Base de données</th>
              </tr>
            </thead>
            <tbody>
              <c:choose>
                <c:when test="${not empty environnements}">
                  <c:forEach items="${environnements}" var="env">
                    <tr>
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
                            <span class="env-server-host">
                              <i data-lucide="server" class="env-server-icon"></i>
                              <span>
                                <c:out value="${env.serveur.adressIP}" />
                                <c:if test="${not empty env.serveur.os}">
                                  <span class="text-muted"> (<c:out value="${env.serveur.os}" />)</span>
                                </c:if>
                              </span>
                            </span>
                          </c:when>
                          <c:otherwise>
                            <span class="env-server-empty">Aucun serveur associé</span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                      <td>
                        <div class="env-access-links">
                          <c:choose>
                            <c:when test="${not empty env.urlFront}">
                              <a href="<c:out value='${env.urlFront}'/>" target="_blank" rel="noopener noreferrer"
                                 class="env-access-btn env-access-btn-front" title="Ouvrir le front-end">
                                <i data-lucide="monitor"></i>
                                <span>Front</span>
                              </a>
                            </c:when>
                            <c:otherwise>
                              <span class="env-access-btn is-disabled" title="URL front non renseignée">
                                <i data-lucide="monitor"></i>
                                <span>Front</span>
                              </span>
                            </c:otherwise>
                          </c:choose>
                          <c:choose>
                            <c:when test="${not empty env.urlBack}">
                              <a href="<c:out value='${env.urlBack}'/>" target="_blank" rel="noopener noreferrer"
                                 class="env-access-btn env-access-btn-back" title="Ouvrir l'API / back-end">
                                <i data-lucide="plug"></i>
                                <span>API/Back</span>
                              </a>
                            </c:when>
                            <c:otherwise>
                              <span class="env-access-btn is-disabled" title="URL back non renseignée">
                                <i data-lucide="plug"></i>
                                <span>API/Back</span>
                              </span>
                            </c:otherwise>
                          </c:choose>
                        </div>
                      </td>
                      <td>
                        <c:choose>
                          <c:when test="${not empty env.nomBaseDeDonnees}">
                            <code class="env-db-name"><c:out value="${env.nomBaseDeDonnees}" /></code>
                          </c:when>
                          <c:otherwise>
                            <span class="text-muted">—</span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <tr>
                    <td colspan="4" class="text-center text-muted" style="padding: 2rem;">
                      Aucun environnement n'est rattaché à ce projet.
                    </td>
                  </tr>
                </c:otherwise>
              </c:choose>
            </tbody>
          </table>
        </div>
      </section>
    </div>

    <aside class="projet-details-sidebar stack stack-lg">
      <section class="card stack stack-md equipe-card">
        <div class="flex items-center justify-between">
          <h2 class="section-title" style="margin: 0;">Équipe</h2>
          <c:if test="${canManageTeam}">
            <button type="button" class="btn btn-primary btn-sm" id="btn-add-member">
              <i data-lucide="user-plus"></i>
              <span class="hide-mobile">Ajouter</span>
            </button>
          </c:if>
        </div>

        <c:set var="hasChef" value="false" />
        <c:forEach items="${equipe}" var="affectation">
          <c:if test="${affectation.roleProjet == 'CHEF_PROJET'}">
            <c:set var="hasChef" value="true" />
          </c:if>
        </c:forEach>

        <c:if test="${hasChef}">
          <div class="equipe-section">
            <h3 class="equipe-section-label">
              <i data-lucide="crown"></i>
              Chef de Projet
            </h3>
            <ul class="equipe-list">
              <c:forEach items="${equipe}" var="affectation">
                <c:if test="${affectation.roleProjet == 'CHEF_PROJET'}">
                  <li class="equipe-member equipe-member-chef">
                    <div class="equipe-member-info">
                      <div class="equipe-avatar equipe-avatar-chef" title="Chef de Projet">
                        <i data-lucide="crown"></i>
                      </div>
                      <div>
                        <p class="equipe-member-name">
                          <c:out value="${affectation.utilisateur.prenomUser}" />
                          <c:out value="${affectation.utilisateur.nomUser}" />
                          <span class="badge badge-chef">Chef</span>
                        </p>
                        <p class="text-xs text-muted"><c:out value="${affectation.utilisateur.email}" /></p>
                      </div>
                    </div>
                    <c:if test="${canManageTeam}">
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 remove-member-btn"
                              title="Retirer du projet"
                              data-member-id="${affectation.utilisateur.idUser}"
                              data-member-name="${affectation.utilisateur.prenomUser} ${affectation.utilisateur.nomUser}">
                        <i data-lucide="trash-2"></i>
                      </button>
                    </c:if>
                  </li>
                </c:if>
              </c:forEach>
            </ul>
          </div>
        </c:if>

        <div class="equipe-section">
          <h3 class="equipe-section-label">
            <i data-lucide="code-2"></i>
            Développeurs
          </h3>
          <ul class="equipe-list">
            <c:set var="hasDevs" value="false" />
            <c:forEach items="${equipe}" var="affectation">
              <c:if test="${affectation.roleProjet == 'DEVELOPPEUR'}">
                <c:set var="hasDevs" value="true" />
                <li class="equipe-member">
                  <div class="equipe-member-info">
                    <div class="equipe-avatar">
                      <i data-lucide="user"></i>
                    </div>
                    <div>
                      <p class="equipe-member-name">
                        <c:out value="${affectation.utilisateur.prenomUser}" />
                        <c:out value="${affectation.utilisateur.nomUser}" />
                      </p>
                      <p class="text-xs text-muted"><c:out value="${affectation.utilisateur.email}" /></p>
                    </div>
                  </div>
                  <c:if test="${canManageTeam}">
                    <button type="button" class="btn-icon btn-icon-sm text-red-500 remove-member-btn"
                            title="Retirer du projet"
                            data-member-id="${affectation.utilisateur.idUser}"
                            data-member-name="${affectation.utilisateur.prenomUser} ${affectation.utilisateur.nomUser}">
                      <i data-lucide="trash-2"></i>
                    </button>
                  </c:if>
                </li>
              </c:if>
            </c:forEach>
            <c:if test="${not hasDevs}">
              <li class="text-sm text-muted equipe-empty">Aucun développeur affecté.</li>
            </c:if>
          </ul>
        </div>

        <c:if test="${empty equipe}">
          <p class="text-sm text-muted text-center" style="padding: 1rem 0;">
            Aucun membre n'est affecté à ce projet.
          </p>
        </c:if>

        <c:if test="${canManageTeam}">
          <button type="button" class="btn btn-secondary btn-block mt-2" id="btn-manage-team">
            <i data-lucide="users"></i>
            Gérer l'équipe
          </button>
        </c:if>
      </section>
    </aside>
  </div>
</div>

<c:if test="${canEditProjet}">
<div id="edit-projet-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="folder"></i>
        </div>
        <div>
          <h2>Modifier le projet</h2>
          <p class="text-muted text-sm">Mettez à jour les informations de ce projet.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-edit-projet-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/projets/details" method="post">
      <input type="hidden" name="formAction" value="update" />
      <input type="hidden" name="projetId" value="${projet.idProjet}" />
      <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto;">
        <div class="form-group">
          <label for="nom">Nom du projet *</label>
          <input type="text" id="nom" name="nom" required class="form-control" value="<c:out value='${projet.nomProjet}' />" />
        </div>
        <div class="form-group">
          <label for="client">Client associé *</label>
          <select id="client" name="client" required class="form-control">
            <c:forEach items="${listeClients}" var="client">
              <option value="${client.idClient}" <c:if test="${client.idClient == projet.idClient}">selected</c:if>>
                <c:out value="${client.entrepriseClient}" /> (<c:out value="${client.nomClient}" />)
              </option>
            </c:forEach>
          </select>
        </div>
        <div class="grid grid-2">
          <div class="form-group">
            <label for="statut">Statut *</label>
            <select id="statut" name="statut" class="form-control">
              <option value="EN_COURS" <c:if test="${projet.statutProjet == 'EN_COURS'}">selected</c:if>>En cours</option>
              <option value="EN_PAUSE" <c:if test="${projet.statutProjet == 'EN_PAUSE'}">selected</c:if>>En pause</option>
              <option value="LIVRE" <c:if test="${projet.statutProjet == 'LIVRE'}">selected</c:if>>Livré</option>
              <option value="ANNULE" <c:if test="${projet.statutProjet == 'ANNULE'}">selected</c:if>>Annulé</option>
            </select>
          </div>
          <div class="form-group">
            <label for="avancement">Progression (%) *</label>
            <input type="number" id="avancement" name="avancement" class="form-control" min="0" max="100"
                   value="${projet.pourcentageAvancement}" />
          </div>
        </div>
        <div class="grid grid-2">
          <div class="form-group">
            <label for="dateLancement">Date de lancement *</label>
            <input type="date" id="dateLancement" name="dateLancement" class="form-control"
                   value="<fmt:formatDate value='${projet.dateLancement}' pattern='yyyy-MM-dd'/>" />
          </div>
          <div class="form-group">
            <label for="dateLivraison">Date de livraison estimée</label>
            <input type="date" id="dateLivraison" name="dateLivraison" class="form-control"
                   value="<fmt:formatDate value='${projet.dateLivraisonEstimee}' pattern='yyyy-MM-dd'/>" />
          </div>
        </div>
        <div class="form-group">
          <label for="description">Description technique</label>
          <textarea id="description" name="description" class="form-control" rows="3"><c:out value="${projet.descriptionTech}" /></textarea>
        </div>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-edit-projet-modal">Annuler</button>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
      </div>
    </form>
  </div>
</div>
</c:if>

<c:if test="${canManageTeam}">
<div id="add-member-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="user-plus"></i>
        </div>
        <div>
          <h2>Ajouter un membre</h2>
          <p class="text-muted text-sm">Affectez un utilisateur à l'équipe du projet.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-add-member-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/projets/details" method="post">
      <input type="hidden" name="formAction" value="addMember" />
      <input type="hidden" name="projetId" value="${projet.idProjet}" />
      <div class="modal-body stack stack-sm">
        <div class="form-group">
          <label for="memberUserId">Utilisateur *</label>
          <select id="memberUserId" name="memberUserId" required class="form-control">
            <option value="">Sélectionnez un utilisateur...</option>
            <c:forEach items="${utilisateursDisponibles}" var="u">
              <option value="${u.idUser}">
                <c:out value="${u.prenomUser}" /> <c:out value="${u.nomUser}" /> — <c:out value="${u.email}" />
              </option>
            </c:forEach>
          </select>
          <c:if test="${empty utilisateursDisponibles}">
            <p class="text-xs text-muted mt-1">Tous les utilisateurs sont déjà affectés à ce projet.</p>
          </c:if>
        </div>
        <div class="form-group">
          <label for="memberRole">Rôle sur le projet *</label>
          <select id="memberRole" name="memberRole" required class="form-control">
            <option value="DEVELOPPEUR">Développeur</option>
            <c:if test="${canAssignChef}">
              <option value="CHEF_PROJET">Chef de Projet</option>
            </c:if>
          </select>
          <c:if test="${not canAssignChef}">
            <p class="text-xs text-muted mt-1">Seul un administrateur peut affecter un Chef de Projet.</p>
          </c:if>
        </div>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-add-member-modal">Annuler</button>
        <c:choose>
          <c:when test="${empty utilisateursDisponibles}">
            <button type="submit" class="btn btn-primary" disabled>Ajouter à l'équipe</button>
          </c:when>
          <c:otherwise>
            <button type="submit" class="btn btn-primary">Ajouter à l'équipe</button>
          </c:otherwise>
        </c:choose>
      </div>
    </form>
  </div>
</div>

<div id="remove-member-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Retirer un membre</h2>
      <button type="button" class="modal-close" id="close-remove-member-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="remove-member-form" action="${pageContext.request.contextPath}/admin/projets/details" method="post">
      <input type="hidden" name="formAction" value="removeMember" />
      <input type="hidden" name="projetId" value="${projet.idProjet}" />
      <input type="hidden" name="memberUserId" id="remove-member-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment retirer <strong id="remove-member-name"></strong> de l'équipe ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-remove-member-modal">Annuler</button>
        <button type="submit" class="btn btn-danger">Retirer</button>
      </div>
    </form>
  </div>
</div>
</c:if>
