package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DBManager;
import dao.GetMaxNoteIdDao;

/**
 * Servlet implementation class GetMaxNoteIdAction
 */
@WebServlet("/GetMaxNoteIdAction")
public class GetMaxNoteIdAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager db = (DBManager) request.getAttribute("dbConn");
        GetMaxNoteIdDao dao = new GetMaxNoteIdDao(db.getConnection());
        String noteId = null;
        String maxNoteId = dao.getMaxNoteId();
        if(maxNoteId != null){
            noteId = "NI" + String.format(String.valueOf(Integer.parseInt(maxNoteId.substring(2, 7)) + 1));
        }else{
            noteId = "NI00001";
        }
        Gson gson = new Gson();
        // リストデータをjson形式にパースする
        String taglistJson = gson.toJson(noteId);

        response.getWriter().write(taglistJson);

    }

}
