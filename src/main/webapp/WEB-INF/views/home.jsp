<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>ElectroShop</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" />
</head>
<body>
  <%@ include file="/WEB-INF/views/fragments/header.jspf" %>
  <main>
    <section class="store-hero">
      <div>
        <p class="eyebrow">Linh kien dien tu</p>
        <h1>ElectroShop</h1>
        <p>Tim linh kien phu hop cho bai tap, prototype va du an dieu khien.</p>
        <a class="primary-link" href="${pageContext.request.contextPath}/products">Xem san pham</a>
      </div>
      <div class="hero-count"><strong>${productCount}</strong><span>san pham dang co san</span></div>
    </section>
    <section class="section-heading"><div><p class="eyebrow">Noi bat</p><h2>San pham moi</h2></div><a href="${pageContext.request.contextPath}/products">Xem tat ca</a></section>
    <section class="product-grid">
      <c:forEach items="${featuredProducts}" var="product">
        <article class="product-card">
          <img class="product-image" src="${pageContext.request.contextPath}${product.imageUrl}" alt="${product.name}" />
          <div class="product-body">
            <p class="product-meta"><c:out value="${product.category}" /></p>
            <h3><c:out value="${product.name}" /></h3>
            <p class="product-price">${product.price} d</p>
            <a class="secondary-link" href="${pageContext.request.contextPath}/products/${product.id}">Chi tiet</a>
          </div>
        </article>
      </c:forEach>
    </section>
  </main>
</body>
</html>
