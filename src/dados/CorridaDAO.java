package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Carro;
import model.Piloto;
import model.Volta;

public class CorridaDAO {
    
    private static Pattern pattern = Pattern.compile("([\\d]{1,2}:[\\d]{2}:[\\d]{2}.[\\d]{3})\\W+([\\d]+)\\W+([A-Z.]+)\\W+([\\d]+)\\W+([\\d]{1,2}:[\\d]{2}.[\\d]{3})\\W+([\\d]+[,]*[\\d]+)"); 

    public static List<Volta> getVoltas() {
        List<Volta> voltas = new ArrayList<>();
        
        try {
            Scanner sc = new Scanner(new File("resources/dados-corrida.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                voltas.add(converteLinha(linha));
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return voltas;
    }
    
    public static void main(String[] args) {
        CorridaDAO.getVoltas();
    }
    
    public static Volta converteLinha(String linha) {
        String horaInicio = null;
        Long numero = null;
        Carro carro = null;
        String tempo = null;
        Double velocidadeMedia = null;

        Matcher m = pattern.matcher(linha);
        if (m.find( )) {
            horaInicio = m.group(1);
            carro = new Carro(m.group(2), new Piloto(m.group(3)));
            numero = Long.valueOf(m.group(4));
            tempo = m.group(5);
            velocidadeMedia = Double.valueOf(m.group(6).replaceAll(",","."));            
        } else {
           System.out.println("Linha Invalida --> [" + linha + "]");
        }
        
        return new Volta(horaInicio, numero, carro, tempo, velocidadeMedia);
    }

}
