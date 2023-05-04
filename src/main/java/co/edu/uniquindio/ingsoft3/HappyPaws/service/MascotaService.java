package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    public Mascota guardarMascota(Mascota mascota);

    public List<Mascota> listarMascotas();

    public Optional<Mascota> buscarMascotaPorId(Long id);
}
