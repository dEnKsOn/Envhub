<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<div class="stack stack-lg dev-projets-page">
  
  <header class="flex items-center justify-between wrap gap-4">
    <div>
      <h1 class="page-title">Mes Projets</h1>
      <p class="text-muted text-sm mt-1">Consultez les projets sur lesquels vous êtes actuellement affecté.</p>
    </div>
    
    <div class="search-form" id="search-form" style="min-width: 320px;">
      <div class="input-with-icon search-input-wrapper">
        <i data-lucide="search"></i>
        <input type="text" id="search-input" placeholder="Rechercher dans mes projets..." autocomplete="off">
      </div>
    </div>
  </header>

  <div id="no-results-message" class="card empty-state-card" style="display: none;">
    <div class="empty-state-icon"><i data-lucide="search-x"></i></div>
    <h3 class="text-lg font-bold">Aucun projet trouvé</h3>
    <p class="text-muted mt-2">Aucun de vos projets ne correspond à "<strong id="no-results-query"></strong>".</p>
  </div>

  <div class="projets-grid">
    <c:choose>
      <c:when test="${not empty mesAffectations}">
        
        <c:forEach items="${mesAffectations}" var="affectation">
          <article class="card projet-card stack stack-sm">
            
            <div class="flex items-start justify-between gap-4 wrap">
              <div class="projet-card-header-left">
                <h2 class="projet-card-title"><c:out value="${affectation.projet.nomProjet}" /></h2>
                <div class="mt-2">
                  <c:choose>
                    <c:when test="${affectation.roleProjet == 'CHEF_PROJET'}">
                      <span class="role-badge role-badge-chef">
                        <i data-lucide="crown"></i> Chef de Projet
                      </span>
                    </c:when>
                    <c:otherwise>
                      <span class="role-badge role-badge-dev">
                        <i data-lucide="code-2"></i> Développeur
                      </span>
                    </c:otherwise>
                  </c:choose>
                </div>
              </div>
              
              <span class="badge-status ${affectation.projet.statutProjet}">
                <c:choose>
                  <c:when test="${affectation.projet.statutProjet == 'EN_COURS'}"> En cours</c:when>
                  <c:when test="${affectation.projet.statutProjet == 'LIVRE'}"> Livré</c:when>
                  <c:when test="${affectation.projet.statutProjet == 'EN_PAUSE'}"> En pause</c:when>
                  <c:when test="${affectation.projet.statutProjet == 'ANNULE'}"> Annulé</c:when>
                </c:choose>
              </span>
            </div>

            <p class="projet-card-desc text-sm text-muted">
              <c:out value="${affectation.projet.descriptionTech}" default="Aucune description technique fournie pour ce projet."/>
            </p>

            <div class="progress-wrapper mt-2">
              <div class="flex items-center justify-between text-xs text-muted mb-1" style="width: 100%;">
                <span> Avancement </span>
                <span style="font-weight: 700; color: var(--text-main);"><c:out value="${affectation.projet.pourcentageAvancement}" />%</span>
              </div>
              <div class="progress-track">
                <div class="progress-fill" style="width: ${affectation.projet.pourcentageAvancement}%;"></div>
              </div>
            </div>

            <div class="projet-card-footer mt-auto pt-4 flex items-center justify-between">
              <div class="text-xs text-muted flex items-center gap-2">
                <div class="date-badge">
                  <i data-lucide="calendar"></i>
                  <span>Lancement : <fmt:formatDate value="${affectation.projet.dateLancement}" pattern="dd/MM/yyyy" /></span>
                </div>
              </div>
              
              <a href="${pageContext.request.contextPath}/dev/mes-projets/details?id=${affectation.projet.idProjet}" class="btn btn-secondary btn-sm flex items-center gap-2">
                Ouvrir l'espace <i data-lucide="arrow-right" style="width: 14px; height: 14px;"></i>
              </a>
            </div>
            
          </article>
        </c:forEach>
        
      </c:when>
      
      <c:otherwise>
        <div class="card empty-state-card" style="grid-column: 1 / -1;">
          <div class="empty-state-icon"><i data-lucide="folder-kanban"></i></div>
          <h3 class="text-lg font-bold">Aucun projet affecté</h3>
          <p class="text-muted mt-2">Vous n'êtes actuellement affecté à aucun projet. Veuillez patienter ou contacter votre administrateur.</p>
        </div>
      </c:otherwise>
      
    </c:choose>
  </div>
</div>