<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <c:forEach items="${categories}" var="category">
        <div>${category.name}</div>

        <a href="/">Назад</a>

    <table>
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Описание</th>
            <th>Добавить</th>
        </tr>
        <tr>
            <form action="/admin/${category.id}/" method="post">
                <td>
                    <input type="text" name="name" id="name-p" placeholder="Название продукта" required>
                </td>
                <td>
                    <input type="number" name="price" id="price-p" placeholder="Цена продукта" required>
                </td>
                <td>
                    <input type="text" name="description" id="description-p" placeholder="Описание продукта" required>
                </td>
                <td>
                    <input id="add-btn-product" type="submit" value="Добавить">
                </td>
            </form>
        </tr>
        <c:forEach items="${category.products}" var="product">
            <tr>
                <form action="admin/update/${product.id}" method="post">
                    <td><input type="text" name="name" id="name" placeholder="Название продукта" value = "${product.name}"/></td>
                    <td><input type="text" name="price" id="cost" placeholder="Цена" value = "${product.price}"/></td>
                    <td><input type="text" name="description" id="description"  placeholder="Описание продукта" value = "${product.description}"/></td>
                    <td>
                        <input id="update-product" type="submit" value="Изменить">
                    </td>
                </form>
                <td>
                 <%--   <form:form action="admin/delete/${category.id}/${product.id}" method="post">
                        <input id="delete-product" type="submit" value="X">
                    </form:form>--%>
                    <a href="admin/delete/${category.id}/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:forEach>
</div>
<%@include file="shared/footer.jsp"%>