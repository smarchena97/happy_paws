package co.edu.uniquindio.ingsoft3.HappyPaws.repository;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findById(Long idMascota);

    @Query("SELECT m FROM Mascota m WHERE m.usuario.idUsuario = :idUsuario")
    List<Mascota> obtenerMascotasCliente(Long idUsuario);

}
