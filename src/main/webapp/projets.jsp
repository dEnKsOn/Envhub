<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Projets - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/projets.jsp");
    request.setAttribute("pageCss", "/assets/css/projets.css");
    request.setAttribute("pageJs", "/assets/js/projets.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />