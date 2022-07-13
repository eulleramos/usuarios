package br.senai.service;

import br.senai.model.Usuario;
import br.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario update(Usuario usuario, long id) {
        Optional<Usuario> u = usuarioRepository.findById(id);
        if (!u.isEmpty()) {
            Usuario usuarioUpadate = u.get();
            usuarioUpadate.setNome(usuario.getNome());
            usuarioUpadate.setUsarname(usuarioUpadate.getUsername());
            usuarioUpadate.setSenha(usuario.getSenha());
           return usuarioRepository.save(usuarioUpadate);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
}
