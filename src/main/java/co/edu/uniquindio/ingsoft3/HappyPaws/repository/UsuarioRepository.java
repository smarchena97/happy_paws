package co.edu.uniquindio.ingsoft3.HappyPaws.repository;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
