package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Livro {
    private Long codigo;
    private String titulo;
    private String subTitulo;
    private String ISBN;
    private Long numeroPaginas;
    private Date dataPublicacao;
    private Editora editora;
    private List<Autor> autores;

    private Livro(Builder builder) {
        codigo = builder.codigo;
        titulo = builder.titulo;
        subTitulo = builder.subTitulo;
        ISBN = builder.ISBN;
        numeroPaginas = builder.numeroPaginas;
        dataPublicacao = builder.dataPublicacao;
        editora = builder.editora;
        autores = builder.autores;
    }

    public Integer getAnoPublicacao(){
        return LocalDate.ofEpochDay(dataPublicacao.getTime()).getYear();
    }
    
    public Integer getQuantidadeAutores(){
        return autores.size();
    }
    
    @Override
    public String toString() {
        return "[" + codigo + "] " + titulo + ": " + subTitulo;
    }
    
    public static class Builder {
        private Long codigo;
        private String titulo;
        private String subTitulo;
        private String ISBN;
        private Long numeroPaginas;
        private Date dataPublicacao;
        private Editora editora;
        private List<Autor> autores;

        public Builder comCodigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder comTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder comSubTitulo(String subTitulo) {
            this.subTitulo = subTitulo;
            return this;
        }
        
        public Builder comISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Builder comNumeroPaginas(Long numeroPaginas) {
            this.numeroPaginas = numeroPaginas;
            return this;
        }

        public Builder publicadoEm(Date dataPublicacao) {
            this.dataPublicacao = dataPublicacao;
            return this;
        }

        public Builder escritoPor(List<Autor> autores) {
            this.autores = autores;
            return this;
        }

        public Builder publicadoPor(Editora editora) {
            this.editora = editora;
            return this;
        }

        public Livro build() {
            return new Livro(this);
        }        
    }

}
