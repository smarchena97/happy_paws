package co.edu.uniquindio.ingsoft3.HappyPaws.repository;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username = :username and u.password= :password")
    Optional<Usuario> comprobarAutenticacion(String username, String password);
}
