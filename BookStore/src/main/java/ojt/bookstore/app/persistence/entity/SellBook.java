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
import ojt.bookstore.app.web.form.SellBookForm;

/**
 * <h2>SellBook Class</h2>
 * <p>
 * Process for Displaying SellBook
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
@Table(name = "SellBook")
public class SellBook {
    /**
     * <h2>sbid</h2>
     * <p>
     * sbid
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer sellbid;
    /**
     * <h2>bid</h2>
     * <p>
     * bid
     * </p>
     */
    @Column(name = "BId")
    private Integer bid;
    /**
     * <h2>sbdate</h2>
     * <p>
     * sbdate
     * </p>
     */
    @Column(name = "Date")
    private String sellbdate;
    /**
     * <h2>sbquan</h2>
     * <p>
     * sbquan
     * </p>
     */
    @Column(name = "Quantity")
    private Integer sellbquantity;
    /**
     * <h2>sbtprice</h2>
     * <p>
     * sbtprice
     * </p>
     */
    @Column(name = "Price")
    private Integer sellbtprice;

    /**
     * <h2>Constructor for SellBook</h2>
     * <p>
     * Constructor for SellBook
     * </p>
     * 
     * @param sbForm SellBookForm
     */
    public SellBook(SellBookForm sellBookForm) {
        super();
        this.sellbid = sellBookForm.getSellbid();
        this.bid = sellBookForm.getBid();
        this.sellbdate = sellBookForm.getSellbdate();
        this.sellbquantity = sellBookForm.getSellbquantity();
        this.sellbtprice = sellBookForm.getSellbtprice();
    }
}
