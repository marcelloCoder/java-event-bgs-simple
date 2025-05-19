package br.com.mcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitanteVip extends Visitante {

    private boolean salaVipAcesso;
    private List<String> beneficios = new ArrayList<>();

    public VisitanteVip(Long id, String nome, String email, String cpf, Integer idade, String profissao,
                        boolean salaVipAcesso, List<String> beneficios) {
        super(id, nome, email, cpf, idade, profissao);
        this.salaVipAcesso = salaVipAcesso;
        this.beneficios = beneficios;
    }

    public List<String> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<String> beneficios) {
        this.beneficios = beneficios;
    }

    public boolean isSalaVipAcesso() {
        return salaVipAcesso;
    }

    public void setSalaVipAcesso(boolean salaVipAcesso) {
        this.salaVipAcesso = salaVipAcesso;
    }

    @Override
    public String toString() {
        return "VisitanteVip{"
                + "beneficios=" + beneficios
                + ", salaVipAcesso=" + salaVipAcesso
                + "} " + super.toString();
    }

    public static VisitanteVip cadastrarVisitanteVip(Scanner sc) {
        List<Pessoa> pessoas = new ArrayList<>();
        boolean salaVipAcesso = true;
        List<String> beneficios = List.of("Brinde exclusivo", "Fila especial");

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
        return new VisitanteVip(id, nome, email, cpf, idade, prof, salaVipAcesso, beneficios);
    }

    public static VisitanteVip editarVistanteVip(Scanner sc, VisitanteVip vip, String nome) {
        if (vip.getNome().equals(nome)) {
            System.out.printf("%nEditando visitante VIP: %s%n", vip);
            System.out.println("ID : " + vip.getId());

            System.out.println("EDITAR NOME : " + vip.getNome());
            vip.setNome(sc.nextLine());

            System.out.println("EDITAR EMAIL : " + vip.getEmail());
            vip.setEmail(sc.nextLine());

            System.out.println("EDITAR CPF : " + vip.getCpf());
            vip.setCpf(sc.nextLine());

            System.out.println("EDITAR IDADE : " + vip.getIdade());
            vip.setIdade(Integer.parseInt(sc.nextLine()));

            System.out.println("EDITAR PROFISSÃO : " + vip.getProfissao());
            vip.setProfissao(sc.nextLine());

            System.out.println("ALTERAR ACESSO À SALA VIP (true/false) : " + vip.isSalaVipAcesso());
            vip.setSalaVipAcesso(Boolean.parseBoolean(sc.nextLine()));

            System.out.println("EDITAR BENEFÍCIOS (separar por vírgula) : " + vip.getBeneficios());
            String beneficiosStr = sc.nextLine();
            vip.setBeneficios(List.of(beneficiosStr.split("\\s*,\\s*")));

            System.out.println("Dados atualizados : " + vip);
            return vip;
        } else {
            throw new RuntimeException("Dados inválidos");
        }
    }

    public static VisitanteVip consultarVistanteVip(VisitanteVip vip, String nome) {
        if (vip.getNome().equals(nome)) {
            System.out.println("Visitante VIP encontrado : " + vip);
            return vip;
        }
        throw new RuntimeException("Visitante VIP não encontrado");
    }
}