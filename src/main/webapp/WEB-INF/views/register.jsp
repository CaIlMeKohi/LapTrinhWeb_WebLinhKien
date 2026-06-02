<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html><html><head><title>Dang ky</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" /></head>
<body class="bg-slate-950 text-slate-100"><%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<main class="mx-auto max-w-xl px-4 py-12"><h1 class="text-3xl font-semibold">Dang ky tai khoan</h1>
<c:if test="${not empty emailExists}"><p class="mt-4 text-red-300"><c:out value="${emailExists}" /></p></c:if>
<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="registerForm" cssClass="mt-6 grid gap-4">
<label>Ho va ten<form:input path="fullName" cssClass="mt-2 w-full rounded border px-3 py-2 text-slate-950" /><form:errors path="fullName" cssClass="text-red-300" /></label>
<label>Email<form:input path="email" type="email" cssClass="mt-2 w-full rounded border px-3 py-2 text-slate-950" /><form:errors path="email" cssClass="text-red-300" /></label>
<label>Mat khau<form:password path="password" cssClass="mt-2 w-full rounded border px-3 py-2 text-slate-950" /><form:errors path="password" cssClass="text-red-300" /></label>
<button class="rounded bg-cyan-400 px-4 py-2 text-slate-950">Dang ky</button></form:form></main></body></html>
