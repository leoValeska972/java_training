package ojt.bookstore.app.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.bookstore.app.persistence.entity.Book;

/**
 * <h2>BookDTO Class</h2>
 * <p>
 * Process for Displaying BookDTO
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
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
     * <h2>bauth</h2>
     * <p>
     * bauth
     * </p>
     */
    private String bauthor;
    /**
     * <h2>bpub</h2>
     * <p>
     * bpub
     * </p>
     */
    private String bpublisher;
    /**
     * <h2>bisbn</h2>
     * <p>
     * bisbn
     * </p>
     */
    private Integer bisbn;
    /**
     * <h2>bquan</h2>
     * <p>
     * bquan
     * </p>
     */
    private Integer bquantity;
    /**
     * <h2>bprice</h2>
     * <p>
     * bprice
     * </p>
     */
    private Integer bprice;

    /**
     * <h2>Constructor for BookDTO</h2>
     * <p>
     * Constructor for BookDTO
     * </p>
     * 
     * @param book Book
     */
    public BookDTO(Book book) {
        super();
        this.bid = book.getBid();
        this.bname = book.getBname();
        this.bauthor = book.getBauthor();
        this.bpublisher = book.getBpublisher();
        this.bisbn = book.getBisbn();
        this.bquantity = book.getBquantity();
        this.bprice = book.getBprice();
    }
}
