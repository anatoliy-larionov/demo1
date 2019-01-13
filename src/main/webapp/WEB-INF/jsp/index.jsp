<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="shared/header.jsp"%>
<div id="container">
    <header id="main-header">
        <div id="name-user">Ларионов Анатолий</div>
        <div id="a-exit"><a href="authorization">Выход</a></div>
        <c:if var="users"  test="${user.role == 'ADMIN'}">
            <div id="add-item"><a href="<c:url value="/admin"/>">Добавить товар</a></div>
        </c:if>

        <%@include file="search.jsp"%>
        <%@include file="basket.jsp"%>
    </header>
    <section class="main-section">
        <div class="items-wrapper">
            <c:forEach items="${categories}" var="category">
                <div class="name-category">${category.name}</div>
                <c:forEach items="${category.products}" var="product">
                    <div class="item">
                        <div class="item-view">
                            <div class="item-img">
                                <img class="size-img" src="../category/kalyan/Kalayn Black Stone.JPG" alt="Black Stone">
                            </div>
                            <div class="item-name">${product.name}</div>
                        </div>
                        <div class="item-details">
                            <div class="item-description">${product.description}</div>
                            <div>Цена: <span class="item-price">${product.price}</span>$</div>
                            <div class="put-basket"><input class="add-basket" type="button" id="${product.id}" value="Положить в корзину">
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:forEach>
        </div>
    </section>
<%@include file="shared/footer.jsp"%>
