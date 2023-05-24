package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Double precio;
    @Builder
    public Producto (String nombre,String descripcion, Double precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
    }
}
