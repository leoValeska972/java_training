package ojt.bookstore.app.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.bookstore.app.persistence.entity.SellBook;

/**
 * <h2>SellBookDTO Class</h2>
 * <p>
 * Process for Displaying SellBookDTO
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellBookDTO {
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
    private Integer bid;
    /**
     * <h2>bname</h2>
     * <p>
     * bname
     * </p>
     */
    private String bname;
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
    private Integer sbquan;
    /**
     * <h2>sbtprice</h2>
     * <p>
     * sbtprice
     * </p>
     */
    private Integer sbtprice;

    /**
     * <h2>Constructor for SellBookDTO</h2>
     * <p>
     * Constructor for SellBookDTO
     * </p>
     * 
     * @param sb SellBook
     */
    public SellBookDTO(SellBook sb) {
        super();
        this.sbid = sb.getSbid();
        this.bid = sb.getBid();
        this.sbdate = sb.getSbdate();
        this.sbquan = sb.getSbquan();
        this.sbtprice = sb.getSbtprice();
    }
}
