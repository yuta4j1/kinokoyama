package action;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.AddNoteBusiness;
import dao.DBManager;
import model.NoteDetailModel;
import model.UserInf;
import util.Result;

/**
 * 新規ノート作成アクションクラス
 *
 * @author ozaki
 *
 */
@WebServlet("/AddNoteAction")
public class AddNoteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションからユーザ情報取得
        HttpSession session = request.getSession();
        // 入力値をmodelにセット
        NoteDetailModel  model = new NoteDetailModel(request.getParameter("noteId"), ((UserInf)session.getAttribute("userInf")).getUserId(),
                request.getParameter("tagNm"), request.getParameter("title"), request.getParameter("studyNoteTitle1"),
                request.getParameter("studyNote1"), request.getParameter("studyNoteTitle2"),
                request.getParameter("studyNote2"), request.getParameter("studyNoteTitle3"),
                request.getParameter("studyNote3"), request.getParameter("todoNoteTitle1"),
                request.getParameter("todoNote1"), request.getParameter("todoNoteTitle2"),
                request.getParameter("todoNote2"), request.getParameter("todoNoteTitle3"),
                request.getParameter("todoNote3"), request.getParameter("biko"), LocalDateTime.now());

        DBManager db = (DBManager) request.getAttribute("dbConn");
        Result result = new Result(new ArrayList<String>(), new ArrayList<String>());
        AddNoteBusiness business = new AddNoteBusiness(db.getConnection());
        model = business.addNote(model, result);
        request.setAttribute("model", model);
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sinkiNote.jsp");
        dispatcher.forward(request, response);
    }

}
