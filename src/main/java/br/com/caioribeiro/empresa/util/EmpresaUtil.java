package br.com.caioribeiro.empresa.util;

public final class EmpresaUtil {
    public static boolean validCnpj(String cnpj) {
        int cont, r, numero, peso;
        
        //Define o calculo do CNPJ
        cont = 0;
        peso = 2;
        
        for(int i = 11; i >= 0 ;i--){
            numero = (int) (cnpj.charAt(i) - 48);
            cont = cont + (numero * peso);
            peso = peso++;
            if (peso == 10){
                peso = 2;
            }
            
            r = cont % 11;
            
            
        }
        return true;
    }           
    
    public static boolean isNumber(String telefone) {
        char c[] = telefone.toCharArray();      
        for(int i = 0; i < c.length; i++){
            if(!Character.isDigit(c[i])){
                return false;
            }
        }
        return true;
    }
}
