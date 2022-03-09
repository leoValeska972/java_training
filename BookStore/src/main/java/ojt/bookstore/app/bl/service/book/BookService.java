package ojt.bookstore.app.bl.service.book;

import java.util.List;

import ojt.bookstore.app.bl.dto.BookDTO;
import ojt.bookstore.app.web.form.BookForm;

/**
 * <h2>BookService Class</h2>
 * <p>
 * Process for Displaying BookService
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface BookService {
    /**
     * <h2>doAddBook</h2>
     * <p>
     * Add New Book
     * </p>
     *
     * @param bookFrom BookForm
     * @return void
     */
    public void doAddBook(BookForm bookFrom);

    /**
     * <h2>doListBooks</h2>
     * <p>
     * Show All Books
     * </p>
     *
     * @return
     * @return List<BookDTO>
     */
    public List<BookDTO> doListBooks();

    /**
     * <h2>doGetBookById</h2>
     * <p>
     * Get Book By ID
     * </p>
     *
     * @param id int
     * @return
     * @return BookDTO
     */
    public BookDTO doGetBookById(int id);

    /**
     * <h2>doUpdateBook</h2>
     * <p>
     * Update Book
     * </p>
     *
     * @param bookForm BookForm
     * @return void
     */
    public void doUpdateBook(BookForm bookForm);
}
