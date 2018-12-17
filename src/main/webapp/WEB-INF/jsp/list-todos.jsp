<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TODOS</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1></h1>
<div class="container">
<table class="table table-striped">
    <caption>My Businesses are:</caption>
    <thead>
    <tr>
    <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.description} </td>
            <td><a type="button" class="btn btn-warning" href="/update-todo?id=${todo.id}">Edit</a></td>
            <td><a type="button" class="btn btn-success" href="/delete-todo?id=${todo.id}">Done!</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div><a class="btn btn-success" href="/todo">Add TODO</a></div>
</div>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>