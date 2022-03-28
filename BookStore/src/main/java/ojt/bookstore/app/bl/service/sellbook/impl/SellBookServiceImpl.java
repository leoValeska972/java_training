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
     * <h2>sellBookDao</h2>
     * <p>
     * sellBookDao
     * </p>
     */
    @Autowired
    private SellBookDao sellBookDao;

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
     * @param sellBookForm SellBookForm
     */
    @Override
    public void doAddSellBook(SellBookForm sellBookForm) {
        SellBook sellBook = new SellBook(sellBookForm);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        sellBook.setSellbdate(dtf.format(now));
        int price = bookDao.dbGetBookById(sellBook.getBid()).getBprice();
        int totalPrice = price * sellBook.getSellbquantity();
        sellBook.setSellbtprice(totalPrice);
        int quantity = bookDao.dbGetBookById(sellBook.getBid()).getBquantity();
        int leftQuantity = quantity - sellBook.getSellbquantity();
        bookDao.dbUpdateQuan(sellBook.getBid(), leftQuantity);
        sellBookDao.dbAddSellBook(sellBook);
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
        for (SellBook sellBook : this.sellBookDao.dbListSellBooks()) {
            SellBookDTO sellBookDto = new SellBookDTO(sellBook);
            String bname = bookDao.dbGetBookById(sellBook.getBid()).getBname();
            sellBookDto.setBname(bname);
            bookList.add(sellBookDto);
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
        int quantity = bookDao.dbGetBookById(id).getBquantity();
        int leftQuantity = quantity - quan;
        if (leftQuantity >= 0) {
            return leftQuantity;
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
        return bookDao.dbGetBookById(id).getBquantity();
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
