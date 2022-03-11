package ojt.bookstore.app.bl.service.user;

import ojt.bookstore.app.persistence.entity.User;

/**
 * <h2>UserService Class</h2>
 * <p>
 * Process for Displaying UserService
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface UserService {

    /**
     * <h2>doGetUserByName</h2>
     * <p>
     * Get User By Name
     * </p>
     *
     * @param username String
     * @return
     * @return User
     */
    public User doGetUserByName(String username);

    /**
     * <h2>doGetUserCount</h2>
     * <p>
     * Get User Number
     * </p>
     *
     * @return
     * @return long
     */
    public long doGetUserCount();
}