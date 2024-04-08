package br.com.ajrdevops.projeto.DAO;

import br.com.ajrdevops.projeto.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

}
