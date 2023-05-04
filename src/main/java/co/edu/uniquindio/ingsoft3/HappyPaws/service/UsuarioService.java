package co.edu.uniquindio.ingsoft3.HappyPaws.service;

import co.edu.uniquindio.ingsoft3.HappyPaws.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario);

    public List<Usuario> mostrarUsuarios();

    public Usuario buscarUsuarioPorUsername(String username);
}
