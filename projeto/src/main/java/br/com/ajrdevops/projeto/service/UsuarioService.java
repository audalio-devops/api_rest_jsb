package br.com.ajrdevops.projeto.service;

import br.com.ajrdevops.projeto.dto.UsuarioDto;
import br.com.ajrdevops.projeto.model.Usuario;
import br.com.ajrdevops.projeto.repository.IUsuario;
import br.com.ajrdevops.projeto.security.Token;
import br.com.ajrdevops.projeto.security.TokenUtil;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario () {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario (Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        return repository.save(usuario);
    }

    public Usuario editarUsuario (Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        return repository.save(usuario);
    }

    public Boolean excluirUsuario (Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return  valid;
    }

    public Token gerarToken(UsuarioDto usuario) {
        Usuario user = repository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());

        if(user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha()) //valida usrs com senha criptografadas no banco
                    || usuario.getSenha().equals(user.getSenha()); //valida usrs sem senha criptografada no banco

            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }

        return null;
    }
}
