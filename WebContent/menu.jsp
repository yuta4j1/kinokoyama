<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.UserInf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Style-Type" content="text/css" />
<title>きのこ山</title>
<link href="https://bootswatch.com/4/litera/bootstrap.min.css"
  rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

 <%
    UserInf model = (UserInf) session.getAttribute("userInf");
  %>
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
    <div>ようこそ、<i class="fas fa-user"></i> <%=model.getUserName()%>さん！！</div>
  </div>
  </nav>
  <script>
    /* $(function() {
      $('#gizyutuNoteLink').hover(function(e) {
        $(this).addClass('bg-primary')},
        function(e) {
            $(this).removeClass('bg-primary');
      });
    }); */

    function submit(url){
      location.href = url;
    }
  </script>
  <div align="center">
    <div class="cantainer">
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-2">
          <div class="card border-primary mb-3" style="max-width: 20rem; margin-top: 100px">
            <div class="card-header">studyノート</div>
            <div class="card-body text-primary">
              <h4 class="card-title"><i class="fas fa-book fa-2x"></i></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <button type="button" class="btn btn-outline-primary" onclick="submit('gizyutuNoteList.jsp')">ノート一覧へ</button>
            </div>
          </div>
        </div>
        <div class="col-md-2">
          <div class="card border-success mb-5" style="max-width: 20rem; margin-top: 100px">
            <div class="card-header">ToDoリスト</div>
            <div class="card-body text-success">
              <h4 class="card-title"><i class="fas fa-paperclip fa-2x"></i></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <button type="button" class="btn btn-outline-success">ToDoリストへ</button>
            </div>
          </div>
        </div>
        <div class="col-md-2">
          <div class="card bg-light mb-3" style="max-width: 20rem; margin-top: 100px">
            <div class="card-header">日報</div>
            <div class="card-body">
              <h4 class="card-title"><i class="far fa-edit fa-2x"></i></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <button type="button" class="btn btn-outline-secondary">日報一覧へ</button>
            </div>
          </div>
        </div>
        <div class="col-md-3"></div>
      </div>
    </div>
  </div>

</body>
</html>