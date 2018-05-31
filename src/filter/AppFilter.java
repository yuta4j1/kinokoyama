package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.DBManager;

/**
 * フィルタークラス
 */
@WebFilter("/*")
public class AppFilter implements Filter {

    /**
     * コンストラクタ
     */
    public AppFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 前処理
        // デフォルトの文字コードセット
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }

        // DB接続オブジェクト取得
        DBManager db = new DBManager();
        db.connect();
        request.setAttribute("dbConn", db);

        // pass the request along the filter chain
        chain.doFilter(request, response);

        // 後処理
        db.commit();
        db.close();
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
