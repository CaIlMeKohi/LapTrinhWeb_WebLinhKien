<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>S&#x1EA3;n ph&#x1EA9;m</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" /></head>
<body><%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<main>
  <h1 class="page-heading">T&#x1EA5;t c&#x1EA3; s&#x1EA3;n ph&#x1EA9;m</h1>
  <p class="page-subtitle">L&#x1EF1;a ch&#x1ECD;n linh ki&#x1EC7;n ph&#xF9; h&#x1EE3;p cho b&#x1ED9; m&#xE1;y c&#x1EE7;a b&#x1EA1;n.</p>
  <div class="product-grid">
    <c:forEach items="${products}" var="product">
      <article class="product-card">
        <img class="product-image" src="${pageContext.request.contextPath}${product.imageUrl}" alt="${product.name}" />
        <div class="product-body">
          <p class="product-meta"><c:out value="${product.category}" /></p>
          <h2><c:out value="${product.name}" /></h2>
          <p class="product-price">${product.price} &#x111;</p>
          <div class="product-actions">
            <a class="secondary-link" href="${pageContext.request.contextPath}/products/${product.id}">Chi ti&#x1EBF;t</a>
            <form action="${pageContext.request.contextPath}/cart/add/${product.id}" method="post"><button type="submit">Th&#xEA;m v&#xE0;o gi&#x1ECF;</button></form>
          </div>
        </div>
      </article>
    </c:forEach>
  </div>
</main></body>
</html>
