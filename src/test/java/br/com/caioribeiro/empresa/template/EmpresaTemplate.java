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
            add("cnpj", cnpj(true));
            add("razaoSocial", random("Razão Social LTDA.", "Nova Empresa SA", "Teste de Empresa ME"));
            add("nomeFantasia", random("Restaurante do João", "Escola da Maria", "Indústria de Alimentos da Carla"));
            add("emails", has(3).of(Email.class, "valid"));
            add("dataDeCadastro", randomDate("2011-04-15", "2016-17-02", new SimpleDateFormat("yyyy-MM-dd")));
        }});        
        Fixture.of(Endereco.class).addTemplate("valid", new Rule(){{
            add("bairro", random("Tatuapé", "Vila Carrão", "Penha"));
            add("cep", regex("\\d\\d\\d\\d\\d-\\d\\d\\d"));
            add("cidade", "São Paulo");
            add("estado", "SP");
            add("logradouro", random("Rua da Penha", "Teste de Rua", "Avenida da Paz"));
            add("numero", regex("\\b([1-9]{1,5})"));
            add("pais", "Brasil");
            add("tipoEndereco", random(TipoEndereco.COMERCIAL, TipoEndereco.RESIDENCIAL));
        }});
        Fixture.of(Telefone.class).addTemplate("valid", new Rule(){{
        	add("telefone", regex("\\(^[2-5]{1})\\([0-9]{3})\\[-]\\([0-9]{4}$)"));
        	add("ddd", regex("\\b([1-9]{2}?)"));
        	add("tipo", random(TipoTelefone.COMERCIAL, TipoTelefone.FAX));
        }});        
        Fixture.of(Email.class).addTemplate("valid", new Rule(){{
            add("userName", random("empresa@gmail.com", "nomefantasia@uol.com.br", "novaempresa@hotmail.com"));
            add("dominio", random("@gmail.com", "@uol.com.br", "@hotmail.com", "@bol.com.br", "@teste.com"));
        }});
        Fixture.of(Telefone.class).addTemplate("celular", new Rule(){{
        	add("telefone", regex("\\(^[9]{1})\\([4-9]{1}\\)([0-9]{3})\\[-]\\([0-9]{4}$)"));
        	add("ddd", regex("\\b([1-9]{2}?)"));
        	add("tipo", random(TipoTelefone.CELULAR));
        }});
	}	
}
