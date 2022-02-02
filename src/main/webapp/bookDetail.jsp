<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍详情</title>
    <style>
        .container {
            /*background-color: #e3cfcf;*/
            margin: 150px auto;
            width: 80%;
            height: 500px;
            text-align: center;
        }

        .msg {
            width: 50%;
            /*background-color: #59a9fa;*/
            margin: auto;
            text-align: left;
        }

        .p1 {
            font-size: 20px;
            height: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>《${requestScope.book.name}》</h1>
    <div class="msg">
        <p style="text-align: left; font-size: 22px">${requestScope.book.intro}</p>
        <div style="float: left; width: 400px">
            <div class="p1">
                作者：${requestScope.book.author}
            </div>
            <div class="p1">
                出版社：${requestScope.book.press}
            </div>

        </div>
        <div>
            <div class="p1">
                ISBN：${requestScope.book.isbn}
            </div>
            <div class="p1">
                单价：${requestScope.book.price}
            </div>
        </div>
    </div>
    <button onclick="back()">返回</button>
</div>
<script>
    function back() {
        window.location =  "index.jsp"
    }
</script>
</body>

</html>
