<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Détails du Projet - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/dev/dev-projet-details.jsp");
    request.setAttribute("pageCss", "/assets/css/dev-projet-details.css"); 
    request.setAttribute("pageJs", "/assets/js/dev-projet-details.js"); 
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />