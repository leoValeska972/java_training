package ojt.employee.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.employee.crud.model.Employee;
import ojt.employee.crud.service.EmployeeService;

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
     * <h2>listemployees</h2>
     * <p>
     * List All Employees
     * </p>
     *
     * @param model Model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView listEmployees(Model model) {
        ModelAndView mv = new ModelAndView("emp");
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", employeeService.listEmployees());
        return mv;
    }

    /**
     * <h2>addemployee</h2>
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
    public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult br,
            Model model) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("emp");
            model.addAttribute("employee", employee);
            model.addAttribute("employeeList", employeeService.listEmployees());
            return mv;
        }
        if (employee.getEid() == null || employee.getEid() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        mv.setViewName("redirect:/employees");
        return mv;
    }

    /**
     * <h2>removeemployee</h2>
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
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    /**
     * <h2>editemployee</h2>
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
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("employeeList", employeeService.listEmployees());
        return mv;
    }
}