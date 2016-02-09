package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Calendar;
import java.util.Date;

public class Empresa {

	private Endereco endereco;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Date dataDeCadastro;
	
	private static final Date DATA_ATUAL = new Date();

	public Endereco getEndereco() {
		return endereco;
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

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	 * Verifica se a data de cadastro é menor/maior que a data atual
	 * @param dataDeCadastro
	 */
	public void validaDataCadastro(Date dataDeCadastro) {
		this.verificaSeMenorQueAtual(dataDeCadastro);
		this.verificaSeMaiorQueAtual(dataDeCadastro);
	}
	
	public void verificaSeMenorQueAtual(Date dataDeCadastro) {
		this.zerarData(dataDeCadastro);
		checkArgument(dataDeCadastro.before(DATA_ATUAL),"A data de cadastro não pode ser anterior a data atual!");		
	}
	
	public void verificaSeMaiorQueAtual(Date dataDeCadastro) {
		this.zerarData(dataDeCadastro);
		checkArgument(dataDeCadastro.after(DATA_ATUAL),"A data de cadastro não pode ser posterior a data atual!");
	}
	
	public void zerarData(Date dataDeCadastro) {		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataDeCadastro);
		calendar.set(Calendar.HOUR_OF_DAY, 0); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}
}
