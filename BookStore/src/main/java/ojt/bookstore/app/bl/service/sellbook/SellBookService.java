package ojt.bookstore.app.bl.service.sellbook;

import java.util.List;

import ojt.bookstore.app.bl.dto.SellBookDTO;
import ojt.bookstore.app.web.form.SellBookForm;

/**
 * <h2>SellBookService Class</h2>
 * <p>
 * Process for Displaying SellBookService
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface SellBookService {
    /**
     * <h2>doAddSellBook</h2>
     * <p>
     * Add New Sold Book
     * </p>
     *
     * @param sellBookForm SellBookForm
     * @return void
     */
    public void doAddSellBook(SellBookForm sellBookForm);

    /**
     * <h2>doListSellBooks</h2>
     * <p>
     * Show All Sold Book
     * </p>
     *
     * @return
     * @return List<SellBookDTO>
     */
    public List<SellBookDTO> doListSellBooks();

    /**
     * <h2>doCheckQuan</h2>
     * <p>
     * Check Book Quantity
     * </p>
     *
     * @param id   int
     * @param quan int
     * @return
     * @return int
     */
    public int doCheckQuan(int id, int quan);

    /**
     * <h2>doGetQuan</h2>
     * <p>
     * Get Book Quantity
     * </p>
     *
     * @param id int
     * @return
     * @return int
     */
    public int doGetQuan(int id);

    /**
     * <h2>doGetBookId</h2>
     * <p>
     * 
     * </p>
     *
     * @param id int
     * @return
     * @return int
     */
    public int doGetBookId(int id);
}
