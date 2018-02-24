<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>仮タイトル</title>
<link href="https://bootswatch.com/4/litera/bootstrap.min.css"
  rel="stylesheet">
<link href="css/modal.css" rel="stylesheet">
<script type="text/javascript">
  var resultMsg = "<%=request.getAttribute("resultMsg")%>";
  if (resultMsg != "null") {
    alert(resultMsg);
  }
</script>
</head>
<body>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
  <script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>
  <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
  <script type="text/javascript"
    src="${pageContext.request.contextPath}/js/modal.js"></script>
  <script type="text/javascript">
    $(function() {
      // $('#loginModal').modal('show');
      $("#clearButton").on("click", function() {
        $('input[name="userId"]').val('');
        $('input[name="password"]').val('');
      });
    });
  </script>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
    class="navbar-brand" href="#">きのこ山（仮）</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse"
    data-target="#navbarColor02" aria-controls="navbarColor02"
    aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor02">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active"><a class="nav-link" href="#">Home
          <span class="sr-only">(current)</span>
      </a></li>
      <li class="nav-item"><a class="nav-link" href="#">Features</a></li>
    </ul>
  </div>
  </nav>
  <!-- <div id="addUser-content" align="right">
    <a href="#modal-addUser" id="modal-addUser-open">ユーザーアカウント登録</a>
  </div>
  <div id="modal-addUser" class="card">
    <div style="background-color: #3399FF" class="card-header">
      <div style="color: #FFFFFF; font-weight: bold">ユーザーアカウント登録</div>
    </div>
    <div class="card-body">
      <div class="form-group">
        <label style="padding-top: 20px">ユーザーID</label>
        <div class="row">
          <div class="col-md-7">
            <input type="text" class="form-control" />
          </div>
        </div>
        <label style="padding-top: 20px">ユーザー名</label>
        <div class="row">
          <div class="col-md-7">
            <input type="text" class="form-control" />
          </div>
        </div>
        <label style="padding-top: 20px">パスワード</label>
        <div class="row">
          <div class="col-md-7">
            <input type="password" class="form-control" />
          </div>
        </div>
      </div>
    </div>
    <div class="card-footer">
      <div class="text-center">
        <div class="row">
          <div class="col-md-3">
            <input type="button" value="新規登録" id="addUser"
              class="btn btn-primary" />
          </div>
          <div class="col-md-3">
            <button id="close" class="btn">close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <hr> -->
  <div class="container">
    <div class="row">
      <div class="col-md-6" style="margin-top: 200px; padding-right: 50px">
        <h3>きのこ山へようこそ！</h3>
        <p style="margin-top: 50px">
                      きのこ山とは、日々の学び、気づき、<br>ToDoリストなどを残しておくための記録ツールです。
                   貴重な学習の成果やアイデアをきのこ山に記録し、あなただけのきのこ山を育てましょう。
        </p>
      </div>
      <div class="col-md-6">
        <div class="card card-inverse border-secondary" style="margin-top: 200px">
          <div class="card-header">ログイン</div>
          <div class="card-body">
            <form method="post" action="LoginAction">
              <div class="form-group">
                <label for="userId" class="col-form-label">ユーザーID</label> <input
                  type="text" id="userId" name="userId" class="form-control" />
              </div>
              <div class="form-group">
                <label for="password" class="col-form-label">パスワード</label> <input
                  type="password" id="password" name="password"
                  class="form-control" />
              </div>
              <hr>
              <div class="float-right">
                  <input type="submit" name="loginButton" value="Submit"
                    class="btn btn-primary" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>