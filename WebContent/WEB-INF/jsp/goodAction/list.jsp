<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>商品列表</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				商品管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="100px">商品ID</td>
					<td width="100px">商品名称</td>
					<td width="100px">商品价格</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="goodList">

				<s:iterator value="#goodList">
					<tr class="TableDetail1 template">
						<td>${id}&nbsp;</td>
						<td>${name}&nbsp;</td>
						<td>${price}&nbsp;</td>
						<td><a href="good_delete.action?id=${id}"
								onclick="return confirm('确定要删除吗？')">删除</a> <a
								href="good_editUI.action?id=${id}">修改</a></td>
					</tr>
				</s:iterator>

			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="good_addUI.action">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</a>
				<%-- <s:a action="good_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/import.png" />
                </s:a>
                <s:a action="good_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/export.png" />
                </s:a> --%>
			</div>
		</div>
	</div>
</body>
</html>
