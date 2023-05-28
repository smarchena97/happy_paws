package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Positive
    private Double precio;
    @Builder
    public Producto (String nombre,String descripcion, Double precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
    }
}
