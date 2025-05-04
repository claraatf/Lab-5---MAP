package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Filme {
    private String nome, id;
    private int ano;
    private Map<String, Map<String, List<String>>> funcionarios; // CPF -> Nome -> Lista de funções
    private String trilhaSonora;

    public Filme(String nome, int ano, String id) {
        this.nome = nome;
        this.ano = ano;
        this.id = id;
        this.funcionarios = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getId() {
        return id;
    }

    public Map<String, Map<String, List<String>>> getFuncionarios() {
        return funcionarios;
    }

    public boolean adicionarNoFilme(String cpf, String nome, String funcao) {
        try {
            Map<String, List<String>> mapaNomeFuncoes = funcionarios.computeIfAbsent(cpf, k -> new HashMap<>());
            List<String> listaFuncoes = mapaNomeFuncoes.computeIfAbsent(nome, k -> new ArrayList<>());

            if (!listaFuncoes.contains(funcao)) {
                listaFuncoes.add(funcao);
                return true;
            } else {
                System.out.println("A função já está associada ao funcionário.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar funcionário no filme: " + e.getMessage());
            return false;
        }
    }

    public void atualizarFuncoes(String cpf, String nome, String novaFuncao) {
        try {
            Map<String, List<String>> mapaNomeFuncoes = funcionarios.get(cpf);
            if (mapaNomeFuncoes != null) {
                List<String> listaFuncoes = mapaNomeFuncoes.get(nome);
                if (listaFuncoes != null) {
                    if (!listaFuncoes.contains(novaFuncao)) {
                        listaFuncoes.add(novaFuncao);
                    } else {
                        System.out.println("A função já está associada ao funcionário.");
                    }
                } else {
                    System.out.println("Nome do funcionário não encontrado.");
                }
            } else {
                System.out.println("CPF não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar funções: " + e.getMessage());
        }
    }

    public void setTrilhaSonora(String trilhaSonora) {
        try {
            this.trilhaSonora = trilhaSonora;
        } catch (Exception e) {
            System.out.println("Erro ao definir a trilha sonora: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_____________________________________________________________________\n");
            sb.append(String.format("Filme: %s (%d)\n", nome, ano));
            sb.append(String.format("Trilha sonora: %s\n", trilhaSonora));
            sb.append("\nFuncionarios e Funcoes:\n");
            sb.append(String.format("%-30s %-30s %-20s\n", "CPF", "Funcionario", "Funcao"));
            sb.append("--------------------------------------------------------------------\n");

            for (Map.Entry<String, Map<String, List<String>>> entryCpf : funcionarios.entrySet()) {
                String cpf = entryCpf.getKey();
                Map<String, List<String>> mapaNomeFuncoes = entryCpf.getValue();
                for (Map.Entry<String, List<String>> entryNome : mapaNomeFuncoes.entrySet()) {
                    String nomeFuncionario = entryNome.getKey();
                    List<String> funcoes = entryNome.getValue();
                    for (String funcao : funcoes) {
                        sb.append(String.format("%-30s %-30s %-20s\n", cpf, nomeFuncionario, funcao));
                    }
                }
            }
            sb.append("_____________________________________________________________________\n");
            return sb.toString();
        } catch (Exception e) {
            return "Erro ao gerar string do filme: " + e.getMessage();
        }
    }
}