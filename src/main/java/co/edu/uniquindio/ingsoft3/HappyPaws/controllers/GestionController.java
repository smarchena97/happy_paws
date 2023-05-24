package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.CitaService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ProductoService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.PanelUI;
import java.util.List;

@Controller
@RequestMapping("/gestion")
public class GestionController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ServicioService servicioService;

    @Autowired
    CitaService citaService;

    @GetMapping("/")
    public String gestionVista(){
        return "gestion";
    }

    @GetMapping("/logout")
    public String logout(){return "redirect:/";}

    @GetMapping("/productos")
    public String mostrarListaProductos(Model model){
        model.addAttribute("titulo", "Lista de productos");
        model.addAttribute("productos", productoService.listarProductos());
        return "gestionProductos";
    }

    @GetMapping("/productos/nuevo")
    public String verFormProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto",producto);
        model.addAttribute("titulo","Registro de productos");
        return "formProducto";
    }

    @PostMapping("/productos/nuevo")
    public String agregarNuevoProducto(Producto producto){
        productoService.guardarProducto(producto);
        return "redirect:/gestion/productos";
    }

    @GetMapping("productos/actualizar/{id}")
    public String verFormActualizacionProducto(@PathVariable("id") Long id, Model model) throws Exception {
        Producto producto = productoService.obtenerProducto(id);
        model.addAttribute("producto",producto);
        model.addAttribute("titulo","Actualizacion de productos");
        return "formActualizacionProducto";  // Redirige a la página de gestión de productos
    }


    @PostMapping("productos/actualizar/{id}")
    public String actualizarProducto(@PathVariable("id") Long id,Producto producto) throws Exception {
        productoService.actualizarProducto(producto,id);
        return "redirect:/gestion/productos";  // Redirige a la página de gestión de productos
    }

    @GetMapping("productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) throws Exception {
        productoService.eliminarProducto(id);
        return "redirect:/gestion/productos";  // Redirige a la página de gestión de productos
    }

    @GetMapping("/servicios")
    public String mostrarListaServicios(Model model){
        model.addAttribute("titulo", "Lista de servicios");
        model.addAttribute("servicios", servicioService.listarServicios());
        return "gestionServicios";
    }

    @GetMapping("/servicios/nuevo")
    public String verFormServicio(Model model){
        Servicio servicio = new Servicio();
        model.addAttribute("servicio",servicio);
        model.addAttribute("titulo","Registro de servicios");
        return "formServicio";
    }

    @PostMapping("/servicios/nuevo")
    public String agregarNuevoServicio(Servicio servicio){
        servicioService.guardarServicio(servicio);
        return "redirect:/gestion/servicios";
    }

    @GetMapping("servicios/actualizar/{id}")
    public String verFormActualizacionServicio(@PathVariable("id") Long id, Model model) throws Exception {
        Servicio servicio = servicioService.obtenerServicioPorId(id);
        model.addAttribute("servicio",servicio);
        model.addAttribute("titulo","Actualizacion de servicios");
        return "formActualizacionServicio";
    }


    @PostMapping("servicios/actualizar/{id}")
    public String actualizarservicio(@PathVariable("id") Long id,Servicio servicio) throws Exception {
        servicioService.actualizarServicio(servicio,id);
        return "redirect:/gestion/servicios";  // Redirige a la página de gestión de servicios
    }

    @GetMapping("servicios/eliminar/{id}")
    public String eliminarServicio(@PathVariable("id") Long id) throws Exception {
        servicioService.eliminarServicio(id);
        return "redirect:/gestion/servicios";  // Redirige a la página de gestión de productos
    }

    @GetMapping("/citas")
        public String listarCitas(Model model){
        List<Cita> citas = citaService.listarCitas();
        model.addAttribute("titulo","Historico de citas");
        model.addAttribute("citas",citas);
        return "listarCitas";
    }
}
