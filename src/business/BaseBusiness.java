package business;

import java.sql.Connection;

public abstract class BaseBusiness {
    /** コネクション */
    Connection conn;

    /**
     * コンストラクタ
     */
    public BaseBusiness(Connection conn) {
        this.conn = conn;
    }

}
