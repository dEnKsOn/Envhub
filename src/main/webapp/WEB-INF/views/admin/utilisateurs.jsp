<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/utilisateurs.css">

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Utilisateurs</h2>
      <p class="text-sm text-muted mt-1">Gérez les informations et les profils d'accès au système EnvHub.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-user">
      <i data-lucide="user-plus"></i>
      <span class="hide-mobile">Nouvel Utilisateur</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/admin/utilisateurs" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}" placeholder="Rechercher par nom, prénom ou email" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/admin/utilisateurs">Réinitialiser</a>
    </c:if>
  </form>

  <div id="no-results-message" class="alert alert-danger search-result-message" style="display: ${searchNotFound ? 'flex' : 'none'};">
    <div>
      <strong>Utilisateur introuvable.</strong>
      <div>Aucun résultat pour "<span id="no-results-query"><c:out value="${searchQuery}"/></span>".</div>
    </div>
    <button type="button" class="btn btn-primary open-user-modal">Ajouter un utilisateur</button>
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
            <th>Nom</th>
            <th>Prénom</th>
            <th>Genre</th>
            <th>Email</th>
            <th>Profil Système</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="users-table-body">
          <c:choose>
            <c:when test="${not empty listeUtilisateurs}">
              <c:forEach items="${listeUtilisateurs}" var="user">
                <tr>
                  <td class="text-capitalize"><c:out value="${user.nomUser}" /></td>
                  <td class="text-capitalize"><c:out value="${user.prenomUser}" /></td>
                  <td><c:out value="${user.genre}"/></td>
                  <td class="text-muted"><c:out value="${user.email}" /></td>
                  <td>
                    <span class="badge badge-outline">
                      <i data-lucide="shield" style="width:12px; height:12px;"></i>
                      <c:out value="${user.profil.libelle}" default="Non défini" />
                    </span>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <button type="button" class="btn-icon btn-icon-sm edit-user-btn" title="Modifier"
                              data-user-id="${user.idUser}"
                              data-prenom="${user.prenomUser}"
                              data-nom="${user.nomUser}"
                              data-email="${user.email}"
                              data-genre="${user.genre}"
                              data-profil-id="${user.profil.idProfil}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-user-btn" title="Supprimer"
                              data-user-id="${user.idUser}"
                              data-user-name="${user.prenomUser} ${user.nomUser}">
                        <i data-lucide="trash-2"></i>
                      </button>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="6" class="text-center text-muted" style="padding: 3rem;">
                  <i data-lucide="users" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucun utilisateur n'est enregistré dans le système.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="user-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="user-plus" id="user-modal-icon"></i>
        </div>
        <div>
          <h2 id="user-modal-title">Ajouter un utilisateur</h2>
          <p id="user-modal-subtitle">Veuillez renseigner les informations de l'utilisateur.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-user-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    
    <form id="user-modal-form" action="${pageContext.request.contextPath}/admin/utilisateurs" method="post">
      <input type="hidden" name="formAction" id="user-form-action" value="create" />
      <input type="hidden" name="userId" id="userId" />
      <div class="modal-body stack stack-sm">
        
        <div class="grid grid-2">
          <div class="form-group">
            <label for="prenom">Prénom</label>
            <div class="input-with-icon">
              <i data-lucide="user"></i>
              <input type="text" id="prenom" name="prenom" required class="form-control" placeholder="Ex: Jean" />
            </div>
          </div>
          <div class="form-group">
            <label for="nom">Nom</label>
            <div class="input-with-icon">
              <i data-lucide="user"></i>
              <input type="text" id="nom" name="nom" required class="form-control" placeholder="Ex: Dupont" />
            </div>
          </div>
        </div>

        <div class="grid grid-2">
          <div class="form-group">
            <label for="email">Adresse Email</label>
            <div class="input-with-icon">
              <i data-lucide="mail"></i>
              <input type="email" id="email" name="email" required class="form-control" placeholder="jean.dupont@envhub.ma" />
            </div>
            <p id="email-error" class="text-xs text-red-500" style="display:none; margin-top: 0.5rem;"><i data-lucide="alert-circle" style="width:12px; height:12px; display:inline-block; vertical-align:middle; margin-right:4px;"></i>L'adresse email doit se terminer par @envhub.ma</p>
          </div>
          <div class="form-group">
            <label for="genre">Genre</label>
            <div class="input-with-icon">
              <i data-lucide="users"></i>
              <select id="genre" name="genre" class="form-control">
                <option value="">Non spécifié</option>
                <option value="Masculin">Masculin</option>
                <option value="Féminin">Féminin</option>
              </select>
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="password">Mot de passe</label>
          <div class="input-with-icon">
            <i data-lucide="lock"></i>
            <input type="password" id="password" name="password" class="form-control" placeholder="••••••••" />
          </div>
          <p id="password-help" class="text-xs text-muted" style="display:none; margin-top: 0.5rem;"><i data-lucide="info" style="width:12px; height:12px; display:inline-block; vertical-align:middle; margin-right:4px;"></i>Laissez vide pour conserver le mot de passe actuel.</p>
        </div>

        <div class="form-group">
          <label for="idProfil">Profil d'accès (Rôle)</label>
          <div class="input-with-icon">
            <i data-lucide="shield"></i>
            <select id="idProfil" name="idProfil" required class="form-control">
              <option value="">Sélectionner un profil...</option>
              <c:forEach items="${listeProfils}" var="profil">
                <option value="${profil.idProfil}"><c:out value="${profil.libelle}" /></option>
              </c:forEach>
            </select>
          </div>
        </div>
        
      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-user-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="user-modal-submit">Enregistrer l'utilisateur</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-user-modal" class="modal-overlay" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-user-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="delete-user-form" action="${pageContext.request.contextPath}/admin/utilisateurs" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="userId" id="delete-user-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer <strong id="delete-user-name"></strong> ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn" style="background: transparent; border: 1px solid var(--border-light); color: var(--text-main);" id="delete-user-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div> 