<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page import="model.UserInf"%>
<%@ page import="model.NoteDetailModel"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%
  LocalDate dateNow = LocalDate.now();
  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  String hiduke = fmt.format(dateNow);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/css/note.css">

<title>技術ノート</title>
</head>
<body>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
  <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/tether.min.js"></script>
  <script type="text/javascript">
    $(function() {
      $('#tabs').tabs({
        active : 0
      });

      $.ajax({
        type : 'GET',
        url : 'http://localhost:8090/KINOKOYAMA/GetTagListAction',
        dataType : 'json',
        success : function(taglist) {
          dropdown(taglist);
        },
        error : function(XMLHttpRequest, TextStatus, errorThrown) {
          error(XMLHttpRequest, TextStatus, errorThrown);
        }
      });
    });

    function dropdown(list) {
        for (var i in list) {
          var option = '<option>' + list[i].tagNm + '</option>';
          $('#tagList').append(option);
        }
      }

      function error(XMLHttpRequest, TextStatus, errorThrown) {
        alert('error : ' + XMLHttpRequest);
        alert('status : ' + TextStatus);
        alert('errorThrown : ' + errorThrown);
      }

      function onReturn() {
          // 確認メッセージの表示
          $('#alertState').show();
        }

      function closeMessage() {
          // 確認メッセージの表示
          $('#alertState').hide();
        }

        function submitAction(url) {
          $('form').attr('action', url);
          $('form').submit();
        }


  </script>
  <h3>新規ノート登録</h3>
  <%
    UserInf user = (UserInf) session.getAttribute("userInf");
  NoteDetailModel model = (NoteDetailModel) request.getAttribute("model");
  %>
  <div align="right">
    <div>
      ようこそ、<%=user.getUserName()%>さん！！
    </div>
    <div>
      <a href="menu.jsp">メニューに戻る</a>
    </div>
  </div>
  <hr>
  <div id="alertState" style="display: none">
    <div class="alert alert-warning alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert"
        aria-label="Close" onclick="closeMessage()">
        <span aria-hidden="true">&times;</span>
      </button>
      <strong>Warning!</strong> 変更内容は破棄されます。よろしいでしょうか？
      <a href="./gizyutuNoteList.jsp" class="alert-link">はい</a>
      <a href="#" class="alert-link" onclick="closeMessage()">いいえ</a>
    </div>
  </div>

  <form method="post" action="AddSinkiNote">
    <input type="hidden" name="noteId" id="noteId" />
    <div align="right"><%=fmt.format(dateNow)%></div>
    <div class="row" style="margin-bottom: 30px;">
      <div class="col-sm-10">
      <c:choose>
        <c:when test="${ empty model.title }">
          <input type="text" id="title" name="title" value=""
            class="form-control" />
        </c:when>
        <c:otherwise>
            <input type="text" id="title" name="title" value="${ model.title }"
          class="form-control" />
        </c:otherwise>
      </c:choose>
      </div>
      <div id="taglist" class="col-sm-2">
        <div class="dropdown">
          <select class="form-control" id="tagList" name="tagNm">
          <c:choose>
            <c:when test="${ empty model.tagNm }">
              <option value="init">選択してください</option>
            </c:when>
            <c:otherwise>
              <option value="init">"${ model.tagNm }"</option>
            </c:otherwise>
          </c:choose>
          </select>
        </div>
      </div>
    </div>
    <div id="tabs">
      <ul>
        <li><a href="#studyNote">学習</a></li>
        <li><a href="#todoNote">ToDo</a></li>
        <li><a href="#notepage3">備考</a></li>
      </ul>
      <div class="notepage" id="studyNote">
        <div class="col-sm-10">
          <div class="row">
            <div>1.</div>
            <div class="col-sm-6">
            <c:choose>
             <c:when test="${ empty model.studyNoteTitle1 }">
              <input type="text" id="studyNoteTitle1" name="studyNoteTitle1"
                class="form-control">
             </c:when>
             <c:otherwise>
              <input type="text" id="studyNoteTitle1" name="studyNoteTitle1" value="${ model.studyNoteTitle1 }"
                class="form-control">
             </c:otherwise>
            </c:choose>
            </div>
          </div>
        </div>
        <div>
        <c:choose>
         <c:when test="${ empty model.studyNote1 }">
          <textarea id="studyNote1" name="studyNote1" cols="40" rows="4"
            style="margin-top: 20px" class="form-control"></textarea>
          </c:when>
         <c:otherwise>
           <textarea id="studyNote1" name="studyNote1" cols="40" rows="4"
            style="margin-top: 20px" class="form-control" name="${ model.studyNote1 }"></textarea>
         </c:otherwise>
        </c:choose>
        </div>
        <div style="margin-top: 30px" class="col-sm-10">
          <div class="row">
            <div>2.</div>
            <div class="col-sm-6">
            <c:choose>
             <c:when test="${ empty model.studyNoteTitle2 }">
              <input type="text" id="studyNoteTitle2" name="studyNoteTitle2"
                class="form-control">
             </c:when>
             <c:otherwise>
               <input type="text" id="studyNoteTitle2" name="studyNoteTitle2" value="${ model.studyNote2 }"
                class="form-control">
             </c:otherwise>
            </c:choose>
            </div>
          </div>
        </div>
        <div>
          <textarea id="studyNote2" name="studyNote2" cols="40" rows="4"
            style="margin-top: 20px" class="form-control"></textarea>
        </div>
        <div style="margin-top: 30px" class="col-sm-10">
          <div class="row">
            <div>3.</div>
            <div class="col-sm-6">
              <input type="text" id="studyNoteTitle3" name="studyNoteTitle3"
                class="form-control">
            </div>
          </div>
        </div>
        <div>
          <textarea id="studyNote3" name="studyNote3" cols="40" rows="4"
            style="margin-top: 30px" class="form-control"></textarea>
        </div>
      </div>
      <div class="notepage" id="todoNote">
        <div class="row">
          <div class="col-sm-3">
            <div class="card">
              <div class="card-header">
                <input type="text" id="todoNoteTitle1" name="todoNoteTitle1"
                  class="form-control" />
              </div>
              <div class="card-body">
                <textarea id="todoNote1" name="todoNote1" cols="15" rows="30"
                  style="margin-top: 20px" class="form-control"></textarea>
              </div>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="card">
              <div class="card-header">
                <input type="text" id="todoNoteTitle2" name="todoNoteTitle2"
                  class="form-control" />
              </div>
              <div class="card-body">
                <textarea id="todoNote2" name="todoNote2" cols="15" rows="30"
                  style="margin-top: 20px" class="form-control"></textarea>
              </div>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="card">
              <div class="card-header">
                <input type="text" id="todoNoteTitle3" name="todoNoteTitle3"
                  class="form-control" />
              </div>
              <div class="card-body">
                <textarea id="todoNote3" name="todoNote3" cols="15" rows="30"
                  style="margin-top: 20px" class="form-control"></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="notepage" id="notepage3">
        <div>
          <textarea id="biko" name="biko" cols="30" rows="40"
            class="form-control"></textarea>
        </div>
        <div>
          <input type="file" name="file" class="form-control">
        </div>
      </div>
    </div>

    <!-- フッターボタン -->
    <div class="pull-right">
      <div class="row">
      <!-- pull-rightしても右寄せにならないので、ボタン左側に余白をセット -->
        <div class="col-lg-9"></div>
        <div class="col-lg-1">
          <button type="button" id="addButton"
            class="btn btn-success btn-block" onclick="submitAction('./AddNoteAction')">登録</button>
        </div>
        <div class="col-lg-1">
          <button type="button" id="tmpSaveButton"
            class="btn btn-primary btn-block"
            onclick="submitAction('./TmpSaveNoteAction')">一時保存</button>
        </div>
        <div class="col-lg-1">
          <button type="button" id="returnButton"
            class="btn btn-default btn-block" onclick="onReturn()">戻る</button>
        </div>
      </div>
    </div>
  </form>
</body>
</html>