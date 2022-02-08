package org.generation.blogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas") // esse que nós usamos para procuramos no postmam
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long idtema) {
		return repository.findById(idtema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomeTema/{nomeTema}")
	public ResponseEntity<List<Tema>> GetByName(@PathVariable String nomeTema) {
		return ResponseEntity.ok(repository.findAllByNomeTemaContainingIgnoreCase(nomeTema));

	}

	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	/*
	 * @PutMapping public ResponseEntity<Tema> put (@RequestBody Tema tema){ return
	 * ResponseEntity.ok(repository.save(tema));
	 */

	/*
	 * @DeleteMapping("/{idTema}") public void deletePostagem(@PathVariable long
	 * idTema) { repository.deleteById(idTema);
	 */

	
	@PutMapping
    public ResponseEntity<Tema> putTema(@Valid @RequestBody Tema tema) {
        return repository.findById(tema.getIdTema())
            .map(resp -> ResponseEntity.status(HttpStatus.OK).body(repository.save(tema)))
            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }


	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTema(@PathVariable long idtema) {
		return repository.findById(idtema)
          .map(resposta -> { repository.deleteById(idtema);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

}
		
