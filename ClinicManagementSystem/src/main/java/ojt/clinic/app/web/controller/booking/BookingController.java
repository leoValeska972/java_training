package ojt.clinic.app.web.controller.booking;

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
import org.springframework.web.servlet.ModelAndView;

import ojt.clinic.app.bl.service.booking.BookingService;
import ojt.clinic.app.web.form.BookingForm;

@Controller
public class BookingController {
    private ModelAndView mv;
    @Autowired
    private BookingService bookingService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/bookingInit", method = RequestMethod.GET)
    public ModelAndView bookingInit() {
        mv = new ModelAndView("booking");
        mv.addObject("bookingForm", new BookingForm());
        mv.addObject("btnName", "Clear");
        mv.addObject("btnJs", "clear");
        return mv;
    }

    @RequestMapping(value = "/addBookingConfirm", method = RequestMethod.POST)
    public ModelAndView addBookingConfirm(@Valid @ModelAttribute("bookingForm") BookingForm bookingForm,
            BindingResult br) {
        mv = new ModelAndView();
        if (br.hasErrors()) {
            if (bookingForm.getBookingId() == null || bookingForm.getBookingId() == 0) {
                mv.addObject("btnName", "Clear");
                mv.addObject("btnJs", "clear");
            } else {
                mv.addObject("btnName", "Reset");
                mv.addObject("btnJs", "reset");
            }
            mv.setViewName("booking");
        } else {
            mv.setViewName("confirm");
            mv.addObject("res", "booking");
        }
        return mv;
    }

    @RequestMapping(value = "/addBooking", method = RequestMethod.POST)
    public ModelAndView addBooking(@ModelAttribute("bookingForm") BookingForm bookingForm) {
        mv = new ModelAndView("redirect:/bookingView");
        if (bookingForm.getBookingId() == null || bookingForm.getBookingId() == 0) {
            bookingService.doAddBooking(bookingForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            bookingService.doUpdateBooking(bookingForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0003", null, null));
        }
        return mv;
    }

    @RequestMapping(value = "/bookingView", method = RequestMethod.GET)
    public ModelAndView bookingView() {
        mv = new ModelAndView("bookingView");
        mv.addObject("bookingList", bookingService.doListBookings());
        return mv;
    }

    @RequestMapping(value = "/bookingSearch", method = RequestMethod.POST)
    public ModelAndView bookingSearch(@RequestParam("search") String search) {
        mv = new ModelAndView("bookingView");
        mv.addObject("bookingList", bookingService.doSearchListBookings(search));
        int count = bookingService.doSearchListBookings(search).size();
        mv.addObject("msg", count + " results found");
        return mv;
    }

    @RequestMapping("/editBooking/{id}")
    public ModelAndView editBooking(@PathVariable("id") int id) {
        mv = new ModelAndView("booking");
        mv.addObject("btnName", "Reset");
        mv.addObject("btnJs", "reset");
        mv.addObject("bookingForm", bookingService.doGetBookingById(id));
        return mv;
    }

    @RequestMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable("id") int id) {
        session.setAttribute("msg", this.messageSource.getMessage("M_SC_0002", null, null));
        bookingService.doDeleteBooking(id);
        return "redirect:/bookingView";
    }

}
