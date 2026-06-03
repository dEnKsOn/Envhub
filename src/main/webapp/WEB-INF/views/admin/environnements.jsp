<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/healthcheck.css">

<div class="page-header">
    <div>
        <h2 class="section-title">Cartographie des Environnements</h2>
        <p class="text-muted">Supervision de l'infrastructure, des instances de développement à la production.</p>
    </div>
</div>

<div class="filters-panel">
    <div class="filter-group">
        <i data-lucide="building"></i>
        <select id="filter-client" class="form-control filter-select">
            <option value="">Tous les Clients</option>
            <c:forEach items="${clients}" var="client">
                <option value="${client.idClient}"><c:out value="${client.nomClient} ${client.prenomClient}" /></option>
            </c:forEach>
        </select>
    </div>

    <div class="filter-group">
        <i data-lucide="activity"></i>
        <select id="filter-status" class="form-control filter-select">
            <option value="">État du projet (Tous)</option>
            <option value="EN_COURS">En cours</option>
            <option value="EN_PAUSE">En pause</option>
            <option value="LIVRE">Livré</option>
            <option value="ANNULE">Annulé</option>
        </select>
    </div>

    <div class="filter-group">
        <i data-lucide="cpu"></i>
        <select id="filter-tech" class="form-control filter-select">
            <option value="">Technologie (Toutes)</option>
            <c:forEach items="${technologies}" var="tech">
                <option value="${tech.nomTechno}"><c:out value="${tech.nomTechno}" /></option>
            </c:forEach>
        </select>
    </div>
    
    <button type="button" class="btn btn-secondary" id="btn-reset-filters">
        <i data-lucide="rotate-ccw"></i> Réinitialiser
    </button>
</div>

