package br.com.caioribeiro.empresa;

import static org.apache.commons.lang3.StringUtils.isNumeric;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.caioribeiro.empresa.stringbuilder.MyTelephoneStyle;

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
    @NotBlank(message="O telefone não pode estar vazio!")
    @Size(max=9, min=8, message="O telefone não pode ter menos de {min} dígitos e mais de {max} dígitos!")    
    private String telefone;

    /**
     * Define o tipo de telefone da classe. Se fixo, celular, fax etc.
     */
    @Valid
    private TipoTelefone tipo;

    /**
     * Define o DDD do telefone, sempre com apenas dois numeros.
     */
    @NotBlank(message="O DDD não pode estar vazio!")
    @Size(max=2, min=2, message="O DDD não pode ter tamanho diferente de {max}!")
    private String ddd;

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
    public String getDdd() {
        return ddd;
    }

    /**
     * Seta o atributo telefone.
     *
     * @param telefone novo valor de telefone
     */
    public void setTelefone(String telefone) {
        isNumeric(telefone);
        this.telefone = telefone;
    }

    /**
     * Seta o atributo ddd.
     *
     * @param ddd novo valor de ddd
     */
    public void setDdd(String ddd) {
        isNumeric(ddd);
        this.ddd = ddd;
    }

    /**
     * Seta o atributo tipo.
     *
     * @param tipo novo valor de tipo
     */
    public void setTipo(TipoTelefone tipo) {
        //this.validaTipo(tipo);
        this.tipo = tipo;
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
