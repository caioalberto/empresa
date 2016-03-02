package br.com.caioribeiro.empresa;

import static org.apache.commons.lang3.StringUtils.isNumeric;

import java.text.SimpleDateFormat;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 *
 * Classe Empresa, define a criacao de um objeto do tipo empresa, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public final class Empresa {

//Variaveis de Atributo-------------------------------------------------------------------------------------                
    /**
     * Define uma lista de Enderecos, para armazenar os enderecos de uma empresa
     * caso haja mais de um.
     */    
    private Set<Endereco> enderecos;

    /**
     * Define uma lista de Telefones, para armazenar os telefones de uma
     * empresa.
     */
    private Set<Telefone> telefones;

    /**
     * Define o CNPJ de uma empresa.
     */   
    @Size(min=14, max=14, message="O CNPJ deve ter {max} dígitos!")
    @NotBlank(message="O CNPJ deve ser preenchido!")
    @CNPJ(formatted=true)
    @Pattern(regexp="XX.XXX.XXX/XXXX-XX", message="O CNPJ deve estar no formato {regexp}")
    private String cnpj;

    /**
     * Define a razao social de uma empresa.
     */
    @NotBlank(message="A Razão Social deve ser preenchida!")
    @Size(min=10, max=80, message="A Razão Social deve ter entre {min} e {max} letras!")
    private String razaoSocial;

    /**
     * Define o nome fantasia de uma empresa.
     */
    @NotBlank(message="O Nome Fantasia deve ser preenchido!")
    @Size(min=10, max=80, message="O Nome Fantasia deve conter mais de {min} e menos de {max} letras!")
    private String nomeFantasia;

    /**
     *
     * Define uma String que armazena o email da empresa.
     */ 
    @NotEmpty(message="A lista de E-mails não pode estar vazia!")
    @NotNull(message="A lista de E-mails não pode estar vazia!")
    @Valid
    private Set<Email> emails;

    /**
     *
     * Define a data de cadastro de uma empresa dentro do objeto.
     */
    @Future(message="A data não pode ser anterior a data atual!")
    @Past(message="A data não pode ser posterior a data atual!")
    @NotNull(message="A data não pode ser nula!")
    private LocalDate dataDeCadastro;
    
    /**
     * 
     * Define a data de alteracao de uma empresa dentro do objeto.
     */
    @Future(message="A data não pode ser anterior a data atual!")
    @Past(message="A data não pode ser posterior a data atual!")
    @NotNull(message="A data não pode ser nula!")
    private LocalDate dataDeAlteracao;

//Getters e Setters------------------------------------------------------------------------------------------        
    /**
     * Gets the enderecos.
     *
     * @return the enderecos
     */
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * Gets the telefones.
     *
     * @return the telefones
     */
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Gets the nome fantasia.
     *
     * @return the nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Gets the emails.
     *
     * @return the emails
     */
    public Set<Email> getEmails() {
        return emails;
    }

    /**
     * Gets the data de cadastro.
     *
     * @return the data de cadastro
     */
    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * Seta o atributo endereco.
     *
     * @param enderecos novo valor de endereco
     */
    public void setEndereco(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * Seta o atributo telefone.
     *
     * @param telefones novo valor de telefone
     */
    public void setTelefone(Set<Telefone> telefones) {        
        this.telefones = telefones;
    }

   /**
     * Seta o atributo cnpj.
     *
     * @param cnpj novo valor de cnpj
     */
    public void setCnpj(String cnpj) {
        isNumeric(cnpj);
        this.cnpj = cnpj;
    }

    /**
     * Seta o atributo razao social.
     *
     * @param razaoSocial novo valor de razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Seta o atributo nome fantasia.
     *
     * @param nomeFantasia novo valor de nome fantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Seta o atributo emails.
     *
     * @param emails novo valor de emails
     */
    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    /**
     * Seta o atributo data de cadastro.
     *
     * @param dataDeCadastro novo valor de data de cadastro
     */
    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
    
    /**
     * Gets the data de alteracao.
     *
     * @return the data de alteracao
     */
    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }
    
    /**
     * Seta o atributo data de alteracao.
     *
     * @param dataDeAlteracao novo valor de data de alteracao
     */
    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }
    	
//hashCode, equals e to String----------------------------------------------------------------------------------------------------    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    	return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Empresa)){
			return false;			
		}
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new ToStringBuilder(this, MyStyle.MY_STYLE)
                .append(this.razaoSocial != null ? this.razaoSocial : "A razão social não pode estar vazia!")
                .append(this.cnpj != null ? "CNPJ: " + this.cnpj : "O CNPJ não pode estar vazio!")
                .append(enderecos != null ? "Endereço: " + enderecos : "O endereço não pode estar vazio!")
                .append(telefones != null ? "Contato: " + telefones : "O telefone não pode estar vazio!")
                .append(emails != null ? emails + "\n" : "O email não pode estar vazio!") 
                .append(this.dataDeCadastro != null ? "Data de Abertura: " + sdf.format(this.dataDeCadastro) : "A data de abertura não pode estar vazia!")
                .append(this.dataDeCadastro != null ? "Data de Alteração: " + sdf.format(this.dataDeAlteracao) : "A data de alteração não pode estar vazia!")
                .toString();
    }
}
