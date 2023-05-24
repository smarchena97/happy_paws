package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario);

    public List<Usuario> mostrarUsuarios();

    public Usuario buscarUsuarioPorUsername(String username);

    boolean login(String username, String password);

}
