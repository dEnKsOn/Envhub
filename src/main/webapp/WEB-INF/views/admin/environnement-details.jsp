<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="stack stack-lg">
  <a href="${pageContext.request.contextPath}/admin/environnements" class="back-link text-sm text-muted">
    <i data-lucide="arrow-left"></i>
    Retour aux environnements
  </a>

  <div>
    <h2 class="section-title">Gestion de la stack</h2>
    <p class="text-sm text-muted mt-1">
      <c:out value="${environnement.nomProjet}" /> —
      <span class="env-badge env-badge-${environnement.typeEnv}">
        <c:out value="${environnement.typeEnv}" />
      </span>
    </p>
  </div>

  <div class="card">
    <div class="card-body">
      <p class="text-center text-muted" style="padding: 2rem;">
        Module de gestion des technologies (VersionTechno) — en cours de développement.
      </p>
      <p class="text-sm text-muted text-center">
        Environnement : <code><c:out value="${environnement.idEnv}" /></code>
        <c:if test="${not empty environnement.nomBaseDeDonnees}">
          — Base : <c:out value="${environnement.nomBaseDeDonnees}" />
        </c:if>
      </p>
    </div>
  </div>
</div>
