package model;

import lombok.Data;

@Data
public class Piloto {
    private String nome;

    public Piloto(String nome) {
        super();
        this.nome = nome;
    }    
    
}
