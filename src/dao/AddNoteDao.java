package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.NoteDetailModel;
import util.Result;

/**
 * 新規ノート登録Daoクラス
 * @author ozaki
 *
 */
public class AddNoteDao extends BaseDao {

    // コンストラクタ
    public AddNoteDao(Connection conn) {
        super(conn);
    }

    private static final String SELECT_NOTE_ID = "select note_id from T_NOTE_DETAIL order by note_id desc ;";

    private static final String INSERT_NOTE_DETAIL = "insert into T_NOTE_DETAIL values (?, ?, ?, ?, ?, ?, "
            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    /*
     * ノートIDの最大を取得するメソッド
     */
    public String getMaxNoteId() {
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTE_ID)) {
            ResultSet rs = pstmt.executeQuery();
            String result = null;

            if (rs.next()) {
                result =  rs.getString("note_id");
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

    /*
     * ノート情報を登録するメソッド
     */
    public void insertNote(NoteDetailModel model, Result result) {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_NOTE_DETAIL)) {
            pstmt.setString(1, model.getNoteId());
            pstmt.setString(2, model.getUserId());
            pstmt.setString(3, model.getTitle());
            pstmt.setString(4, model.getTagNm());
            pstmt.setString(5, model.getStudyNoteTitle1());
            pstmt.setString(6, model.getStudyNote1());
            pstmt.setString(7, model.getStudyNoteTitle2());
            pstmt.setString(8, model.getStudyNote2());
            pstmt.setString(9, model.getStudyNoteTitle3());
            pstmt.setString(10, model.getStudyNote3());
            pstmt.setString(11, model.getTodoNoteTitle1());
            pstmt.setString(12, model.getTodoNote1());
            pstmt.setString(13, model.getTodoNoteTitle2());
            pstmt.setString(14, model.getTodoNote2());
            pstmt.setString(15, model.getTodoNoteTitle3());
            pstmt.setString(16, model.getTodoNote3());
            pstmt.setString(17, model.getBiko());
            pstmt.setTimestamp(18, Timestamp.valueOf(model.getCreateDate()));
            if(pstmt.executeUpdate() == 1){
                result.setSuccess(true);
                result.getMsg().add("登録処理が完了しました！");
            }else{
                result.setSuccess(false);
                result.getErrorMsg().add("正常に登録処理が完了しませんでした。");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
