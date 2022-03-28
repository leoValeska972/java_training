package ojt.clinic.app.persistence.dao.user;

import java.util.List;

import ojt.clinic.app.persistence.entity.User;

public interface UserDao {
    public void dbAddUser(User user);

    public List<User> dbListUsers(String type);

    public List<User> dbSearchListUsers(String search,String type);

    public User dbGetUserById(int id);

    public User dbGetUserByEmail(String email);

    public void dbUpdateUser(User user);

    public void dbDeleteUser(int id);
}
