<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.UserInf"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
  LocalDate now = LocalDate.now();
  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  String nowDate = fmt.format(now);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
  href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css">
<link href="https://bootswatch.com/4/litera/bootstrap.min.css"
  rel="stylesheet">
<link
  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
  rel="stylesheet">
<script defer
  src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<title>技術ノート</title>
</head>
<body>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
  <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
  <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
  <script src="js/tether.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function sinki() {
      document.location.href = "sinkiNote.jsp"
    }

    // ノート追加/削除ボタンの状態変化
    function toggleNoteButtonState(num){
      if(num >= 5){
        $('#addNoteButton').prop('disabled', true);
      }else {
        $('#addNoteButton').prop('disabled', false);
      }
      if(num <= 1){
        $('#minusNoteButton').prop('disabled', true);
      }else {
        $('#minusNoteButton').prop('disabled', false);
      }
    }

    $(function() {
      $('.datepicker').datepicker();

      $('#addNoteButton').on('click', function(){
        $('<textarea class="form-control form-control-sm" id="studyNote" rows="3" style="margin-top: 20px"></textarea>').insertAfter('#studyNote1');
        var textAreaNum = $('textarea').length;
        toggleNoteButtonState(textAreaNum);
        for(var i = 0; i < textAreaNum; i++){
          var _id = 'studyNote' + (i + 1);
          console.log("id", _id);
          $('textarea').eq(i).attr('id', _id);
        }
      });

      $('#minusNoteButton').on('click', function(){
        var textAreaNum = $('textarea').length;
        // toggleNoteButtonState(textAreaNum);
        var targetId = '#studyNote' + textAreaNum;
        $(targetId).remove();
        toggleNoteButtonState($('textarea').length);
      });
    });
  </script>
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
      <li class="nav-item active"><a class="nav-link" href="menu.jsp">Home
          <span class="sr-only">(current)</span>
      </a></li>
      <li class="nav-item"><a class="nav-link" href="#">Features</a></li>
    </ul>
    <div>
      ようこそ、<i class="fas fa-user"></i>
      <%=model.getUserName()%>さん！！
    </div>
  </div>
  </nav>
  <div class="container">
    <div class="row" style="margin-top: 50px">
      <div class="col-md-10">
        <div class="card">
          <div class="card-header">
            <div class="card-title">検索条件</div>
          </div>
          <div class="card-body">
            <form method="post" action="SearchNoteAction">
              <div class="cantainer">
                <div class="form-group row">
                  <label class="col-form-label col-md-2" for="author">作成者</label>
                  <div class="col-md-6">
                    <div class="input-group" aria-label="Text input with dropdown button">
                      <input type="text" class="form-control">
                      <div class="input-group-append">
                        <button id="btnGroupAuthor" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        </button>
                        <div class="dropdown show">
                          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupAuthor">
                            <a class="active dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-2">
                    <label for="title" class="col-form-label">タイトル</label>
                  </div>
                  <div class="col-md-6">
                    <input type="text" id="title" class="form-control" />
                  </div>
                </div>
                <div class="form-group row">
                  <label class="col-sm-2 col-form-label" for="taglist">タグ</label>
                  <div class="col-sm-6" id="taglist">
                    <div class="dropdown">
                      <!-- 切替ボタンの設定 -->
                      <button type="button"
                        class="btn btn-secondary dropdown-toggle"
                        id="dropdownMenuButton" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">タグ</button>
                      <!-- ドロップメニューの設定 -->
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">メニュー1</a> <a
                          class="dropdown-item" href="#">メニュー2</a> <a
                          class="dropdown-item" href="#">メニュー3</a>
                      </div>
                      <!-- /.dropdown-menu -->
                    </div>
                    <!-- /.dropdown -->
                  </div>
                </div>
                <div class="form-group row">
                  <label class="col-md-2 label-control" for="upddate">更新日付</label>
                  <div class="col-md-6" id="upddate">
                    <div class="row">
                      <div class="col-md-6">
                        <input type="text" class="datepicker form-control" />
                      </div>
                      <!-- <div class="col-md-2">
                        <p>～</p>
                      </div> -->
                      <div class="col-md-6">
                        <input type="text" class="datepicker form-control" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="card-footer">
            <div class="row">
              <div class="col-md-2">
                <input type="button" value="新規ノート" class="btn btn-outline-success"
                data-toggle="modal" data-target="#addNoteModal">
              </div>
              <div class="col-md-6"></div>
              <div class="col-md-4">
                <div class="btn-group" role="group">
                  <input type="submit" name="searchButton" value="検索"
                    class="btn btn-outline-primary" />
                  <input type="button" value="条件クリア" class="btn btn-outline-secondary" onclick="sinki()">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="addNoteModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container">
      <div class="modal-dialog" role="document">
        <div class="modal-content" style="width: 740px; margin-left: -70px">
          <div class="modal-header" style="background-color: #3399FF">
            <h5 class="modal-title" style="color: #FFFFFF	">Study Note</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="float-right"><%= nowDate %></div>
            <div class="frorm-group">
                <label>タイトル</label>
                <input type="text" id="title" class="form-control form-control-sm" placeholder="タイトル" style="width: 580px;">
            </div>
            <div class="row" style="padding-top: 20px">
              <div class="col-md-4">
                <div class="frorm-group">
                  <label>作成者</label>
                  <input type="text" id="author" class="form-control form-control-sm" placeholder="作成者名">
                </div>
              </div>
              <div class="col-md-4">
                <div class="frorm-group">
                  <label>タグ</label>
                  <input type="text" id="tag" class="form-control form-control-sm" placeholder="タグ名">
                </div>
              </div>
            </div>
            <hr/>
            <div class="row">
              <div class="col-md-10"></div>
              <div class="col-md-1">
                <button type="button" class="btn btn-primary btn-sm" id="addNoteButton"><i class="fas fa-plus"></i></button>
              </div>
              <div class="col-md-1">
                <button type="button" class="btn btn-primary btn-sm" id="minusNoteButton" disabled><i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="form-group">
              <label for="studyNote1">ノート</label>
              <textarea class="form-control form-control-sm" id="studyNote1" rows="3"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary">登録</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる

            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="table-list" style="margin-top: 30px">
    <table class="table table-striped">
      <thead>
        <tr>
          <th><button type="button" class="btn btn-primary btn-xs">詳細</button></th>
          <th>タイトル</th>
          <th>タグ</th>
          <th>作成者</th>
          <th>更新年月日</th>
        </tr>
      </thead>
    </table>
  </div>
</body>
</html>