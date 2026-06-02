<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><title>Gio hang</title><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css?v=20260602-2" /></head><body><%@ include file="/WEB-INF/views/fragments/header.jspf" %><main><h1>Gio hang</h1>
<c:forEach items="${cartLines}" var="line"><section><b>${line.product.name}</b> - ${line.subtotal} d
<form action="${pageContext.request.contextPath}/cart/update/${line.product.id}" method="post"><input name="quantity" type="number" min="1" value="${line.quantity}" /><button>Cap nhat</button></form>
<form action="${pageContext.request.contextPath}/cart/remove/${line.product.id}" method="post"><button>Xoa</button></form></section></c:forEach>
<form action="${pageContext.request.contextPath}/cart/clear" method="post"><button>Xoa gio hang</button></form><a href="${pageContext.request.contextPath}/checkout">Thanh toan</a></main></body></html>
