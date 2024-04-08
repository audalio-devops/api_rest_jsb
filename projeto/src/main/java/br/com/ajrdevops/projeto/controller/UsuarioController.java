package br.com.ajrdevops.projeto.controller;

import br.com.ajrdevops.projeto.DAO.IUsuario;
import br.com.ajrdevops.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuario dao;
    @GetMapping
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return dao.save(usuario);
    }
    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        return dao.save(usuario);
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> excluirUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
    }
}
