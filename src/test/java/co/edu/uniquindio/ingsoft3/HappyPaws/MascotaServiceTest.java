package co.edu.uniquindio.ingsoft3.HappyPaws;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.UsuarioRepository;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.MascotaService;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class MascotaServiceTest {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void guardarMascotaTest(){
        Optional<Usuario> usuario = usuarioRepository.findById(1L);
        Mascota mascota = Mascota.builder().usuario(usuario.get()).raza("Labrador").nombre("poo").especie("perro").edad(3).build();
        try {
            Usuario actualizado = mascotaService.guardarMascota(mascota,1L);
            Assertions.assertEquals(2,actualizado.getMascotas().size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMascotasTest(){
        List<Mascota> mascotas = mascotaService.listarMascotas();
        Assertions.assertEquals(4,mascotas.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarMascotasUsuarioTest(){
        List<Mascota> mascotas = mascotaService.listarMascotasUsuario(1L);
        Assertions.assertEquals(1,mascotas.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarMascotaPorIdTest(){
        Optional<Mascota> buscada = mascotaService.buscarMascotaPorId(1L);
        try {
            Assertions.assertTrue(buscada.isPresent());
        }catch (Exception  e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMascotaTest(){
        Optional<Mascota> mascota = mascotaService.buscarMascotaPorId(1L);
        Mascota actual = mascota.get();
        actual.setEdad(14);
        try {
            Mascota actualizada = mascotaService.actualizarMascota(actual,1L);
            Assertions.assertEquals(14,actualizada.getEdad());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMascotaTest(){
        try {
            mascotaService.eliminarMascota(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            Optional<Mascota> eliminado = mascotaService.buscarMascotaPorId(1L);
        } catch (Exception e){
            Assertions.assertTrue(true);
        }
    }
}
