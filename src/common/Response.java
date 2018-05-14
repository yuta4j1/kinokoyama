package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * レスポンスを送信する親クラス。
 */
public abstract class Response {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected Response(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

}
