<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title><c:out value="${pageTitle}" default="EnvHub - Dashboard" /></title>
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/layout.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dashboard.css">
  <c:if test="${not empty pageCss}">
    <link rel="stylesheet" href="${pageContext.request.contextPath}${pageCss}">
  </c:if>
</head>
<body>

  <div class="layout-root">
    
    <jsp:include page="/WEB-INF/views/components/sidebar.jsp" />

    <div class="layout-main">
      
      <jsp:include page="/WEB-INF/views/components/header.jsp" />

      <main class="layout-content">
        <div id="page-container" class="container">
          <c:choose>
            <c:when test="${not empty pageContent}">
              <jsp:include page="${pageContent}" />
            </c:when>
            <c:otherwise>
              <jsp:include page="/WEB-INF/views/admin/dashboard-stats.jsp" />
            </c:otherwise>
          </c:choose>
          <c:if test="${not empty pageJs}">
            <script src="${pageContext.request.contextPath}${pageJs}"></script>
          </c:if>
        </div>
      </main>

    </div>
  </div>

  <div id="toast-host" class="toast-host" aria-live="polite"></div>

  <div id="logout-modal" class="modal-overlay" role="dialog" aria-modal="true" aria-labelledby="logout-modal-title" aria-hidden="true">
    <div class="modal-card">
      <header class="modal-header">
        <h2 id="logout-modal-title">Confirmer la déconnexion</h2>
        <button type="button" class="modal-close" aria-label="Fermer la fenêtre"></button>
      </header>
      <div class="modal-body">
        <p>Voulez-vous vraiment vous déconnecter de EnvHub ?</p>
      </div>
      <div class="modal-actions">
        <button type="button" id="logout-cancel" class="btn btn-secondary">Annuler</button>
        <button type="button" id="logout-confirm" class="btn btn-danger">Déconnexion</button>
      </div>
    </div>
  </div>

  <script src="https://unpkg.com/lucide@latest"></script>

  <script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>

</body>
</html>