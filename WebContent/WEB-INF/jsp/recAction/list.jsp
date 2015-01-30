<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>销售记录</title>
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
				销售记录管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="100px">记录号</td>
					<td width="100px">商品号</td>
					<td width="100px">商品名</td>
					<td width="100px">数量</td>
					<td width="100px">单价</td>
					<td width="100px">时间</td>
					<td width="100px">收银员工号</td>
					<td width="100px">店铺号</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="recList">

				<s:iterator value="#recList">
					<tr class="TableDetail1 template">
						<td>${id}&nbsp;</td>
						<td>${good.id}&nbsp;</td>
						<td>${good.name}&nbsp;</td>
						<td>${quantity}&nbsp;</td>
						<td>${good.price}&nbsp;</td>
						<td>${dateTime}&nbsp;</td>
						<td>${user.id}&nbsp;</td>
						<td>${shop.id}&nbsp;</td>
						<td><a href="rec_delete.action?id=${id}"
								onclick="return confirm('确定要删除吗？')">删除</a>
						</td>
					</tr>
				</s:iterator>

			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="rec_addUI.action">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</a>
				<a href="rec_list.action">
                    <img
                        src="${pageContext.request.contextPath}/style/images/import.png" />
                </a>
                <a href="rec_list.action">
                    <img
                        src="${pageContext.request.contextPath}/style/images/export.png" />
                </a>
			</div>
		</div>
	</div>
</body>
</html>
