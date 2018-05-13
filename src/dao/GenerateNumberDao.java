package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GenerateNumberDao extends BaseDao {

    /**
     * コンストラクタ。
     *
     * @param conn コネクション
     */
    public GenerateNumberDao(Connection conn) {
        super(conn);
    }

    private static final String SELECT_STUDYNOTEID = "SELECT id from t_study_note_id";

    private static final String INCREMENT_STUDYNOTEID = "update t_study_note_id set update id = ?, updated_at = ?";

    /**
     * ノートIDの取得を行う。
     *
     * @return ノートID
     */
    public int getStudyNoteId() {

        int result = 0;
        ResultSet rs = null;
        try(PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDYNOTEID)){
            rs = pstmt.executeQuery();
            while(rs.next()) {
                result = rs.getInt("id");
            }

            return result;

        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void incrementId(int incrementedId) {

        try(PreparedStatement pstmt = conn.prepareStatement(INCREMENT_STUDYNOTEID)) {
            pstmt.setInt(1, incrementedId);
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.executeUpdate();

        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
