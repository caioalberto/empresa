/******************************************************************************
 * Produto: Connect Cont                                                      *
 * Contmatic Phoenix © Desde 1986                                             *
 * Tecnologia em Softwares de Gestão Contábil, Empresarial e ERP              *
 * Todos os direitos reservados.                                              *
 *                                                                            *
 *                                                                            *
 *    Histórico:                                                              *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  24/02/2016  Caio Ribeiro         Classe criada.                   *
 *                                                                            *
 *   Comentários:                                                             *
 *                                                                            *
 *                                                                            *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 * @author Caio Ribeiro
 *
 */
public class Email {

    //Variaveis e constantes----------------------------------------------------------------------------------------------------------

    /**
     * Define o tamanho minimo do username do email.
     */
    private static final int TAMANHO_MINIMO_USERNAME = 6;

    /**
     * Define o tamanho maximo do username do email.
     */
    private static final int TAMANHO_MAXIMO_USERNAME = 15;

    /**
     * Define o tamanho minimo do dominio do email.
     */
    private static final int TAMANHO_MINIMO_DOMINIO = 9;

    /**
     * Define o tamanho maximo do username do email.
     */
    private static final int TAMANHO_MAXIMO_DOMINIO = 15;

    /**
     * Define o username do email.
     */
    private String userName;

    /**
     *  Define o dominio do email.
     */
    private String dominio;

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
     *
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
        this.validarUserName(userName);
        this.userName = userName;
    }
    
    /**
     * Seta o atributo dominio.
     *
     * @param dominio novo valor de dominio
     */
    public void setDominio(String dominio) {
        this.validarDominio(dominio);
        this.dominio = dominio;
    }

    //Metodos de Verificacao----------------------------------------------------------------------------------------------------------

    /**
     * Validar user name.
     *
     * @param userName the user name
     */
    public void validarUserName(String userName) {
        this.verificaSeNuloOuVazioUserName(userName);
        this.verificaTamMinUserName(userName);
        this.verificaTamMaxUserName(userName);        
    }

    /**
     * Verifica se nulo ou vazio user name.
     *
     * @param userName the user name
     */
    public void verificaSeNuloOuVazioUserName(String userName) {
        checkNotNull(userName, "O Nome de Usuário não pode ser nulo!");
        checkArgument(userName.length() != 0, "O Nome de Usuário não pode ser vazio!");
    }

    /**
     * Verifica tam min user name.
     *
     * @param userName the user name
     */
    public void verificaTamMinUserName(String userName) {
        checkArgument(userName.length() > TAMANHO_MINIMO_USERNAME, "O Nome de Usuário deve conter pelo menos 6 caracteres!");
    }

    /**
     * Verifica tam max user name.
     *
     * @param userName the user name
     */
    public void verificaTamMaxUserName(String userName) {
        checkArgument(userName.length() < TAMANHO_MAXIMO_USERNAME, "O Nome de Usuário deve conter no máximo 15 caracteres!");
    }

    /**
     * Validar dominio.
     *
     * @param dominio the dominio
     */
    public void validarDominio(String dominio) {
        this.verificaSeNuloOuVazioUserName(dominio);
        this.verificaTamMinUserName(dominio);
        this.verificaTamMaxDominio(dominio);        
    }

    /**
     * Verifica se nulo ou vazio dominio.
     *
     * @param dominio the dominio
     */
    public void verificaSeNuloOuVazioDominio(String dominio) {
        checkNotNull(dominio, "O domínio não pode ser nulo!");
        checkArgument(dominio.length() != 0, "O domínio não pode ser vazio!");
    }

    /**
     * Verifica tam min dominio.
     *
     * @param dominio the dominio
     */
    public void verificaTamMinDominio(String dominio) {
        checkArgument(dominio.length() > TAMANHO_MINIMO_DOMINIO, "O Domínio deve conter pelo menos 9 caracteres!");
    }

    /**
     * Verifica tam max dominio.
     *
     * @param dominio the dominio
     */
    public void verificaTamMaxDominio(String dominio) {
        checkArgument(dominio.length() < TAMANHO_MAXIMO_DOMINIO, "O Domínio deve conter no máximo 15 caracteres!");
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
