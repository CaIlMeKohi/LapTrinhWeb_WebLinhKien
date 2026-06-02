<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><title>Ho so</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" /></head><body class="bg-slate-950 text-slate-100"><%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<main class="mx-auto max-w-xl px-4 py-10"><h1 class="text-3xl font-semibold">Ho so ca nhan</h1><c:if test="${not empty profileError}"><p class="text-red-300">${profileError}</p></c:if><c:if test="${not empty profileSuccess}"><p class="text-cyan-300">${profileSuccess}</p></c:if>
<form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data" class="mt-6 grid gap-4">
<label>Ho va ten<input name="fullName" value="<c:out value='${sessionScope.currentUser.fullName}' />" class="mt-2 w-full rounded border px-3 py-2 text-slate-950" /></label>
<label>So dien thoai<input name="phone" value="<c:out value='${sessionScope.currentUser.phone}' />" class="mt-2 w-full rounded border px-3 py-2 text-slate-950" /></label>
<label>Dia chi<input name="address" value="<c:out value='${sessionScope.currentUser.address}' />" class="mt-2 w-full rounded border px-3 py-2 text-slate-950" /></label>
<label>Avatar<input name="avatar" type="file" class="mt-2 w-full" /></label><button class="rounded bg-cyan-400 px-4 py-2 text-slate-950">Cap nhat</button></form></main></body></html>
