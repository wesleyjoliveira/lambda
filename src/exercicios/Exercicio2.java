package exercicios;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Carro;
import model.Volta;
import dados.CorridaDAO;

public class Exercicio2 {
    
    public static void main(String[] args) {
        List<Volta> voltas = CorridaDAO.getVoltas();
        
//        A partir de um input de um arquivo de log do formato acima
//        Montar o resultado da corrida com as seguintes informações
//        A corrida termina quando o primeiro colocado completa 4 voltas - NAO IMPLEMENTADO

//        Descobrir a melhor volta de cada piloto
        Map<Carro, Optional<Volta>> voltasPorPiloto = voltas.stream()
                .collect(Collectors.groupingBy(Volta::getCarro, Collectors.minBy(Comparator.comparing(Volta::getTempo))));                
        System.out.println(voltasPorPiloto);
        

//        Descobrir a melhor volta da corrida
        Volta melhorVolta = voltas.stream().min(Comparator.comparing(Volta::getTempo)).get();
        System.out.println(melhorVolta);
        
//        Calcular a velocidade média de cada piloto durante toda corrida 
        Map<Carro, Double> velocidades = voltas.stream().collect(Collectors.groupingBy(Volta::getCarro, Collectors.averagingDouble(Volta::getVelocidadeMedia)));
        System.out.println(velocidades);

//        Descobrir quanto tempo cada piloto chegou após o vencedor
        Map<Carro, Long> tempoTotalPorPilotoOrdenado = voltas.stream()
                .collect(Collectors.groupingBy(Volta::getCarro, Collectors .summingLong(Volta::getVoltaEmMilissegundos)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                
        Long melhorTempo = tempoTotalPorPilotoOrdenado.entrySet().iterator().next().getValue();

        tempoTotalPorPilotoOrdenado.forEach((carro, tempo) -> {
            System.out.println(carro + " +" + LocalTime.ofNanoOfDay(tempo - melhorTempo));
        });          
        
    }

}
