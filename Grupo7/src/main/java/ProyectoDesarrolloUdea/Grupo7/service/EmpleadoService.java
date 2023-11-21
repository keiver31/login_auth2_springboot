package ProyectoDesarrolloUdea.Grupo7.service;


import ProyectoDesarrolloUdea.Grupo7.entity.Empleado;
import ProyectoDesarrolloUdea.Grupo7.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id){

        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado saveEmpleado(Empleado empleado){

        return empleadoRepository.save(empleado);
    }
    public List<Empleado> saveEmleados(List<Empleado> empleados){

        return empleadoRepository.saveAll(empleados);
    }

    public Empleado updateEmpleado(Empleado empleado){
        Empleado existingEmpleado = empleadoRepository.findById(empleado.getId()).orElse(null);
        existingEmpleado.setNombreEmpleado(empleado.getNombreEmpleado());
        existingEmpleado.setEmail(empleado.getEmail());
        existingEmpleado.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
        existingEmpleado.setRole(empleado.getRole());
        return empleadoRepository.save(existingEmpleado);
    }


    public String deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
        return "Has eliminado el empleado con el ID: " + id;
    }

}