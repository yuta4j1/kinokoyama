package business;

import java.sql.Connection;

import dao.GetMaxNoteIdDao;

/**
 * ノートIDを取得するビジネスクラス
 *
 */
public class NoteIdBusiness extends BaseBusiness {

    /**
     * コンストラクタ
     *
     * @param conn
     */
    public NoteIdBusiness(Connection conn){
        super(conn);
    }

    public String generateNoteId(){

        GetMaxNoteIdDao dao = new GetMaxNoteIdDao(conn);
        /* ノートIDを取得する。 */
        String noteId = dao.getMaxNoteId();
        return noteId;
    }

}
