package br.com.alura.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDias) {

        if(quantidadeDias > 1) {
          return  quantidadeDias + PLURAL;
        } else {
            return quantidadeDias + SINGULAR;
        }
    }
}
