package ojt.bookstore.app.web.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>BookForm Class</h2>
 * <p>
 * Process for Displaying BookForm
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {
    /**
     * <h2>bid</h2>
     * <p>
     * bid
     * </p>
     */
    private Integer bid;
    /**
     * <h2>bname</h2>
     * <p>
     * bname
     * </p>
     */
    @NotEmpty
    @Size(max = 60)
    private String bname;
    /**
     * <h2>bauth</h2>
     * <p>
     * bauth
     * </p>
     */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    @Size(max = 30)
    private String bauth;
    /**
     * <h2>bpub</h2>
     * <p>
     * bpub
     * </p>
     */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    @Size(max = 30)
    private String bpub;
    /**
     * <h2>bisbn</h2>
     * <p>
     * bisbn
     * </p>
     */
    @NotNull
    private String bisbn;
    /**
     * <h2>bquan</h2>
     * <p>
     * bquan
     * </p>
     */
    @NotNull
    private Integer bquan;
    /**
     * <h2>bprice</h2>
     * <p>
     * bprice
     * </p>
     */
    @NotNull
    private Integer bprice;
}
