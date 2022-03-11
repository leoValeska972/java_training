package ojt.bookstore.app.persistence.dao.user;

import ojt.bookstore.app.persistence.entity.User;

/**
 * <h2>UserDao Class</h2>
 * <p>
 * Process for Displaying UserDao
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface UserDao {

    /**
     * <h2>dbSaveUser</h2>
     * <p>
     * Insert User
     * </p>
     *
     * @param user User
     * @return void
     */
    public void dbSaveUser(User user);

    /**
     * <h2>dbGetUserByName</h2>
     * <p>
     * Get User By Name
     * </p>
     *
     * @param username String
     * @return
     * @return User
     */
    public User dbGetUserByName(String username);

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * Get User Number
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetUserCount();
}
