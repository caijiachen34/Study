<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
    <title>Insert title here</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

    <script>
        function a(){
            $.post({
                url:"${pageContext.request.contextPath}/a1",
                data:{"name":$("#username").val()},
                success: function (data,status) {
                console.log("data=="+data);
                console.log("status=="+status)
                },
                error:function () {

                }
            })
        }
    </script>
</head>
<body>

    <%--失去焦点时候，发起一个请求（携带信息）到后台--%>
    用户名: <input type="text" id="username" onblur="a()">

</body>
</html>