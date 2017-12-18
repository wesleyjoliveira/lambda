package model;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Autor {
    private String nome;
    private Date dataNascimento;
    private Profissao profissao;
    private Empresa empresa;

    private Autor(Builder builder) {
        nome = builder.nome;
        dataNascimento = builder.dataNascimento;
        profissao = builder.profissao;
        empresa = builder.empresa;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public Integer getQuantidade(){
        return 1;
    }

    public static class Builder {
        private String nome;
        private Date dataNascimento;
        private Profissao profissao;
        private Empresa empresa;

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder nascidoEm(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder trabalhaComo(Profissao profissao) {
            this.profissao = profissao;
            return this;
        }

        public Builder trabalhaEm(Empresa empresa) {
            this.empresa = empresa;
            return this;
        }

        public Autor build() {
            return new Autor(this);
        }
    }

}
