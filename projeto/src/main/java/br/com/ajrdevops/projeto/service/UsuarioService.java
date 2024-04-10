package br.com.ajrdevops.projeto.service;

import br.com.ajrdevops.projeto.model.Usuario;
import br.com.ajrdevops.projeto.repository.IUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuario () {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario (Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario editarUsuario (Usuario usuario) {
        return repository.save(usuario);
    }

    public Boolean excluirUsuario (Integer id) {
        repository.deleteById(id);
        return true;
    }
}
