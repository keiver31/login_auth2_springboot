package ProyectoDesarrolloUdea.Grupo7.controller;


import ProyectoDesarrolloUdea.Grupo7.entity.Empresa;
import ProyectoDesarrolloUdea.Grupo7.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class EmpresaController {


    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresa/{id}")
    public Empresa findById(@PathVariable Long id){
        return empresaService.getEmpresaById(id);
    }

    @PostMapping("/addEmpresa")
    public RedirectView saveEmpresa(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        empresaService.saveEmpresa(empresa);
        return new RedirectView("/empresas");
    }


    @DeleteMapping("/empresa/{id}")
    public RedirectView deleteEmpresa(@PathVariable Long id){
        empresaService.deleteEmpresa(id);
        return new RedirectView("/empresas");
    }

    @PostMapping("/empresa/update")
    public RedirectView updateEmpresa(@ModelAttribute Empresa empresa){
        empresaService.updateEmpresa(empresa);
        return new RedirectView("/empresas");
    }
}
