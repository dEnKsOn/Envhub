<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setAttribute("pageTitle", "Technologies - EnvHub");
    request.setAttribute("pageContent", "/WEB-INF/views/admin/technologies.jsp");
%>
<jsp:include page="/WEB-INF/views/base_layout.jsp" />