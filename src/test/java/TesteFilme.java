import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Filme;

public class TesteFilme {

    Filme somosTaoJovens;
    String cpfClara;
    String clara;
    String ator;
    String diretor;

    @BeforeEach
    public void setup() {
        somosTaoJovens = new Filme("Somos Tão Jovens", 2013, "596");
        cpfClara = "123.456.789-98";
        clara = "Clara";
        ator = "Ator";
        diretor = "Diretor";
    }

    @Test
    public void testGetNome() {
        assertEquals("Somos Tão Jovens", somosTaoJovens.getNome());
        assertNotEquals("Somos_Tão_Jovens", somosTaoJovens.getNome());
    }

    @Test
    public void testGetAno() {
        assertEquals(2013, somosTaoJovens.getAno());
        assertNotEquals(2024, somosTaoJovens.getAno());
        assertNotEquals("2013", somosTaoJovens.getAno());
    }

    @Test
    public void testGetId() {
        assertEquals("596", somosTaoJovens.getId());
        assertNotEquals("569", somosTaoJovens.getId());
        assertNotEquals(596, somosTaoJovens.getId());
    }

    @Test
    public void testeAdicionarNoFilme() {
        boolean adicionou = somosTaoJovens.adicionarNoFilme(cpfClara, clara, ator);
        assertTrue(adicionou);
    }

    @Test
    public void testeGetFuncionarios() {
        somosTaoJovens.adicionarNoFilme(cpfClara, clara, ator);

        Map<String, Map<String, List<String>>> funcionarios = somosTaoJovens.getFuncionarios();
        assertTrue(funcionarios.containsKey(cpfClara));
        assertTrue(funcionarios.get(cpfClara).containsKey(clara));
        assertTrue(funcionarios.get(cpfClara).get(clara).contains(ator));
    }

    @Test
    public void testeAtualizarFuncoes() {
        somosTaoJovens.adicionarNoFilme(cpfClara, clara, ator);
        somosTaoJovens.atualizarFuncoes(cpfClara, clara, diretor);

        List<String> funcoesEsperadas = new ArrayList<>();
        funcoesEsperadas.add(ator);
        funcoesEsperadas.add(diretor);

        assertEquals(funcoesEsperadas, somosTaoJovens.getFuncionarios().get(cpfClara).get(clara));
    }

    @Test
    public void testeAtualizarFuncoesExistente() {
        somosTaoJovens.adicionarNoFilme(cpfClara, clara, ator);
        somosTaoJovens.atualizarFuncoes(cpfClara, clara, ator);

        List<String> funcoesEsperadas = new ArrayList<>();
        funcoesEsperadas.add(ator);

        assertEquals(funcoesEsperadas, somosTaoJovens.getFuncionarios().get(cpfClara).get(clara));
    }

    @Test
    public void testeFuncionarioNaoEncontrado() {
        somosTaoJovens.atualizarFuncoes("987.654.321-00", "Maria", diretor);

        assertFalse(somosTaoJovens.getFuncionarios().containsKey("987.654.321-00"));
    }

    @Test
    public void testeSetTrilhaSonora() {
        somosTaoJovens.setTrilhaSonora("Legião Urbana");
        assertTrue(somosTaoJovens.toString().contains("Trilha sonora: Legião Urbana"));
    }
}