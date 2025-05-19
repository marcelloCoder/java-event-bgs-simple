package br.com.mcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitanteVip extends Visitante {
    private boolean salaVipAcesso;
    private List<String> beneficios = new ArrayList<>();

    public VisitanteVip(Long id,String nome,String email,String cpf,Integer idade,String profissao,
                        boolean salaVipAcesso,List<String> beneficios){
        super(id,nome,email,cpf,idade,profissao);
        this.salaVipAcesso=salaVipAcesso;
        this.beneficios=beneficios;
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
        return "VisitanteVip{" +
                "beneficios=" + beneficios +
                ", salaVipAcesso=" + salaVipAcesso +
                "} " + super.toString();
    }

    public static VisitanteVip cadastrarVisitanteVip(Scanner sc){
        List<Pessoa> pessoas = new ArrayList<>();
        Long id = (long) pessoas.size() + 1;
        System.out.print("ID: " + id);
        System.out.print("Nome: ");
        String nome=sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        if (!Validator.validarEmail(email)) {
            throw new RuntimeException("EMAIL INVALIDO");
        }
        System.out.print("CPF: ");
        String cpf=sc.nextLine();
        System.out.print("Idade: ");
        Integer idade=Integer.parseInt(sc.nextLine());
        System.out.print("Profissão: ");
        String prof=sc.nextLine();
        return new VisitanteVip(id,nome,email,cpf,idade,prof);
    }
}