package ojt.employee.app.web.controller.employee;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.employee.app.bl.service.employee.EmployeeService;
import ojt.employee.app.web.form.EmployeeForm;

/**
 * <h2>EmployeeController Class</h2>
 * <p>
 * Process for Displaying EmployeeController
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Controller
public class EmployeeController {

    /**
     * <h2>employeeService</h2>
     * <p>
     * employeeService
     * </p>
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * <h2>Message Source</h2>
     * <p>
     * Message Source
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    /**
     * <h2>addEmployee</h2>
     * <p>
     * Insert or Update Employee
     * </p>
     *
     * @param employee Employee
     * @param br       BindingResult
     * @param model    Model
     * @return
     * @return String
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ModelAndView addEmployee(@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
            BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("emp");
            mv.addObject("employeeForm", employeeForm);
            mv.addObject("employeeList", employeeService.doListEmployees());
            return mv;
        }
        if (employeeForm.getEid() == null || employeeForm.getEid() == 0) {
            employeeService.doAddEmployee(employeeForm);
            session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0019", null, null));
        } else {
            employeeService.doUpdateEmployee(employeeForm);
            session.setAttribute("errorMsg", messageSource.getMessage("M_SC_0021", null, null));
        }
        mv.setViewName("redirect:/employees");
        return mv;
    }

    /**
     * <h2>listEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     *
     * @param model Model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView listEmployees() {
        ModelAndView mv = new ModelAndView("emp");
        mv.addObject("employeeForm", new EmployeeForm());
        mv.addObject("employeeList", employeeService.doListEmployees());
        return mv;
    }

    /**
     * <h2>editEmployee</h2>
     * <p>
     * Edit Employee
     * </p>
     *
     * @param id    int
     * @param model Model
     * @return
     * @return ModelAndView
     */
    @RequestMapping("/editEmployee/{id}")
    public ModelAndView editEmployee(@PathVariable("id") int id, Model model) {
        ModelAndView mv = new ModelAndView("emp");
        mv.addObject("employeeForm", employeeService.doGetEmployeeById(id));
        mv.addObject("employeeList", employeeService.doListEmployees());
        return mv;
    }

    /**
     * <h2>deleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     *
     * @param id int
     * @return
     * @return String
     */
    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        session.setAttribute("errorMsg", this.messageSource.getMessage("M_SC_0020", null, null));
        employeeService.doDeleteEmployee(id);
        return "redirect:/employees";
    }
}
