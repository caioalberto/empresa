package br.com.caioribeiro.empresa;

import static br.com.caioribeiro.empresa.stringbuilder.MyStyle.MY_STYLE;
import static org.apache.commons.lang3.StringUtils.isNumeric;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * Classe Endereco, define a criacao de um objeto do tipo endereco, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public final class Endereco {

//Variaveis e Constantes----------------------------------------------------------------------------------
    /**
     *
     * Defnine o logradouro do endereco, assim como seu nome.
     */
    @NotBlank(message="O logradouro não pode estar vazio!")
    @Size(min=5, max=80, message="O Logradouro deve conter, no mínimo {min} e no máximo {max} letras!")
    private String logradouro;

    /**
     *
     * Define o bairro do endereco, assim como seu nome.
     */
    @NotBlank(message="O bairro não pode estar vazio!")
    @Size(min=5, max=80, message="O Bairro deve conter, no mínino {min} e no máximo {max} letras!")
    private String bairro;

    /**
     *
     * Define o cep do endereco, assim como seu numero.
     */
    @NotBlank(message="O CEP não pode estar vazio!")
    @Size(min=8, max=8, message="O CEP não pode ter tamanho diferente de {min}!")
    private String cep;

    /**
     *
     * Define a cidade do endereco, assim como seu nome.
     */
    @NotBlank(message="A cidade não pode estar vazia!")
    @Size(min=7, max=50, message="A cidade não pode conter menos de {min} e mais de {max} letras!")
    private String cidade;

    /**
     *
     * Define o estado do endereco, assim como seu nome (Sempre em dois
     * caracteres).
     */
    @NotBlank(message="O estado não pode estar vazio!")
    @Size(min=2, max=2, message="O estado deve conter {max} letras!")
    private String estado;

    /**
     *
     * Define o pais do endereco, assim como seu nome.
     */
    @NotBlank(message="O país não pode estar vazio!")
    @Size(min=2, max=2, message="O país deve conter {max} letras!")
    private String pais;

    /**
     *
     * Define o numero do estabelecimento dentro do endereco.
     */
    private Integer numero;
    
    /**
     * 
     * Define o tipo do endereco, se residencial/comercial.
     */
    @Valid
    private TipoEndereco tipoEndereco;

//Getters e Setters---------------------------------------------------------------------------------------			
    /**
     * Gets the logradouro.
     *
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Gets the cidade.
     *
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Gets the pais.
     *
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Gets the tipo endereco.
     *
     * @return the tipo endereco
     */
    public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * Seta o atributo logradouro.
	 *
	 * @param logradouro novo valor de logradouro
	 */
	public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Seta o atributo bairro.
     *
     * @param bairro novo valor de bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Seta o atributo cep.
     *
     * @param cep novo valor de cep
     */
    public void setCep(String cep) {
        isNumeric(cep);
        this.cep = cep;
    }

    /**
     * Seta o atributo cidade.
     *
     * @param cidade novo valor de cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Seta o atributo estado.
     *
     * @param estado novo valor de estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Seta o atributo pais.
     *
     * @param pais novo valor de pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Seta o atributo numero.
     *
     * @param numero novo valor de numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
	/**
	 * Seta o atributo tipo endereco.
	 *
	 * @param tipoEndereco novo valor de tipo endereco
	 */
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
    
    //Equals, HashCode e toString---------------------------------------------------------------------------------------------------
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    	return new HashCodeBuilder().append(this.cep).toHashCode();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)){
			return false;			
		}
		Endereco other = (Endereco) obj;
		return new EqualsBuilder().append(this.cep, other.cep).isEquals();
	}
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, MY_STYLE)
                .append("Endereço: ",this.logradouro)
                .append("Nº", this.numero)
                .append("Bairro: ", this.bairro)
                .append("Cidade: ", this.cidade)
                .append("UF: ", this.estado)
                .append("País ", this.pais)
                .append(tipoEndereco)
                .toString();
    }

}
