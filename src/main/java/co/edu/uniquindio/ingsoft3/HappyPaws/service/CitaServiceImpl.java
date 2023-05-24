package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.CitaRepository;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.MascotaRepository;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService{

    @Autowired
    CitaRepository citaRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public Cita agendarCita(Cita cita) throws Exception {
        Optional<Cita> ocupado = citaRepository.obtenerCitaHorarioMascota(cita.getFechaHoraInicio(),cita.getMascota().getIdMascota());
        if (ocupado.isEmpty()){
            return citaRepository.save(cita);
        }else{
            throw new Exception("La mascota ya tiene una cita asignada en este horario");
        }
    }

    @Override
    public void cancelarCita(Long idCita) throws Exception {
        Optional<Cita> buscada = citaRepository.findById(idCita);
        if (buscada.isEmpty()){
            throw new Exception("La cita no existe");
        }else{
            citaRepository.delete(buscada.get());
        }
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita obtenerCita(Long idCita) throws Exception{
        Optional<Cita> buscada = citaRepository.findById(idCita);
        if (buscada.isEmpty()){
            throw new Exception("La cita no existe");
        }else{
            return buscada.get();
        }
    }

    @Override
    public List<Cita> obtenerCitasUsuario(Long idUsuario) throws Exception {
        List<Cita> citasUsuario = citaRepository.obtenerCitasMascotasCliente(idUsuario);
        return citasUsuario;
    }

    @Override
    public List<Cita> obtenerCitasMascota(Long idMascota) throws Exception {
        List<Cita> citasMascota = citaRepository.obtenerCitasMascota(idMascota);
        return citasMascota;
    }
}
