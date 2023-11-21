package ProyectoDesarrolloUdea.Grupo7.repository;


import ProyectoDesarrolloUdea.Grupo7.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
