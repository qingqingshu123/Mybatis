<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--在写控件跳转 和 向jsp 传值有用-->
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <!--
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
  -->
  <title>内容列表页面</title>
  <link rel="stylesheet"
      type="text/css"
        href="<c:url value="/resources/css/all.css"/>"/>
  <script src="/resources/js/common/jquery-1.8.0.min.js" type="text/javascript"></script>
  <script src="/resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<!--此处常用，应该用path-->
<form action="<%= basePath %>/List.action" id="mainForm" method="post">
  <div class="right">
    <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
    <div class="rightCont">
      <p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
      <table class="tab1">
        <tbody>
        <tr>
          <td width="90" align="right"> 指令名称：</td>
          <td>
            <input name="command" type="text" class="allInput" value="${command}"/> <!-- value 向页面传值-->
          </td>
          <td width="90" align="right">描述：</td>
          <td>
            <input name="description" type="text" class="allInput" value="${description}"/>
          </td>
          <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
        </tr>
        </tbody>
      </table>
      <div class="zixun fix">
        <table class="tab2" width="100%">
          <tbody>
          <tr>
            <th><input type="checkbox" id="all" onclick="#"/></th>
            <th>序号</th>
            <th>指令名称</th>
            <th>描述</th>
            <th>操作</th>
          </tr>
          <c:forEach  var="message" items="${messageList}" varStatus="status">
            <tr <c:if test="${status.index%2 != 0}">style="background-color:#ECF6EE;"</c:if>>
              <td><input type="checkbox" name="ids"  value="${message.id}"/></td>
              <td>${status.index+1}</td>
              <td>${message.command}</td>
              <td>${message.description}</td>
              <td>${message.content}</td>
              <td>
                <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                <a href="/DeleceOne.action?id=${message.id}">删除</a>
              </td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
        <div class='page fix'>
          共 <b>4</b> 条
          <a href='###' class='first'>首页</a>
          <a href='###' class='pre'>上一页</a>
          当前第<span>1/1</span>页
          <a href='###' class='next'>下一页</a>
          <a href='###' class='last'>末页</a>
          跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
          <a href='###' class='go'>GO</a>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>