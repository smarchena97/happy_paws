package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String username;

    private String tipoDocumento;

    private String numeroDocumento;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @Builder.Default
    private List<Mascota> mascotas = new ArrayList<>();
}
