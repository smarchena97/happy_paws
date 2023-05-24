package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    public Usuario guardarMascota(Mascota mascota,Long idUsuario) throws Exception;

    public List<Mascota> listarMascotas();

    List<Mascota> listarMascotasUsuario(Long idUsuario);

    public Optional<Mascota> buscarMascotaPorId(Long id);

    Mascota actualizarMascota(Mascota mascota, Long idMascota) throws Exception;
}
