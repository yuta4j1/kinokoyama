package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ログインユーザー情報モデル
 *
 * @author ozaki
 *
 */
public class UserInf implements Serializable {

    private static final long serialVersionUID = 1L;
    /* ユーザID */
    private String userId;
    /* ユーザー名 */
    private String userName;
    /* パスワード */
    private String password;
    /* 管理者ロール */
    private String roll;
    /* ログイン日時 */
    private LocalDateTime loginDateTime;
    /* アカウント作成日時 */
    private LocalDateTime createDateTime;

    /**
     * コンストラクタ
     */
    public UserInf() {
    }

    /**
     * コンストラクタ（引数あり）
     *  ログインユーザ取得時に使う
     *
     * @param userId
     * @param password
     */
    public UserInf(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /**
     * ユーザIDを取得する。
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定する。
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザー名を取得する。
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を設定する。
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(LocalDateTime loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

}
