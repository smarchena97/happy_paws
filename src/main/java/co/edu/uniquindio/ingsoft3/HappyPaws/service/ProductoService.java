package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> listarProductos();

    public Producto buscarPorNombre(String nombre);

    public Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto, Long idProducto) throws Exception;

    void eliminarProducto(Long idProducto)throws Exception;
}
