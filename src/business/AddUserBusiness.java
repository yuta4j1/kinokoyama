package business;

import java.sql.Connection;
import java.time.LocalDateTime;

import dao.AddUserDao;
import model.UserInf;

public class AddUserBusiness {
    public boolean addUser(UserInf model, Connection conn) {
        AddUserDao dao = new AddUserDao(conn);
        if (!dao.searchUser(model)) {
            return false;
        }
        // modelに情報追加
        model.setRoll("2");
        model.setCreateDateTime(LocalDateTime.now());
        model.setLoginDateTime(LocalDateTime.now());
        if (dao.insert(model) != 1) {
            return false;
        }
        return true;
    }
}
