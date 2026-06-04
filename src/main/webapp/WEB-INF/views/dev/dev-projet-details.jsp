<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/healthcheck.css">

<div class="stack stack-lg projet-details-page">

  <div class="flex items-center justify-between gap-4 wrap projet-details-toolbar">
    <div>
      <a href="${pageContext.request.contextPath}/dev/mes-projets" class="back-link text-sm text-muted">
        <i data-lucide="arrow-left"></i> Retour à mes projets
      </a>
    </div>
    
    <c:if test="${canEditProjet}">
      <button type="button" class="btn btn-secondary" id="btn-edit-projet-details">
        <i data-lucide="edit-2"></i> <span class="hide-mobile">Modifier le projet</span>
      </button>
    </c:if>
  </div>

  <c:if test="${not empty param.success}">
    <div class="alert alert-success"><i data-lucide="check-circle-2" style="margin-right:8px;"></i> L'opération a été réalisée avec succès.</div>
  </c:if>
  <c:if test="${not empty param.error}">
    <div class="alert alert-danger"><i data-lucide="alert-circle" style="margin-right:8px;"></i> Une erreur est survenue lors du traitement.</div>
  </c:if>

  <div class="projet-details-grid">

    <div class="projet-details-main stack stack-lg">
      
      <header class="card projet-header-card">
        <div class="projet-header-top">
          <div class="projet-header-title">
            <div class="projet-header-icon"><i data-lucide="folder"></i></div>
            <div>
              <h1 class="projet-title"><c:out value="${projet.nomProjet}" /></h1>
              <p class="text-sm text-muted mt-1">Client : <strong><c:out value="${projet.entrepriseClient}" /></strong></p>
            </div>
          </div>
          <span class="badge-status ${projet.statutProjet}">
            <c:choose>
              <c:when test="${projet.statutProjet == 'EN_COURS'}"> En cours</c:when>
              <c:when test="${projet.statutProjet == 'LIVRE'}"> Livré</c:when>
              <c:when test="${projet.statutProjet == 'EN_PAUSE'}"> En pause</c:when>
              <c:when test="${projet.statutProjet == 'ANNULE'}"> Annulé</c:when>
            </c:choose>
          </span>
        </div>

        <div class="progress-wrapper stack stack-xs mt-4">
          <div class="flex items-center justify-between text-sm">
            <span class="text-muted">Avancement </span>
            <span style="font-weight: 700; color: var(--text-main);"><c:out value="${projet.pourcentageAvancement}"/>%</span>
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
            <span class="text-xs text-muted"> Date de lancement</span>
            <p class="text-sm" style="font-weight: 600; margin: 4px 0 0;">
              <fmt:formatDate value="${projet.dateLancement}" pattern="dd/MM/yyyy" />
            </p>
          </div>
          <c:if test="${not empty projet.dateLivraisonEstimee}">
            <div class="projet-date-item">
              <span class="text-xs text-muted"> Livraison estimée</span>
              <p class="text-sm" style="font-weight: 600; margin: 4px 0 0;">
                <fmt:formatDate value="${projet.dateLivraisonEstimee}" pattern="dd/MM/yyyy" />
              </p>
            </div>
          </c:if>
        </div>
      </header>

      <section class="card stack stack-sm">
        <div class="flex items-center justify-between">
          <h2 class="section-title flex items-center gap-2" style="margin: 0;"> Environnements </h2>
          <div class="flex items-center gap-3">
            <span class="badge badge-outline" style="margin-right: 20px;"><c:out value="${projet.nombreEnvironnements}" default="0"/> instance(s)</span>
            
            <button type="button" class="btn btn-primary btn-sm flex items-center gap-2" id="btn-add-env">
              <i data-lucide="plus-circle" style="width: 14px; height: 14px;"></i> <span class="hide-mobile">Nouveau</span>
            </button>
          </div>
        </div>

        <div class="table-responsive env-table-wrapper">
          <table class="data-table env-table">
            <thead>
              <tr>
                <th>Type</th>
                <th>Serveur hôte</th>
                <th>Accès Rapide</th>
                <th class="text-right">Actions</th>
              </tr>
            </thead>
            <tbody>
              <c:choose>
                <c:when test="${not empty environnements}">
                  <c:forEach items="${environnements}" var="env">
                    <tr>
                      <td><span class="env-badge env-badge-${env.typeEnv}"><c:out value="${env.typeEnv}" /></span></td>
                      
                      <td>
                        <c:choose>
                          <c:when test="${not empty env.serveur and not empty env.serveur.adressIP}">
                            <span class="health-indicator status-pending" data-ip="${env.serveur.adressIP}"></span>
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
                          <c:if test="${not empty env.urlFront}">
                            <a href="<c:out value='${env.urlFront}'/>" target="_blank" class="env-access-btn env-access-btn-front" title="Ouvrir Front-end"><i data-lucide="monitor"></i> <c:out value='${env.urlFront}'/></a>
                          </c:if>
                          <c:if test="${not empty env.urlBack}">
                            <a href="<c:out value='${env.urlBack}'/>" target="_blank" class="env-access-btn env-access-btn-back" title="Ouvrir Back-end"><i data-lucide="plug"></i> <c:out value='${env.urlBack}'/></a>
                          </c:if>
                        </div>
                      </td>
                      
                      <td class="text-right">
                        <c:set var="technoJson" value="[" />
                        <c:forEach items="${env.versions}" var="vt" varStatus="loop">
                          <c:set var="technoJson" value="${technoJson}{\"id\":\"${vt.technologie.idTechno}\", \"nom\":\"${fn:escapeXml(vt.technologie.nomTechno)}\", \"version\":\"${fn:escapeXml(vt.version)}\"}${!loop.last ? ',' : ''}" />
                        </c:forEach>
                        <c:set var="technoJson" value="${technoJson}]" />

                        <div class="flex items-center justify-end gap-2">
                          <button style="margin-right: 2px;" type="button" class="btn-icon btn-icon-sm text-primary btn-view-env" title="Voir les détails"
                                  data-env-type="${env.typeEnv}"
                                  data-env-db="${env.nomBaseDeDonnees}"
                                  data-env-server-ip="${env.serveur.adressIP}"
                                  data-env-server-os="${env.serveur.os}"
                                  data-env-url-front="<c:out value='${env.urlFront}'/>"
                                  data-env-url-back="<c:out value='${env.urlBack}'/>"
                                  data-env-technos='${technoJson}'>
                            <i data-lucide="eye"></i>
                          </button>
                          
                          <c:if test="${canEditProjet or env.createur.idUser == sessionScope.user.idUser}">
                            
                            <button style="margin-right: 2px;" type="button" class="btn-icon btn-icon-sm text-secondary btn-edit-env" title="Modifier cet environnement"
                                    data-env-id="${env.idEnv}"
                                    data-env-type="${env.typeEnv}"
                                    data-env-server-id="${not empty env.serveur ? env.serveur.idServ : ''}"
                                    data-env-db="${env.nomBaseDeDonnees}"
                                    data-env-url-front="<c:out value='${env.urlFront}'/>"
                                    data-env-url-back="<c:out value='${env.urlBack}'/>"
                                    data-env-technos='${technoJson}'>
                              <i data-lucide="edit-3" ></i>
                            </button>
                            
                            <button style="margin-right: 2px;" type="button" class="btn-icon btn-icon-sm text-red-500 btn-delete-env" title="Supprimer cet environnement"
                                    data-env-id="${env.idEnv}">
                              <i data-lucide="trash-2"></i>
                            </button>
                            
                          </c:if>
                        </div>
                      </td>

                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <tr><td colspan="4" class="text-center text-muted" style="padding: 2rem;">Aucun environnement n'est rattaché à ce projet.</td></tr>
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
          <h2 class="section-title flex items-center gap-2" style="margin: 0;"> Équipe</h2>
          
          <c:if test="${canManageTeam}">
            <button type="button" class="btn btn-primary btn-sm flex items-center gap-2" id="btn-add-member">
              <i data-lucide="user-plus" style="width: 14px; height: 14px;"></i> <span class="hide-mobile">Ajouter</span>
            </button>
          </c:if>
        </div>

        <div class="equipe-section">
          <h3 class="equipe-section-label"><i data-lucide="crown"></i> Chef de projet</h3>
          <ul class="equipe-list">
            <c:forEach items="${equipe}" var="affectation">
              <c:if test="${affectation.roleProjet == 'CHEF_PROJET'}">
                <li class="equipe-member equipe-member-chef flex items-center justify-between">
                  <div class="equipe-member-info">
                    <div class="equipe-avatar equipe-avatar-chef"><i data-lucide="crown"></i></div>
                    <div>
                      <p class="equipe-member-name">
                        <c:out value="${affectation.utilisateur.prenomUser}" /> <c:out value="${affectation.utilisateur.nomUser}" />
                        <c:if test="${affectation.utilisateur.idUser == sessionScope.user.idUser}"><span class="badge badge-outline" style="font-size: 0.6rem; padding: 2px 6px; height: auto;">(Moi)</span></c:if>
                      </p>
                      <p class="text-xs text-muted"><c:out value="${affectation.utilisateur.email}" /></p>
                    </div>
                  </div>
                </li>
              </c:if>
            </c:forEach>
          </ul>
        </div>

        <div class="equipe-section mt-4">
          <h3 class="equipe-section-label"><i data-lucide="code-2"></i> Développeurs</h3>
          <ul class="equipe-list">
            <c:forEach items="${equipe}" var="affectation">
              <c:if test="${affectation.roleProjet == 'DEVELOPPEUR'}">
                <li class="equipe-member flex items-center justify-between">
                  <div class="equipe-member-info">
                    <div class="equipe-avatar"><i data-lucide="user"></i></div>
                    <div>
                      <p class="equipe-member-name">
                        <c:out value="${affectation.utilisateur.prenomUser}" /> <c:out value="${affectation.utilisateur.nomUser}" />
                        <c:if test="${affectation.utilisateur.idUser == sessionScope.user.idUser}"><span class="badge badge-outline" style="font-size: 0.6rem; padding: 2px 6px; height: auto;">(Moi)</span></c:if>
                      </p>
                      <p class="text-xs text-muted"><c:out value="${affectation.utilisateur.email}" /></p>
                    </div>
                  </div>
                  
                  <c:if test="${canManageTeam}">
                    <button type="button" class="btn-icon btn-icon-sm text-red-500 remove-member-btn" title="Retirer" data-member-id="${affectation.utilisateur.idUser}" data-member-name="${affectation.utilisateur.prenomUser} ${affectation.utilisateur.nomUser}">
                      <i data-lucide="trash-2"></i>
                    </button>
                  </c:if>
                </li>
              </c:if>
            </c:forEach>
          </ul>
        </div>
        
        <c:if test="${canManageTeam}">
          <button type="button" class="btn btn-secondary mt-4 flex items-center justify-center gap-2" id="btn-manage-team" style="width: 100%; padding: 10px;">
            <i data-lucide="users"></i> Gérer l'équipe
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
          <div class="modal-header-icon"><i data-lucide="folder"></i></div>
          <div><h2>Modifier mon projet</h2><p class="text-muted text-sm">Mettez à jour les informations.</p></div>
        </div>
        <button type="button" class="modal-close" id="close-edit-projet-modal"><i data-lucide="x"></i></button>
      </header>
      <form action="${pageContext.request.contextPath}/dev/mes-projets/details" method="post">
        <input type="hidden" name="formAction" value="update" />
        <input type="hidden" name="projetId" value="${projet.idProjet}" />
        <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto;">
          <div class="form-group"><label for="nom">Nom du projet *</label><input type="text" id="nom" name="nom" required class="form-control" value="<c:out value='${projet.nomProjet}' />" /></div>
          <input type="hidden" name="client" value="${projet.idClient}" />
          <div class="grid grid-2">
            <div class="form-group">
              <label for="statut">Statut *</label>
              <select id="statut" name="statut" class="form-control">
                <option value="EN_COURS" <c:if test="${projet.statutProjet == 'EN_COURS'}">selected</c:if>>En cours</option>
                <option value="EN_PAUSE" <c:if test="${projet.statutProjet == 'EN_PAUSE'}">selected</c:if>>En pause</option>
                <option value="LIVRE" <c:if test="${projet.statutProjet == 'LIVRE'}">selected</c:if>>Livré</option>
              </select>
            </div>
            <div class="form-group"><label for="avancement">Progression (%) *</label><input type="number" id="avancement" name="avancement" class="form-control" min="0" max="100" value="${projet.pourcentageAvancement}" /></div>
          </div>
          <div class="grid grid-2">
            <div class="form-group"><label for="dateLancement">Date de lancement *</label><input type="date" id="dateLancement" name="dateLancement" class="form-control" value="<fmt:formatDate value='${projet.dateLancement}' pattern='yyyy-MM-dd'/>" /></div>
            <div class="form-group"><label for="dateLivraison">Livraison estimée</label><input type="date" id="dateLivraison" name="dateLivraison" class="form-control" value="<fmt:formatDate value='${projet.dateLivraisonEstimee}' pattern='yyyy-MM-dd'/>" /></div>
          </div>
          <div class="form-group"><label for="description">Description technique</label><textarea id="description" name="description" class="form-control" rows="3"><c:out value="${projet.descriptionTech}" /></textarea></div>
        </div>
        <div class="modal-actions"><button type="button" class="btn btn-secondary" id="cancel-edit-projet-modal">Annuler</button><button type="submit" class="btn btn-primary">Enregistrer</button></div>
      </form>
    </div>
  </div>

  <div id="add-member-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
    <div class="modal-card">
      <header class="modal-header" style="align-items: flex-start;">
        <div class="modal-header-content">
          <div class="modal-header-icon"><i data-lucide="user-plus"></i></div>
          <div><h2>Ajouter un développeur</h2><p class="text-muted text-sm">Affectez un utilisateur au projet.</p></div>
        </div>
        <button type="button" class="modal-close" id="close-add-member-modal"><i data-lucide="x"></i></button>
      </header>
      <form action="${pageContext.request.contextPath}/dev/mes-projets/details" method="post">
        <input type="hidden" name="formAction" value="addMember" />
        <input type="hidden" name="projetId" value="${projet.idProjet}" />
        <div class="modal-body stack stack-sm">
          <div class="form-group">
            <label for="memberUserId">Utilisateur *</label>
            <select id="memberUserId" name="memberUserId" required class="form-control">
              <option value="">Sélectionnez un utilisateur...</option>
              <c:forEach items="${utilisateursDisponibles}" var="u"><option value="${u.idUser}"><c:out value="${u.prenomUser}" /> <c:out value="${u.nomUser}" /></option></c:forEach>
            </select>
          </div>
          <input type="hidden" name="memberRole" value="DEVELOPPEUR" />
          <p class="text-xs text-muted">L'utilisateur sera ajouté en tant que Développeur.</p>
        </div>
        <div class="modal-actions"><button type="button" class="btn btn-secondary" id="cancel-add-member-modal">Annuler</button><button type="submit" class="btn btn-primary">Ajouter</button></div>
      </form>
    </div>
  </div>

  <div id="remove-member-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
    <div class="modal-card">
      <header class="modal-header"><h2 style="color: #B91C1C;">Retirer un membre</h2><button type="button" class="modal-close" id="close-remove-member-modal"><i data-lucide="x"></i></button></header>
      <form id="remove-member-form" action="${pageContext.request.contextPath}/dev/mes-projets/details" method="post">
        <input type="hidden" name="formAction" value="removeMember" />
        <input type="hidden" name="projetId" value="${projet.idProjet}" />
        <input type="hidden" name="memberUserId" id="remove-member-id" />
        <div class="modal-body"><p>Voulez-vous vraiment retirer <strong id="remove-member-name"></strong> de votre équipe ?</p></div>
        <div class="modal-actions"><button type="button" class="btn btn-secondary" id="cancel-remove-member-modal">Annuler</button><button type="submit" class="btn btn-danger">Retirer</button></div>
      </form>
    </div>
  </div>
  
