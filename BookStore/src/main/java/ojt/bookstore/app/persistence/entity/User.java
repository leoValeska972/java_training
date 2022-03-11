package ojt.bookstore.app.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {
    /**
     * <h2>uid</h2>
     * <p>
     * uid
     * </p>
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    /**
     * <h2>uname</h2>
     * <p>
     * uname
     * </p>
     */
    @Column(name = "Name")
    private String uname;
    /**
     * <h2>upass</h2>
     * <p>
     * upass
     * </p>
     */
    @Column(name = "Password")
    private String upass;
    /**
     * <h2>urole</h2>
     * <p>
     * urole
     * </p>
     */
    @Column(name = "Role")
    private String urole;
}