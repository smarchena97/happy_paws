package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Long idCita;

    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;

    @OneToOne
    private Servicio servicio;

    @ManyToOne
    private Mascota mascota;

    @Builder
    public Cita(Servicio servicio,Mascota mascota,LocalDateTime fechaHoraInicio){
        this.servicio = servicio;
        this.mascota = mascota;
        this.fechaHoraInicio = fechaHoraInicio;
    }
}
