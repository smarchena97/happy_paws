package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ProductoServiceImpl;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class vistasController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/listar")
    public String mostrarListaClientes(Model model){
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("usuarios", usuarioService.mostrarUsuarios());
        return "listarClientes";
    }

    @GetMapping()
    public String mostrarLogin(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Login");
        return "login";
    }

    /*
     * Este metodo muestra el formulario de registro de usuario
     *
     * */
    @GetMapping("/register")
    public String mostrarFormRegistro(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Registro");
        return "formUsuario";
    }

    /*
    * Este metodo guarda el usuario creado en la vista y redirige a la pagina de login
    *
    * */
    @PostMapping("/form")
    public String guardarUsuario(Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/";
    }

    @PostMapping()
    public String logeo(@RequestParam("username") String username, @RequestParam("password") String password){
        Usuario usuario = usuarioService.buscarUsuarioPorUsername(username);
        if(usuario != null){
            if(usuario.getPassword().equals(password)){
                return "redirect:/listar";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/productos")
    public String mostrarListaProductos(Model model){
        model.addAttribute("titulo","Lista de productos");
        model.addAttribute("productos",productoService.listarProductos());
        return "listarProductos";
    }
}
