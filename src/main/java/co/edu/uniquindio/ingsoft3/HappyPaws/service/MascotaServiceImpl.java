package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }
}
