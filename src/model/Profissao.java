package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Profissao {
    private Long codigo;
    private String nome;

    private Profissao(Builder builder) {
        codigo = builder.codigo;
        nome = builder.nome;
    }
    
    public Profissao(Long codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public static class Builder {
        private Long codigo;
        private String nome;

        public Builder comCodigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Profissao build() {
            return new Profissao(this);
        }
    }
}
