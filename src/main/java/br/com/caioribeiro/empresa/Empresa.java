package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Empresa {

	private Endereco endereco;
	private List<Telefone> telefones;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String email;
	private Date dataDeCadastro;
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public List<Telefone> getTelefones(){
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
	
	public String getEmail() {
		return email;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}	
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.validaDataCadastro(dataDeCadastro);
		this.dataDeCadastro = dataDeCadastro;
	}

	/**
	 * 
	 * Método para a verificação e validação da data de cadastro da roda.
	 * @param dataCadastro
	 */
	public void validaDataCadastro(Date dataDeCadastro) {
		this.verificaDataNula(dataDeCadastro);
		this.verificaSeAntesQueAtual(dataDeCadastro);
		this.verificaSeDepoisQueAtual(dataDeCadastro);
	}
	
    private static Date zerarHoras(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
	
	public void verificaDataNula(Date dataDeCadastro) {
		checkNotNull(dataDeCadastro,"Não é possível criar um objeto com data nula!");
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
		checkArgument(!dataCadastroZerada.after(dataAtualZerada), "Não é possível criar um objeto com uma data posterior a atual!" );
	}
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Empresa && ((Empresa)obj).getCnpj().equals(this.getCnpj())){
			return true;			
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Empresa: " + nomeFantasia + "\n" + "Razão Social: " + razaoSocial + " CNPJ: " + cnpj + "\n" + "Data de abertura: " + sdf.format(dataDeCadastro);
	}
}
