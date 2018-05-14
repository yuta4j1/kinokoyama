package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.AddStudyNoteBusiness;
import common.Forward;
import dao.DBManager;
import model.StudyNoteModel;
import util.R2P;
import util.Result;

/**
 * Servlet implementation class AddStudyNote
 */
@WebServlet("/AddStudyNoteAction")
public class AddStudyNoteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * studyノートの新規登録情報を受け付ける。
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* リクエストから新規ノート情報パラメータを取得する。 */
        StudyNoteModel model = (StudyNoteModel) R2P.request2Pojo(request, StudyNoteModel.class);
        /* リクエストパラメータから、DBコネクションを取得する。 */
        DBManager db = (DBManager) request.getAttribute("dbConn");
        AddStudyNoteBusiness business = new AddStudyNoteBusiness(db.getConnection());
        Result result = new Result();
        business.excecute(model, result);
        Map<String, Object> param = new HashMap<>();
        param.put("model", model);
        param.put("result", result);
        new Forward(request, response).response(param, "./");

    }

}
