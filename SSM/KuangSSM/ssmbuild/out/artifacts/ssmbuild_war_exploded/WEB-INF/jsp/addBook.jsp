<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/6/29
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <%--BootStrap美化--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>

        </div>

        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            书籍名称：<input class="form-control" type="text" name="bookName" required><br><br><br>
            书籍数量：<input class="form-control" type="text" name="bookCounts" required><br><br><br>
            书籍详情：<input class="form-control" type="text" name="detail" required><br><br><br>

            <input type="submit" class="form-control" value="添加">

        </form>

    </div>

</body>
</html>
