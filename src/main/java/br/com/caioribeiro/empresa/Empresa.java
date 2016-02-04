package br.com.caioribeiro.empresa;

import com.google.common.base.Preconditions;

public class Empresa {

	private String endereço;
	public static final int VALOR_MINIMO_DE_CARACTERES_ENDERECO = 50;
	public static final int VALOR_MAXIMO_DE_CARACTERES_ENDERECO = 500;

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.validaEndereco(endereco);
		this.endereço = endereço;
	}

	/**
	 * 
	 * Método recebe um parâmetro de endereço, para validar o mesmo de acordo
	 * com as regras preestabelecidas: O endereço deve ser obrigatoriamente preenchido
	 * e deve conter no mínimo o valor de caracteres definido na constante.
	 * @param endereco
	 */
	public void validaEndereco(String endereco){
		this.verificaSePreencheu(endereco);
		this.verificaValorDeCaracteres(endereco);
	}
	
	public void verificaSePreencheu(String endereco){
		Preconditions.checkArgument(endereco.length() > VALOR_MINIMO_DE_CARACTERES_ENDERECO, "Você deve preencher o endereço com o valor mínimo de 50 caracteres!");		
	}
}
