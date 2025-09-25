<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<main>
		<h1>ようこそ${account.name}さん！</h1>
		<h2>タスク管理</h2>
		<!--エラー時の表示処理-->
		<c:if test="${not empty errorMsg}">
			<p style="color: red;">${errorMsg}</p>
		</c:if>


		<h3>新しいタスクの追加</h3>
		<form action="TaskServlet" method="post">
			新しいタスク: <input type="text" name="tasks"> <input type="hidden"
				name="action" value="add"> <input type="submit" value="追加">
		</form>
		<ul>
			<c:forEach var="task" items="${taskList}">
				<li <c:if test="${task.completed}">class="completed-task"</c:if>>
<!--					${task.tasks} <%--完了 --%> <c:if test="${!task.completed}">-->
<!--						<form action="TaskServlet" method="post">-->
<!--							<input type="hidden" name="taskId" value="${task.taskId}">-->
<!--							<input type="hidden" name="action" value="complete"> <input-->
<!--								type="submit" value="完了">-->
<!--						</form>-->
					</c:if> <%--削除 --%>
					<form action="TaskServlet" method="post">
						<input type="hidden" name="taskId" value="${task.taskId}">
						<input type="hidden" name="action" value="delete"> <input
							type="submit" value="削除">
					</form>
				</li>
			</c:forEach>
		</ul>


		<form action="LoginServlet" method="post">
			<input type="hidden" name="action" value="logout"> <input
				type="submit" value="ログアウト">
		</form>
	</main>


</body>
</html>