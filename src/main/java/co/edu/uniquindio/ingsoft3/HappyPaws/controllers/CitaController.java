package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.CitaService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.MascotaService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    ServicioService servicioService;

    @Autowired
    CitaService citaService;

    @Autowired
    MascotaService mascotaService;
    /*
    @GetMapping("/mascota/{idMascota}/servicio")
    public String verListadeServicios(Model model,@PathVariable("idMascota") Long idMascota){
        List<Servicio> servicios = servicioService.listarServicios();
        Optional<Mascota> mascota = mascotaService.buscarMascotaPorId(idMascota);
        model.addAttribute("titulo","Seleccion de servicio");
        model.addAttribute("servicios",servicios);
        model.addAttribute("mascota",mascota);
        return "seleccionServicios";
    }

    @PostMapping("/mascota/{idMascota}/servicio/{idServicio}")
    public String registrarCita(@PathVariable("idMascota") Long idMascota,@PathVariable("idServicio") Long idServicio, LocalDateTime fechaHoraInicio) throws Exception {
        Optional<Mascota> mascota = mascotaService.buscarMascotaPorId(idMascota);
        Servicio servicio = servicioService.obtenerServicioPorId(idServicio);
        if (mascota.isPresent()&&servicio!=null){
            Cita cita = Cita.builder().mascota(mascota.get()).servicio(servicio).fechaHoraInicio(fechaHoraInicio).build();
            citaService.agendarCita(cita);
        }
        return "redirect:/listarMascotas";
    }*/

}
