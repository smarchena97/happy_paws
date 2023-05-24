package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto, Long idProducto) throws Exception{
        Optional<Producto> guardado = productoRepository.findById(idProducto);

        if (guardado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            return productoRepository.save(producto);
        }
    }

    @Override
    public void eliminarProducto(Long idProducto) throws Exception{
        Optional<Producto> guardado = productoRepository.findById(idProducto);

        if (guardado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            productoRepository.delete(guardado.get());
        }
    }

    @Override
    public Producto obtenerProducto(Long idProducto) throws Exception {
        Optional<Producto> buscado = productoRepository.findById(idProducto);
        if (buscado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            return buscado.get();
        }
    }
}
