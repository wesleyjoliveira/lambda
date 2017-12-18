package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Empresa {
    private Long codigo;
    private String nome;

    private Empresa(Builder builder) {
        codigo = builder.codigo;
        nome = builder.nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public Empresa(Long codigo, String nome){
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

        public Empresa build() {
            return new Empresa(this);
        }
    }
    
    
}
