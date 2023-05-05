package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;

import java.util.List;

public interface ServicioService {

    public List<Servicio> listarServicios();

    public Servicio guardarServicio(Servicio servicio);
}
