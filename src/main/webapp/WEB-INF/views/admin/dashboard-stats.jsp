<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dashboard-stats.css">

<div class="stack stack-lg dashboard-container">
  
  <div>
    <h2 class="section-title">Tableau de Bord</h2>
    <p class="text-sm text-muted mt-1">Supervision globale de l'infrastructure et des projets EnvHub</p>
  </div>

  <div class="dashboard-grid-4">
    
    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-amber">
          <i data-lucide="bell-ring"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Demandes</p>
          <h3 class="kpi-value"><c:out value="${kpiDemandes}" default="0" /></h3>
          <p class="kpi-subtitle">À valider d'urgence</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-blue">
          <i data-lucide="folder-kanban"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Projets en cours</p>
          <h3 class="kpi-value"><c:out value="${kpiProjets}" default="0" /></h3>
          <p class="kpi-subtitle">En développement</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-indigo">
          <i data-lucide="users"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Total Clients</p>
          <h3 class="kpi-value"><c:out value="${kpiClients}" default="0" /></h3>
          <p class="kpi-subtitle">Entreprises partenaires</p>
        </div>
      </div>
    </article>

    <article class="card kpi-card-modern">
      <div class="kpi-body">
        <div class="kpi-icon-box icon-emerald">
          <i data-lucide="server"></i>
        </div>
        <div class="kpi-details">
          <p class="kpi-label">Instances PROD</p>
          <h3 class="kpi-value"><c:out value="${kpiProd}" default="0" /></h3>
          <p class="kpi-subtitle">Déploiements réussis</p>
        </div>
      </div>
    </article>
    
  </div>

  <div class="dashboard-layout-main">
    
    <div class="stack stack-lg">
      <div class="card">
        <header class="card-header flex items-center justify-between" style="padding: 20px 24px;">
          <h2 class="card-title" style="margin:0;">Projets Actifs Récents</h2>
          <a href="${pageContext.request.contextPath}/admin/projets" class="text-sm font-medium text-primary" style="text-decoration:none;">Voir tout</a>
        </header>
        <div class="table-responsive" style="border: none; box-shadow: none; border-radius: 0 0 12px 12px;">
          <table class="data-table">
            <thead>
              <tr>
                <th>Projet</th>
                <th>Client</th>
                <th style="width: 35%;">Avancement</th>
                <th class="text-right">Action</th>
              </tr>
            </thead>
            <tbody>
              <c:choose>
                <c:when test="${not empty listeProjetsRecents}">
                  <c:forEach items="${listeProjetsRecents}" var="projet">
                    <tr>
                      <td><strong><c:out value="${projet.nomProjet}" /></strong></td>
                      <td class="text-sm text-muted"><c:out value="${projet.entrepriseClient}" default="Non défini" /></td>
                      
                      <td>
                        <div class="progress-wrapper">
                          <div class="progress-track">
                            <div class="progress-fill" style="width: ${projet.pourcentageAvancement}%;"></div>
                          </div>
                          <span class="progress-text"><c:out value="${projet.pourcentageAvancement}" />%</span>
                        </div>
                      </td>
                      
                      <td class="text-right">
                        <a href="${pageContext.request.contextPath}/admin/projets/details?id=${projet.idProjet}" class="btn-icon btn-icon-sm" title="Voir les détails">
                          <i data-lucide="arrow-right"></i>
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <tr>
                    <td colspan="4" class="text-center text-muted py-4">Aucun projet en cours.</td>
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
          <h2 class="card-title" style="margin:0;">Infrastructure</h2>
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

      <div class="card">
        <header class="card-header" style="padding: 20px 24px;">
          <h2 class="card-title" style="margin:0;">Activité Récente</h2>
        </header>
        <div class="card-body">
          <ul class="timeline">
            <c:forEach items="${activitesRecentes}" var="activite">
              <li class="timeline-item">
                <div class="timeline-dot"></div>
                <p class="timeline-desc"><c:out value="${activite.description}" /></p>
                <p class="timeline-date">
                  <i data-lucide="clock"></i> 
                  <c:out value="${activite.dateFormatee}" />
                </p>
              </li>
            </c:forEach>
            
            <c:if test="${empty activitesRecentes}">
              <p class="text-sm text-muted text-center" style="padding: 10px 0;">Aucune activité récente.</p>
            </c:if>
          </ul>
        </div>
      </div>

    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dashboard-stats.js"></script>