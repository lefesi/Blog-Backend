package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>{
/* consultas
 * vai ser publica retornar uma lista de postagem e 
 * o metodo no caso é o que ele faz que no caso é
 * find
 * ele vai buscar todod pelo titulo, que é o nome do atrbuto da entidade
 * contain é como o Like do MySQL e o ignore case não leva em consideração minusculo
 * e maiusculo*/
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);//containg funciona como um like do SQL
}
