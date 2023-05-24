package co.edu.uniquindio.ingsoft3.HappyPaws;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServiceTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Sql("classpath:dataset.sql")
    public void guardarUsuarioTest(){
        Usuario usuario = Usuario.builder().apellido("Lopez").email("lalo@email.com").nombre("Lalo").numeroDocumento("645798312").password("lalolo").tipoDocumento("cedula").username("lalolo").build();
        Usuario guardado = usuarioService.guardarUsuario(usuario);

        Assertions.assertTrue(passwordEncoder.matches("lalolo",guardado.getPassword()));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void mostrarUsuariosTest(){
        List<Usuario> usuarios = usuarioService.mostrarUsuarios();
        Assertions.assertEquals(6,usuarios.size());
        System.out.println(usuarios);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarUsuarioPorUsernameTest(){
        Usuario buscado = usuarioService.buscarUsuarioPorUsername("joserodriguez");
        Assertions.assertEquals("Rodriguez",buscado.getApellido());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        boolean estado = usuarioService.login("username","password");
        Assertions.assertTrue(estado);
    }
}
