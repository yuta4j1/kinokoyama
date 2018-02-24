package business;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import dao.GetTagListDao;
import entity.TagListEntity;
import model.TagListModel;

/**
 * タグリスト取得ビジネスクラス
 * @author ozaki
 *
 */
public class GetTagListBusiness extends BaseBusiness {

    public GetTagListBusiness(Connection conn) {
        super(conn);
    }

    /**
     * タグリスト取得処理を実行するメソッド
     * @return
     */
    public List<TagListModel> execute() {
        GetTagListDao dao = new GetTagListDao(conn);

        //タグリストを取得
        List<TagListEntity> entities = dao.getTagList();

        // エンティティからモデルに詰め替え
        return entities.stream()
                .map(m -> new TagListModel(m.getTagNm(), m.getTagKbn(), m.getCreateUser(), m.getUpdateDate()))
                .collect(Collectors.toList());
    }

}
