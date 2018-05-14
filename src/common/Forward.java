package common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * フォワードクラス
 */
public class Forward extends Response {

    /**
     * コンストラクタ。
     *
     * @param request リクエストオブジェクト
     * @param response レスポンスオブジェクト
     */
    public Forward(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    /**
     * フォワード用レスポンス。
     *
     * @param param パラメータ
     * @param destination 送信先
     */
    public void response(Map<String, Object> param, String destination) {
        // レスポンスオブジェクトにパラメータをセットする。
        for(Map.Entry<String, Object> entry : param.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
        try{
             dispatcher.forward(request, response);
        }catch(ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}
