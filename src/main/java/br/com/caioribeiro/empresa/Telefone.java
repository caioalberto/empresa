package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Telefone {
	
	private String telefone;
	private String tipo;
	private int ddd;
	
	private static final int TAM_MIN_TELEFONE = 8;
	private static final int TAM_MAX_TELEFONE = 9;
	private static final int TAM_DDD = 2;
	private static final int TAM_MIN_TIPO = 3;
	private static final int TAM_MAX_TIPO = 7;

	public String getTelefone() {
		return telefone;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getDdd() {
		return ddd;
	}
	
	public void setTelefone(String telefone) {
		this.validaTelefone(telefone);
		this.telefone = telefone;
	}
	
	public void setDdd(int ddd) {
		this.validaDdd(ddd);
		this.ddd = ddd;
	}
	
	public void setTipo(String tipo) {
		this.validaTipo(tipo);
		this.tipo = tipo;
	}
	
	/**
	 * 
	 * Valida o preenchimento do telefone, assim como as regras preestabelecidas
	 * @param telefone
	 */
	public void validaTelefone(String telefone) {
		this.verificaSeNulo(telefone);
		this.verificaTamMinTel(telefone);
		this.verificaTamMaxTel(telefone);
	}
	
	public void verificaSeNulo(String telefone) {
		checkNotNull(telefone, "O telefone não pode ser nulo!");
	}
	
	public void verificaTamMinTel(String telefone) {
		checkArgument(telefone.length() >= TAM_MIN_TELEFONE, "O telefone não deve conter menos do que 8 caracteres!");
	}
	
	public void verificaTamMaxTel(String telefone) {
		checkArgument(telefone.length() <= TAM_MAX_TELEFONE, "O telefone não deve conter mais do que 9 caracteres!");
	}
	
	/**
	 * 
	 * Verifica se o DDD foi preenchido corretamente, assim como as regras preestabelecidas
	 * @param ddd
	 */
	public void validaDdd(int ddd) {
		this.verificaSePreenchidoDdd(ddd);
	}
	
	public void verificaSePreenchidoDdd(int ddd){
		checkArgument(ddd != TAM_DDD, "O DDD deve ter apenas 2 dígitos!");
	}
	
	/**
	 * 
	 * Verifica se o tipo foi preenchido, e as regras preestabelecidas
	 * @param tipo
	 */
	public void validaTipo(String tipo) {
		this.verificaSePreenchidoTipo(tipo);
		this.verificaTamMinTipo(tipo);
		this.verificaTamMaxTipo(tipo);
	}
	
	public void verificaSePreenchidoTipo(String tipo) {
		checkNotNull(tipo, "O tipo não pode ser nulo!");
	}
	
	public void verificaTamMinTipo(String tipo) {
		checkArgument(tipo.length() > TAM_MIN_TIPO, "O tipo não pode ser menor que 3!");
	}
	
	public void verificaTamMaxTipo(String tipo) {
		checkArgument(tipo.length() < TAM_MAX_TIPO, "O tipo não pode ser maior que 7!");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Telefone && ((Telefone) obj).getTelefone().equals(this.getTelefone())){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Telefone " + tipo + ": " + ddd + " " + telefone;
	}
}
