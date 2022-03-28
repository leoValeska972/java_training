package ojt.clinic.app.bl.service.user;

import ojt.clinic.app.persistence.entity.User;

public interface UserService {
    public User doGetUserByEmail(String email);
    
    public boolean doCheckEmail(String email);
}
