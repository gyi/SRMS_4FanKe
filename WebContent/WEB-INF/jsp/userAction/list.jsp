<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>员工列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>
	
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /> 
				员工管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="100px">姓名</td>
					<td width="100px">工号</td>
					<td width="100px">分店号</td>
					<td width="100px">分店名</td>
					<td width="100px">权限</td>
					<td>相关操作</td>
				</tr>
			</thead>
			
			<!--显示数据列表-->
			
			<tbody id="TableData" class="dataContainer" datakey="userList">

				<s:iterator value="#userList">
					<tr class="TableDetail1 template">
						<td>${name}&nbsp;</td>
						<td>${id}&nbsp;</td>
						<td>${shop.id}&nbsp;</td>
						<td>${shop.name}&nbsp;</td>
						<td>${role.name}&nbsp;</td>
						<td><s:a action="user_editUI?id=%{id}">修改</s:a> <s:a
								action="user_delete?id=%{id}"
								onclick="return confirm('确定要删除吗？')">删除</s:a> <s:a
								action="user_initPassWord?id=%{id}"
								onclick="return confirm('确定密码初始化为1吗？')">密码初始化</s:a></td>
					</tr>
				</s:iterator>

			</tbody>
			 
		</table>

		<!-- 其他功能超链接 -->
		
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="user_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
				<%-- <s:a action="user_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/import.png" />
                </s:a>
                <s:a action="user_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/export.png" />
                </s:a> --%>
			</div>
		</div> 
	</div>
</body>
</html>
