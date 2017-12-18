package dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.Autor;
import model.Editora;
import model.Empresa;
import model.Livro;
import model.Profissao;

public class LivroDAO {

    public static List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<>();

        Autor diego = new Autor.Builder().comNome("Diego Martins de Pinho")
                .nascidoEm(new Date(LocalDate.of(1970, 01, 01).toEpochDay()))
                .trabalhaComo(new Profissao(1L, "Analista de Sistemas"))
                .trabalhaEm(new Empresa(1L, "Alura")).build();

        Autor nelson = new Autor.Builder().comNome("Nelson Fabbri Gerbelli")
                .nascidoEm(new Date(LocalDate.of(1990, 01, 01).toEpochDay()))
                .trabalhaComo(new Profissao(3L, "Professor"))
                .trabalhaEm(new Empresa(2L, "ETEC")).build();

        Autor valeria = new Autor.Builder()
                .comNome("Valéria Helena P. Gerbelli")
                .nascidoEm(new Date(LocalDate.of(1995, 01, 01).toEpochDay()))
                .trabalhaComo(new Profissao(3L, "Professor"))
                .trabalhaEm(new Empresa(2L, "ETEC")).build();

        Autor marcos = new Autor.Builder().comNome("Marcos Brizeno")
                .nascidoEm(new Date(LocalDate.of(2000, 01, 01).toEpochDay()))
                .trabalhaComo(new Profissao(2L, "Consultor"))
                .trabalhaEm(new Empresa(3L, "ThoughtWorks Brasil")).build();

        Autor everton = new Autor.Builder()
                .comNome("Everton Coimbra de Araújo")
                .nascidoEm(new Date(LocalDate.of(1998, 1, 01).toEpochDay()))
                .trabalhaComo(new Profissao(4L, "Tecnologo em Processamento de Dados"))
                .trabalhaEm(new Empresa(4L, "Centro de Ensino superior de Foz do Iguaçu"))
                .build();

        Autor leonardo = new Autor.Builder().comNome("Leonardo Vilarinho")
                .nascidoEm(new Date(LocalDate.of(1998, 1, 01).toEpochDay()))
                .trabalhaComo(new Profissao(1L, "Analista de Sistemas"))
                .trabalhaEm(new Empresa(5L, "Freelance")).build();

        Autor wesley = new Autor.Builder().comNome("Wesley Oliveira Vanelli")
                .nascidoEm(new Date(LocalDate.of(1980, 9, 27).toEpochDay()))
                .trabalhaComo(new Profissao(2L, "Oreia Seca"))
                .trabalhaEm(new Empresa(3L, "ThoughtWorks Brasil"))
                .build();
        
        Livro livro1 = new Livro.Builder().comCodigo(1L)
                .comTitulo("ECMAScript 6")
                .comSubTitulo("Entre de cabeça no futuro do JavaScript")
                .comISBN("978-85-5519-258-6")
                .comNumeroPaginas(206L)
                .publicadoEm(new Date(LocalDate.of(2017, 05, 05).toEpochDay()))
                .publicadoPor(new Editora(111L, "Casa do Codigo"))
                .escritoPor(Arrays.asList(diego))
                .build();

        Livro livro2 = new Livro.Builder().comCodigo(2L)
                .comTitulo("Front-end com Vue.js")
                .comSubTitulo("Da teoria à prática sem complicações")
                .comISBN("978-85-94188-27-4")
                .comNumeroPaginas(215L)
                .publicadoEm(new Date(LocalDate.of(2017, 12, 01).toEpochDay()))
                .publicadoPor(new Editora(111L, "Casa do Codigo"))
                .escritoPor(Arrays.asList(leonardo)).build();

        Livro livro3 = new Livro.Builder().comCodigo(3L)
                .comTitulo("App Inventor")
                .comSubTitulo("Seus primeiros aplicativos Android")
                .comISBN("978-85-94188-30-4")
                .comNumeroPaginas(311L)
                .escritoPor(Arrays.asList(nelson, valeria))
                .publicadoEm(new Date(LocalDate.of(2017, 01, 01).toEpochDay()))
                .publicadoPor(new Editora(111L, "Casa do Codigo"))
                .build();

        Livro livro4 = new Livro.Builder().comCodigo(4L)
                .comTitulo("Orientação a Objetos em C#")
                .comSubTitulo("Conceitos e implementações em .NET")
                .comISBN("978-85-94188-24-3")
                .comNumeroPaginas(141L)
                .escritoPor(Arrays.asList(everton))
                .publicadoEm(new Date(LocalDate.of(2010, 01, 01).toEpochDay()))
                .publicadoPor(new Editora(555L, "Editora Google"))
                .build();

        Livro livro5 = new Livro.Builder().comCodigo(5L)
                .comTitulo("Refatorando com padrões de projeto")
                .comSubTitulo("Um guia em Java")
                .comISBN("978-85-94188-21-2")
                .comNumeroPaginas(142L)
                .escritoPor(Arrays.asList(marcos))
                .publicadoEm(new Date(LocalDate.of(2010, 01, 01).toEpochDay()))
                .publicadoPor(new Editora(555L, "Editora Google"))
                .build();

        Livro livro6 = new Livro.Builder().comCodigo(6L)
                .comTitulo("Java para cangaceiros")
                .comSubTitulo("Aqui o côro comi")
                .comISBN("978-85-94188-66-7")
                .comNumeroPaginas(11L)
                .escritoPor(Arrays.asList(wesley))
                .publicadoEm(new Date(LocalDate.of(2016, 11, 20).toEpochDay()))
                .publicadoPor(new Editora(555L, "Editora Google"))
                .build();
        
        Livro livro7 = new Livro.Builder().comCodigo(6L)
                .comTitulo("Java para cangaceiros II")
                .comSubTitulo("Aqui o côro comi Denovo")
                .comISBN("978-85-94188-66-9")
                .comNumeroPaginas(11L)
                .escritoPor(Arrays.asList(wesley))
                .publicadoEm(new Date(LocalDate.of(2017, 12, 25).toEpochDay()))
                .publicadoPor(new Editora(555L, "Editora Google"))
                .build();
        
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);

        return livros;
    }
}
