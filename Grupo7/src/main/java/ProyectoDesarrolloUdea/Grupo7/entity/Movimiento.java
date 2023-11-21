package ProyectoDesarrolloUdea.Grupo7.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String empresa;
    @Column
    private Double monto;
    @Column
    private String tipo;
    @Column
    private String concepto;
    @Column
    private String responsable;


    //Getters


    public String getEmpresa() {
        return empresa;
    }

    public Long getId() {
        return id;
    }

    public Double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getResponsable() {
        return responsable;
    }


    //Setters


    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
