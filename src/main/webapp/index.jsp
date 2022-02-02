<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css" charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
      integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<body>

<div id="lead">
    <a href="<%=request.getContextPath()%>/LogoutServlet">注销</a>
</div>
<h2 align="center">图书管理系统</h2>
<div class="container">

    <div class="search">
        <label>
            <input type="text" placeholder="输入你想搜索的书籍" id="search"/>
        </label>
        <button onclick="search()" class="glyphicon glyphicon-search">搜索</button>
    </div>
    <div class="bookList">
        <div class="col-md-12 column">
            <div class="panel-heading">
                <button class="btn btn-primary" onclick="toAddBook()">添加</button>
                <button class="btn btn-primary" onclick="refresh()">刷新</button>
            </div>

            <table class="table table-hover table-striped">
                <thead>

                <tr align="right">
                    <th width="50px">序号</th>
                    <th width="350px">书名</th>
                    <th width="200px">作者</th>
                    <th width="80px">价格</th>
                    <th width="120px">出版社</th>
                    <th width="150px">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.bookList}" var="book" varStatus="status">
                    <tr>
                        <td>${status.count + (sessionScope.current-1)*10}</td>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.press}</td>
                        <td>
                            <a onclick="return foo();" href="<%=request.getContextPath()%>/DeleteServlet?id=${book.id}">删除</a>
                            |
                            <a href="<%=request.getContextPath()%>/GetOneServlet?id=${book.id}">编辑</a> |
                            <a href="<%=request.getContextPath()%>/BookDetailServlet?id=${book.id}">查看详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <nav aria-label="Page navigation">
            <ul class="pagination right">
                <li>
                    <a href="<%=request.getContextPath()%>/GetServlet?current=${sessionScope.current > 1 ? sessionScope.current-1:sessionScope.current}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${sessionScope.page}" var="i">
                    <c:if test="${i==sessionScope.current}">
                        <li class="active"><a href="<%=request.getContextPath()%>/GetServlet?current=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${i!=sessionScope.current}">
                        <li><a href="<%=request.getContextPath()%>/GetServlet?current=${i}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="<%=request.getContextPath()%>/GetServlet?current=${sessionScope.current < sessionScope.page ? sessionScope.current+1:sessionScope.current}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="footer">Copyright &copy; 2021 by suhu</div>
</div>
<script type="text/javascript">
    function refresh() {
        window.location = "<%=request.getContextPath()%>/GetServlet?current=1&size=10"
    }

    function toAddBook() {
        window.location = "<%=request.getContextPath()%>/addBook.jsp"
    }

    function search() {
        s = document.getElementById("search")
        // console.log(s.value)
        window.location = "<%=request.getContextPath()%>/GetServlet?current=1&size=10&key=" + s.value
    }

    function foo() {
        return confirm("确定要删除吗？");
    }

    var input = document.getElementById("search")
    input.addEventListener("keyup", function (event) {
        event.preventDefault()
        if (event.keyCode === 13 && input.value !== "") {
            search()
        }
    })

</script>
</body>
</html>