<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dashboard-stats.css">

<div class="stack stack-lg dashboard-container">
  
  <div>
    <h2 class="section-title">Mon Espace de Travail</h2>
    <p class="text-sm text-muted mt-1">Bienvenue <c:out value="${sessionScope.user.prenomUser} ${sessionScope.user.nomUser}" />. Voici un résumé de vos affectations actuelles.</p>
  </div>

  <div class="dashboard-grid-4">
    
    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-blue">
          <i data-lucide="folder-kanban"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Mes Projets</p>
          <h3 class="kpi-value"><c:out value="${kpiMesProjets}" default="0" /></h3>
          <p class="kpi-subtitle">En cours de dev</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-emerald">
          <i data-lucide="network"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Mes Environnements</p>
          <h3 class="kpi-value"><c:out value="${kpiMesEnvs}" default="0" /></h3>
          <p class="kpi-subtitle">Sur mes projets</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-amber">
          <i data-lucide="crown"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Chef de Projet</p>
          <h3 class="kpi-value"><c:out value="${kpiChefDeProjet}" default="0" /></h3>
          <p class="kpi-subtitle">Projets que je pilote</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-indigo">
          <i data-lucide="check-circle-2"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Projets Livrés</p>
          <h3 class="kpi-value"><c:out value="${kpiProjetsLivres}" default="0" /></h3>
          <p class="kpi-subtitle">Historique de succès</p>
        </div>
      </div>
    </article>
    
  </div>

  <div class="dashboard-layout-main">
    
    <div class="stack stack-lg">
      <div class="card">
        <header class="card-header flex items-center justify-between" style="padding: 20px 24px;">
          <h2 class="card-title" style="margin:0;">Mes Projets Actifs</h2>
          <a href="${pageContext.request.contextPath}/dev/mes-projets" class="text-sm font-medium text-primary" style="text-decoration:none;">Voir tous mes projets</a>
        </header>
        <div class="table-responsive" style="border: none; box-shadow: none; border-radius: 0 0 12px 12px;">
          <table class="data-table">
            <thead>
              <tr>
                <th>Projet</th>
                <th>Mon Rôle</th>
                <th style="width: 35%;">Avancement</th>
                <th class="text-right">Action</th>
              </tr>
            </thead>
            <tbody>
              <c:choose>
                <c:when test="${not empty listeMesProjetsRecents}">
                  <c:forEach items="${listeMesProjetsRecents}" var="projetMap">
                    <tr>
                      <td><strong><c:out value="${projetMap.projet.nomProjet}" /></strong></td>
                      <td>
                        <c:choose>
                          <c:when test="${projetMap.role == 'CHEF PROJET'}">
                            <span class="role-badge role-badge-chef">
                              <i data-lucide="crown"></i>
                              Chef de Projet
                            </span>
                          </c:when>
                          <c:otherwise>
                            <span class="role-badge role-badge-dev">
                              Développeur
                            </span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                      
                      <td>
                        <div class="progress-wrapper">
                          <div class="progress-track">
                            <div class="progress-fill" style="width: ${projetMap.projet.pourcentageAvancement}%;"></div>
                          </div>
                          <span class="progress-text"><c:out value="${projetMap.projet.pourcentageAvancement}" />%</span>
                        </div>
                      </td>
                      
                      <td class="text-right">
                        <a href="${pageContext.request.contextPath}/dev/mes-projets/details?id=${projetMap.projet.idProjet}" class="btn-icon btn-icon-sm" title="Voir mon projet">
                          <i data-lucide="arrow-right"></i>
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <tr>
                    <td colspan="4" class="text-center text-muted py-4">Vous n'êtes affecté à aucun projet en cours.</td>
                  </tr>
                </c:otherwise>
              </c:choose>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <div class="stack stack-lg">
      
      <div class="card">
        <header class="card-header" style="padding: 20px 24px;">
          <h2 class="card-title" style="margin:0;">Environnements (Mes Projets)</h2>
        </header>
        <div class="card-body" style="display: flex; justify-content: center; padding: 24px;">
          <canvas id="envChart" 
                  style="max-height: 220px;"
                  data-dev="${not empty statDev ? statDev : 0}"
                  data-staging="${not empty statStaging ? statStaging : 0}"
                  data-prod="${not empty statProd ? statProd : 0}"
                  data-local="${not empty statLocal ? statLocal : 0}">
          </canvas>
        </div>
        <div class="card-body chart-legend">
          <div><span style="color: #3B82F6;">●</span> DEV</div>
          <div><span style="color: #F59E0B;">●</span> STG</div>
          <div><span style="color: #10B981;">●</span> PROD</div>
          <div><span style="color: #64748B;">●</span> LOC</div>
        </div>
      </div>

    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dashboard-stats.js"></script>