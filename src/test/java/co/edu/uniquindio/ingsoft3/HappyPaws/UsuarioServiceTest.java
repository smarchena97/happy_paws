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
    public void login(){
        boolean estado = usuarioService.login("username","password");
        Assertions.assertTrue(estado);
    }
}
