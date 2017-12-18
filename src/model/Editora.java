package model;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Editora {
    private Long codigo;
    private String nome;
    private Date dataFundacao;

    private Editora(Builder builder) {
        codigo = builder.codigo;
        nome = builder.nome;
        dataFundacao = builder.dataFundacao;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    public Editora(Long codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }

    public static class Builder {
        private Long codigo;
        private String nome;
        private Date dataFundacao;

        public Builder comCodigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder fundadaEm(Date dataFundacao) {
            this.dataFundacao = dataFundacao;
            return this;
        }

        public Editora build() {
            return new Editora(this);
        }
    }

}
