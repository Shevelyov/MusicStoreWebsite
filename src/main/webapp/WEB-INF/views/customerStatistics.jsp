<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Table CSS -->
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Statistics Page</h1>

            <p class="lead">This is the customer statistics page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Username</th>
                <th>Product name</th>
                <th>Opened</th>
            </tr>
            </thead>
            <c:forEach items="${userStatisticsList}" var="userStatistic">
                <tr>
                    <td>${userStatistic.customer.username}</td>
                    <td>${userStatistic.product.productName}</td>
                    <td>${userStatistic.clicksCount}</td>
                </tr>
            </c:forEach>
        </table>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
