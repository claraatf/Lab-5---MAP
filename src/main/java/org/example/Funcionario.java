package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Funcao> funcoes;
    private Map<String, List<Funcao>> filmografia; // NomeFilme/FuncaoNoFilme

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcoes = new ArrayList<>();
        this.filmografia = new HashMap<>();
    }

    public void adicionarFilme(Funcao funcao, String filmeCodigo) {
        try {
            List<Funcao> funcoesNoFilme = this.filmografia.get(filmeCodigo);

            if (funcoesNoFilme == null) {
                funcoesNoFilme = new ArrayList<>();
                this.filmografia.put(filmeCodigo, funcoesNoFilme);
            }

            if (!funcoesNoFilme.contains(funcao)) {
                funcoesNoFilme.add(funcao);
            }

            if (!this.funcoes.contains(funcao)) {
                this.funcoes.add(funcao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar filme: " + e.getMessage());
        }
    }

    public void adicionarFuncao(String filmeCodigo, Funcao novaFuncao) {
        try {
            if (this.funcoes.contains(novaFuncao)) {
                System.out.println("Erro: A função já está atribuída ao funcionário.");
                return;
            }

            this.funcoes.add(novaFuncao);

            List<Funcao> funcoesNoFilme = this.filmografia.get(filmeCodigo);

            if (funcoesNoFilme == null) {
                funcoesNoFilme = new ArrayList<>();
                this.filmografia.put(filmeCodigo, funcoesNoFilme);
            }

            if (funcoesNoFilme.contains(novaFuncao)) {
                System.out.println("Erro: A função já está atribuída ao filme para este funcionário.");
            } else {
                funcoesNoFilme.add(novaFuncao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar função: " + e.getMessage());
        }
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public List<Funcao> getFuncoes() {
        return this.funcoes;
    }

    public Map<String, List<Funcao>> getFilmografia() {
        return this.filmografia;
    }

    public String toStringFilmografia() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_____________________________________________________________________\n");
            sb.append("Filmografia de: " + this.nome + "\n");
            sb.append(String.format("%-30s %-30s\n", "Filme", "Funcao"));
            sb.append("--------------------------------------------\n");

            for (Map.Entry<String, List<Funcao>> entry : filmografia.entrySet()) {
                String filme = entry.getKey();
                List<Funcao> funcoes = entry.getValue();
                for (Funcao funcao : funcoes) {
                    sb.append(String.format("%-30s %-30s\n", filme, funcao.getDescricao()));
                }
            }

            sb.append("_____________________________________________________________________\n");
            return sb.toString();
        } catch (Exception e) {
            return "Erro ao gerar string da filmografia: " + e.getMessage();
        }
    }

    @Override
    public String toString() {
        try {
            StringBuilder funcoesDescricao = new StringBuilder();

            for (Funcao funcao : this.funcoes) {
                funcoesDescricao.append("- ").append(funcao.getDescricao()).append("\n");
            }

            String descricaoFuncoes = funcoesDescricao.length() > 0 ? funcoesDescricao.toString()
                    : "Nenhuma funcao atribuída";

            return "___________________________________________\n" +
                    "Funcionario: " + this.nome + "\n" +
                    "CPF: " + this.cpf + "\n" +
                    "Funcoes:\n" + descricaoFuncoes +
                    "___________________________________________";
        } catch (Exception e) {
            return "Erro ao gerar string do funcionário: " + e.getMessage();
        }
    }
}