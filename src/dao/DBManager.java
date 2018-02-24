package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.Constants;

/** DB接続用クラス */
public class DBManager {

    /** コネクションオブジェクト */
    protected Connection conn = null;

    /**
     * コネクションを取得する。
     *
     * @return conn
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * DB接続処理(データソース取得)
     */
    public void connect() {
        DataSource ds = null;
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(Constants.JNDI_NAME_JDBC);
            conn = ds.getConnection();
            conn.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    throw new RuntimeException("DB接続失敗", e);
                }
            }
        }
    }

    /**
     * コミット処理
     */
    public void commit() {
        if (conn == null) {
            return;
        }
        try {
            conn.commit();
        } catch (Exception e) {
            throw new RuntimeException("コミット失敗", e);
        }
    }

    /**
     * ロールバック処理
     */
    public void rollback() {
        if (conn == null) {
            return;
        }
        try {
            conn.rollback();
        } catch (Exception e) {
            throw new RuntimeException("ロールバック失敗", e);
        }
    }

    /**
     * クローズ処理
     */
    public void close() {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException("クローズ失敗", e);
        }
    }

}
