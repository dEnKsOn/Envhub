<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<aside class="sidebar">
  <div class="sidebar-header">
    <div class="sidebar-logo">
      <div class="logo-box">
        <i data-lucide="globe"></i>
      </div>
      <span class="logo-text">EnvHub</span>
    </div>
  </div>

  <nav class="sidebar-nav">
    <div class="nav-group">
      <p class="nav-group-label">- Navigation principale -</p>
      
      <a href="${pageContext.request.contextPath}/dashboard" class="nav-item ${pageContext.request.requestURI.contains('dashboard') ? 'is-active' : ''}">
        <i data-lucide="bar-chart-3"></i>
        <span>Dashboard</span>
      </a>
      
      <a href="${pageContext.request.contextPath}/projets" class="nav-item ${pageContext.request.requestURI.contains('projets') ? 'is-active' : ''}">
        <i data-lucide="folder-open"></i>
        <span>Projets</span>
      </a>
      
      <a href="${pageContext.request.contextPath}/environnements" class="nav-item ${pageContext.request.requestURI.contains('environnements') ? 'is-active' : ''}">
        <i data-lucide="network"></i>
        <span>Environnements</span>
      </a>
    </div>
    
    <div class="nav-group mt-4">
      <p class="nav-group-label">- Administration -</p>
      
      <a href="${pageContext.request.contextPath}/admin/utilisateurs" class="nav-item ${pageContext.request.requestURI.contains('utilisateurs') ? 'is-active' : ''}">
        <i data-lucide="users"></i>
        <span>Utilisateurs</span>
      </a>

      <a href="${pageContext.request.contextPath}/clients" class="nav-item ${pageContext.request.requestURI.contains('clients') ? 'is-active' : ''}">
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
  </nav>

  <div class="sidebar-footer">
    <div class="user-block">
      <button id="user-menu-trigger" class="user-trigger">
        <div class="avatar">
          <i data-lucide="user"></i>
        </div>
        <div class="user-meta">
          <span class="user-name"><c:out value="${sessionScope.user.prenomUser}" /></span>
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