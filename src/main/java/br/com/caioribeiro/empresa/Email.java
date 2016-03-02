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
    @org.hibernate.validator.constraints.Email(regexp="xxxxx@xxx.xxx")
    private String userName;

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
     * Seta o atributo user name.
     *
     * @param userName novo valor de user name
     */
    public void setUserName(String userName) {
        //this.validarUserName(userName);
        this.userName = userName;
    }
    
    //Equals, HashCode e toString---------------------------------------------------------------------------------------------------       
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, MyStyle.MY_STYLE)
                .append(this.getUserName() != null ? this.getUserName() : "O username não pode estar vazio!").toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.userName).toHashCode();
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
        return new EqualsBuilder().append(this.userName, ohter.userName).isEquals();
    }

}
