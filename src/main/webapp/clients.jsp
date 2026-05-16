<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Clients - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/clients.jsp");
    request.setAttribute("pageCss", "/assets/css/clients.css");
    request.setAttribute("pageJs", "/assets/js/clients.js");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />