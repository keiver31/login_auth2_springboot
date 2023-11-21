package ProyectoDesarrolloUdea.Grupo7.controller;

import ProyectoDesarrolloUdea.Grupo7.entity.Empresa;
import ProyectoDesarrolloUdea.Grupo7.entity.Movimiento;
import ProyectoDesarrolloUdea.Grupo7.entity.Empleado;
import ProyectoDesarrolloUdea.Grupo7.service.EmpresaService;
import ProyectoDesarrolloUdea.Grupo7.service.MovimientoService;
import ProyectoDesarrolloUdea.Grupo7.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class FrontController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null){
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }

                       @GetMapping("/empresas")
    public String empresa(Model model){
        List<Empresa> empresas = empresaService.getEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresa";
    }

    @GetMapping("/empresas/newEmpresa")
    public String newEmpresa(Model model){
        model.addAttribute("empresas", new Empresa());
        return "newEmpresa";
    }

    @GetMapping("/empresa/edit/{id}")
    public String editEmpresa(@PathVariable long id, Model model){
        Empresa empresa = empresaService.getEmpresaById(id);
        if (empresa != null){
            model.addAttribute("empresa", empresa);
            return "editEmpresa";
        } else {
            return "redirect:/empresas";
        }
    }

    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public String movimiento(Model model){
        List<Movimiento> movimientos = movimientoService.getMovimientos();
        model.addAttribute("movimientos", movimientos);
        return "movimiento";
    }

    @GetMapping("/movimientos/newMovimiento")
    public String newMovimiento(Model model){
        model.addAttribute("movimientos", new Movimiento());
        return "newMovimiento";
    }

    @GetMapping("/movimiento/edit/{id}")
    public String editMovimiento(@PathVariable long id, Model model){
        Movimiento movimiento = movimientoService.getMovimientoById(id);
        if (movimiento != null){
            model.addAttribute("movimiento", movimiento);
            return "editMovimiento";
        } else {
            return "redirect:/movimientos";
        }
    }


    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public String Empleado(Model model){
        List<Empleado> empleados = empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleado";
    }

    @GetMapping("/empleados/newEmpleado")
    public String newEmpleado(Model model){
        model.addAttribute("empleados", new Empleado());
        return "newEmpleado";
    }

    @GetMapping("/empleado/edit/{id}")
    public String editEmpleado(@PathVariable long id, Model model){
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null){
            model.addAttribute("empleado", empleado);
            return "editEmpleado";
        } else {
            return "redirect:/empleados";
        }
    }

}
