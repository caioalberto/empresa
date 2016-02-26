package br.com.caioribeiro.empresa;

public enum TipoTelefone {
    CELULAR(9, "Celular"), FAX(8, "Fax"), COMERCIAL(8, "Comercial");
    
   private final int qtdNumeros;
   private final String nomeTipo;
   
    TipoTelefone(int telefone, String descricao){
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
