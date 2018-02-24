package entity;

import java.time.LocalDateTime;

/**
 * タグリスト取得エンティティクラス
 * @author ozaki
 *
 */
public class TagListEntity {

    /* タグ名 */
    private String tagNm;
    /* タグ区分 */
    private String tagKbn;
    /* 作成者 */
    private String createUser;
    /* 更新日付 */
    private LocalDateTime updateDate;

    /**
     * 引数なしコンストラクタ
     */
    public TagListEntity(){

    }

    /**
     * 引数ありコンストラクタ
     * @param tagNm
     * @param tagKbn
     * @param createUser
     * @param updateDate
     */
    public TagListEntity(String tagNm, String tagKbn, String createUser, LocalDateTime updateDate) {
        this.tagNm = tagNm;
        this.tagKbn = tagKbn;
        this.createUser = createUser;
        this.updateDate = updateDate;
    }


    public String getTagNm() {
        return tagNm;
    }

    public void setTagNm(String tagNm) {
        this.tagNm = tagNm;
    }

    public String getTagKbn() {
        return tagKbn;
    }

    public void setTagKbn(String tagKbn) {
        this.tagKbn = tagKbn;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
