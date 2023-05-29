package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.MascotaServiceImpl;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ProductoServiceImpl;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ServicioServiceImpl;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class vistasController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    private MascotaServiceImpl mascotaService;

    @Autowired
    private ServicioServiceImpl servicioService;

    @GetMapping("/")
    public String inicio(Model model){
        return "inicio";
    }

    @GetMapping("/listar")
    public String mostrarListaClientes(Model model){
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("usuarios", usuarioService.mostrarUsuarios());
        return "listarClientes";
    }

    @GetMapping("/listarMascotas")
    public String mostrarListaMascotas(Model model,HttpSession session) {

        Long idUsuario = (Long) session.getAttribute("idUsuario");

        model.addAttribute("titulo", "Lista de mascotas");
        model.addAttribute("mascotas", mascotaService.listarMascotasUsuario(idUsuario));
        return "listarMascotas";
    }
    @GetMapping("/login")
    public String mostrarLogin(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Login");
        return "login";
    }

    @GetMapping("/loginEmpleado")
    public String mostrarLoginEmpleado(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Login");
        return "loginEmpleado";
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
    @GetMapping("/gestion")
    public String gestionarServiciosProductos(){
        return "gestion";
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

   /* @PostMapping()
    public String logeo(@RequestParam("username") String username, @RequestParam("password") String password){
        Usuario usuario = usuarioService.buscarUsuarioPorUsername(username);
        if(usuario != null){
            if(usuario.getPassword().equals(password)){
                return "redirect:/listar";
            }
        }
        return "redirect:/";
    }*/
    @PostMapping()
    public String logeo(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        boolean estado = usuarioService.login(username,password);
        if (estado){
            Long idUsuario = usuarioService.buscarUsuarioPorUsername(username).getIdUsuario();
            session.setAttribute("idUsuario",idUsuario);
            return "redirect:/listarMascotas";
        }else{
            return "redirect:/";
        }
    }



    @GetMapping("/productos")
    public String mostrarListaProductos(Model model){
        model.addAttribute("titulo","Lista de productos");
        model.addAttribute("productos",productoService.listarProductos());
        return "listarProductos";
    }

    @GetMapping("/mascota")
    public String formMascota(Model model){
        Mascota mascota = new Mascota();
        model.addAttribute("titulo","Registro de mascota");
        model.addAttribute("mascota",mascota);
        return "formMascota";
    }
    @PostMapping("/mascota")
    public String guardarMascota(Mascota mascota,HttpSession session, Model model) throws Exception {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        mascotaService.guardarMascota(mascota,idUsuario);
        return "redirect:/listarMascotas";
    }

    @GetMapping("/servicios")
    public String listarServicios(Model model){
        model.addAttribute("titulo","Lista de servicios");
        model.addAttribute("servicios",servicioService.listarServicios());
        return "listarServicios";
    }

    @GetMapping("/crear_producto")
    public String mostrarFormProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("titulo","Crear Productos");
        model.addAttribute("producto", producto);
        return "formProducto";
    }

    @PostMapping("/productos")
    public String guardarProductos(Producto producto, Model model){
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/crear_servicio")
    public String mostrarFormServicio(Model model){
        Servicio servicio = new Servicio();
        model.addAttribute("titulo","Crear Servicio");
        model.addAttribute("servicio",servicio);
        return "formServicio";
    }

    @PostMapping("/servicios")
    public String guardarServicio(Servicio servicio){
        servicioService.guardarServicio(servicio);
        return "redirect:/servicios";
    }
    @GetMapping("/mascotas/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") Long id) throws Exception {
        mascotaService.eliminarMascota(id);
        return "redirect:/listarMascotas";  // Redirige a la página de gestión de productos
    }

    @GetMapping("/actualizar/{idMascota}")
    public String actualizarMascota( @PathVariable("idMascota") Long idMascota, Model model) throws Exception {
        Optional<Mascota> mascota = mascotaService.buscarMascotaPorId(idMascota);
        if (mascota.isPresent()){
            model.addAttribute("mascota",mascota.get());
            model.addAttribute("titulo","Actualizacion de mascota");
            return "formActualizacionMascota";
        }else{
            return "/listarMascotas";
        }
    }

    @PostMapping("/actualizar/{idMascota}")
    public String actualizarservicio(@PathVariable("idMascota") Long idMascota,Mascota mascota,HttpSession session) throws Exception {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        mascota.setIdMascota(idMascota);
        mascotaService.actualizarMascota(mascota,idUsuario);
        return "redirect:/listarMascotas";  // Redirige a la página de gestión de servicios
    }
}
