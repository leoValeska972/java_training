package ojt.bookstore.app.bl.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <h2>UserDTO Class</h2>
 * <p>
 * Process for Displaying UserDTO
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserDetails {

    /**
     * <h2>serialVersionUID</h2>
     * <p>
     * serialVersionUID
     * </p>
     */
    private static final long serialVersionUID = 7376528184215268346L;

    /**
     * <h2>username</h2>
     * <p>
     * username
     * </p>
     */
    private String username;
    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    private String password;
    /**
     * <h2>role</h2>
     * <p>
     * role
     * </p>
     */
    private String role;

    /**
     * <h2>getAuthorities</h2>
     * <p>
     * Get Authorities
     * </p>
     * 
     * @return list List<GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(this.role));
        return list;
    }

    /**
     * <h2>getPassword</h2>
     * <p>
     * Get Password
     * </p>
     * 
     * @return
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * <h2>getUsername</h2>
     * <p>
     * Get Username
     * </p>
     * 
     * @return
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * <h2>isAccountNonExpired</h2>
     * <p>
     * Account is non Non Expired
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * <h2>isAccountNonLocked</h2>
     * <p>
     * Account is non locked
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * <h2>isCredentialsNonExpired</h2>
     * <p>
     * Credentials is non Expired
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * <h2>isEnabled</h2>
     * <p>
     * Is Enabled
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
