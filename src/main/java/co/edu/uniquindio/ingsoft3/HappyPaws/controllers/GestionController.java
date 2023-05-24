package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gestion")
public class GestionController {

    @GetMapping("/")
    public String gestionVista(){
        return "gestion";
    }

    @GetMapping("/productos")
    public String gestionarProdcutos(){
        return "formProducto";
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
