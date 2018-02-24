
package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import business.GetTagListBusiness;
import dao.DBManager;
import model.TagListModel;

/**
 * タグのドロップダウンリスト取得リクエストを受け付けるアクションクラス
 * @author ozaki
 *
 */
@WebServlet("/GetTagListAction")
public class GetTagListAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * タグ取得処理
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager db = (DBManager) request.getAttribute("dbConn");
        GetTagListBusiness business = new GetTagListBusiness(db.getConnection());
        List<TagListModel> models = business.execute();
        Gson gson = new Gson();
        // リストデータをjson形式にパースする
        String taglistJson = gson.toJson(models);

        response.getWriter().write(taglistJson);
    }

}
