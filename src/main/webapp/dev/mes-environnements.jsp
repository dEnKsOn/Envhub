<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Mes Environnements - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/dev/dev-mes-environnements.jsp");
    
    // On réutilise le CSS des projets-details pour avoir le beau design des badges d'environnements
    request.setAttribute("pageCss", "/assets/css/projets-details.css"); 
    request.setAttribute("pageJs", "/assets/js/dev-environnements.js"); 
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />