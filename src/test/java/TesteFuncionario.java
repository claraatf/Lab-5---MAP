import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Ator;
import org.example.Diretor;
import org.example.Filme;
import org.example.Funcao;
import org.example.Funcionario;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TesteFuncionario {
    private Funcionario funcionario;
    private String filme1;
    private String filme2;
    private Funcao diretor;
    private Funcao ator;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario("Tarcio Elyakin", "123.456.789-00");
        filme1 = "O Auto da Compadecida 2";
        filme2 = "O Homem que Desafiou o Diabo";
        diretor = new Diretor();
        ator = new Ator();
    }

    @Test
    void testAdicionarFilme() {
        funcionario.adicionarFilme(diretor, filme1);

        List<Funcao> funcoesFilme1 = funcionario.getFilmografia().get(filme1);
        assertNotNull(funcoesFilme1);
        assertTrue(funcoesFilme1.contains(diretor));

        assertTrue(funcionario.getFuncoes().contains(diretor));
    }

    @Test
    void testAdicionarFuncao() {
        funcionario.adicionarFuncao(filme2, ator);

        List<Funcao> funcoesFilme2 = funcionario.getFilmografia().get(filme2);
        assertNotNull(funcoesFilme2);
        assertTrue(funcoesFilme2.contains(ator));
        assertTrue(funcionario.getFuncoes().contains(ator));
    }

    @Test
    void testAdicionarFuncaoExistente() {

        funcionario.adicionarFuncao(filme1, diretor);
        funcionario.adicionarFuncao(filme1, diretor);

        List<Funcao> funcoesFilme1 = funcionario.getFilmografia().get(filme1);
        assertEquals(1, funcoesFilme1.size());

    }

    @Test
    void testToStringFilmografia() {

        funcionario.adicionarFilme(diretor, filme1);
        funcionario.adicionarFilme(ator, filme2);

        String esperado = "_____________________________________________________________________\n" +
                "Filmografia de: Tarcio Elyakin\nT\n" +
                "Filme                          Funcao                        \n" +
                "--------------------------------------------\n" +
                "O Homem que Desafiou o Diabo   Ator                          \n" +
                "O Auto da Compadecida 2        Diretor                       \n" +
                "_____________________________________________________________________\n";

        assertEquals(esperado, funcionario.toStringFilmografia());

    }

    @Test
    void testToString() {

        funcionario.adicionarFuncao(filme1, diretor);

        String esperado = "___________________________________________\n" +
                "Funcionario: Tarcio Elyakin\n" +
                "CPF: 123.456.789-00\n" +
                "Funcoes:\n" +
                "- Diretor\n" +
                "___________________________________________";

        assertEquals(esperado, funcionario.toString());

    }
}