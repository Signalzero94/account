package tmax.account2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tmax.account2.domain.Employee;
import tmax.account2.service.EmployeeService;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/employees/new")
    public String createForm(){
        return "employees/createEmployeeForm";
    }
    @PostMapping("/employees/new")
    public String create(EmployeeForm form){
        Employee employee = new Employee();
        employee.setName(form.getName());
        employee.setResRegiNumber(form.getResRegiNumber());
        employee.setAddress(form.getAddress());
        employee.setClub(form.getClub());
        employee.setCompanyName(form.getCompanyName());
        employee.setCompanyNumber(form.getCompanyNumber());
        employee.setDepartment(form.getDepartment());
        employee.setEmailAddress(form.getEmailAddress());
        employee.setEmployeeNumber(form.getEmployeeNumber());
        employee.setHomeNumber(form.getHomeNumber());
        employee.setMobileNumber(form.getMobileNumber());
        employee.setPosition(form.getPosition());
        employee.setResponsibilities(form.getResponsibilities());
        employee.setWorkLocation(form.getWorkLocation());

        employeeService.join(employee);
        return "redirect:/";
    }

    @GetMapping("/employees")
    public String list(Model model) {
        List<Employee> Employees = employeeService.findEmployees();
        model.addAttribute("employees", Employees);
        return "employees/employeesList";
    }
}