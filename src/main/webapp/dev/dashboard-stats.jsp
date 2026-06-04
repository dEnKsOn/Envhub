<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Mon Espace - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/dev/dev-dashboard-stats.jsp");
    request.setAttribute("pageCss", "/assets/css/dashboard-stats.css");
    request.setAttribute("pageJs", "/assets/js/dashboard.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />