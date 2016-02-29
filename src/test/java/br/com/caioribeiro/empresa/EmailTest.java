package br.com.caioribeiro.empresa;

import java.util.*;

import org.junit.Test;

public class EmailTest {
    
    private Email email;  
    
    @Test
    public void teste(){
        email.setDominio("@teste.com.br");
        email.setUserName("usuarioteste");
        email.toString();
        }
    }
    
    
    

