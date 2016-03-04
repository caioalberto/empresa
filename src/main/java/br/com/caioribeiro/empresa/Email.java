package br.com.caioribeiro.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.beanvalidation.tck.tests.xmlconfiguration.constraintdefinition.Length;
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
    @NotBlank(message = "O Nome do usuário não pode ser nulo!")
    @Length(min = 6, max = 15, message = "O Nome de Usuário deve conter entre {min} e {max}!")
    @org.hibernate.validator.constraints.Email(regexp = "\\@\\.com")
    private String enderecoDeEmail;

    // Getters and Setters-------------------------------------------------------------------------------------------------------------
    /**
     * Gets the endereco de email.
     *
     * @return the endereco de email
     */
    public String getEnderecoDeEmail() {
        return enderecoDeEmail;
    }

    /**
     * Seta o atributo user name.
     *
     * @param userName novo valor de user name
     */
    public void setEnderecoDeEmail(String enderecoDeEmail) {
        this.enderecoDeEmail = enderecoDeEmail;
    }

    // Equals, HashCode e toString---------------------------------------------------------------------------------------------------
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, MyStyle.MY_STYLE).append(this.enderecoDeEmail != null ? this.enderecoDeEmail : null).toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enderecoDeEmail).toHashCode();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Email)) {
            return false;
        }
        Email ohter = (Email) obj;
        return new EqualsBuilder().append(enderecoDeEmail, ohter.enderecoDeEmail).isEquals();
    }

}
