package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;

import java.util.List;

public interface ServicioService {

    public List<Servicio> listarServicios();

    public Servicio guardarServicio(Servicio servicio);

    Servicio actualizarServicio(Servicio servicio, Long idServicio) throws Exception;

    void eliminarServicio(Long idServicio) throws Exception;
}
