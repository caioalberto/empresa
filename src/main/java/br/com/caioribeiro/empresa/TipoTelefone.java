package br.com.caioribeiro.empresa;

public enum TipoTelefone {
    CELULAR(9, "Celular"), FAX(8, "Fax"), COMERCIAL(8, "Comercial");
    
   private static int qtdNumeros;
   private static String nomeTipo;
    
    TipoTelefone(int qtdNumeros, String nomeTipo){        
    }

    public static int getQtdNumeros() {
        return qtdNumeros;
    }

    public static String getNomeTipo() {
        return nomeTipo;
    }
    

}
