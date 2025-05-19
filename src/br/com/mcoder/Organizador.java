package br.com.mcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Organizador extends Pessoa{
    private String setorResponsavel;
    private String nivelAcesso;

    public Organizador(Long id, String nome, String email, String cpf, String setorResponsavel, String nivelAcesso) {
        super(id, nome, email, cpf);
        this.setorResponsavel = setorResponsavel;
        this.nivelAcesso = nivelAcesso;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "Organizador{" + "setorResponsavel=" + setorResponsavel + ", nivelAcesso=" + nivelAcesso + '}' + super.toString();
    }

    public static Organizador cadastrarOrganizador(Scanner sc) {
        List<Pessoa> pessoas = new ArrayList<>();
        String nivelAcesso = "Nivel = Organizador";
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
        System.out.println("SETOR RESPONSAVEL");
        String setor = sc.nextLine();

        return new Organizador(id, nome, email, cpf, setor, nivelAcesso);
    }

    public static Organizador editarOrganizador(Scanner sc, Organizador organizador, String nome) {
        if (organizador.getNome().equals(nome)) {
            System.out.printf("%nEditando organizador: %s%n", organizador);
            System.out.println("ID : " + organizador.getId());

            System.out.println("EDITAR NOME : " + organizador.getNome());
            organizador.setNome(sc.nextLine());

            System.out.println("EDITAR EMAIL : " + organizador.getEmail());
            organizador.setEmail(sc.nextLine());

            System.out.println("EDITAR CPF : " + organizador.getCpf());
            organizador.setCpf(sc.nextLine());

            System.out.println("EDITAR SETOR RESPONSÁVEL : " + organizador.getSetorResponsavel());
            organizador.setSetorResponsavel(sc.nextLine());

            System.out.println("EDITAR NÍVEL DE ACESSO : " + organizador.getNivelAcesso());
            organizador.setNivelAcesso(sc.nextLine());

            System.out.println("Dados atualizados : " + organizador);
            return organizador;
        } else {
            throw new RuntimeException("Dados inválidos");
        }
    }

    public static Organizador consultarOrganizador(Organizador organizador, String nome) {
        if (organizador.getNome().equals(nome)) {
            System.out.println("Organizador encontrado : " + organizador);
            return organizador;
        }
        throw new RuntimeException("Organizador não encontrado");
    }

}