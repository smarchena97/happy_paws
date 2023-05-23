package co.edu.uniquindio.ingsoft3.HappyPaws.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Email
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,length = 100,unique = true)
    private String username;

    @Column(nullable = false)
    private String tipoDocumento;

    @Column(nullable = false,length = 100,unique = true)
    private String numeroDocumento;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    private List<Mascota> mascotas = new ArrayList<>();


}
