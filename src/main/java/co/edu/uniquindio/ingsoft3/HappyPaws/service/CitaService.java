package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {

    Cita agendarCita(Cita cita) throws Exception;

    void cancelarCita(Long idCita) throws Exception;

    List<Cita> listarCitas();

   Cita obtenerCita(Long idCita) throws Exception;

   List<Cita> obtenerCitasUsuario(Long idUsuario)throws Exception;

   List<Cita> obtenerCitasMascota(Long idMascota) throws Exception;
}
