<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Chi ti&#x1EBF;t s&#x1EA3;n ph&#x1EA9;m</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" /></head>
<body><%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<main>
  <div class="detail-layout">
    <img class="detail-image" src="${pageContext.request.contextPath}${product.imageUrl}" alt="${product.name}" />
    <section class="content-panel detail-copy">
      <p class="product-meta"><c:out value="${product.category}" /></p>
      <h1><c:out value="${product.name}" /></h1>
      <p class="product-price">${product.price} &#x111;</p>
      <p><c:out value="${product.description}" /></p>
      <form action="${pageContext.request.contextPath}/cart/add/${product.id}" method="post"><button type="submit">Th&#xEA;m v&#xE0;o gi&#x1ECF;</button></form>
    </section>
  </div>
</main></body>
</html>
