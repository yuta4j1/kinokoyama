package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TagListEntity;

public class GetTagListDao extends BaseDao {

    public GetTagListDao(Connection conn) {
        super(conn);
    }

    private static final String GET_TAG_INF = "select tag_nm, tag_kbn, create_user, update_date from m_tag ;";

    public List<TagListEntity> getTagList() {
        List<TagListEntity> entities = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(GET_TAG_INF)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagListEntity entity = new TagListEntity(rs.getString("tag_nm"), rs.getString("tag_kbn"),
                        rs.getString("create_user"), rs.getTimestamp("update_date").toLocalDateTime());
                entities.add(entity);
            }

            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

}
