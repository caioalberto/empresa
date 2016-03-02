package br.com.caioribeiro.empresa;



public enum EnderecoType {
    
    COMERCIAL("Comcercial"), RESIDENCIAL ("Residencial");
    
    private final String nomeTipoEndereco;
    
    EnderecoType(String descricao){
        nomeTipoEndereco = descricao;
    }
    

    public String getNomeTipoEndereco() {
        return nomeTipoEndereco;
    }
}
