package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class Volta {
    private LocalTime horaInicio;
    private Long numero;
    private Carro carro;
    private LocalTime tempo;
    private Double velocidadeMedia;

    public static LocalTime parseLocalTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }
    
    public Volta(String horaInicio, Long numero, Carro carro, String tempo,
            Double velocidadeMedia) {
        super();
        this.horaInicio = parseLocalTime(horaInicio);
        this.numero = numero;
        this.carro = carro;
        this.tempo = parseLocalTime("00:0" + tempo);
        this.velocidadeMedia = velocidadeMedia;
    }
    
    public Long getVoltaEmMilissegundos(){
        return tempo.toNanoOfDay();
    }
    
    public Integer getVoltaEmSegundos(){
        return tempo.toSecondOfDay();
    }
    
    @Override
    public String toString() {
        return numero + " " + horaInicio + " " + carro + " " + tempo + " " + velocidadeMedia;
    }

}
