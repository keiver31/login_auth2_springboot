package ProyectoDesarrolloUdea.Grupo7.controller;


import ProyectoDesarrolloUdea.Grupo7.entity.Empleado;
import ProyectoDesarrolloUdea.Grupo7.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EmpleadoController {


    @Autowired
    private EmpleadoService empleadoService;



    @GetMapping("/empleado/{id}")
    public Empleado findById(@PathVariable Long id){
        return empleadoService.getEmpleadoById(id);
    }


    @PostMapping("/addEmpleado")
    public RedirectView saveEmpleado(@ModelAttribute Empleado empleado, Model model){
        model.addAttribute(empleado);
        empleado.setRole("Operativo");
        empleadoService.saveEmpleado(empleado);
        return new RedirectView("/empleados");
    }

    @DeleteMapping("/empleado/{id}")
    public RedirectView deleteEmpleado(@PathVariable Long id){
        empleadoService.deleteEmpleado(id);
        return new RedirectView("/empleados");
    }

    @PostMapping("/empleado/update")
    public RedirectView updateEmpleado(@ModelAttribute Empleado empleado){
        empleado.setRole("Operativo");
        empleadoService.updateEmpleado(empleado);
        return new RedirectView("/empleados");
    }

}