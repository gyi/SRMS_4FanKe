<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>店铺列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 店铺管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">店铺名称</td>
                <td width="300px">店铺说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="shopList">
        
        <s:iterator value="#shopList">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${location}&nbsp;</td>
				<td>
					<a href="shop_delete.action?id=${id}" onclick="return confirm('确定要删除吗？')">删除</a>
					<a href="shop_editUI.action?id=${id}">修改</a>
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
			<a href="shop_addUI.action"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
           <%--  <s:a action="shop_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/import.png" />
                </s:a>
                <s:a action="shop_list">
                    <img
                        src="${pageContext.request.contextPath}/style/images/export.png" />
                </s:a> --%>
        </div>      
    </div>
</div>
</body>
</html>
