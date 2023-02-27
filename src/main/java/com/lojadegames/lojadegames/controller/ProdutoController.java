package com.lojadegames.lojadegames.controller;

import com.lojadegames.lojadegames.model.Produto;
import com.lojadegames.lojadegames.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/produtos")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class ProdutoController {

        @Autowired
        private ProdutoRepository postagemRepository;

        @GetMapping
        public ResponseEntity<List<Produto>> getAll(){
            return ResponseEntity.ok(postagemRepository.findAll());
        }
        @GetMapping("/{id}")
        public ResponseEntity<Produto> getById(@PathVariable Long id){
            return postagemRepository.findById(id)
                    .map(resp -> ResponseEntity.ok(resp))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

        @PostMapping
        public ResponseEntity<Produto> post(@Valid @RequestBody Produto postagem) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(postagemRepository.save(postagem));
        }

        @PutMapping
        public ResponseEntity<Produto> put(@Valid @RequestBody Produto postagem) {
            return postagemRepository.findById(postagem.getId())
                    .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                            .body(postagemRepository.save(postagem)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            Optional<Produto> postagem = postagemRepository.findById(id);

            if(postagem.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            postagemRepository.deleteById(id);
        }

    }

