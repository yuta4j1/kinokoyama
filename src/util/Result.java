package util;

import java.util.List;

public class Result {

    // 処理成功/失敗フラグ
    private boolean success;

    // 成功メッセージ
    private List<String> successMsg;

    // エラーメッセージ
    private List<String> errorMsg;

    // コンストラクタ
    public Result(List<String> sMsg, List<String> eMsg) {
        this.successMsg = sMsg;
        this.errorMsg = eMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(List<String> successMsg) {
        this.successMsg = successMsg;
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

}
