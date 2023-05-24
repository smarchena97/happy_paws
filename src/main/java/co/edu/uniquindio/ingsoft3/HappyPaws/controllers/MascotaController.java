package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaServiceImpl mascotaService;

    @GetMapping("/listar")
    public List<Mascota> listarMascotas(){
        List<Mascota> mascotas = mascotaService.listarMascotas();
        return mascotas;
    }

    @GetMapping("/listar/{id}")
    public Mascota buscarMascota(@PathVariable("id") Long id){
        return mascotaService.buscarMascotaPorId(id).get();
    }

    /*
    @PutMapping("/listar/{id}")
    public Mascota actualizarMascota(@RequestBody Mascota mascotaActualizada, @PathVariable("id") Long id){
        Mascota mascotaDes = mascotaService.buscarMascotaPorId(id).get();
        mascotaDes.setEdad(mascotaActualizada.getEdad());
        mascotaDes.setRaza(mascotaActualizada.getRaza());
        mascotaDes.setEspecie(mascotaActualizada.getEspecie());
        mascotaDes.setNombre(mascotaActualizada.getNombre());
        return mascotaService.guardarMascota(mascotaDes);
    }

    @PostMapping("/")
    public String guardarMascota(@RequestBody Mascota mascota){
        Mascota m = mascotaService.guardarMascota(mascota);
        return "Mascota guardada";
    }
     */


    @PutMapping("/listar/{id}")
    public Mascota actualizarMascota(@RequestBody Mascota mascotaActualizada, @PathVariable("id") Long id) throws Exception {
        Long idUsuario = mascotaService.buscarMascotaPorId(id).get().getUsuario().getIdUsuario();
        return mascotaService.actualizarMascota(mascotaActualizada,idUsuario);
    }
    @PostMapping("/")
    public String guardarMascota(@RequestBody Mascota mascota,@RequestBody Long idCliente) throws Exception {
        mascotaService.guardarMascota(mascota,idCliente);
        return "Mascota guardada";
    }

    @DeleteMapping("/eliminar/{idMascota}")
    public String eliminarMascota(@PathVariable("idMascota")Long idMascota){
        return "redirect:/listar";  //ESTO TOCA HACERLO SOLO PUSE EL RETURN PARA QUE NO DE ERROR
    }
}
