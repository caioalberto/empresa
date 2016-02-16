package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * Classe Telefone, define a criacao de um objeto do tipo telefone, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public final class  Telefone {

//Variaveis e constantes------------------------------------------------------------------------ 
    /**
     * Define o numero de telefone da classe.
     */
    private String telefone;

    /**
     * Define o tipo de telefone da classe. Se fixo, celular, fax etc.
     */
    private String tipo;

    /**
     * Define o DDD do telefone, sempre com apenas dois numeros.
     */
    private int ddd;

    /**
     * Define o tamanho minimo da constante telefone.
     */
    private static final int TAM_MIN_TELEFONE = 8;

    /**
     * Define o tamanho maximo da constante telefone.
     */
    private static final int TAM_MAX_TELEFONE = 9;

    /**
     * Define o tamanho do DDD.
     */
    private static final int TAM_DDD = 2;

    /**
     * Define o tamanho minimo do tipo do telefone.
     */
    private static final int TAM_MIN_TIPO = 3;

    /**
     * Define o tamanho maximo do tipo de telefone.
     */
    private static final int TAM_MAX_TIPO = 7;

//Getters e Setters-----------------------------------------------------------------------------------------
    public String getTelefone() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDdd() {
        return ddd;
    }

    public void setTelefone(String telefone) {
        this.validaTelefone(telefone);
        this.telefone = telefone;
    }

    public void setDdd(int ddd) {
        this.validaDdd(ddd);
        this.ddd = ddd;
    }

    public void setTipo(String tipo) {
        this.validaTipo(tipo);
        this.tipo = tipo;
    }

//Metodos de validacao-------------------------------------------------------------------
    
    /**
     *
     * Valida o preenchimento do telefone, assim como as regras preestabelecidas
     *
     * @param telefone
     */
    public void validaTelefone(String telefone) {
        this.verificaSeNulo(telefone);
        checkArgument(this.verificaSeEhNumero(telefone)==true,"Você deve inserir apenas números!");
        this.verificaTamMinTel(telefone);
        this.verificaTamMaxTel(telefone);
    }

    public void verificaSeNulo(String telefone) {
        checkNotNull(telefone, "O telefone não pode ser nulo!");
    }

    public void verificaTamMinTel(String telefone) {
        checkArgument(telefone.length() >= TAM_MIN_TELEFONE, "O telefone não deve conter menos do que 8 caracteres!");
    }

    public void verificaTamMaxTel(String telefone) {
        checkArgument(telefone.length() <= TAM_MAX_TELEFONE, "O telefone não deve conter mais do que 9 caracteres!");
    }
    
    public boolean verificaSeEhNumero(String telefone) {
		boolean aceito = true;
		char c[] = telefone.toCharArray();		
		for(int i = 0; i < c.length; i++){
			if(!Character.isDigit(c[i])){
				aceito = false;
				break;
			}
		}
		
    	return aceito;
    }

    /**
     *
     * Verifica se o DDD foi preenchido corretamente, assim como as regras
     * preestabelecidas
     *
     * @param ddd
     */
    public void validaDdd(int ddd) {
        this.verificaSePreenchidoDdd(ddd);
    }

    public void verificaSePreenchidoDdd(int ddd) {
        checkArgument(ddd != TAM_DDD, "O DDD deve ter apenas 2 dígitos!");
    }

    /**
     *
     * Verifica se o tipo foi preenchido, e as regras preestabelecidas
     *
     * @param tipo
     */
    public void validaTipo(String tipo) {
        this.verificaSePreenchidoTipo(tipo);
        this.verificaTamMinTipo(tipo);
        this.verificaTamMaxTipo(tipo);
    }

    public void verificaSePreenchidoTipo(String tipo) {
        checkNotNull(tipo, "O tipo não pode ser nulo!");
    }

    public void verificaTamMinTipo(String tipo) {
        checkArgument(tipo.length() > TAM_MIN_TIPO, "O tipo não pode ser menor que 3!");
    }

    public void verificaTamMaxTipo(String tipo) {
        checkArgument(tipo.length() < TAM_MAX_TIPO, "O tipo não pode ser maior que 7!");
    }

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.tipo).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone)){
			return false;			
		}
		Telefone other = (Telefone) obj;
		return new EqualsBuilder().append(this.tipo, other.tipo).isEquals();
	}

	@Override
    public String toString() {
        return "Telefone " + tipo + ": " + ddd + " " + telefone;
    }
}
