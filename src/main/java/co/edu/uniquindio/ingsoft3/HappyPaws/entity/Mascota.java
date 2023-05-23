package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "mascotas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    @EqualsAndHashCode.Include
    private Long idMascota;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String raza;

    @PositiveOrZero
    private int edad;

    @Column(length = 100)
    private String especie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "mascota")
    @ToString.Exclude
    private List<Cita> citas;

    @Builder
    public Mascota(String nombre, int edad, String especie, String raza,Usuario usuario){
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.usuario = usuario;
    }
}
