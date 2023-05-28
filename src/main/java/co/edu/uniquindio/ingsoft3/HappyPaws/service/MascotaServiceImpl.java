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
            if(mascotas.contains(mascota)){
                throw new Exception("El cliente ya tiene esta mascota registrada");
            }else{
                mascota.setUsuario(usuario);
                mascotas.add(mascota);
                usuario.setMascotas(mascotas);
            }
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
            Usuario usuario = usuarioBuscado.get();
            List<Mascota> mascotas = usuario.getMascotas();
            if(mascotas.contains(mascota)){
                int index = mascotas.indexOf(mascota);
                mascotas.set(index,mascota);
                usuario.setMascotas(mascotas);
                usuarioRepository.save(usuario);
                return mascotaRepository.findById(mascota.getIdMascota()).get();
            }else{
                throw new Exception("El cliente no tiene esta mascota registrada");

            }
        }
    }

    @Override
    public void eliminarMascota(Long idMascota) throws Exception {
        Optional<Mascota> buscada = mascotaRepository.findById(idMascota);

        if (buscada.isEmpty()){
            throw new Exception("La mascota no existe");
        }else{
            mascotaRepository.delete(buscada.get());
        }
    }
}