</c:if>

<div id="add-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card" style="width: min(700px, 95vw);">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background: linear-gradient(135deg, #ECFDF5 0%, #D1FAE5 100%); color: #059669; border-color: rgba(5, 150, 105, 0.15);"><i data-lucide="server-cog"></i></div>
        <div><h2>Nouvel Environnement</h2><p class="text-muted text-sm">Configurez un espace technique pour ce projet.</p></div>
      </div>
      <button type="button" class="modal-close" id="close-add-env-modal"><i data-lucide="x"></i></button>
    </header>
    
    <form action="${pageContext.request.contextPath}/dev/mes-projets/environnements/add" method="post">
      <input type="hidden" name="projetId" value="${projet.idProjet}" />
      <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto; overflow-x: hidden;">
        <div class="grid grid-2">
          <div class="form-group">
            <label for="typeEnv">Type d'environnement *</label>
            <select id="typeEnv" name="typeEnv" required class="form-control">
              <option value="LOCAL">Local (Poste Dev)</option>
              <option value="DEVELOPPEMENT">Développement</option>
              <c:if test="${monRole == 'CHEF_PROJET'}">
                <option value="STAGING">Staging</option>
                <option value="PRODUCTION">Production</option>
              </c:if>
            </select>
          </div>
          <div class="form-group">
            <label for="serveurId">Serveur Hôte</label>
            <select id="serveurId" name="serveurId" class="form-control">
              <option value="">-- Aucun serveur (Poste Local) --</option>
              <c:forEach items="${listeServeurs}" var="serveur"><option value="${serveur.idServ}">IP: <c:out value="${serveur.adressIP}" /> (<c:out value="${serveur.os}" />)</option></c:forEach>
            </select>
          </div>
        </div>
        
        <div class="form-group"><label for="urlFront">URL Front-end</label><div class="input-with-icon"><i data-lucide="link"></i><input type="url" id="urlFront" name="urlFront" class="form-control" placeholder="ex: http://localhost:3000" /></div></div>
        <div class="form-group"><label for="urlBack">URL Back-end (API)</label><div class="input-with-icon"><i data-lucide="plug"></i><input type="url" id="urlBack" name="urlBack" class="form-control" placeholder="ex: http://localhost:8080/api" /></div></div>
        <div class="form-group"><label for="dbName">Nom de la base de données</label><div class="input-with-icon"><i data-lucide="database"></i><input type="text" id="dbName" name="dbName" class="form-control" placeholder="ex: envhub_db_local" /></div></div>
        
        <hr style="margin: 16px 0; border: 0; border-top: 1px solid var(--border-light);" />

        <div class="form-group">
          <label>Technologies & Versions utilisées</label>
          <p class="text-xs text-muted mb-2">Précisez la stack technique pour garantir la reproductibilité de cet environnement.</p>
          <div id="techno-container" class="stack stack-xs">
            <div class="flex items-center gap-2 techno-row" style="margin-bottom: 8px;">
              <select name="technoIds[]" class="form-control" style="flex: 2; margin-right: 10px;">
                <option value="">-- Choisir une technologie --</option>
                <c:forEach items="${listeTechnologies}" var="techno"><option value="${techno.idTechno}"><c:out value="${techno.nomTechno}" /> (<c:out value="${techno.typeTechno}" />)</option></c:forEach>
              </select>
              <input type="text" name="technoVersions[]" class="form-control" placeholder="Version (ex: 17.0)" style="flex: 1;" />
              <button type="button" class="btn-icon btn-icon-sm text-red-500 remove-techno-row" title="Retirer cette ligne" style="margin-left: 5px;"><i data-lucide="trash-2"></i></button>
            </div>
          </div>
          <button type="button" class="btn btn-secondary btn-sm mt-2" onclick="addTechnoRow()" style="font-size: 0.8rem; padding: 6px 12px;"><i data-lucide="plus" style="width: 14px; height: 14px;"></i> Ajouter une technologie</button>
        </div>
      </div>
      <div class="modal-actions"><button type="button" class="btn btn-secondary" id="cancel-add-env-modal">Annuler</button><button type="submit" class="btn btn-primary">Créer l'environnement</button></div>
    </form>
  </div>
</div>

<div id="view-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card" style="width: min(600px, 95vw);">
    <header class="modal-header" style="align-items: flex-start; padding-bottom: 16px; border-bottom: 1px solid var(--border-light);">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background: linear-gradient(135deg, #EEF2FF 0%, #E0E7FF 100%); color: #4F46E5; border-color: rgba(79, 70, 229, 0.15);"><i data-lucide="eye"></i></div>
        <div>
          <h2 style="display:flex; align-items:center; gap:8px;">Détails Environnement <span id="view-env-type" class="badge badge-outline" style="font-size:0.7rem;"></span></h2>
        </div>
      </div>
      <button type="button" class="modal-close"><i data-lucide="x"></i></button>
    </header>
    
    <div class="modal-body stack stack-md" style="padding: 0 16px 0 16px;">
      <div class="grid grid-2" style="margin: 16px 0 16px 0;">
        <div>
          <span class="text-xs text-muted" style="text-transform:uppercase; font-weight:700;">Serveur Hôte</span>
          <p id="view-env-server" class="mt-1" style="font-weight:600; display:flex; align-items:center;"></p>
        </div>
        <div>
          <span class="text-xs text-muted" style="text-transform:uppercase; font-weight:700;">Base de données</span>
          <p class="mt-1"><code id="view-env-db" style="padding:4px 8px; background:#F8FAFC; border-radius:6px; border:1px solid #E2E8F0;"></code></p>
        </div>
      </div>

      <div style="margin: 0 0 16px 0;">
        <span class="text-xs text-muted" style="text-transform:uppercase; font-weight:700; display:block; margin-bottom:8px;">Points d'accès</span>
        <div id="view-env-links" class="flex gap-2 wrap" ></div>
      </div>

      <div>
        <span class="text-xs text-muted" style="text-transform:uppercase; font-weight:700; display:block; margin-bottom:8px;">Stack Technique & Versions</span>
        <div id="view-env-technos" class="flex gap-2 wrap"></div>
      </div>
    
    </div>
    <div class="modal-actions" style="border-top: 1px solid var(--border-light); margin: 16px 0 16px 0;">
      <button type="button" class="btn btn-secondary modal-close" style="width: 100%;">Fermer</button>
    </div>
  </div>
</div>

<div id="edit-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card" style="width: min(700px, 95vw);">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background: linear-gradient(135deg, #EEF2FF 0%, #E0E7FF 100%); color: #4F46E5; border-color: rgba(79, 70, 229, 0.15);"><i data-lucide="edit-3"></i></div>
        <div><h2>Modifier l'Environnement</h2><p class="text-muted text-sm">Mettez à jour cet espace de travail.</p></div>
      </div>
      <button type="button" class="modal-close"><i data-lucide="x"></i></button>
    </header>
    
    <form action="${pageContext.request.contextPath}/dev/mes-projets/environnements/edit" method="post">
      <input type="hidden" name="envId" id="edit-env-id" />
      <div class="modal-body stack stack-sm" style="max-height: 70vh; overflow-y: auto; overflow-x: hidden;">
        
        <div class="grid grid-2">
          <div class="form-group">
            <label for="edit-typeEnv">Type d'environnement *</label>
            <select id="edit-typeEnv" name="typeEnv" required class="form-control">
              <option value="LOCAL">Local (Poste Dev)</option>
              <option value="DEVELOPPEMENT">Développement</option>
              <c:if test="${monRole == 'CHEF_PROJET'}">
                <option value="STAGING">Staging</option>
                <option value="PRODUCTION">Production</option>
              </c:if>
            </select>
          </div>
          <div class="form-group">
            <label for="edit-serveurId">Serveur Hôte</label>
            <select id="edit-serveurId" name="serveurId" class="form-control">
              <option value="">-- Aucun serveur (Poste Local) --</option>
              <c:forEach items="${listeServeurs}" var="serveur"><option value="${serveur.idServ}">IP: <c:out value="${serveur.adressIP}" /> (<c:out value="${serveur.os}" />)</option></c:forEach>
            </select>
          </div>
        </div>
        
        <div class="form-group"><label for="edit-urlFront">URL Front-end</label><div class="input-with-icon"><i data-lucide="link"></i><input type="url" id="edit-urlFront" name="urlFront" class="form-control" /></div></div>
        <div class="form-group"><label for="edit-urlBack">URL Back-end (API)</label><div class="input-with-icon"><i data-lucide="plug"></i><input type="url" id="edit-urlBack" name="urlBack" class="form-control" /></div></div>
        <div class="form-group"><label for="edit-dbName">Nom de la base de données</label><div class="input-with-icon"><i data-lucide="database"></i><input type="text" id="edit-dbName" name="dbName" class="form-control" /></div></div>
        
        <hr style="margin: 16px 0; border: 0; border-top: 1px solid var(--border-light);" />

        <div class="form-group">
          <label>Technologies & Versions utilisées</label>
          <div id="edit-techno-container" class="stack stack-xs">
            </div>
          <button type="button" class="btn btn-secondary btn-sm mt-2" onclick="addEditTechnoRow()" style="font-size: 0.8rem; padding: 6px 12px;"><i data-lucide="plus" style="width: 14px; height: 14px;"></i> Ajouter une technologie</button>
        </div>
      </div>
      <div class="modal-actions"><button type="button" class="btn btn-secondary modal-close">Annuler</button><button type="submit" class="btn btn-primary">Enregistrer les modifications</button></div>
    </form>
  </div>
</div>

<template id="techno-row-template">
  <div class="flex items-center gap-2 techno-row" style="margin-bottom: 8px;">
    <select name="technoIds[]" class="form-control" style="flex: 2; margin-right: 10px;">
      <option value="">-- Choisir une technologie --</option>
      <c:forEach items="${listeTechnologies}" var="techno"><option value="${techno.idTechno}"><c:out value="${techno.nomTechno}" /> (<c:out value="${techno.typeTechno}" />)</option></c:forEach>
    </select>
    <input type="text" name="technoVersions[]" class="form-control" placeholder="Version (ex: 17.0)" style="flex: 1;" />
    <button type="button" class="btn-icon btn-icon-sm text-red-500 remove-techno-row" title="Retirer cette ligne" style="margin-left: 5px;"><i data-lucide="trash-2"></i></button>
  </div>
</template>

<div id="delete-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2 style="color: #B91C1C;">Supprimer l'Environnement</h2>
      <button type="button" class="modal-close"><i data-lucide="x"></i></button>
    </header>
    <form action="${pageContext.request.contextPath}/dev/mes-projets/environnements/delete" method="post">
      <input type="hidden" name="envId" id="delete-env-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer définitivement cet environnement ? Cette action effacera ses accès et ses associations techniques.</p>
      </div>
      <div class="modal-actions"><button type="button" class="btn btn-secondary modal-close">Annuler</button><button type="submit" class="btn btn-danger">Supprimer</button></div>
    </form>
  </div>
</div>

<script>const CONTEXT_PATH = '${pageContext.request.contextPath}';</script>
<script src="${pageContext.request.contextPath}/assets/js/healthcheck.js"></script>