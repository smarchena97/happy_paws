package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gestion")
public class GestionController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/")
    public String gestionVista(){
        return "gestion";
    }

    /*@GetMapping("/productos")
    public String gestionarProdcutos(){
        return "gestionProductos";
    }*/

    @GetMapping("/productos")
    public String mostrarListaClientes(Model model){
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
    public String gestionarServicios(){
        return "formServicio";
    }

    @GetMapping("/citas")
        public String listarCitas(HttpSession session, Model model){
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        model.addAttribute("idUsuario",idUsuario);
        return "listarCitas";
    }
}
