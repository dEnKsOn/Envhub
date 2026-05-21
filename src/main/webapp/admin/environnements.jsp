<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Environnements - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/admin/environnements.jsp");
    request.setAttribute("pageCss", "/assets/css/environnements.css");
    request.setAttribute("pageJs", "/assets/js/environnements.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />
