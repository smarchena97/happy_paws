package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
}
