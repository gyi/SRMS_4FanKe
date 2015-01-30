<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>店铺设置</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				店铺设置
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">

		<s:form action="rec_add">

			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 店铺信息 </DIV>  -->
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm" id="eidt_table">
						<tr align="CENTER" valign="MIDDLE" id="TableTitle">
							<td width="10%">商品号</td>
							<td width="10%">数量</td>
						</tr>
						<tr align="CENTER" valign="MIDDLE" id="TableTitle"
							class="TableDetail1 template">
							<td><s:textfield name="goodId" cssClass="RecInputStyle" />
							</td>
							<td><s:textfield name="quantity" cssClass="RecInputStyle" />
							</td>
						</tr>
					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<%-- <a onclick="return newEditRow()"><img src="${pageContext.request.contextPath}/style/images/save.png"/></a> --%>
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" />
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" />
				</a>
			</div>
		</s:form>
	</div>
</body>
</html>

