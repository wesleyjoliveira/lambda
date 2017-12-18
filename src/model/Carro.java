package model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Carro {
    private String numero;
    private Piloto piloto;

    public Carro(String numero, Piloto piloto) {
        super();
        this.numero = numero;
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return numero + " - " + piloto.getNome();
    }

}
