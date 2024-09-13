package com.example.lab3_20215433.controller;

import com.example.lab3_20215433.model.entity.Employee;
import com.example.lab3_20215433.model.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {


    final EmployeeRepository employeeRepository;

    public HomeController(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;

    }

    @GetMapping("/pagPrincipal")
    public String navbar( Model model) {

        return"pagPrincipal";
    }


    @GetMapping("/empleadosPage")
    public String empleados( Model model) {

        List<Employee> listaEmployees = employeeRepository.findAll();
        model.addAttribute("listaEmployees", listaEmployees);

        return"empleados";
    }

    @GetMapping("/editar")
    public String editarEmpleado(Model model,
                                 @RequestParam("id") int id) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if( optEmployee.isPresent()){

            Employee employee = optEmployee.get();
            model.addAttribute("employee", employee);
            return "editarEmpleado";
        }else{
            return "empleados";
        }

    }

    @PostMapping("/empleadoGuardar")
    public String guardar(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/empleadosPage";
    }

    @GetMapping("/borrar")
    public String borrar(){

        return "redirect:/empleadosPage";
    }


    @GetMapping("/historialPage")
    public String historial( Model model) {
        List<Employee> listaEmployees = employeeRepository.findAll();
        model.addAttribute("listaEmployees", listaEmployees);


        return"historial";
    }



    @GetMapping("/reportesPage")
    public String reportes( Model model) {

        return"reportes";
    }



}
