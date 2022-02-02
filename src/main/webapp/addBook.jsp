<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style>
        .container {
            margin: 200px auto 0 auto;
        }

        .form-add {
            width: 500px;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-add">
        <h2 align="center">添加书籍</h2>
        <form class="form-horizontal" action="<%=request.getContextPath()%>/AddServlet" id="addForm">
            <div class="form-group">
                <label for="inputUsername" class="col-sm-2 control-label">书名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUsername" placeholder="请输入书名" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">作者</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPassword" placeholder="请输入作者" name="author">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPrice" class="col-sm-2 control-label">价格</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPrice" placeholder="请输入价格" name="price">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPress" class="col-sm-2 control-label">出版社</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPress" placeholder="请输入出版社" name="press">
                </div>
            </div>
            <div class="form-group">
                <label for="inputIsbn" class="col-sm-2 control-label">ISBN号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIsbn" placeholder="请输入ISBN号" name="isbn">
                </div>
            </div>
            <div class="form-group">
                <label for="inputIntro" class="col-sm-2 control-label">简介</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="inputIntro" placeholder="请输入简介" name="intro"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button type="button" onclick="back()">取消</button>
                    <button type="reset">全部清除</button>
                    <button type="button" onclick="check()">提交</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    function back() {
        window.location = "index.jsp"
    }

    function check() {
        const form = document.getElementsByTagName("input")
        for (let i = 0; i < form.length; i++) {
            const value = form[i].value
            if (value === "") {
                form[i].focus()
                return
            }

        }
        if (isNaN(Number(form[2].value))) {
            window.alert("请输入正确的价格！")
            form[2].focus()
            return
        }

        document.getElementById("addForm").submit()
    }
</script>
</body>
</html>
