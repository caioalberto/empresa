package br.com.caioribeiro.empresa.template;

import java.text.SimpleDateFormat;

import br.com.caioribeiro.empresa.*;
import br.com.six2six.fixturefactory.*;
import br.com.six2six.fixturefactory.loader.TemplateLoader;


public class EmpresaTemplate implements TemplateLoader {

	@Override
	public void load() {
        Fixture.of(Empresa.class).addTemplate("valid", new Rule(){{
            add("enderecos", has(2).of(Endereco.class, "valid"));
            add("telefones", has(4).of(Telefone.class, "valid"));
            add("cnpj", cnpj());
            add("razaoSocial", random("Razão Social LTDA.", "Nova Empresa SA", "Teste de Empresa ME"));
            add("nomeFantasia", random("Restaurante do João", "Escola da Maria", "Indústria de Alimentos da Carla"));
            add("email", random("empresa@gmail.com", "testedeemail@gmail.com", "empresa@empresa.com.br"));
            add("dataDeCadastro", randomDate("2011-04-15", "2016-17-02", new SimpleDateFormat("yyyy-MM-dd")));
        }});
        		
        Fixture.of(Endereco.class).addTemplate("valid", new Rule(){{
        	add("logradouro", random("Rua das Laranjeiras", "Avenida da Paz", "Viela Cardoso", "Travessa Santos", "Rodovia Presidente Dutra"));
        	add("bairro", random("Tatuapé", "Centro", "Vila Mariana", "Jardins", "Belém"));
        	add("cep", random("07097171", "07457850", "12345678", "74185236"));
        	add("cidade", random("São Paulo", "Guarulhos", "Suzano", "Santos"));
        	add("estado", "SP");
        	add("pais", "Brasil");
        	add("numero", regex("\\d{1,3}"));
        }});
        
        Fixture.of(Telefone.class).addTemplate("valid", new Rule(){{
        	add("telefone", regex("\\d{8}"));
        	add("ddd", regex("\\d{2}"));
        	add("tipo", random("Fixo", "Comercial", "Residencial", "Celular"));
        }});
	}	

		
}
