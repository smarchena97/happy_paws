package co.edu.uniquindio.ingsoft3.HappyPaws.repository;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    @Query("SELECT c FROM Cita c " +
            "JOIN c.mascota m " +
            "JOIN m.usuario u " +
            "WHERE u.idUsuario = :idUsuario")
    List<Cita> obtenerCitasMascotasCliente(Long idUsuario);
    @Query("SELECT c FROM Cita c WHERE c.mascota.idMascota = :idMascota")
    List<Cita> obtenerCitasMascota(Long idMascota);

    @Query("SELECT c FROM Cita c WHERE c.fechaHoraInicio = :fechaHoraInicio AND c.mascota.idMascota = :idMascota")
    Optional<Cita> obtenerCitaHorarioMascota(LocalDateTime fechaHoraInicio,Long idMascota);

}
