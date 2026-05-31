<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

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
                    <th>Stack & Base de données</th>
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
                                        <span class="font-mono"><c:out value="${env.serveur.adressIP}" /></span>
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
                                <div class="urls-mini">
                                    <c:if test="${not empty env.urlFront}"><span title="${env.urlFront}">Front</span></c:if>
                                    <c:if test="${not empty env.urlBack}"><span title="${env.urlBack}">API</span></c:if>
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
                            <div class="actions-flex">
                                <button type="button" class="btn-icon btn-view-env" 
                                        data-id="${env.idEnv}"
                                        data-front="${env.urlFront}"
                                        data-back="${env.urlBack}"
                                        data-db="${env.nomBaseDeDonnees}"
                                        data-notes="${env.notes}"
                                        title="Kit de Configuration">
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

<div id="modal-env-details" class="modal-overlay">
    <div class="modal-card">
        <header class="modal-header">
            <div class="modal-header-content">
                <div class="modal-icon"><i data-lucide="server-cog"></i></div>
                <div>
                    <h3>Kit de Configuration</h3>
                    <p class="text-xs text-muted">Paramètres d'accès réseau de l'instance</p>
                </div>
            </div>
            <button type="button" class="modal-close" id="btn-close-modal"><i data-lucide="x"></i></button>
        </header>
        
        <div class="modal-body">
            <div class="config-grid">
                <div class="config-item">
                    <span class="config-label">URL Front-end</span>
                    <div class="copy-box">
                        <span id="modal-front-url" class="font-mono">...</span>
                        <button class="btn-copy" title="Copier"><i data-lucide="copy"></i></button>
                    </div>
                </div>
                <div class="config-item">
                    <span class="config-label">URL API / Back-end</span>
                    <div class="copy-box">
                        <span id="modal-back-url" class="font-mono">...</span>
                        <button class="btn-copy" title="Copier"><i data-lucide="copy"></i></button>
                    </div>
                </div>
                <div class="config-item">
                    <span class="config-label">Base de données cible</span>
                    <div class="copy-box">
                        <span id="modal-db-name" class="font-mono">...</span>
                        <button class="btn-copy" title="Copier"><i data-lucide="copy"></i></button>
                    </div>
                </div>
            </div>
            
            <div class="notes-container mt-4">
                <span class="config-label">Notes techniques / Scripts de lancement</span>
                <div class="notes-box" id="modal-notes"></div>
            </div>
        </div>
    </div>
</div>