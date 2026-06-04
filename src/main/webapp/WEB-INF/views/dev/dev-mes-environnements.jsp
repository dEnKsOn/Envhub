<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="stack stack-lg">

  <header class="flex items-center justify-between wrap gap-4">
    <div>
      <h1 class="page-title flex items-center gap-2">
        <i data-lucide="terminal-square" class="text-primary"></i> 
        Mes Accès & URLs
      </h1>
      <p class="text-muted text-sm mt-1">L'ensemble des environnements déployés pour vos projets actifs.</p>
    </div>
    
    <div class="search-form" id="search-form" style="min-width: 300px;">
      <div class="input-with-icon search-input-wrapper">
        <i data-lucide="search"></i>
        <input type="text" id="search-input" placeholder="Rechercher une URL, un projet..." autocomplete="off">
      </div>
    </div>
  </header>

  <div class="card stack stack-sm">
    <div class="table-responsive env-table-wrapper" style="border: none;">
      <table class="data-table env-table">
        <thead>
          <tr>
            <th>Projet</th>
            <th>Type</th>
            <th>Serveur</th>
            <th>Points d'accès (URLs)</th>
            <th>Base de données</th>
          </tr>
        </thead>
        <tbody id="env-table-body">
          <c:choose>
            <c:when test="${not empty mesEnvironnements}">
              <c:forEach items="${mesEnvironnements}" var="env">
                <tr>
                  <td><strong><c:out value="${env.projet.nomProjet}" /></strong></td>
                  
                  <td>
                    <span class="env-badge env-badge-${env.typeEnv}">
                      <c:out value="${env.typeEnv}" />
                    </span>
                  </td>
                  
                  <td>
                    <c:choose>
                      <c:when test="${not empty env.serveur and not empty env.serveur.adressIP}">
                        <span class="env-server-host flex items-center gap-2">
                          <i data-lucide="server" class="text-muted" style="width:16px;"></i>
                          <span><c:out value="${env.serveur.adressIP}" /></span>
                          <button class="btn-copy" data-clipboard="${env.serveur.adressIP}" title="Copier l'IP">
                            <i data-lucide="copy"></i>
                          </button>
                        </span>
                      </c:when>
                      <c:otherwise><span class="text-muted text-sm">—</span></c:otherwise>
                    </c:choose>
                  </td>
                  
                  <td>
                    <div class="env-access-links">
                      <c:if test="${not empty env.urlFront}">
                        <div class="flex items-center gap-1">
                          <a href="<c:out value='${env.urlFront}'/>" target="_blank" class="env-access-btn env-access-btn-front" title="Ouvrir Front">
                            <i data-lucide="monitor"></i> Front
                          </a>
                          <button class="btn-copy" data-clipboard="${env.urlFront}" title="Copier l'URL">
                            <i data-lucide="copy"></i>
                          </button>
                        </div>
                      </c:if>
                      
                      <c:if test="${not empty env.urlBack}">
                        <div class="flex items-center gap-1">
                          <a href="<c:out value='${env.urlBack}'/>" target="_blank" class="env-access-btn env-access-btn-back" title="Ouvrir API">
                            <i data-lucide="plug"></i> API
                          </a>
                          <button class="btn-copy" data-clipboard="${env.urlBack}" title="Copier l'URL">
                            <i data-lucide="copy"></i>
                          </button>
                        </div>
                      </c:if>
                    </div>
                  </td>
                  
                  <td>
                    <c:choose>
                      <c:when test="${not empty env.nomBaseDeDonnees}">
                        <div class="flex items-center gap-2">
                          <code class="env-db-name"><c:out value="${env.nomBaseDeDonnees}" /></code>
                          <button class="btn-copy" data-clipboard="${env.nomBaseDeDonnees}" title="Copier le nom">
                            <i data-lucide="copy"></i>
                          </button>
                        </div>
                      </c:when>
                      <c:otherwise><span class="text-muted">—</span></c:otherwise>
                    </c:choose>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="5" class="text-center text-muted" style="padding: 3rem;">
                  <i data-lucide="hard-drive" style="width:48px;height:48px;margin-bottom:10px;opacity:0.5;"></i><br/>
                  Aucun environnement n'est configuré pour vos projets actuels.
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<style>
  .btn-copy {
    background: transparent; border: none; color: #94A3B8; cursor: pointer;
    padding: 4px; border-radius: 4px; transition: all 0.2s; display: inline-flex;
  }
  .btn-copy:hover { color: var(--primary); background: #EFF6FF; }
  .btn-copy i { width: 14px; height: 14px; }
  .copied-success { color: #10B981 !important; }
</style>