package business;

import java.sql.Connection;

import dao.AddNoteDao;
import model.NoteDetailModel;
import util.Result;

/**
 * 新規ノート登録ビジネスクラス
 * @author ozaki
 *
 */
public class AddNoteBusiness extends BaseBusiness {

    /**
     * コンストラクタ
     *
     * @param conn
     */
    public AddNoteBusiness(Connection conn) {
        super(conn);
    }

    /**
     * 新規ノート登録処理
     *
     * @param model
     * @return
     */
    public NoteDetailModel addNote(NoteDetailModel model, Result result) {

        /* 必須チェック */
        if(model.getUserId() == null){
            result.getErrorMsg().add("ユーザIDを入力してください。");
        }
        if(model.getTagNm() == null){
            result.setSuccess(false);
            result.getErrorMsg().add("タグを選択してください。");
        }
        if(model.getTitle() == null){
            result.setSuccess(false);
            result.getErrorMsg().add("タイトルを入力してください。");
        }

        /* 文字数チェック */
        if(model.getTitle().length() > 30){
            result.getErrorMsg().add("タイトルは30文字以内で入力してください。");
        }
        if(model.getStudyNoteTitle1().length() > 30){
            result.getErrorMsg().add("学習ノートタイトル１は30文字以内で入力してください。");
        }
        if(model.getStudyNote1().length() > 400){
            result.getErrorMsg().add("学習ノート１は400文字以内で入力してください。");
        }
        if(model.getStudyNoteTitle2().length() > 30){
            result.getErrorMsg().add("学習ノートタイトル２は30文字以内で入力してください。");
        }
        if(model.getStudyNote2().length() > 400){
            result.getErrorMsg().add("学習ノート２は400文字以内で入力してください。");
        }
        if(model.getStudyNoteTitle3().length() > 30){
            result.getErrorMsg().add("学習ノートタイトル３は30文字以内で入力してください。");
        }
        if(model.getStudyNote3().length() > 400){
            result.getErrorMsg().add("学習ノート３は400文字以内で入力してください。");
        }
        if(model.getTodoNoteTitle1().length() > 30){
            result.getErrorMsg().add("ToDoノートタイトル１は30文字以内で入力してください。");
        }
        if(model.getTodoNote1().length() > 400){
            result.getErrorMsg().add("ToDoノート１は400文字以内で入力してください。");
        }
        if(model.getTodoNoteTitle2().length() > 30){
            result.getErrorMsg().add("ToDoノートタイトル２は30文字以内で入力してください。");
        }
        if(model.getTodoNote2().length() > 400){
            result.getErrorMsg().add("ToDoノート２は400文字以内で入力してください。");
        }
        if(model.getTodoNoteTitle3().length() > 30){
            result.getErrorMsg().add("ToDoノートタイトル３は30文字以内で入力してください。");
        }
        if(model.getTodoNote3().length() > 400){
            result.getErrorMsg().add("ToDoノート３は400文字以内で入力してください。");
        }
        if(model.getBiko().length() > 4000){
            result.getErrorMsg().add("備考は4000文字以内で入力してください。");
        }

        // エラーチェックにてエラーが存在した場合、画面遷移
        if(result.getErrorMsg().size() > 0){
          result.setSuccess(false);
          return model;
        }

        // エラーが存在しなかった場合
        result.setSuccess(true);

        /* 登録処理 */
        AddNoteDao dao = new AddNoteDao(conn);
        /* ノートIDの取得 */
        String noteId = null;
        String maxNoteId = dao.getMaxNoteId();
        if(maxNoteId != null){
            noteId = "NI" + String.format("%05d", Integer.parseInt(maxNoteId.substring(2, 7)) + 1);
        }else{
            // データが一件も登録されていない場合
            noteId = "NI00001";
        }
        // 取得したノートIDをモデルにセット
        model.setNoteId(noteId);

        /* DBへ登録 */
        dao.insertNote(model, result);
        return model;
    }

}
