package br.com.ajrdevops.projeto.service;

import br.com.ajrdevops.projeto.dto.UsuarioDto;
import br.com.ajrdevops.projeto.model.Usuario;
import br.com.ajrdevops.projeto.repository.IUsuario;
import br.com.ajrdevops.projeto.security.Token;
import br.com.ajrdevops.projeto.security.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    private final IUsuario repository;
    private final PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario () {
        logger.info("User: " + getLogged() + " - listarUsuario");
        return repository.findAll();
    }

    public Usuario criarUsuario (Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        logger.info("User: " + getLogged() + " - criarUsuario");
        return repository.save(usuario);
    }

    public Usuario editarUsuario (Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        logger.info("User: " + getLogged() + " - editarUsuario: " + usuario.getNome());
        return repository.save(usuario);
    }

    public Boolean excluirUsuario (Integer id) {
        repository.deleteById(id);

        logger.info("User: " + getLogged() + " - excluirUsuario Id: " + id);
        return true;
    }

    public Token gerarToken(UsuarioDto usuario) {
        Usuario user = repository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());

        if(user != null) {
            boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha()) //valida usrs com senha criptografadas no banco
                    || usuario.getSenha().equals(user.getSenha()); //valida usrs sem senha criptografada no banco

            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }

        return null;
    }

    private String getLogged() {
        Authentication userLogged = SecurityContextHolder.getContext().getAuthentication();

        if (!(userLogged instanceof AnonymousAuthenticationToken)) {
            return userLogged.getName();
        }

        return "null";
    }
}
