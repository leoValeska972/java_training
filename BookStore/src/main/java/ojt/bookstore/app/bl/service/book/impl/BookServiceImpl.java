package ojt.bookstore.app.bl.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.bookstore.app.bl.dto.BookDTO;
import ojt.bookstore.app.bl.service.book.BookService;
import ojt.bookstore.app.persistence.dao.book.BookDao;
import ojt.bookstore.app.persistence.entity.Book;
import ojt.bookstore.app.web.form.BookForm;

/**
 * <h2>BookServiceImpl Class</h2>
 * <p>
 * Process for Displaying BookServiceImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    /**
     * <h2>bookDao</h2>
     * <p>
     * bookDao
     * </p>
     */
    @Autowired
    private BookDao bookDao;

    /**
     * <h2>doAddBook</h2>
     * <p>
     * Add New Book
     * </p>
     * 
     * @param bookForm BookForm
     */
    @Override
    public void doAddBook(BookForm bookForm) {
        Book book = new Book(bookForm);
        bookDao.dbAddBook(book);
    }

    /**
     * <h2>doListBooks</h2>
     * <p>
     * Show All Books
     * </p>
     * 
     * @return bookList List<BookDTO>
     */
    @Override
    public List<BookDTO> doListBooks() {
        List<BookDTO> bookList = new ArrayList<BookDTO>();
        for (Book book : this.bookDao.dbListBooks()) {
            BookDTO bookDto = new BookDTO(book);
            bookList.add(bookDto);
        }
        return bookList;
    }

    /**
     * <h2>doGetBookById</h2>
     * <p>
     * Get Book By ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @Override
    public BookDTO doGetBookById(int id) {
        Book book = this.bookDao.dbGetBookById(id);
        BookDTO bookForm = book != null ? new BookDTO(book) : null;
        return bookForm;
    }

    /**
     * <h2>doUpdateBook</h2>
     * <p>
     * Update Book
     * </p>
     * 
     * @param bookForm BookForm
     */
    @Override
    public void doUpdateBook(BookForm bookForm) {
        Book book = new Book(bookForm);
        bookDao.dbUpdateBook(book);
    }
}
