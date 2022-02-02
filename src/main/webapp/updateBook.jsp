<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style>
        .hide {
            display: none;
        }

        .container {
            margin: 200px auto 0 auto;
        }

        .form-edit {
            width: 500px;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-edit">
        <h2 align="center">修改书籍</h2>
        <form class="form-horizontal" action="<%=request.getContextPath()%>/UpdateServlet" id="editForm">
            <input type="text" value="${sessionScope.editBook.id}" name="id" class="hide">
            <div class="form-group">
                <label for="inputUsername" class="col-sm-2 control-label">书名</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.name}" class="form-control" id="inputUsername"
                           placeholder="请输入书名" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">作者</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.author}" class="form-control" id="inputPassword"
                           placeholder="请输入作者" name="author">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPrice" class="col-sm-2 control-label">价格</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.price}" class="form-control" id="inputPrice"
                           placeholder="请输入价格" name="price">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPress" class="col-sm-2 control-label">出版社</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.press}" class="form-control" id="inputPress"
                           placeholder="请输入出版社" name="press">
                </div>
            </div>
            <div class="form-group">
                <label for="inputIsbn" class="col-sm-2 control-label">ISBN号</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.isbn}" class="form-control" id="inputIsbn"
                           placeholder="请输入ISBN号" name="isbn">
                </div>
            </div>
            <div class="form-group">
                <label for="inputIntro" class="col-sm-2 control-label">简介</label>
                <div class="col-sm-10">
                    <input type="text" value="${sessionScope.editBook.intro}" class="form-control" id="inputIntro" placeholder="请输入简介" name="intro"/>
                </div>
            </div>
            <%--            <input type="text" value="${sessionScope.editBook.picUrl}" name="picUrl" class="hide"><br>--%>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button onclick="back()">取消</button>
                    <button type="reset">还原修改</button>
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
            console.log(value)
            if (value === "") {
                form[i].focus()
                return
            }
        }
        if (isNaN(Number(form[3].value))) {
            window.alert("请输入正确的价格！")
            form[3].focus()
            return
        }
        document.getElementById("editForm").submit()
    }
</script>
</body>
</html>
