<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lixiao
  Date: 2017/4/9
  Time: 下午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>2:上传头像</h3>
<form action="/upload/upload" method="POST"
      enctype="multipart/form-data">
    文件1：<input type="file" name="file"/><br/>
    <s:submit value="提交"></s:submit>
</form>

</body>
</html>
