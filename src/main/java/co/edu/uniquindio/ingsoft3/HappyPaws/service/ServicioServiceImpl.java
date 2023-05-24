package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio, Long idServicio) throws Exception {
        Optional<Servicio> guardado = servicioRepository.findById(idServicio);

        if(guardado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            return servicioRepository.save(servicio);
        }
    }

    @Override
    public void eliminarServicio(Long idServicio) throws Exception {
        Optional<Servicio> guardado = servicioRepository.findById(idServicio);

        if(guardado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            servicioRepository.delete(guardado.get());
        }
    }


}
