<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Utilisateurs - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/admin/utilisateurs.jsp");
    request.setAttribute("pageCss", "/assets/css/utilisateur.css");
    request.setAttribute("pageJs", "/assets/js/utilisateurs.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />