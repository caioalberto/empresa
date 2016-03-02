package br.com.caioribeiro.empresa;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 * @author Caio Ribeiro
 *
 */
public class Email {
    /**
     * Define o username do email.
     */
    @NotBlank(message="O Nome do usuário não pode ser nulo!")
    @Size(min=6, max=15, message="O Nome de Usuário deve conter entre {min} e {max}!")
    private String userName;

    /**
     *  Define o dominio do email.
     */
    @NotBlank(message="O Domínio não pode estar vazio!")
    @Size(min=9, max=15, message="O Nome do Domínio deve conter entre {min} e {max}!")
    private String dominio;
/**
    //Getters and Setters-------------------------------------------------------------------------------------------------------------    
/**    
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Gets the dominio.
     * @return the dominio
     */
    public String getDominio() {
        return dominio;
    }
    
    /**
     * Seta o atributo user name.
     *
     * @param userName novo valor de user name
     */
    public void setUserName(String userName) {
        //this.validarUserName(userName);
        this.userName = userName;
    }
    
    /**
     * Seta o atributo dominio.
     *
     * @param dominio novo valor de dominio
     */
    public void setDominio(String dominio) {
        //this.validarDominio(dominio);
        this.dominio = dominio;
    }

    //Equals, HashCode e toString---------------------------------------------------------------------------------------------------       
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, MyStyle.MY_STYLE)
                .append(this.getUserName()+this.getDominio()).toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.dominio).append(this.userName).toHashCode();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Email)){
            return false;
        }
        Email ohter = (Email) obj;
        return new EqualsBuilder().append(this.userName, ohter.userName).append(this.dominio, ohter.dominio).isEquals();
    }

}
