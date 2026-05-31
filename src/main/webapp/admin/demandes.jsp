<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Demandes Clients - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/admin/demandes.jsp");
    request.setAttribute("pageCss", "/assets/css/demandes.css"); 
    request.setAttribute("pageJs", "/assets/js/demandes.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />
