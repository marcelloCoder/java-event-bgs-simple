package br.com.mcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Visitante extends Pessoa {

    private Integer idade;
    private String profissao;

    public Visitante() {
    }



    public Visitante(Long id, String nome, String email, String cpf, Integer idade, String profissao) {
        super(id, nome, email, cpf);
        this.idade = idade;
        this.profissao = profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public static Visitante cadastrarVisitante(Scanner sc) {
        List<Pessoa> pessoas = new ArrayList<>();
        Long id = (long) pessoas.size() + 1;
        System.out.print("ID: " + id);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        if (!Pessoa.validarEmail(email)) {
            throw new RuntimeException("EMAIL INVALIDO");
        }
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Idade: ");
        Integer idade = Integer.parseInt(sc.nextLine());
        System.out.print("Profissão: ");
        String prof = sc.nextLine();
        return new Visitante(id, nome, email, cpf, idade, prof);
    }

    public static Visitante editarVistante(Scanner sc, Visitante visitante, String nome) {

        if (visitante.getNome().equals(nome)) {
            System.out.printf("%nEditando visitante: %s%n", visitante);
            System.out.println("ID : " + visitante.getId());
            System.out.println("EDITAR NOME : " + visitante.getNome());
            visitante.setNome(sc.nextLine());
            System.out.println("EDITAR EMAIL : " + visitante.getEmail());
            visitante.setEmail(sc.nextLine());
            System.out.println("EDITAR CPF : " + visitante.getCpf());
            visitante.setCpf(sc.nextLine());
            System.out.println("EDITAR IDADE : " + visitante.getIdade());
            System.out.println("EDITAR PROFISSAO : " + visitante.getProfissao());
            System.out.println("Dados atualizados : " + visitante);
            return visitante;

        } else {
            throw new RuntimeException("Dados invalidos");
        }
    }

    public static Visitante consultarVistante(Visitante visitante, String nome) {
        if (visitante.getNome().equals(nome)) {
            System.out.println("Visitante encontrado : " + visitante);
            return visitante;
        }
        throw new RuntimeException("Visitante não encontrado");
    }

}
