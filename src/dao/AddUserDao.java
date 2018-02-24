package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.UserInf;

public class AddUserDao extends BaseDao {

    private static final String ADD_USER = "insert into user(user_id, user_name, password, roll, login_datetime, "
            + "create_datetime) values (?, ?, ?, ?, ?, ?);";

    private static final String SEARCH_USER = "select * from user where user_id = ? and password = ?;";

    public AddUserDao(Connection conn) {
        super(conn);
    }

    /**
     * ユーザ登録時、既存ユーザ存在チェック
     * @param model
     * @return
     */
    public boolean searchUser(UserInf model) {
        try (PreparedStatement pstmt = conn.prepareStatement(SEARCH_USER)) {
            pstmt.setString(1, model.getUserId());
            pstmt.setString(2, model.getPassword());
            ResultSet rs = pstmt.executeQuery();
            // 最後行にカーソル移動
            rs.last();
            return rs.getRow() == 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * ユーザ情報をテーブルに登録する。
     * @param model
     * @return
     */
    public int insert(UserInf model) {
        // パラメータセット
        List<Object> param = new ArrayList<>();
        param.add(model.getUserId());
        param.add(model.getUserName());
        param.add(model.getPassword());
        param.add(model.getRoll());
        param.add(model.getLoginDateTime());
        param.add(model.getCreateDateTime());
        try (PreparedStatement pstmt = conn.prepareStatement(ADD_USER)) {
            pstmt.setString(1, model.getUserId());
            pstmt.setString(2, model.getUserName());
            pstmt.setString(3, model.getPassword());
            pstmt.setString(4, model.getRoll());
            pstmt.setTimestamp(5, Timestamp.valueOf(model.getLoginDateTime()));
            pstmt.setTimestamp(6, Timestamp.valueOf(model.getCreateDateTime()));
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("エラー・コード: " + ((SQLException) e).getErrorCode());
            throw new RuntimeException("SQL文が実行できませんでした。", e);
        } catch (Exception e) {
            throw new RuntimeException("SQL文が実行できませんでした。", e);
        }
    }

}
