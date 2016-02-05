package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.common.base.Preconditions;

public class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String pais;
	private int numero;
	private static final int TAM_MIN_LOGRADOURO = 5;
	private static final int TAM_MAX_LOGRADOURO = 80;
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCep() {
		return cep;
	}
	public String getCidade() {
		return cidade;
	}
	public String getPais() {
		return pais;
	}
	public int getNumero() {
		return numero;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * 
	 * Verifica o logradouro, se preenchido e se respeita as ordem preestabelecidas de preenchimento
	 * @param logradouro
	 */
	public void validaLogradouro(String logradouro) {
		this.verificaSePreenchido(logradouro);
		this.verificaTamMin(logradouro);
	}
	
	public void verificaSePreenchido(String logradouro) {
		checkArgument(!isNullOrEmpty(logradouro), "Logradouro não pode estar vazio!");
	}
	
	public void verificaTamMin(String logradouro) {
		checkArgument(logradouro.length() > TAM_MIN_LOGRADOURO,"Logradouro não pode ter menos de 4 caracteres!");
	}
	
	public void verificaTamMax (String logradouro) {
		Preconditions.checkArgument(logradouro.length() < TAM_MAX_LOGRADOURO, "Logradouro não pode ter menos de 80 caracteres!");
	}
}
