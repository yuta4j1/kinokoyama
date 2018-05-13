package util;

import java.util.List;

import lombok.Data;

/**
 * 処理結果を格納するBean定義クラス
 *
 * @author ozaki
 *
 */
@Data
public class Result {

    /* 正常終了フラグ */
    private boolean success;

    /* 通知メッセージ */
    private List<String> msg;

    /* エラーメッセージ */
    private List<String> errorMsg;


    /**
     * 引数なしコンストラクタ
     */
    public Result(){
    }

    /**
     * コンストラクタ
     *
     * @param sMsg 処理成功時メッセージ
     * @param eMsg
     */
    public Result(List<String> msg, List<String> eMsg) {
        this.setMsg(msg);
        this.setErrorMsg(eMsg);
    }



}
