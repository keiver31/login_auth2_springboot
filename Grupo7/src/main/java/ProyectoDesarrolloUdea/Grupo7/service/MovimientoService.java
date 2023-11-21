package ProyectoDesarrolloUdea.Grupo7.service;

import ProyectoDesarrolloUdea.Grupo7.entity.Movimiento;
import ProyectoDesarrolloUdea.Grupo7.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository movimientoRepository;

    public List<Movimiento> getMovimientos(){
        return movimientoRepository.findAll();
    }


    public Movimiento getMovimientoById(Long id){
        return movimientoRepository.findById(id).orElse(null);
    }

    public Movimiento saveMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> saveMovimientos(List<Movimiento> movimientos){
        return movimientoRepository.saveAll(movimientos);
    }

    public Movimiento updateMovimiento(Movimiento movimiento){
        Movimiento existingMovimiento = movimientoRepository.findById(movimiento.getId()).orElse(null);
        existingMovimiento.setEmpresa(movimiento.getEmpresa());
        existingMovimiento.setMonto(movimiento.getMonto());
        existingMovimiento.setTipo(movimiento.getTipo());
        existingMovimiento.setConcepto(movimiento.getConcepto());
        existingMovimiento.setResponsable(movimiento.getResponsable());
        return movimientoRepository.save(existingMovimiento);
    }


    public String deleteMovimiento(Long id){
        movimientoRepository.deleteById(id);
        return  "Has eliminado el movimiento con el ID: " + id;
    }
}