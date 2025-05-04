package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final Funcao ATOR = new Ator();
    public static final Funcao DIRETOR = new Diretor();
    public static final Funcao ROTEIRISTA = new Roteirista();
    public static final Funcao CINEGRAFISTA = new Cinegrafista();
    public static final Funcao PRODUTOR = new Produtor();
    public static final Funcao CAMERA = new Camera();

    public static void main(String[] args) {
        ControleDeAcesso controleGloboFilmes =new ControleDeAcesso();

        // Criando funcionários

        controleGloboFilmes.cadastrarFuncionario("Maria", "11111111111"); //11111111111

        controleGloboFilmes.cadastrarFuncionario("Clara", "11111111112"); //11111111112

        controleGloboFilmes.cadastrarFuncionario("Ronaldo", "11111111113"); //11111111113

        // Criando um filme

        controleGloboFilmes.cadastrarFilme("Scream IV", 2011, "00001");
        controleGloboFilmes.cadastrarFilme("Superman - O filme", 1978, "00002");

        // Colocando funcionarios e suas funcoes no filme

        controleGloboFilmes.adicionarAoFilme("00001", "11111111111", DIRETOR);
        controleGloboFilmes.adicionarAoFilme("00001", "11111111112", ATOR);
        controleGloboFilmes.adicionarAoFilme("00001", "11111111112", ROTEIRISTA);
        controleGloboFilmes.adicionarAoFilme("00001", "11111111113", ATOR);
        controleGloboFilmes.atualizarFuncaoEmFilme("00001", "11111111113", PRODUTOR);
        controleGloboFilmes.getFilme("00001").setTrilhaSonora("Wicked game - Chris Isaak");

        //Fazendo o mesmo que foi feito para o filme de id 00002
        controleGloboFilmes.adicionarAoFilme("00002", "11111111111", ATOR);
        controleGloboFilmes.adicionarAoFilme("00002", "11111111113", DIRETOR);
        controleGloboFilmes.getFilme("00002").setTrilhaSonora("Superman Theme - John Williams");

        //Printando todos os filmes
        controleGloboFilmes.obterFilmes();

        //Exibindo filmografia do ator
        System.out.println(controleGloboFilmes.getFuncionario("11111111113"));
        System.out.println(controleGloboFilmes.getFuncionario("11111111113").toStringFilmografia());
    }
}