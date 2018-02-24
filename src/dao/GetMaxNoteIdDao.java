package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMaxNoteIdDao extends BaseDao {

    // コンストラクタ
    public GetMaxNoteIdDao(Connection conn) {
        super(conn);
    }

    private static final String SELECT_NOTE_ID = "select note_id from T_NOTE_DETAIL ;";

    public String getMaxNoteId() {
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTE_ID)) {
            ResultSet rs = pstmt.executeQuery();
            String result = null;

            // 最後行にカーソル移動
            rs.afterLast();
            if (rs.getRow() != 0) {
                result = rs.getString("noteId");
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
