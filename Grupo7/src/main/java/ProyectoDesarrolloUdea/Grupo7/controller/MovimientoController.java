package ProyectoDesarrolloUdea.Grupo7.controller;


import ProyectoDesarrolloUdea.Grupo7.entity.Movimiento;
import ProyectoDesarrolloUdea.Grupo7.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class MovimientoController {


    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/movimiento/{id}")
    public Movimiento findById(@PathVariable Long id){
        return movimientoService.getMovimientoById(id);
    }

    @PostMapping("/addMovimiento")
    public RedirectView saveMovimiento(@ModelAttribute Movimiento movimiento, Model model){
        model.addAttribute(movimiento);
        movimientoService.saveMovimiento(movimiento);
        return new RedirectView("/movimientos");
    }


    @DeleteMapping("/movimiento/{id}")
    public RedirectView deleteMovimiento(@PathVariable Long id){
        movimientoService.deleteMovimiento(id);
        return new RedirectView("/movimientos");
    }

    @PostMapping("/movimiento/update")
    public RedirectView updateMovimiento(@ModelAttribute Movimiento movimiento){
        movimientoService.updateMovimiento(movimiento);
        return new RedirectView("/movimientos");
    }

}
