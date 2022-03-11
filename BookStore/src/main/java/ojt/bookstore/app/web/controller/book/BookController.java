package ojt.bookstore.app.web.controller.book;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ojt.bookstore.app.bl.service.book.BookService;
import ojt.bookstore.app.web.form.BookForm;

/**
 * <h2>BookController Class</h2>
 * <p>
 * Process for Displaying BookController
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Controller
public class BookController {

    /**
     * <h2>bookService</h2>
     * <p>
     * bookService
     * </p>
     */
    @Autowired
    private BookService bookService;

    /**
     * <h2>Message Source</h2>
     * <p>
     * Message Source
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2>session</h2>
     * <p>
     * session
     * </p>
     */
    @Autowired
    private HttpSession session;

    /**
     * <h2>addBook</h2>
     * <p>
     * Insert or Update Book
     * </p>
     *
     * @param bookForm BookForm
     * @param br       BindingResult
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView addBook(@Valid @ModelAttribute("bookForm") BookForm bookForm, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("book");
            mv.addObject("bookForm", bookForm);
            mv.addObject("bookList", bookService.doListBooks());
            return mv;
        }
        if (bookForm.getBid() == null || bookForm.getBid() == 0) {
            bookService.doAddBook(bookForm);
            session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            bookService.doUpdateBook(bookForm);
            session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0003", null, null));
        }
        mv.setViewName("redirect:/books");
        return mv;
    }

    /**
     * <h2>listBooks</h2>
     * <p>
     * Show All Books
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView listBooks() {
        ModelAndView mv = new ModelAndView("book");
        mv.addObject("bookForm", new BookForm());
        mv.addObject("bookList", bookService.doListBooks());
        return mv;
    }

    /**
     * <h2>editBook</h2>
     * <p>
     * Edit Book
     * </p>
     *
     * @param id int
     * @return
     * @return ModelAndView
     */
    @RequestMapping("/editBook/{id}")
    public ModelAndView editBook(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("book");
        mv.addObject("bookForm", bookService.doGetBookById(id));
        mv.addObject("bookList", bookService.doListBooks());
        return mv;
    }

    /**
     * <h2>deleteBook</h2>
     * <p>
     * Delete Book
     * </p>
     *
     * @param id int
     * @return
     * @return String
     */
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        session.setAttribute("errorMsg", this.messageSource.getMessage("M_SC_0002", null, null));
        bookService.doDeleteBook(id);
        return "redirect:/books";
    }

    /**
     * <h2>downloadBook</h2>
     * <p>
     * Download Book Lists
     * </p>
     *
     * @param response HttpServletResponse
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadBook(HttpServletResponse response) throws IOException {
        bookService.doDownloadBook(response);
    }

    /**
     * <h2>uploadBook</h2>
     * <p>
     * Upload Book File
     * </p>
     *
     * @param file MultipartFile
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadBook(@RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView mv = new ModelAndView("book");
        mv.addObject("fileErrMsg", bookService.doUploadBook(file));
        mv.addObject("bookForm", new BookForm());
        mv.addObject("bookList", bookService.doListBooks());
        return mv;
    }
}
