package com.luxnet.testTask.contollers;

import com.luxnet.testTask.models.Employee;
import com.luxnet.testTask.models.Position;
import com.luxnet.testTask.repo.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @GetMapping("/employeelist")
    public String employeeList(Model model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/add/Employee")
    public String addEmployee(Model model) {
        return "add-employee";
    }

    @PostMapping("/add/Employee")
    public String addedEmployee(@RequestParam String name,@RequestParam String surname, @RequestParam Long position, Model model) {
        Employee employee = new Employee(name, surname, position);
        employeeRepository.save(employee);
        return "redirect:/positionlist";
    }

    @GetMapping("/employee/{id}")
    public String employeeInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!employeeRepository.existsById(id)) {
            return "redirect:/home";
        }
        Optional<Employee> employee = employeeRepository.findById(id);
        ArrayList<Employee> res= new ArrayList<>();
        employee.ifPresent(res::add);
        model.addAttribute("employees", res);
        return "employee-info";
    }
    @GetMapping("/employee/{id}/edit")
    public String employeeEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!employeeRepository.existsById(id)) {
            return "redirect:/home";
        }
        Optional<Employee> employee = employeeRepository.findById(id);
        ArrayList<Employee> res= new ArrayList<>();
        employee.ifPresent(res::add);
        model.addAttribute("employees", res);
        return "employee-edit";
    }

    @PostMapping("/employee/{id}/edit")
    public String editEmployee(@PathVariable(value = "id") Long id, @RequestParam String name,@RequestParam String surname, @RequestParam Long position, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPositionId(position);
        employeeRepository.save(employee);
        return "redirect:/employeelist";
    }

    @PostMapping("/employee/{id}/delete")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employee);
        return "redirect:/employeelist";
    }

}
