package ProyectoDesarrolloUdea.Grupo7.service;

import ProyectoDesarrolloUdea.Grupo7.entity.Empresa;
import ProyectoDesarrolloUdea.Grupo7.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long id){

        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa saveEmpresa(Empresa empresa){

        return empresaRepository.save(empresa);
    }
    public List<Empresa> saveEmpresas(List<Empresa> empresas){

        return empresaRepository.saveAll(empresas);
    }

    public Empresa updateEmpresa(Empresa empresa){
        Empresa existingEmpresa = empresaRepository.findById(empresa.getId()).orElse(null);
        existingEmpresa.setNombre(empresa.getNombre());
        existingEmpresa.setDireccion(empresa.getDireccion());
        existingEmpresa.setTelefono(empresa.getTelefono());
        existingEmpresa.setNit(empresa.getNit());
        return empresaRepository.save(existingEmpresa);
    }


    public String deleteEmpresa(Long id){
        empresaRepository.deleteById(id);
        return "Has eliminado la empresa con el ID: " + id;
    }




}
