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
    private Integer sellbid;
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
    private String sellbdate;
    /**
     * <h2>sbquan</h2>
     * <p>
     * sbquan
     * </p>
     */
    private Integer sellbquantity;
    /**
     * <h2>sbtprice</h2>
     * <p>
     * sbtprice
     * </p>
     */
    private Integer sellbtprice;

    /**
     * <h2>Constructor for SellBookDTO</h2>
     * <p>
     * Constructor for SellBookDTO
     * </p>
     * 
     * @param sb SellBook
     */
    public SellBookDTO(SellBook sellBook) {
        super();
        this.sellbid = sellBook.getSellbid();
        this.bid = sellBook.getBid();
        this.sellbdate = sellBook.getSellbdate();
        this.sellbquantity = sellBook.getSellbquantity();
        this.sellbtprice = sellBook.getSellbtprice();
    }
}
