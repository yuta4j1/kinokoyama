package business;

import java.sql.Connection;

import dao.GenerateNumberDao;

public class GenerateNumberBusiness extends BaseBusiness {

    /**
     * コンストラクタ。
     *
     * @param conn コネクション
     */
    public GenerateNumberBusiness(Connection conn) {
        super(conn);
    }

    public int getStudyNoteId() {
        GenerateNumberDao dao = new GenerateNumberDao(conn);
        int id = dao.getStudyNoteId();
        dao.incrementId(id + 1);
        return id;

    }

}
