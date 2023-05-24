package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.repository.UsuarioRepository;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginEmpleado")
public class LoginEmpleadoController {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/")
    public String loginEmpleadoForm(){
        return "loginEmpleado";
    }

    @PostMapping()
    public String logeoEmpleado(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        boolean estado = usuarioService.login(username,password);
        if (estado){
            Long idUsuario = usuarioService.buscarUsuarioPorUsername(username).getIdUsuario();
            session.setAttribute("idUsuario",idUsuario);
            return "redirect:/gestion";
        }else{
            return "redirect:/";
        }
    }

}
