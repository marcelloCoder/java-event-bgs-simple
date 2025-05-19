package br.com.mcoder;

public class Validator {
    public static boolean validarEmail(String email){
        return email!=null && email.contains("@") && email.endsWith(".com");
    }
}