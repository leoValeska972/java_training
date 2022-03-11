package ojt.bookstore.app.persistence.dao.book;

import java.util.List;

import ojt.bookstore.app.persistence.entity.Book;

public interface BookDao {
    /**
     * <h2>dbAddBook</h2>
     * <p>
     * Add New Book
     * </p>
     *
     * @param book Book
     * @return void
     */
    public void dbAddBook(Book book);

    /**
     * <h2>dbListBooks</h2>
     * <p>
     * Show All Books
     * </p>
     *
     * @return
     * @return List<Book>
     */
    public List<Book> dbListBooks();

    /**
     * <h2>dbGetBookById</h2>
     * <p>
     * Get Book By ID
     * </p>
     *
     * @param id int
     * @return
     * @return Book
     */
    public Book dbGetBookById(int id);

    /**
     * <h2>dbUpdateBook</h2>
     * <p>
     * Update Book
     * </p>
     *
     * @param book Book
     * @return void
     */
    public void dbUpdateBook(Book book);

    /**
     * <h2>dbUpdateQuan</h2>
     * <p>
     * Update Book Quantity
     * </p>
     *
     * @param id   int
     * @param quan int
     * @return void
     */
    public void dbUpdateQuan(int id, int quan);

    /**
     * <h2>dbDeleteBook</h2>
     * <p>
     * Delete Book
     * </p>
     *
     * @param id int
     * @return void
     */
    public void dbDeleteBook(int id);
}
