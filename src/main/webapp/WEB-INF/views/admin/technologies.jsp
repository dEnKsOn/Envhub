<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/technologies.css">

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Technologies</h2>
      <p class="text-sm text-muted mt-1">Gérez le catalogue des technologies, langages, frameworks et SGBD.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-techno">
      <i data-lucide="code"></i>
      <span class="hide-mobile">Nouvelle Technologie</span>
    </button>
  </div>

  <form action="${pageContext.request.contextPath}/admin/technologies" method="get" class="search-form" id="search-form">
    <div class="search-input-wrapper">
      <input type="search" id="search-input" name="search" value="${searchQuery}" placeholder="Rechercher par nom ou catégorie" class="form-control" />
    </div>
    <c:if test="${not empty searchQuery}">
      <a class="btn" href="${pageContext.request.contextPath}/admin/technologies">Réinitialiser</a>
    </c:if>
  </form>

  <div id="no-results-message" class="alert alert-danger search-result-message" style="display: none;">
    <div>
      <strong>Technologie introuvable.</strong>
      <div>Aucun résultat pour "<span id="no-results-query"></span>".</div>
    </div>
    <button type="button" class="btn btn-primary open-techno-modal">Ajouter une technologie</button>
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
            <th>Nom de la Technologie</th>
            <th>Catégorie</th>
            <th>Utilisations</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody id="technos-table-body">
          <c:choose>
            <c:when test="${not empty listeTechnologies}">
              <c:forEach items="${listeTechnologies}" var="techno">
                <tr>
                  <td>
                    <div style="display: flex; align-items: center; gap: 8px;">
                      <c:choose>
                        <c:when test="${techno.typeTechno == 'LANGAGE'}">
                          <i data-lucide="file-code" style="width: 16px; height: 16px; color: var(--primary);"></i>
                        </c:when>
                        <c:when test="${techno.typeTechno == 'FRAMEWORK'}">
                          <i data-lucide="layers" style="width: 16px; height: 16px; color: var(--accent);"></i>
                        </c:when>
                        <c:when test="${techno.typeTechno == 'SGBD'}">
                          <i data-lucide="database" style="width: 16px; height: 16px; color: var(--success);"></i>
                        </c:when>
                        <c:otherwise>
                          <i data-lucide="code" style="width: 16px; height: 16px; color: var(--primary);"></i>
                        </c:otherwise>
                      </c:choose>
                      <span class="text-capitalize"><c:out value="${techno.nomTechno}" /></span>
                    </div>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${techno.typeTechno == 'LANGAGE'}">
                        <span class="badge" style="background-color: #E0E7FF; color: #3730A3; border: 1px solid #C7D2FE;">Langage</span>
                      </c:when>
                      <c:when test="${techno.typeTechno == 'FRAMEWORK'}">
                        <span class="badge" style="background-color: #FEF3C7; color: #92400E; border: 1px solid #FDE68A;">Framework</span>
                      </c:when>
                      <c:when test="${techno.typeTechno == 'SGBD'}">
                        <span class="badge" style="background-color: #D1FAE5; color: #065F46; border: 1px solid #A7F3D0;">SGBD</span>
                      </c:when>
                      <c:otherwise>
                        <span class="badge badge-outline"><c:out value="${techno.typeTechno}" /></span>
                      </c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <span class="badge badge-outline">
                      <c:out value="${techno.utilisations}" />
                    </span>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 8px;">
                      <button type="button" class="btn-icon btn-icon-sm edit-techno-btn" title="Modifier"
                              data-techno-id="${techno.idTechno}"
                              data-nom="${techno.nomTechno}"
                              data-type="${techno.typeTechno}">
                        <i data-lucide="edit-2"></i>
                      </button>
                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-techno-btn" title="Supprimer"
                              data-techno-id="${techno.idTechno}"
                              data-techno-nom="${techno.nomTechno}">
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
                  <i data-lucide="code" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucune technologie n'est enregistrée dans le catalogue.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="techno-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header" style="align-items: flex-start;">
      <div class="modal-header-content">
        <div class="modal-header-icon">
          <i data-lucide="code" id="techno-modal-icon"></i>
        </div>
        <div>
          <h2 id="techno-modal-title">Ajouter une technologie</h2>
          <p id="techno-modal-subtitle">Veuillez renseigner les informations de la technologie.</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-techno-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    
    <form id="techno-modal-form" action="${pageContext.request.contextPath}/admin/technologies" method="post">
      <input type="hidden" name="formAction" id="techno-form-action" value="create" />
      <input type="hidden" name="technoId" id="technoId" />
      <div class="modal-body stack stack-sm">
        
        <div class="form-group">
          <label for="nomTechno">Nom de la Technologie</label>
          <div class="input-with-icon">
            <i data-lucide="type"></i>
            <input type="text" id="nomTechno" name="nomTechno" required class="form-control" placeholder="Ex: Java, Spring, PostgreSQL" />
          </div>
        </div>

        <div class="form-group">
          <label for="typeTechno">Catégorie</label>
          <div class="input-with-icon">
            <i data-lucide="tag"></i>
            <select id="typeTechno" name="typeTechno" required class="form-control" style="appearance: auto; padding-left: 42px;">
              <option value="" disabled selected>Sélectionnez une catégorie...</option>
              <c:forEach items="${typesTechno}" var="type">
                <option value="${type}">${type}</option>
              </c:forEach>
            </select>
          </div>
        </div>

      </div>
      <div class="modal-actions" style="border-top: 1px solid var(--border-light); padding-top: 1.5rem;">
        <button type="button" class="btn btn-secondary" id="cancel-techno-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" id="techno-modal-submit">Enregistrer la technologie</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-techno-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="delete-close-techno-modal">
        <i data-lucide="x"></i>
      </button>
    </header>
    <form id="delete-techno-form" action="${pageContext.request.contextPath}/admin/technologies" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="technoId" id="delete-techno-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer la technologie <strong id="delete-techno-nom"></strong> ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn" style="background: transparent; border: 1px solid var(--border-light); color: var(--text-main);" id="delete-techno-cancel">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>
<script src="${pageContext.request.contextPath}/assets/js/technologies.js"></script>