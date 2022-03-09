package ojt.bookstore.app.web.form;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>SellBookForm Class</h2>
 * <p>
 * Process for Displaying SellBookForm
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellBookForm {
    /**
     * <h2>sbid</h2>
     * <p>
     * sbid
     * </p>
     */
    private Integer sbid;
    /**
     * <h2>bid</h2>
     * <p>
     * bid
     * </p>
     */
    @NotNull
    private Integer bid;
    /**
     * <h2>sbdate</h2>
     * <p>
     * sbdate
     * </p>
     */
    private String sbdate;
    /**
     * <h2>sbquan</h2>
     * <p>
     * sbquan
     * </p>
     */
    @NotNull
    private Integer sbquan;
    /**
     * <h2>sbtprice</h2>
     * <p>
     * sbtprice
     * </p>
     */
    private Integer sbtprice;
}
