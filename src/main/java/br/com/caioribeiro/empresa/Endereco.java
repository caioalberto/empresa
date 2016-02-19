package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import br.com.caioribeiro.empresa.stringbuilder.*;

import com.google.common.base.Preconditions;

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
    private int numero;
    
    /**
     * 
     * Define o tipo do endereco, se residencial/comercial.
     */
    private String tipoEndereco;

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
    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setLogradouro(String logradouro) {
        this.validaLogradouro(logradouro);
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.validaBairro(bairro);
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.validaCep(cep);
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.validaCidade(cidade);
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.validaEstado(estado);
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.validaPais(pais);
        this.pais = pais;
    }

    public void setNumero(int numero) {
        this.validaNumero(numero);
        this.numero = numero;
    }
    
	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

 //Metodos de validacao-------------------------------------------------------------------
    
    /**
     *
     * Verifica o logradouro, se preenchido e se respeita as ordem
     * preestabelecidas de preenchimento
     *
     * @param logradouro
     */
    public void validaLogradouro(String logradouro) {
        this.verificaSePreenchido(logradouro);
        this.verificaTamMin(logradouro);
        this.verificaTamMax(logradouro);
    }

    public void verificaSePreenchido(String logradouro) {
        checkNotNull(logradouro, "Logradouro não pode estar vazio/nulo!");
    }

    public void verificaTamMin(String logradouro) {
        checkArgument(logradouro.length() > TAM_MIN_LOGRADOURO, "Logradouro não pode conter menos de 4 caracteres!");
    }

    public void verificaTamMax(String logradouro) {
        Preconditions.checkArgument(logradouro.length() < TAM_MAX_LOGRADOURO, "Logradouro não pode conter menos de 80 caracteres!");
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
        this.verificaTamMinBairro(bairro);
        this.verificaTamMaxBairro(bairro);
    }

    public void verificaSePreenchidoBairro(String bairro) {
        checkNotNull(bairro, "Bairro não pode estar vazio/nulo!");
    }

    public void verificaTamMinBairro(String bairro) {
        checkArgument(bairro.length() > TAM_MIN_BAIRRO, "O bairro não pode conter menos de 6 letras!");
    }

    public void verificaTamMaxBairro(String bairro) {
        Preconditions.checkArgument(bairro.length() < TAM_MAX_BAIRRO, "O bairro não pode conter mais de 80 letras!");
    }

    /**
     *
     * Verifica o cep, se preenchido e se respeita as ordens preestabelecidas
     *
     * @param cep
     */
    public void validaCep(String cep) {
        this.verificaSePreenchidoCep(cep);
        this.verificaTamCep(cep);
    }

    public void verificaSePreenchidoCep(String cep) {
        checkNotNull(cep, "Cep não pode estar vazio/nulo!");
    }

    public void verificaTamCep(String cep) {
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
        this.verificaTamMinCidade(cidade);
        this.verificaTamMaxCidade(cidade);
    }

    public void verificaSePreenchidaCidade(String cidade) {
        checkNotNull(cidade, "A cidade não pode estar vazia/nula!");
    }

    public void verificaTamMinCidade(String cidade) {
        checkArgument(cidade.length() > TAM_MIN_CIDADE, "A cidade não pode conter menos do que 6 letras!");
    }

    public void verificaTamMaxCidade(String cidade) {
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
        this.verificaTamanhoEstado(estado);
    }

    public void verificaSePreenchidoEstado(String estado) {
        checkNotNull(estado, "O estado não pode ser nulo/vazio!");
    }

    public void verificaTamanhoEstado(String estado) {
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
        this.verificaTamMinPais(pais);
        this.verificaTamMaxPais(pais);
    }

    public void verificaSePreenchidoPais(String pais) {
        checkNotNull(pais, "O país não pode estar vazio/nulo!");
    }

    public void verificaTamMinPais(String pais) {
        checkArgument(pais.length() > TAM_MIN_PAIS, "O país deve conter mais de 5 letras!");
    }

    public void verificaTamMaxPais(String pais) {
        checkArgument(pais.length() < TAM_MAX_PAIS, "O país deve conter no máximo 20 letras!");
    }

    /**
     *
     * Verifica se o numero estÃ¡ preenchido, assim como as regras
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
    public void verificaSePreenchidoNumero(int numero) {
        checkArgument(numero != 0, "O nÃºmero nÃ£o pode ser 0!");
    }

    @Override
    public int hashCode() {
    	return new HashCodeBuilder().append(this.cep).toHashCode();
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)){
			return false;			
		}
		Endereco other = (Endereco) obj;
		return new EqualsBuilder().append(this.cep, other.cep).isEquals();
	}
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
