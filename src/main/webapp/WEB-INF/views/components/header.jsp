<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<header class="top-bar">
  <div class="top-bar-left">
    <div class="breadcrumb">
      <span class="breadcrumb-item text-muted">Application</span>
      <span class="breadcrumb-sep">/</span>
      <span class="breadcrumb-item font-bold" id="page-heading">
        <c:out value="${pageTitle}" default="Dashboard" />
      </span>
    </div>
  </div>

  <div class="top-bar-search">
    <div class="search-input-wrapper">
      <i data-lucide="search" class="search-icon"></i>
      <input type="search" id="global-search" placeholder="Recherche globale..." aria-label="Rechercher" />
    </div>
  </div>

  <div class="top-bar-right">
    <button class="btn-icon" title="Notifications">
      <i data-lucide="bell"></i>
      <span class="badge-dot"></span>
    </button>
    
    <div class="v-sep"></div>

    <button class="btn btn-primary" id="btn-nouveau">
      <i data-lucide="plus"></i>
      <span class="hide-mobile">Nouveau</span>
    </button>
  </div>
</header>