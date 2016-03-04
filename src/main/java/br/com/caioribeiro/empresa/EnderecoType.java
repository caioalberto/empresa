package br.com.caioribeiro.empresa;



/**
 * The Enum EnderecoType.
 */
/**
 * @author Caio Ribeiro
 *
 */
public enum EnderecoType {
    
    /** The comercial. */
    COMERCIAL("Comcercial"), /** The residencial. */
 RESIDENCIAL ("Residencial");
    
    /** The nome tipo endereco. */
    private final String nomeTipoEndereco;
    
    /**
     * Cria uma instancia de endereco type.
     *
     * @param descricao the descricao
     */
    EnderecoType(String descricao){
        nomeTipoEndereco = descricao;
    }
    

    /**
     * Gets the nome tipo endereco.
     *
     * @return the nome tipo endereco
     */
    public String getNomeTipoEndereco() {
        return nomeTipoEndereco;
    }
}
