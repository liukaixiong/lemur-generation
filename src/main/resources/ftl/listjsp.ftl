<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pmnlib" prefix="pmn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${'$'}{ctx}">
<title>${table.chinaName!}管理</title>
<link type="text/css" media="screen" rel="stylesheet"
	href="${'$'}{htdoc_server_url}/commons/css/common.css" />
<link type="text/css" media="screen" rel="stylesheet"
	href="plugins/fancybox-1.3.4/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="plugins/jquery/jquery-1.7.min.js"></script>
<script type="text/javascript" src="plugins/datepicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="plugins/fancybox-1.3.4/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript"
	src="plugins/fancybox-1.3.4/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript">
	${'$'}(document).ready(function() {
		//鼠标经过时结果行背景变色
		${'$'}(".tb-table>table tr:gt(0)").hover(function() {
			${'$'}(this).css("background", "#EEEEEE");
		}, function() {
			${'$'}(this).css("background", "");
		});

		${'$'}("#orderDetailInfo").fancybox({
			'width' : '95%',
			'height' : '95%',
			'autoScale' : false,
			'transitionIn' : 'none',
			'transitionOut' : 'none',
			'type' : 'iframe'
		});

	});
	function details(orderNo, type) {
		var obj = ${'$'}("#orderDetailInfo");
		obj.attr("href",
				"${'$'}{ctx}tencentPayOrderController.htm?action=ORDER_DETAIL&orderNo="
						+ orderNo + "&type=" + type);
		obj.trigger("click");
	}
</script>
</head>
<body>
	<div id="frame-body">
		<div id="frame-main">
			<div id="frame-content">
				<h3 class="fn-mt7">查询条件</h3>
				<div class="tb-table">
					<form id="formId" name="formId"
						action="${params.packageName}.htm" method="POST">
						<input type="hidden" id="action" name="ACTION"
							value="${params.entityName?html?upper_case}_LIST" /><input type="hidden" id="hID"
							name="page" value="$${'$'}{pageForm.page}" />
						<table width=500px>
							
							<tr>
								<td colspan="6" align="center">
									<div class="tb-tfoot-noborder">
										<span class="btn"><input type="submit" value="查    询" /></span>
										<span class="btn"><input type="reset" value="重    置" /></span>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<c:if test="${'$'}{resultMsg != null}">
					<div class="tip-div">
						<div
							<c:choose><c:when test="${'$'}{success}">class="tip-success"</c:when><c:otherwise>class="tip-warn"</c:otherwise></c:choose>>
							<div class="tip-content">${'$'}{resultMsg }</div>
						</div>
					</div>
				</c:if>
				<h3 class="fn-mt7">
					<span style="float: left; font-size: 14px; font-weight: bold;">${table.chinaName!}管理</span>
					<br style='clear: both; height: 0px' />
				</h3>
				<div class="tb-table">
					<table>
						<thead>
							<tr>
								<#list table.fields as v>
									<#if v.name != params.idName>
										<th align="center">${v.chinaName}</th>
									</#if>
								</#list>
								<th align="center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${'$'}{fn:length(list) > 0}">
									<c:forEach var="ar" items="${'$'}{list}">
										<tr>
											<#list table.fields as v>
												<#if v.name != params.idName>
													<td align="center"><c:out value="${'$'}{ar.${v.name}}" /></td>
												</#if>
											</#list>
											<td align="center"></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td align="center" colspan="13">没有找到相应记录</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<c:if test="${'$'}{fn:length(list) > 0}">
					<div>
						<jsp:include page="/views/commons/paginator.jsp">
							<jsp:param name="formName" value="formId" />
							<jsp:param name="hID" value="page" />
						</jsp:include>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<a id="orderDetailInfo" href="" style="display: none;"></a>
</body>
</html>