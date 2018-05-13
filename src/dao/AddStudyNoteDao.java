package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.StudyNoteModel;

/**
 * studyNoteをテーブルに登録するDaoクラス
 *
 * @author ozaki
 *
 */
public class AddStudyNoteDao extends BaseDao {

    /**
     * コンストラクタ
     *
     * @param conn
     *            DBコネクション
     */
    public AddStudyNoteDao(Connection conn) {
        super(conn);
    }

    /** ノートID検索クエリ */
//    private static final String SELECT_NOTE_ID = "select note_id from t_study_note order by note_id desc ;";

    /** ノート情報を登録するクエリ */
    private static final String INSERT_NOTE_DETAIL = "insert into t_study_note values (?, ?, ?, ?, ?, ?, "
            + "?, ?, ?, ?, ?);";

    /**
     * ノートIDの最大値を取得する。
     *
     * @return ノートID
     */
//    public String getMaxNoteId() {
//        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTE_ID)) {
//            ResultSet rs = pstmt.executeQuery();
//            String id = null;
//
//            if (rs.next()) {
//                id = rs.getString("note_id");
//            }
//            return id;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

    /**
     * ノート情報をテーブルに登録する。
     *
     * @param model パラメータ
     * @return 処理結果
     */
    public boolean insertNote(StudyNoteModel model) {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_NOTE_DETAIL)) {
            pstmt.setString(1, model.getNoteId());
            pstmt.setString(2, model.getAddNoteTitle());
            pstmt.setString(3, model.getUserId());
            pstmt.setString(4, model.getCategoryTag());
            pstmt.setString(5, model.getStudyNote1());
            pstmt.setString(6, model.getStudyNote2());
            pstmt.setString(7, model.getStudyNote3());
            pstmt.setString(8, model.getStudyNote4());
            pstmt.setString(9, model.getStudyNote5());
            pstmt.setTimestamp(10, Timestamp.valueOf(model.getCreatedAt()));
            pstmt.setTimestamp(11, Timestamp.valueOf(model.getUpdatedAt()));
            return pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
