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
import ojt.bookstore.app.web.form.BookForm;

/**
 * <h2>Book Class</h2>
 * <p>
 * Process for Displaying Book
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
@Table(name = "Book")
public class Book {
    /**
     * <h2>bid</h2>
     * <p>
     * bid
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer bid;
    /**
     * <h2>bname</h2>
     * <p>
     * bname
     * </p>
     */
    @Column(name = "Name")
    private String bname;
    /**
     * <h2>bauth</h2>
     * <p>
     * bauth
     * </p>
     */
    @Column(name = "Author")
    private String bauthor;
    /**
     * <h2>bpub</h2>
     * <p>
     * bpub
     * </p>
     */
    /**
     * <h2>bpub</h2>
     * <p>
     * bpub
     * </p>
     */
    @Column(name = "Publisher")
    private String bpublisher;
    /**
     * <h2>bisbn</h2>
     * <p>
     * bisbn
     * </p>
     */
    @Column(name = "ISBN")
    private Integer bisbn;
    /**
     * <h2>bquan</h2>
     * <p>
     * bquan
     * </p>
     */
    @Column(name = "Quantity")
    private Integer bquantity;
    /**
     * <h2>bprice</h2>
     * <p>
     * bprice
     * </p>
     */
    @Column(name = "Price")
    private Integer bprice;

    @Column(name = "Flag")
    private Integer flag;

    /**
     * <h2>Constructor for Book</h2>
     * <p>
     * Constructor for Book
     * </p>
     * 
     * @param bookForm BookForm
     */
    public Book(BookForm bookForm) {
        super();
        this.bid = bookForm.getBid();
        this.bname = bookForm.getBname();
        this.bauthor = bookForm.getBauthor();
        this.bpublisher = bookForm.getBpublisher();
        this.bisbn = bookForm.getBisbn();
        this.bquantity = bookForm.getBquantity();
        this.bprice = bookForm.getBprice();
    }
}
