package br.com.caioribeiro.empresa;

public enum TipoEndereco {
    
    COMERCIAL("Comcercial"), RESIDENCIAL ("Residencial");
    
    private final String nomeTipoEndereco;
    
    TipoEndereco(String descricao){
        nomeTipoEndereco = descricao;
    }
    
    public String getNomeTipoEndereco() {
        return nomeTipoEndereco;
    }
}
