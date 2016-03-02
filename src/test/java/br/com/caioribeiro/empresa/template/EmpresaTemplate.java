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
            add("razaoSocial", regex("\\w{20}"));
            add("nomeFantasia", regex("\\w{20}"));
            add("emails", has(3).of(Email.class, "valid"));
            add("dataDeCadastro", randomDate("2011-04-15", "2016-17-02", new SimpleDateFormat("yyyy-MM-dd")));
        }});        
        Fixture.of(Endereco.class).addTemplate("valid", new Rule(){{
            add("bairro", regex("\\w{20}"));
            add("cep", regex("\\d\\d\\d\\d\\d-\\d\\d\\d"));
            add("cidade", "São Paulo");
            add("estado", "SP");
            add("logradouro", regex("\\w{20}"));
            add("numero", regex("\\d{1,5}"));
            add("pais", "Brasil");
            add("EnderecoType", random(EnderecoType.COMERCIAL, EnderecoType.RESIDENCIAL));
        }});
        Fixture.of(Telefone.class).addTemplate("valid", new Rule(){{
        	add("telefone", regex("\\[2-5]{1}\\d{3}\\-\\d{4}"));
        	add("ddd", random(Integer.class, range(11, 99)));
        	add("tipo", random(TelefoneType.COMERCIAL, TelefoneType.FAX));
        }});        
        Fixture.of(Email.class).addTemplate("valid", new Rule(){{
            add("userName", random("empresa@gmail.com", "nomefantasia@uol.com.br", "novaempresa@hotmail.com"));
        }});
        Fixture.of(Telefone.class).addTemplate("celular", new Rule(){{
        	add("telefone", regex("(\\[9])(\\d{4})-(\\d{4})"));
        	add("ddd", random(Integer.class, range(11, 99)));
        	add("tipo", TelefoneType.CELULAR);
        }});
	}	
}
