package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserEntity;
import model.UserInf;

public class LoginDao extends BaseDao {

    private static final String LOGIN_USER_SELECT = "select * from user where user_id = ? and password = ? ;";

    /**
     * コンストラクタ
     *
     * @param conn
     */
    public LoginDao(Connection conn) {
        super(conn);
    }

    public UserEntity selectLoginUser(UserInf model) {
        UserEntity entity = new UserEntity();
        try (PreparedStatement pstmt = conn.prepareStatement(LOGIN_USER_SELECT)) {
            pstmt.setString(1, model.getUserId());
            pstmt.setString(2, model.getPassword());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                entity.setUserId(rs.getString("user_id"));
                entity.setUserName(rs.getString("user_nm"));
                entity.setPassword(rs.getString("password"));
                entity.setRoll(rs.getString("roll"));
                entity.setLoginDateTime(rs.getTimestamp("login_date").toLocalDateTime());
                entity.setCreateDateTime(rs.getTimestamp("create_date").toLocalDateTime());
            }
            if (entity.isEmpty()) {
                entity = null;
            }
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
