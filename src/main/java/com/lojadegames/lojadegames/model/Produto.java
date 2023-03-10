package com.lojadegames.lojadegames.model;



import java.time.LocalDateTime;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

    @Entity
    @Table(name = "tb_produtos")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O atributo título é Obrigatório!")
        @Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
        private String titulo;

        @NotBlank(message = "O atributo texto é Obrigatório!")
        @Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
        private String texto;

        @UpdateTimestamp
        private LocalDateTime data;

        /*Insira os Getters and Setters*/

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getTexto() {
            return this.texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public LocalDateTime getData() {
            return this.data;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

    }

