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
</header>