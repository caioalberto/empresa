package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * Classe Empresa, define a criacao de um objeto do tipo empresa, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public class Empresa {

//Variaveis e Constantes-------------------------------------------------------------------------------------   
    /**
     *
     * Define uma lista de Enderecos, para armazenar os enderecos de uma empresa
     * caso haja mais de um.
     */
    private List<Endereco> enderecos;

    /**
     *
     * Define uma lista de Telefones, para armazenar os telefones de uma
     * empresa.
     */
    private List<Telefone> telefones;

    /**
     *
     * Define o CNPJ de uma empresa.
     */
    private String cnpj;

    /**
     *
     * Define a razao social de uma empresa.
     */
    private String razaoSocial;

    /**
     *
     * Define o nome fantasia de uma empresa.
     */
    private String nomeFantasia;

    /**
     *
     * Define uma lista de Strings que armazena os emails da empresa.
     */
    private List<String> emails;

    /**
     *
     * Define a data de cadastro de uma empresa dentro do objeto.
     */
    private Date dataDeCadastro;

//Getters e Setters------------------------------------------------------------------------------------------        
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public List<String> getEmail() {
        return emails;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setEndereco(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setTelefone(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setEmail(List<String> emails) {
        this.emails = emails;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.validaDataCadastro(dataDeCadastro);
        this.dataDeCadastro = dataDeCadastro;
    }
    
  //Metodos de validacao-------------------------------------------------------------------
    
    /**
     *
     * Metodo para a verificacao e validacao da data de cadastro da roda.
     *
     * @param dataCadastro
     */
    public void validaDataCadastro(Date dataDeCadastro) {
        this.verificaDataNula(dataDeCadastro);
        this.verificaSeAntesQueAtual(dataDeCadastro);
        this.verificaSeDepoisQueAtual(dataDeCadastro);
    }

    private static Date zerarHoras(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public void verificaDataNula(Date dataDeCadastro) {
        checkNotNull(dataDeCadastro, "Não é possível criar um objeto com data nula!");
    }

    public void verificaSeAntesQueAtual(Date dataDeCadastro) {
        Date dataAtual = new Date();
        Date dataAtualZerada = zerarHoras(dataAtual);
        Date dataCadastroZerada = zerarHoras(dataDeCadastro);
        checkArgument(!dataCadastroZerada.before(dataAtualZerada), "Não é possível criar um objeto com uma data anterior a atual!");
    }

    public void verificaSeDepoisQueAtual(Date dataDeCadastro) {
        Date dataAtual = new Date();
        Date dataAtualZerada = zerarHoras(dataAtual);
        Date dataCadastroZerada = zerarHoras(dataDeCadastro);
        checkArgument(!dataCadastroZerada.after(dataAtualZerada), "Não é possível criar um objeto com uma data posterior a atual!");
    }

    @Override
    public int hashCode() {
    	return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Empresa)){
			return false;			
		}
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
	}

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Empresa: " + nomeFantasia + "\n" + "Razão Social: " + razaoSocial + " CNPJ: " + cnpj + "\n" + "Data de abertura: " + sdf.format(dataDeCadastro);
    }
}
