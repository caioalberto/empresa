package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 *
 * Classe Endereco, define a criacao de um objeto do tipo endereco, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public class Endereco {

//Variaveis e Constantes----------------------------------------------------------------------------------
    /**
     *
     * Defnine o logradouro do endereco, assim como seu nome.
     */
    private String logradouro;

    /**
     *
     * Define o bairro do endereco, assim como seu nome.
     */
    private String bairro;

    /**
     *
     * Define o cep do endereco, assim como seu numero.
     */
    private String cep;

    /**
     *
     * Define a cidade do endereco, assim como seu nome.
     */
    private String cidade;

    /**
     *
     * Define o estado do endereco, assim como seu nome (Sempre em dois
     * caracteres).
     */
    private String estado;

    /**
     *
     * Define o pais do endereco, assim como seu nome.
     */
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
    private TipoEndereco tipoEndereco;

    /**
     *
     * Define o tamanho minimo do logradouro.
     */
    private static final int TAM_MIN_LOGRADOURO = 5;

    /**
     *
     * Define o tamanho maximo do logradouro.
     */
    private static final int TAM_MAX_LOGRADOURO = 80;

    /**
     *
     * Define o tamanho minimo do bairro.
     */
    private static final int TAM_MIN_BAIRRO = 6;

    /**
     *
     * Define o tamanho maximo do bairro.
     */
    private static final int TAM_MAX_BAIRRO = 80;

    /**
     *
     * Define o tamanho maximo que um cep devera conter.
     */
    private static final int TAM_MAX_CEP = 9;

    /**
     *
     * Define o tamanho minimo da cidade.
     */
    private static final int TAM_MIN_CIDADE = 6;

    /**
     *
     * Define o tamanho maximo da cidade.
     */
    private static final int TAM_MAX_CIDADE = 30;

    /**
     *
     * Define o tamanho maximo do estado.
     */
    private static final int TAM_ESTADO = 2;

    /**
     *
     * Define o tamanho minimo do pais.
     */
    private static final int TAM_MIN_PAIS = 5;

    /**
     *
     * Define o tamanho maximo do pais.
     */
    private static final int TAM_MAX_PAIS = 20;

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
        this.validaLogradouro(logradouro);
        this.logradouro = logradouro;
    }

    /**
     * Seta o atributo bairro.
     *
     * @param bairro novo valor de bairro
     */
    public void setBairro(String bairro) {
        this.validaBairro(bairro);
        this.bairro = bairro;
    }

    /**
     * Seta o atributo cep.
     *
     * @param cep novo valor de cep
     */
    public void setCep(String cep) {
        this.validaCep(cep);
        this.cep = cep;
    }

    /**
     * Seta o atributo cidade.
     *
     * @param cidade novo valor de cidade
     */
    public void setCidade(String cidade) {
        this.validaCidade(cidade);
        this.cidade = cidade;
    }

    /**
     * Seta o atributo estado.
     *
     * @param estado novo valor de estado
     */
    public void setEstado(String estado) {
        this.validaEstado(estado);
        this.estado = estado;
    }

    /**
     * Seta o atributo pais.
     *
     * @param pais novo valor de pais
     */
    public void setPais(String pais) {
        this.validaPais(pais);
        this.pais = pais;
    }

    /**
     * Seta o atributo numero.
     *
     * @param numero novo valor de numero
     */
    public void setNumero(Integer numero) {
        this.validaNumero(numero);
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

 //Metodos de validacao-------------------------------------------------------------------
    
    /**
     * Verifica o logradouro, se preenchido e se respeita as ordem
     * preestabelecidas de preenchimento
     * 
     * @param logradouro
     */
    public void validaLogradouro(String logradouro) {
        this.verificaSePreenchidoOuNulo(logradouro);
    }

    /**
     * Verifica se preenchido ou nulo.
     *
     * @param logradouro the logradouro
     */
    public void verificaSePreenchidoOuNulo(String logradouro) {
        checkNotNull(logradouro, "Logradouro não pode ser nulo!");
        checkArgument(!logradouro.isEmpty(), "Logradouro não pode estar vazio!");
        checkArgument(logradouro.length() > TAM_MIN_LOGRADOURO, "Logradouro não pode conter menos de 5 caracteres!");
        checkArgument(logradouro.length() < TAM_MAX_LOGRADOURO, "Logradouro não pode conter mais de 80 caracteres!");
        
    }

    /**
     *
     * Verifica o bairro, se preenchido e se respeita as ordem preestabelecidas
     * de preenchimento
     *
     * @param bairro
     */
    public void validaBairro(String bairro) {
        this.verificaSePreenchidoBairro(bairro);
    }

    /**
     * Verifica se preenchido bairro.
     *
     * @param bairro the bairro
     */
    public void verificaSePreenchidoBairro(String bairro) {
        checkNotNull(bairro, "Bairro não pode ser nulo!");
        checkArgument(!bairro.isEmpty(), "O bairro não pode estar vazio!");
        checkArgument(bairro.length() > TAM_MIN_BAIRRO, "O bairro não pode conter menos de 6 letras!");
        checkArgument(bairro.length() < TAM_MAX_BAIRRO, "O bairro não pode conter mais de 80 letras!");
    }


    /**
     *
     * Verifica o cep, se preenchido e se respeita as ordens preestabelecidas
     *
     * @param cep
     */
    public void validaCep(String cep) {
        this.verificaSePreenchidoCep(cep);
    }

    public void verificaSePreenchidoCep(String cep) {
        checkNotNull(cep, "Cep não pode estar nulo!");
        checkArgument(!cep.isEmpty(), "Cep não pode estar vazio!");
        checkArgument(cep.length() == TAM_MAX_CEP, "O cep não pode ter um valor de dígitos diferente de 9!");
    }

    /**
     *
     * Verifica a cidade, se preenchida e se respeita as ordens preestabelecidas
     *
     * @param cidade
     */
    public void validaCidade(String cidade) {
        this.verificaSePreenchidaCidade(cidade);
    }

    public void verificaSePreenchidaCidade(String cidade) {
        checkNotNull(cidade, "A cidade não pode estar nula!");
        checkArgument(!cidade.isEmpty(), "A cidade não pode estar vazia!");
        checkArgument(cidade.length() > TAM_MIN_CIDADE, "A cidade não pode conter menos do que 6 letras!");
        checkArgument(cidade.length() < TAM_MAX_CIDADE, "A cidade não pode conter mais do que 30 caracteres!");
    }

    /**
     * Verifica o estado, assim como seu preenchimento e as regras
     * preestabelecidas
     *
     * @param estado
     */
    public void validaEstado(String estado) {
        this.verificaSePreenchidoEstado(estado);
    }

    public void verificaSePreenchidoEstado(String estado) {
        checkNotNull(estado, "O estado não pode ser nulo!");
        checkArgument(!estado.isEmpty(), "O estado não pode estar vazio!");
        checkArgument(estado.length() == TAM_ESTADO, "O estado não pode ter mais que 2 letras!");
    }

    /**
     *
     * Verifica o pais, assim como seu preenchimento e as regras
     * preestabelecidas
     *
     * @param pais
     */
    public void validaPais(String pais) {
        this.verificaSePreenchidoPais(pais);
    }

    public void verificaSePreenchidoPais(String pais) {
        checkNotNull(pais, "O país não pode estar nulo!");
        checkArgument(!pais.isEmpty(), "O país não pode ser vzaio!");
        checkArgument(pais.length() > TAM_MIN_PAIS, "O país deve conter mais de 5 letras!");
        checkArgument(pais.length() < TAM_MAX_PAIS, "O país deve conter no máximo 20 letras!");
    }

    /**
     *
     * Verifica se o numero esta preenchido, assim como as regras
     * preestabelecidas
     *
     * @param numero
     */
    public void validaNumero(int numero) {
        this.verificaSePreenchidoNumero(numero);
    }

    /**
     *
     * Verifica se o numero foi preenchido
     *
     * @param numero
     */
    public void verificaSePreenchidoNumero(Integer numero) {
        checkArgument(numero != 0, "O número não pode ser 0!");
        checkArgument(!numero.toString().isEmpty(), "Você deve preencher um número");
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
        return new ToStringBuilder(this, MyStyle.MY_STYLE)
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
