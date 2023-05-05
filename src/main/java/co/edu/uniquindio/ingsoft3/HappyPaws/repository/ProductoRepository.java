package co.edu.uniquindio.ingsoft3.HappyPaws.repository;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    public Producto findByNombre(String nombre);
}
