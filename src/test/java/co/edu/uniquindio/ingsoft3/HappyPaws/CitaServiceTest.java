package co.edu.uniquindio.ingsoft3.HappyPaws;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Cita;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.CitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
public class CitaServiceTest {

    @Autowired
    private CitaService citaService;

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarCitaTest(){
        Usuario usuario = Usuario.builder().apellido("Lopez").email("lalo@email.com").nombre("Lalo").numeroDocumento("645798312").password("lalolo").tipoDocumento("cedula").username("lalolo").build();
        Mascota mascota = Mascota.builder().edad(4).especie("gato").nombre("michi").raza("none").usuario(usuario).build();
        Servicio servicio = Servicio.builder().descripcion("Servicio de emergencia").nombre("Suturacion").precio(40.00).build();
        try {
            Cita nueva = Cita.builder().fechaHoraInicio(LocalDateTime.of(2023, 5, 22, 14, 30)).servicio(servicio).mascota(mascota).build();
            Cita agendada = citaService.agendarCita(nueva);
            Assertions.assertNotNull(agendada);
            Assertions.assertEquals(LocalDateTime.of(2023, 5, 22, 14, 30),agendada.getFechaHoraInicio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cancelarCitaTest(){
        try {
            citaService.cancelarCita(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }try {
            citaService.obtenerCita(1L);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listaCitasTest(){
        List<Cita> citas = citaService.listarCitas();
        Assertions.assertEquals(3,citas.size());
    }
}
