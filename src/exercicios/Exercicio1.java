package exercicios;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Autor;
import model.Editora;
import model.Empresa;
import model.Livro;
import dados.LivroDAO;

public class Exercicio1 {
    
    public static void main(String[] args) {
        List<Livro> livros = LivroDAO.getLivros();
        
        // Exibir os livros publicados em 2017
        List<Livro> livros2017 = livros
                .stream()
                .filter(livro -> LocalDate.ofEpochDay(livro.getDataPublicacao().getTime()).getYear() == 2017)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(livros2017.toArray()));

        // Exibir os livros entre 100 e 150 paginas
        List<Livro> livrosPagina = livros
                .stream()
                .filter(livro -> livro.getNumeroPaginas() >= 100  && livro.getNumeroPaginas() <= 150)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(livrosPagina.toArray()));

        // Exibir os livros com ISBN final par
        List<Livro> livrosISBN = livros
                .stream()
                .filter(livro -> Integer.valueOf(livro.getISBN().charAt(livro.getISBN().length()-1)) % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(livrosISBN.toArray()));

        // Exibir a quantidade de Autores por cada livro
        Map<List<Autor>,List<Livro>> livrosPorAutor = livros.stream()
                .collect(Collectors.groupingBy(Livro::getAutores));
        System.out.println(livrosPorAutor);

        // Exibir o total de paginas publicadas por ano
        Map<Integer, Long> paginasPorAno = livros.stream()
                .collect(Collectors.groupingBy(Livro::getAnoPublicacao, Collectors.summingLong(Livro::getNumeroPaginas)));        
        System.out.println(paginasPorAno);

        // Exibir a quantidade de Autores por editora
        Map<Editora, Integer> autoresPorEditora = livros.stream()
                .collect(Collectors.groupingBy(Livro::getEditora, Collectors.summingInt(Livro::getQuantidadeAutores)));        
        System.out.println(autoresPorEditora);

        // Exibir a quantidade de Livros por Empresa (Livro-Autor-Empresa)
        Map<Empresa, Long> livrosPorEmpresa = livros.stream()
                .map(Livro::getAutores).collect(Collectors.toList())
                .stream().parallel().flatMap(x -> x.stream()).collect(Collectors.toSet())
                .stream().parallel().collect(Collectors.groupingBy(Autor::getEmpresa, Collectors.counting()));
        System.out.println(livrosPorEmpresa);

    }

}
