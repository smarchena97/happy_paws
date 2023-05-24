package co.edu.uniquindio.ingsoft3.HappyPaws;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Servicio;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ServicioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ServicioServiceTest {

    @Autowired
    private ServicioService servicioService;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarServiciosTest(){
        List<Servicio> servicios = servicioService.listarServicios();
        Assertions.assertEquals(3,servicios.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void guardarServicioTest(){
        Servicio servicio = Servicio.builder().descripcion("Servicio de emergencia").nombre("Suturacion").precio(40.00).build();
        Servicio guardado = servicioService.guardarServicio(servicio);
        Assertions.assertEquals(40.00,guardado.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarServicioTest(){
        try {
            Servicio buscado = servicioService.obtenerServicioPorId(1L);
            buscado.setNombre("Vacunación para cachorros");
            Servicio actualizado = servicioService.actualizarServicio(buscado,1L);
            Assertions.assertEquals("Vacunación para cachorros",actualizado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarServicioTest(){
        try {
            servicioService.eliminarServicio(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Servicio buscado = servicioService.obtenerServicioPorId(1L);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
