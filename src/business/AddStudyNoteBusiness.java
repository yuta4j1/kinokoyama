package business;

import java.sql.Connection;

import dao.AddStudyNoteDao;
import model.StudyNoteModel;
import util.Convertor;
import util.Result;

/**
 * ノート登録処理を実行するBusinessクラス。
 */
public class AddStudyNoteBusiness extends BaseBusiness {

    /**
     * コンストラクタ
     *
     * @param conn コネクション
     */
    public AddStudyNoteBusiness(Connection conn) {
        super(conn);
    }

    /**
     * ノート登録処理。
     *
     * @param model パラメータ
     * @param result 処理結果
     */
    public void excecute(StudyNoteModel model, Result result){

        GenerateNumberBusiness idBusiness = new GenerateNumberBusiness(conn);
        int id = idBusiness.getStudyNoteId();

        model.setNoteId(Convertor.FormatNoteId(id));
        AddStudyNoteDao dao = new AddStudyNoteDao(conn);
        boolean success = dao.insertNote(model);
        if(success) {
            result.getMsg().add("登録処理に成功しました！");
        }else{
            result.getErrorMsg().add("登録処理に失敗ました。");
        }

    }

}
