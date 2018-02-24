<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>

  <h3>新規ユーザー登録</h3>
  <div align="right">
    <a href="index.jsp">ログイン画面に戻る</a>
  </div>
  <div align="right" style="color: #ff0000; font-size: small">
    <c:forEach var="message" items="${messages}">
      <pre>${ message }
      </pre>
      <!--<c:out value="message" /> -->
    </c:forEach>
  </div>
  <hr>
  <form method="post" action="AddUserAction">
    <div>
      <table>
        <tr>
          <td>ユーザー名</td>
          <td><input type="text" name="userName" maxlength="20" /></td>
        </tr>
        <tr>
          <td>パスワード</td>
          <td><input type="password" name="password" maxlength="20" /></td>
        </tr>
      </table>
    </div>
    <div align="center">
      <input type="submit" name="addUserButton" value="登録する" />
    </div>
  </form>
</body>
</html>