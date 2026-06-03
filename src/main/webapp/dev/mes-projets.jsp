<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Mes Projets - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/dev/dev-mes-projets.jsp");
    request.setAttribute("pageCss", "/assets/css/dev-projets.css"); 
    request.setAttribute("pageJs", "/assets/js/dev-projets.js"); 
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />