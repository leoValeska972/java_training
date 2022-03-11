package ojt.bookstore.app.web.controller.sellbook;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.bookstore.app.bl.service.sellbook.SellBookService;
import ojt.bookstore.app.web.form.SellBookForm;

/**
 * <h2>SellBookController Class</h2>
 * <p>
 * Process for Displaying SellBookController
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Controller
public class SellBookController {
    /**
     * <h2>sbService</h2>
     * <p>
     * sbService
     * </p>
     */
    @Autowired
    private SellBookService sbService;
    /**
     * <h2>messageSource</h2>
     * <p>
     * messageSource
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
     * <h2>addSellBook</h2>
     * <p>
     * Insert Sold Book
     * </p>
     *
     * @param sbForm SellBookForm
     * @param br     BindingResult
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/addSellBook", method = RequestMethod.POST)
    public ModelAndView addSellBook(@Valid @ModelAttribute("sbForm") SellBookForm sbForm, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("sellbook");
            mv.addObject("sbForm", sbForm);
            mv.addObject("sbList", sbService.doListSellBooks());
            return mv;
        }
        if ((sbForm.getSbid() == null || sbForm.getSbid() == 0)
                && sbService.doGetBookId(sbForm.getBid()) == sbForm.getBid()) {
            int quan = sbService.doCheckQuan(sbForm.getBid(), sbForm.getSbquan());
            if (quan >= 0) {
                sbService.doAddSellBook(sbForm);
                session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0001", null, null));
            } else {
                session.setAttribute("errorMsg", "Only " + sbService.doGetQuan(sbForm.getBid()) + " books remaining");
            }
        } else {
            session.setAttribute("errorMsg", "There is no such book");
        }
        mv.setViewName("redirect:/sellbooks");
        return mv;
    }

    /**
     * <h2>listSellBooks</h2>
     * <p>
     * Show All Sold Books
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/sellbooks", method = RequestMethod.GET)
    public ModelAndView listSellBooks() {
        ModelAndView mv = new ModelAndView("sellbook");
        mv.addObject("sbForm", new SellBookForm());
        mv.addObject("sbList", sbService.doListSellBooks());
        return mv;
    }

    /**
     * <h2>error</h2>
     * <p>
     * Login Error
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "book/access-denied";
    }
}
