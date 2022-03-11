package ojt.bookstore.app.bl.service.book.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
        book.setFlag(1);
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
        book.setFlag(1);
        bookDao.dbUpdateBook(book);
    }

    /**
     * <h2>doDeleteBook</h2>
     * <p>
     * Delete Book
     * </p>
     * 
     * @param id
     */
    @Override
    public void doDeleteBook(int id) {
        bookDao.dbDeleteBook(id);
    }

    /**
     * <h2>doDownloadBook</h2>
     * <p>
     * Download Book Lists
     * </p>
     * 
     * @throws IOException
     */
    @Override
    public void doDownloadBook(HttpServletResponse response) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Book Stocks");
        String fileName = "books.xlsx";
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("ID");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("Name");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Author");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("Publisher");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("ISBN");
        Cell cell5 = row.createCell(5);
        cell5.setCellValue("Quantity");
        Cell cell6 = row.createCell(6);
        cell6.setCellValue("Price");
        List<Book> blist = bookDao.dbListBooks();
        for (int i = 1; i <= blist.size(); i++) {
            Row rowi = sheet.createRow(i);
            int k = 1;
            Cell cellId = rowi.createCell(--k);
            cellId.setCellValue(blist.get(i - 1).getBid());
            Cell cellName = rowi.createCell(++k);
            cellName.setCellValue(blist.get(i - 1).getBname());
            Cell cellAuthor = rowi.createCell(++k);
            cellAuthor.setCellValue(blist.get(i - 1).getBauth());
            Cell cellPublisher = rowi.createCell(++k);
            cellPublisher.setCellValue(blist.get(i - 1).getBpub());
            Cell cellISBN = rowi.createCell(++k);
            cellISBN.setCellValue(blist.get(i - 1).getBisbn());
            Cell cellQuantity = rowi.createCell(++k);
            cellQuantity.setCellValue(blist.get(i - 1).getBquan());
            Cell cellPrice = rowi.createCell(++k);
            cellPrice.setCellValue(blist.get(i - 1).getBprice());
        }
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            IOUtils.closeQuietly(response.getOutputStream());
        }
    }

    /**
     * <h2>doUploadBook</h2>
     * <p>
     * Upload Book File
     * </p>
     * 
     * @param file MultipartFile
     * @return
     * @throws IOException
     */
    @SuppressWarnings({ "resource" })
    @Override
    public String doUploadBook(MultipartFile file) throws IOException {
        String errMsg = ValidC(file);
        if (errMsg != null) {
            return errMsg;
        }
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            Book book = new Book();
            Row row = sheet.getRow(i);
            Cell cellName = row.getCell(1);
            book.setBname(cellName.getStringCellValue());
            Cell cellAuthor = row.getCell(2);
            book.setBauth(cellAuthor.getStringCellValue());
            Cell cellPublisher = row.getCell(3);
            book.setBpub(cellPublisher.getStringCellValue());
            Cell cellISBN = row.getCell(4);
            book.setBisbn((int) cellISBN.getNumericCellValue());
            Cell cellQuantity = row.getCell(5);
            book.setBquan((int) cellQuantity.getNumericCellValue());
            Cell cellPrice = row.getCell(6);
            book.setBprice((int) cellPrice.getNumericCellValue());
            book.setFlag(1);
            bookDao.dbAddBook(book);
        }
        return "File Upload Successful";
    }

    @SuppressWarnings({ "resource", "deprecation" })
    private String ValidC(MultipartFile file) throws IOException {
        // check if file is null
        if (file.isEmpty()) {
            return "No FIle Is Selected";
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);

        // check extension
        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            return "File Extension Wrong!";
        }
        // check null
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                Cell cell = row.getCell(k);
                if (cell == null) {
                    return "There is Null in the file";
                }
            }
        }
        // check file Type
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            // Name String
            Cell cellName = row.getCell(1);
            if (cellName.getCellType() != Cell.CELL_TYPE_STRING) {
                return "Wrong Data Type in this file";
            }
            // Author String
            Cell cellAuthor = row.getCell(2);
            if (cellAuthor.getCellType() != Cell.CELL_TYPE_STRING) {
                return "Wrong Data Type in this file";
            }
            // Publisher String
            Cell cellPublisher = row.getCell(3);
            if (cellPublisher.getCellType() != Cell.CELL_TYPE_STRING) {
                return "Wrong Data Type in this file";
            }
            // ISBN int
            Cell cellISBN = row.getCell(4);
            if (cellISBN.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                return "Wrong Data Type in this file";
            }
            // Quantity int
            Cell cellQuantity = row.getCell(5);
            if (cellQuantity.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                return "Wrong Data Type in this file";
            }
            // Price int
            Cell cellPrice = row.getCell(6);
            if (cellPrice.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                return "Wrong Data Type in this file";
            }
        }
        // check file has no data
        if (sheet.getFirstRowNum() == sheet.getLastRowNum()) {
            return "No Data in the File";
        }
        return null;
    }
}
