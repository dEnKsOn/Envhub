<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<aside class="sidebar">
  <div class="sidebar-header">
    <div class="sidebar-logo">
      <div class="logo-box">
        <i data-lucide="blocks"></i>
      </div>
      <span class="logo-text">EnvHub</span>
    </div>
  </div>

  <nav class="sidebar-nav">
    
    <%-- ========================================================== --%>
    <%-- MENU ADMINISTRATEUR                                        --%>
    <%-- ===========================globe=============================== --%>
    <c:if test="${sessionScope.user.profil.libelle == 'Administrateur'}">
      <div class="nav-group">
        <p class="nav-group-label">- Navigation globale -</p>
        
        <a href="${pageContext.request.contextPath}/dashboard" class="nav-item ${pageContext.request.requestURI.contains('dashboard') ? 'is-active' : ''}">
          <i data-lucide="bar-chart-3"></i>
          <span>Dashboard Général</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/projets" class="nav-item ${pageContext.request.requestURI.contains('projets') ? 'is-active' : ''}">
          <i data-lucide="folder-open"></i>
          <span>Tous les Projets</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/environnements" class="nav-item ${pageContext.request.requestURI.contains('admin/environnements') ? 'is-active' : ''}">
          <i data-lucide="network"></i>
          <span>Parc Environnements</span>
        </a>
      </div>
      
      <div class="nav-group mt-4">
        <p class="nav-group-label">- Administration -</p>
        
        <a href="${pageContext.request.contextPath}/admin/demandes" class="nav-item ${pageContext.request.requestURI.contains('demandes') ? 'is-active' : ''}">
          <i data-lucide="inbox"></i>
          <span>Demandes clients</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/utilisateurs" class="nav-item ${pageContext.request.requestURI.contains('utilisateurs') ? 'is-active' : ''}">
          <i data-lucide="users"></i>
          <span>Utilisateurs</span>
        </a>

        <a href="${pageContext.request.contextPath}/admin/clients" class="nav-item ${pageContext.request.requestURI.contains('clients') ? 'is-active' : ''}">
          <i data-lucide="briefcase"></i>
          <span>Clients</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/serveurs" class="nav-item ${pageContext.request.requestURI.contains('serveurs') ? 'is-active' : ''}">
          <i data-lucide="server"></i>
          <span>Serveurs</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/technologies" class="nav-item ${pageContext.request.requestURI.contains('technologies') ? 'is-active' : ''}">
          <i data-lucide="code-2"></i>
          <span>Technologies</span>
        </a>
      </div>
    </c:if>

    <%-- ========================================================== --%>
    <%-- MENU DÉVELOPPEUR / CHEF DE PROJET                          --%>
    <%-- ========================================================== --%>
    <c:if test="${sessionScope.user.profil.libelle == 'Développeur'}">
      <div class="nav-group">
        <p class="nav-group-label">- Mon Espace de Travail -</p>
        
        <a href="${pageContext.request.contextPath}/dev/dashboard" class="nav-item ${pageContext.request.requestURI.contains('dev/dashboard') ? 'is-active' : ''}">
          <i data-lucide="layout-dashboard"></i>
          <span>Mon Résumé</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/dev/mes-projets" class="nav-item ${pageContext.request.requestURI.contains('mes-projets') ? 'is-active' : ''}">
          <i data-lucide="folder-kanban"></i>
          <span>Mes Projets</span>
        </a>
        
        <a href="${pageContext.request.contextPath}/dev/mes-environnements" class="nav-item ${pageContext.request.requestURI.contains('mes-environnements') ? 'is-active' : ''}">
          <i data-lucide="terminal-square"></i>
          <span>Mes Accès & URLs</span>
        </a>
      </div>
    </c:if>

  </nav>

  <div class="sidebar-footer">
    <div class="user-block">
      <button id="user-menu-trigger" class="user-trigger">
        <div class="avatar">
          <c:if test="${sessionScope.user.profil.libelle == 'Administrateur'}">
            <i data-lucide="user-star""></i>
          </c:if>
          <c:if test="${empty sessionScope.user.profil.libelle || sessionScope.user.profil.libelle != 'Administrateur'}">
            <i data-lucide="user"></i>
          </c:if>
        </div>
        <div class="user-meta">
          <span class="user-name"><c:out value="${sessionScope.user.prenomUser} ${sessionScope.user.nomUser}" /></span>
          <span class="user-role"><c:out value="${sessionScope.user.profil.libelle}" /></span>
        </div>
        <i data-lucide="chevron-up" class="user-chevron"></i>
      </button>

      <div id="user-menu-dropdown" class="dropdown-panel dropdown-panel--user is-hidden">
        <div class="p-2">
          <a href="${pageContext.request.contextPath}/profil" class="dropdown-item">
            <i data-lucide="user-cog"></i> Mon Profil
          </a>
          <hr class="dropdown-sep" />
          <form id="logout-form" action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" class="dropdown-item text-red-600">

              <i data-lucide="log-out"></i> Déconnexion
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</aside>