<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>ADD TODO</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <div class="container">
    <form:form method="post" modelAttribute="todo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="description"> Description </form:label>
            <form:input path="description" type="text"
                        class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" class="btn btn-success" value="Submit">
    </form:form>
    </div>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>