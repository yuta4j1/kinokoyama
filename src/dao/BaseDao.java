package dao;

import java.sql.Connection;

/**
 * 基底daoクラス
 * @author ozaki
 *
 */
public abstract class BaseDao {

    Connection conn = null;

    public BaseDao(Connection conn){
        this.conn = conn;
    }

}
