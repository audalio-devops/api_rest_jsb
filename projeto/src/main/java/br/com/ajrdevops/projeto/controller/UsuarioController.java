package br.com.ajrdevops.projeto.controller;

import br.com.ajrdevops.projeto.DAO.IUsuario;
import br.com.ajrdevops.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> lista = (List<Usuario>) dao.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(dao.save(usuario));
    }
    @PutMapping
    public ResponseEntity<Usuario>  editarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(dao.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
