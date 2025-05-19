package br.com.mcoder;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public Pessoa(){

    }

    protected Pessoa(Long id,String nome,String email,String cpf){
        this.id=id;
        this.nome=nome;
        this.email=email;
        this.cpf=cpf;
    }
    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getCpf(){return cpf;}
    public void setCpf(String cpf){this.cpf=cpf;}
    public static boolean validarEmail(String email){
        return email!=null && email.contains("@") && email.endsWith(".com");
    }

    @Override
    public String toString(){
        return "%s[id=%d, nome=%s, email=%s, cpf=%s]".formatted(getClass().getSimpleName(),id,nome,email,cpf);
    }
}