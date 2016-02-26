package br.com.caioribeiro.empresa;

import java.util.*;

import org.junit.Test;

public class EmailTest {
    
    private Email email;  
    private Set<Email> emails = new HashSet<>();
    
    @Test
    public void teste(){
        //email.setUserName("novousuario");
        email.setDominio("@gmail.com");
        System.out.println(emails);
        
        Iterator<Email> it = emails.iterator();
        while(it.hasNext()) {
            Object email = it.next();
            System.out.println(email);
        }
    }
    
    
    
}
