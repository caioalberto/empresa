package br.com.caioribeiro.empresa;

import static br.com.caioribeiro.empresa.util.EmpresaUtil.isNumber;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.caioribeiro.empresa.stringbuilder.MyTelephoneStyle;
import br.com.caioribeiro.empresa.util.EmpresaUtil;
import br.com.caioribeiro.empresa.util.ValidadorUtil;

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
    private TipoTelefone tipo;

    /**
     * Define o DDD do telefone, sempre com apenas dois numeros.
     */
    private Integer ddd;

    /**
     * Define o tamanho minimo da constante telefone.
     */
    private static final int TAM_MIN_TELEFONE = 8;

    /**
     * Define o tamanho maximo da constante telefone.
     */
    private static final int TAM_MAX_TELEFONE = 9;

    /**
     * Define o tamanho minimo do DDD.
     */
    private static final int TAM_DDD = 2;

//Getters e Setters-----------------------------------------------------------------------------------------
    /**
     * Gets the telefone.
     *
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TipoTelefone getTipo() {
        return tipo;
    }

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public Integer getDdd() {
        return ddd;
    }

    /**
     * Seta o atributo telefone.
     *
     * @param telefone novo valor de telefone
     */
    public void setTelefone(String telefone) {
        this.validaTelefone(telefone);
        this.telefone = telefone;
    }

    /**
     * Seta o atributo ddd.
     *
     * @param ddd novo valor de ddd
     */
    public void setDdd(Integer ddd) {
        this.validaDdd(ddd);
        this.ddd = ddd;
    }

    /**
     * Seta o atributo tipo.
     *
     * @param tipo novo valor de tipo
     */
    public void setTipo(TipoTelefone tipo) {
        this.validaTipo(tipo);
        this.tipo = tipo;
    }

//Metodos de validacao-------------------------------------------------------------------
    
    /**
 * Valida o preenchimento do telefone, assim como as regras preestabelecidas.
 *
 * @param telefone the telefone
 */
    public void validaTelefone(String telefone) {
        this.verificaSeNuloOuVazio(telefone);
        checkArgument(isNumber(telefone),"Você deve inserir apenas números!");
        checkArgument(telefone.length() >= TAM_MIN_TELEFONE, "O telefone não deve conter menos do que 8 caracteres!");
        checkArgument(telefone.length() <= TAM_MAX_TELEFONE, "O telefone não deve conter mais do que 9 caracteres!");
    }

    /**
     * Verifica se nulo.
     *
     * @param telefone the telefone
     */
    public void verificaSeNuloOuVazio(String telefone) {
        checkNotNull(telefone, "O telefone não pode ser nulo!");
        checkArgument(!telefone.isEmpty(),"O telefone não pode estar vazio!");
    }
    
    /**
     * Verifica se o DDD foi preenchido corretamente, assim como as regras
     * preestabelecidas.
     *
     * @param ddd the ddd
     */
    public void validaDdd(Integer ddd) {
        this.verificaSePreenchidoDdd(ddd);
    }

    /**
     * Verifica se preenchido ddd.
     *
     * @param ddd the ddd
     */
    public void verificaSePreenchidoDdd(Integer ddd) {
    	checkArgument(ddd != 00, "O DDD não pode ser 0!");     
    	int compair;
    	compair = ddd.toString().length();
    	checkArgument(compair == TAM_DDD, "O DDD deve ser 2!");
    }
    
    /**
     * Verifica se o tipo foi preenchido, e as regras preestabelecidas.
     *
     * @param tipo the tipo
     */
    public void validaTipo(TipoTelefone tipo) {
        this.verificaSePreenchidoTipo(tipo);
    }

    /**
     * Verifica se preenchido tipo.
     *
     * @param tipo the tipo
     */
    public void verificaSePreenchidoTipo(TipoTelefone tipo) {
        checkNotNull(tipo, "O tipo não pode ser nulo!");
    }

  //Equals, HashCode e toString---------------------------------------------------------------------------------------------------   
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.tipo).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone)){
			return false;			
		}
		Telefone other = (Telefone) obj;
		return new EqualsBuilder().append(this.tipo, other.tipo).isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return new ToStringBuilder(this, MyTelephoneStyle.MY_TELEPHONE_STYLE)
                .append(this.ddd)
                .append(this.telefone)
                .append(this.tipo).toString();
    }
	
}
