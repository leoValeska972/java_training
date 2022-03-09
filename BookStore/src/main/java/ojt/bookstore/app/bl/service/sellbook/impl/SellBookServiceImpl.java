package ojt.bookstore.app.bl.service.sellbook.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.bookstore.app.bl.dto.SellBookDTO;
import ojt.bookstore.app.bl.service.sellbook.SellBookService;
import ojt.bookstore.app.persistence.dao.book.BookDao;
import ojt.bookstore.app.persistence.dao.sellbook.SellBookDao;
import ojt.bookstore.app.persistence.entity.SellBook;
import ojt.bookstore.app.web.form.SellBookForm;

/**
 * <h2>SellBookServiceImpl Class</h2>
 * <p>
 * Process for Displaying SellBookServiceImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Service
@Transactional
public class SellBookServiceImpl implements SellBookService {

    /**
     * <h2>sbDao</h2>
     * <p>
     * sbDao
     * </p>
     */
    @Autowired
    private SellBookDao sbDao;

    /**
     * <h2>bookDao</h2>
     * <p>
     * bookDao
     * </p>
     */
    @Autowired
    private BookDao bookDao;

    /**
     * <h2>doAddSellBook</h2>
     * <p>
     * Add New Sold Book
     * </p>
     * 
     * @param sbForm SellBookForm
     */
    @Override
    public void doAddSellBook(SellBookForm sbForm) {
        SellBook sb = new SellBook(sbForm);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        sb.setSbdate(dtf.format(now));
        int p = bookDao.dbGetBookById(sb.getBid()).getBprice();
        int tp = p * sb.getSbquan();
        sb.setSbtprice(tp);
        int q = bookDao.dbGetBookById(sb.getBid()).getBquan();
        int qua = q - sb.getSbquan();
        bookDao.dbUpdateQuan(sb.getBid(), qua);
        sbDao.dbAddSellBook(sb);
    }

    /**
     * <h2>doListSellBooks</h2>
     * <p>
     * Show All Sold Books
     * </p>
     * 
     * @return bookList<SellBookDTO>
     */
    @Override
    public List<SellBookDTO> doListSellBooks() {
        List<SellBookDTO> bookList = new ArrayList<SellBookDTO>();
        for (SellBook sb : this.sbDao.dbListSellBooks()) {
            SellBookDTO sbDto = new SellBookDTO(sb);
            String bname = bookDao.dbGetBookById(sb.getBid()).getBname();
            sbDto.setBname(bname);
            bookList.add(sbDto);
        }
        return bookList;
    }

    /**
     * <h2>doCheckQuan</h2>
     * <p>
     * Check Book Quantity
     * </p>
     * 
     * @param id   int
     * @param quan int
     * @return
     */
    @Override
    public int doCheckQuan(int id, int quan) {
        int q = bookDao.dbGetBookById(id).getBquan();
        int qua = q - quan;
        if (qua >= 0) {
            return qua;
        } else {
            return -1;
        }
    }

    /**
     * <h2>doGetQuan</h2>
     * <p>
     * Get Book Quantity
     * </p>
     * 
     * @param id int
     * @return
     */
    @Override
    public int doGetQuan(int id) {
        return bookDao.dbGetBookById(id).getBquan();
    }

    /**
     * <h2>doGetBookId</h2>
     * <p>
     * Get Book ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @Override
    public int doGetBookId(int id) {
        int bid = 0;
        try {
            bid = bookDao.dbGetBookById(id).getBid();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return bid;
    }
}
