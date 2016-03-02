package br.com.caioribeiro.empresa;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public enum TelefoneType {
    CELULAR(9, "Celular"), FAX(8, "Fax"), COMERCIAL(8, "Comercial");
   
   @Range(min=8, max=9, message="Número de telefone inválido, insira um telefone com a qunatidade de números entre {min} e {max}!") 
   private final int qtdNumeros;
   
   @NotBlank(message="O tipo não pode estar vazio!")
   private final String nomeTipo;
   
    TelefoneType(int telefone, String descricao){
        qtdNumeros = telefone;
        nomeTipo = descricao;
    }

    public int getQtdNumeros() {
        return qtdNumeros;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }
    

}
