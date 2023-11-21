package ProyectoDesarrolloUdea.Grupo7.repository;


import ProyectoDesarrolloUdea.Grupo7.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
