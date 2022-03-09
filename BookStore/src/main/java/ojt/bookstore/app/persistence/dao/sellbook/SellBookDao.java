package ojt.bookstore.app.persistence.dao.sellbook;

import java.util.List;

import ojt.bookstore.app.persistence.entity.SellBook;

/**
 * <h2>SellBookDao Class</h2>
 * <p>
 * Process for Displaying SellBookDao
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface SellBookDao {
    /**
     * <h2>dbAddSellBook</h2>
     * <p>
     * Add Sold Book
     * </p>
     *
     * @param sb SellBook
     * @return void
     */
    public void dbAddSellBook(SellBook sb);

    /**
     * <h2>dbListSellBooks</h2>
     * <p>
     * Show All Sold Books
     * </p>
     *
     * @return
     * @return List<SellBook>
     */
    public List<SellBook> dbListSellBooks();

    /**
     * <h2>dbGetSellBookById</h2>
     * <p>
     * Get Sold Book By ID
     * </p>
     *
     * @param id int
     * @return
     * @return SellBook
     */
    public SellBook dbGetSellBookById(int id);

    /**
     * <h2>dbUpdateSellBook</h2>
     * <p>
     * Update Sold Book
     * </p>
     *
     * @param sb SellBook
     * @return void
     */
    public void dbUpdateSellBook(SellBook sb);
}
