package br.com.caioribeiro.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmailTest.class, EmpresaTest.class, EnderecoTest.class, TelefoneTest.class })
public class AllTests {

}
