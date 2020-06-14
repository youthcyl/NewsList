<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/14
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>产品管理</title>
    <link rel="stylesheet" type="text/css" href="css/Iframe.css" />
    <link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
<span class="cp_title">新闻管理</span>
<div class="add_cp">
    <a href="logo.html">+添加新闻</a>
</div>
<div class="table_con">
    <table>
        <tr class="tb_title">
            <td width="5%">ID</td>
            <td width="15%">类别</td>
            <td width="20%">标题</td>
            <td width="20%">内容</td>
            <td width="15%">作者</td>
            <td width="10%">时间</td>
            <td width="15%">操作</td>
        </tr>
        <c:forEach var="news" items="${listNews}" >
            <tr>
                <td width="5%">${news.newsid}</td>
                <td width="15%">${news.category}</td>
                <td width="20%">${news.title}</td>
                <td width="20%">${news.contents} </td>
                <td width="15%">${news.author}</td>
                <td width="10%">${news.newsdate}</td>
                <td width="15%">
                    <a href="editServlet?newid=${news.newsid}" class="del_btn">编辑</a>
                    <a href="viewServlet?newid=${news.newsid}" class="del_btn">查看</a>
                    <a href="deleteServlet?newid=${news.newsid}" class="del_btn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
