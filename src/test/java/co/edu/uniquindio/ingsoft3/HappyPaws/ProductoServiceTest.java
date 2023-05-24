package co.edu.uniquindio.ingsoft3.HappyPaws;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.service.ProductoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosTest(){
        List<Producto> productos = productoService.listarProductos();
        Assertions.assertEquals(3,productos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPorNombreTest(){
        Producto buscado = productoService.buscarPorNombre("Arena para gatos");
        Assertions.assertEquals(9.99,buscado.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void guardarProductoTest(){
        Producto nuevo = Producto.builder().nombre("Antipulgas para gatos").descripcion("Tratamiento efectivo para eliminar pulgas en gatos").precio(12.99).build();
        Producto guardado = productoService.guardarProducto(nuevo);
        Assertions.assertEquals(12.99,guardado.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest(){
        try {
            Producto actual = productoService.obtenerProducto(1L);
            actual.setPrecio(40.00);
            Producto actualizado = productoService.actualizarProducto(actual,1L);
            Assertions.assertEquals(40.00,actualizado.getPrecio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest(){
        try {
            productoService.eliminarProducto(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Producto actual = productoService.obtenerProducto(1L);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }
}
