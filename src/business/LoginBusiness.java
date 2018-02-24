package business;

import java.sql.Connection;

import dao.LoginDao;
import entity.UserEntity;
import model.UserInf;

/**
 * ユーザ認証ビジネス
 *
 * @author ozaki
 *
 */
public class LoginBusiness extends BaseBusiness {
    /**
     * コンストラクタ
     *
     * @param conn
     */
    public LoginBusiness(Connection conn) {
        super(conn);
    }

    /**
     * ログインユーザー認証
     *
     * @param model
     * @return
     */
    public UserInf loginUser(UserInf model) {
        LoginDao dao = new LoginDao(conn);
        // ユーザ情報を取得し、モデルにセットする。
        UserEntity entity = dao.selectLoginUser(model);
        if (entity != null) {
            model.setUserId(entity.getUserId());
            model.setUserName(entity.getUserName());
            model.setPassword(entity.getPassword());
            model.setRoll(entity.getRoll());
            model.setCreateDateTime(entity.getCreateDateTime());
            model.setLoginDateTime(entity.getLoginDateTime());
        } else {
            model = null;
        }
        return model;
    }

}
