<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="stack stack-lg">
  <div>
    <h2 class="section-title">Vue d'ensemble</h2>
    <p class="text-sm text-muted mt-1">Statistiques globales du parc EnvHub</p>
  </div>

  <div class="grid grid-4">
    <article class="card">
      <div class="card-body">
        <div class="flex items-center justify-between">
          <p class="text-sm font-medium text-muted">Projets Actifs</p>
          <span class="text-green-600"><i data-lucide="trending-up"></i></span>
        </div>
        <div class="mt-2">
          <h3 class="text-2xl font-bold"><c:out value="${kpiProjetsActifs}" default="0" /></h3>
          <p class="text-xs text-muted-foreground">+2 depuis le mois dernier</p>
        </div>
      </div>
    </article>

    <article class="card">
      <div class="card-body">
        <div class="flex items-center justify-between">
          <p class="text-sm font-medium text-muted">Environnements</p>
          <span class="text-blue-500"><i data-lucide="globe"></i></span>
        </div>
        <div class="mt-2">
          <h3 class="text-2xl font-bold"><c:out value="${kpiTotalEnvs}" default="0" /></h3>
          <p class="text-xs text-muted-foreground">Instances configurées</p>
        </div>
      </div>
    </article>

    <article class="card">
      <div class="card-body">
        <div class="flex items-center justify-between">
          <p class="text-sm font-medium text-muted">Avancement Moyen</p>
          <span class="text-amber-500"><i data-lucide="clock"></i></span>
        </div>
        <div class="mt-2">
          <h3 class="text-2xl font-bold"><c:out value="${kpiMoyenneAvancement}" default="0" />%</h3>
          <div class="progress-bar mt-2">
            <div class="progress-fill bg-amber-500" style="width: ${not empty kpiMoyenneAvancement ? kpiMoyenneAvancement : 0}%"></div>
          </div>
        </div>
      </div>
    </article>

    <article class="card">
      <div class="card-body">
        <div class="flex items-center justify-between">
          <p class="text-sm font-medium text-muted">Alertes Orphelins</p>
          <span class="text-red-500"><i data-lucide="alert-triangle"></i></span>
        </div>
        <div class="mt-2">
          <h3 class="text-2xl font-bold"><c:out value="${kpiOrphelins}" default="0" /></h3>
          <p class="text-xs text-muted-foreground text-red-600">Projets sans équipe</p>
        </div>
      </div>
    </article>
  </div>

  <div class="grid grid-2">
    <article class="card">
      <header class="card-header"><h2 class="card-title">Répartition des Statuts</h2></header>
      <div class="card-body">
        <div class="stack stack-sm">
          <div class="flex items-center justify-between text-sm">
            <span>En cours</span>
            <span class="font-bold"><c:out value="${statusEnCours}" default="0" />%</span>
          </div>
          <div class="progress-bar">
            <div class="progress-fill bg-blue-500" style="width: ${not empty statusEnCours ? statusEnCours : 0}%"></div>
          </div>
          
          <div class="flex items-center justify-between text-sm mt-2">
            <span>Livré</span>
            <span class="font-bold"><c:out value="${statusLivre}" default="0" />%</span>
          </div>
          <div class="progress-bar">
            <div class="progress-fill bg-green-500" style="width: ${not empty statusLivre ? statusLivre : 0}%"></div>
          </div>
        </div>
      </div>
    </article>

    <article class="card">
      <header class="card-header"><h2 class="card-title">Top Technologies</h2></header>
      <div class="card-body">
        <div class="stack stack-sm">
          <c:forEach items="${topTechs}" var="tech">
            <div class="flex items-center justify-between text-sm">
              <span><c:out value="${tech.nom}" /></span>
              <span class="font-bold"><c:out value="${tech.pourcentage}" default="0" />%</span>
            </div>
            <div class="progress-bar">
              <div class="progress-fill" style="width: ${not empty tech.pourcentage ? tech.pourcentage : 0}%; background: var(--primary);"></div>
            </div>
          </c:forEach>
          
          <c:if test="${empty topTechs}">
            <p class="text-sm text-muted text-center py-4">Aucune donnée disponible pour le moment.</p>
          </c:if>
        </div>
      </div>
    </article>
  </div>
</div>