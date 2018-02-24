package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.AddUserBusiness;
import dao.DBManager;
import model.UserInf;

/**
 * Servlet implementation class AddUserAction
 */
@WebServlet("/AddUserAction")
public class AddUserAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        // エラーメッセージ用リスト
        List<String> errMsg = new ArrayList<>();
        // 入力エラーチェック
        if (userName.length() < 8 || userName.length() > 20) {
            errMsg.add("ユーザー名は8文字以上20文字以下で入力してください。");
        }
        if (password.length() < 8 || password.length() > 20) {
            errMsg.add("パスワードは8文字以上20文字以下で入力してください。");
        }
        // 一つでもエラーが見つかれば、ユーザー登録画面に戻る
        if (errMsg.size() > 0) {
            request.setAttribute("messages", errMsg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addUser.jsp");
            dispatcher.forward(request, response);
        } else {
            // 結果メッセージ
            String result = null;
            UserInf model = new UserInf();
            model.setUserName(userName);
            model.setPassword(password);
            // DBコネクション作成
            DBManager dbm = new DBManager();
            dbm.connect();
            // ビジネス処理
            AddUserBusiness business = new AddUserBusiness();
            result = business.addUser(model, dbm.getConnection()) ? "登録が完了しました。" : "登録に失敗しました。";
            // 登録コミット
            dbm.commit();
            // 画面遷移
            request.setAttribute("resultMsg", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
