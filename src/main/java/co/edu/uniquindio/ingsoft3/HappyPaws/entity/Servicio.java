package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Table(name = "servicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Positive
    private Double precio;

    @OneToOne(mappedBy = "servicio")
    @ToString.Exclude
    private Cita cita;

    @Builder
    public Servicio(String nombre, String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