<div class="card table-card">
    <div class="table-responsive">
        <table class="data-table" id="environnements-table">
            <thead>
                <tr>
                    <th>Type</th>
                    <th>Projet Associé</th>
                    <th>Hébergement</th>
                    <th>Stack & Points d'accès</th>
                    <th>Traçabilité</th>
                    <th class="text-right">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${environnements}" var="env">
                    <tr class="env-row" data-client="${env.projet.idClient}" data-status="${env.projet.statutProjet}">
                        
                        <td>
                            <c:choose>
                                <c:when test="${env.typeEnv == 'PRODUCTION'}"><span class="badge badge-prod">PROD</span></c:when>
                                <c:when test="${env.typeEnv == 'STAGING'}"><span class="badge badge-staging">STAGING</span></c:when>
                                <c:when test="${env.typeEnv == 'DEVELOPPEMENT'}"><span class="badge badge-dev">DEV</span></c:when>
                                <c:otherwise><span class="badge badge-local">LOCAL</span></c:otherwise>
                            </c:choose>
                        </td>

                        <td>
                            <a href="${pageContext.request.contextPath}/admin/projets/details?id=${env.projet.idProjet}" class="project-link">
                                <strong><c:out value="${env.projet.nomProjet}" /></strong>
                            </a>
                        </td>

                        <td>
                            <div class="tech-info">
                                <c:choose>
                                    <c:when test="${not empty env.serveur}">
                                        <span class="font-mono"> <span class="health-indicator status-pending" data-ip="${env.serveur.adressIP}"></span><c:out value="${env.serveur.adressIP}" /></span>
                                        <span class="text-xs text-muted"><c:out value="${env.serveur.os}" /></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="font-mono">Localhost</span>
                                        <span class="text-xs text-muted">Poste Développeur</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </td>

                        <td class="tech-cell">
                            <div class="tech-info">
                                <span class="db-name">BD : <c:out value="${env.nomBaseDeDonnees}" default="N/A" /></span>
                                <div class="env-access-links" style="margin-top: 4px;">
                                    <c:if test="${not empty env.urlFront}">
                                      <a href="<c:out value='${env.urlFront}'/>" target="_blank" class="env-access-btn env-access-btn-front" title="Ouvrir Front-end">
                                        <i data-lucide="monitor"></i> <c:out value='${env.urlFront}'/>
                                      </a>
                                    </c:if>
                                    <c:if test="${not empty env.urlBack}">
                                      <a href="<c:out value='${env.urlBack}'/>" target="_blank" class="env-access-btn env-access-btn-back" title="Ouvrir Back-end">
                                        <i data-lucide="plug"></i> <c:out value='${env.urlBack}'/>
                                      </a>
                                    </c:if>
                                    <c:if test="${empty env.urlFront and empty env.urlBack}">
                                       <span class="text-muted text-sm">—</span>
                                    </c:if>
                                </div>
                            </div>
                        </td>

                        <td>
                            <div class="trace-info">
                                <span class="trace-author"><c:out value="${env.createur.prenomUser} ${env.createur.nomUser}" /></span>
                                <span class="trace-date">
                                    <i data-lucide="calendar"></i> 
                                    <fmt:formatDate value="${env.dateCreation}" pattern="dd/MM/yyyy à HH:mm" />
                                </span>
                            </div>
                        </td>

                        <td class="text-right">
                            <c:set var="nomClientAffiche" value="Non défini" />
                            <c:forEach items="${clients}" var="c">
                                <c:if test="${c.idClient == env.projet.idClient}">
                                    <c:choose>
                                        <c:when test="${not empty c.entrepriseClient}">
                                            <c:set var="nomClientAffiche" value="${c.entrepriseClient}" />
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="nomClientAffiche" value="${c.nomClient} ${c.prenomClient}" />
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>

                            <c:set var="technoJson" value="[" />
                            <c:forEach items="${env.versions}" var="vt" varStatus="loop">
                                <c:set var="technoJson" value="${technoJson}{\"id\":\"${vt.technologie.idTechno}\", \"nom\":\"${fn:escapeXml(vt.technologie.nomTechno)}\", \"version\":\"${fn:escapeXml(vt.version)}\"}${!loop.last ? ',' : ''}" />
                            </c:forEach>
                            <c:set var="technoJson" value="${technoJson}]" />

                            <div class="actions-flex">
                                <button type="button" class="btn-icon btn-view-env" 
                                        data-env-type="${env.typeEnv}"
                                        data-env-db="${env.nomBaseDeDonnees}"
                                        data-env-server-ip="${not empty env.serveur ? env.serveur.adressIP : ''}"
                                        data-env-server-os="${not empty env.serveur ? env.serveur.os : ''}"
                                        data-env-url-front="<c:out value='${env.urlFront}'/>"
                                        data-env-url-back="<c:out value='${env.urlBack}'/>"
                                        data-env-technos='${technoJson}'
                                        data-env-projet="<c:out value='${env.projet.nomProjet}'/>"
                                        data-env-client="<c:out value='${nomClientAffiche}'/>"
                                        title="Voir la configuration">
                                    <i data-lucide="eye"></i>
                                </button>
                                <a href="${pageContext.request.contextPath}/admin/projets/details?id=${env.projet.idProjet}" class="btn-icon" title="Aller à la fiche projet">
                                    <i data-lucide="external-link"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div id="view-env-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card" style="width: min(600px, 95vw);">
    <header class="modal-header" style="align-items: flex-start; padding-bottom: 16px; border-bottom: 1px solid var(--border-light);">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background: linear-gradient(135deg, #EEF2FF 0%, #E0E7FF 100%); color: #4F46E5; border-color: rgba(79, 70, 229, 0.15);">
          <i data-lucide="eye"></i>
        </div>
        <div>
          <h2 style="display:flex; align-items:center; gap:8px;">
            Détails Environnement 
            <span id="view-env-type" class="badge badge-outline" style="font-size:0.7rem;"></span>
          </h2>
          <p class="text-xs text-muted" style="margin-top: 4px;">
            Projet : <strong id="view-env-projet" style="color: #0F172A;">...</strong> — 
            Client : <strong id="view-env-client" style="color: #0F172A;">...</strong>
          </p>
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

<script>const CONTEXT_PATH = '${pageContext.request.contextPath}';</script>
<script src="${pageContext.request.contextPath}/assets/js/healthcheck.js"></script>