package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Mascota;
import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.MascotaRepository;
import co.edu.uniquindio.ingsoft3.HappyPaws.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Usuario guardarMascota(Mascota mascota,Long idUsuario) throws Exception{
        Optional<Usuario> buscado =  usuarioRepository.findById(idUsuario);
        if (buscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            Usuario usuario = buscado.get();
            List<Mascota> mascotas = usuario.getMascotas();
            mascota.setUsuario(usuario);
            mascotas.add(mascota);
            usuario.setMascotas(mascotas);

            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public List<Mascota> listarMascotasUsuario(Long idUsuario) {
        return mascotaRepository.obtenerMascotasCliente(idUsuario);
    }

    @Override
    public Optional<Mascota> buscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota, Long idUsuario) throws Exception {
        Optional<Usuario> usuarioBuscado =  usuarioRepository.findById(idUsuario);
        if (usuarioBuscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            return mascotaRepository.save(mascota);
        }
    }
}
