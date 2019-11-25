/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpractica_colas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Nicole
 */
public class ExamenPractica_Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Conjunto de mensajes en una cola 
        Queue <Email> emails = new LinkedList <Email> ();
        
        Email mensaje1 = new Email ("nicole@espol.edu.ec", "danielanicole@espol.edu.ec", 1, "adios");
        Email mensaje2 = new Email ("nicole@hotmail.com", "eduardo.com", 3, "chao");
        Email mensaje3 = new Email ("eduardo@hotmail.com", "daniela@hotmail.com", 6, "bye");
        Email mensaje4 = new Email ("edison@hotmail.com", "ivi@hotmail.com", 4, "tarea");

        emails.add(mensaje1);
        emails.add(mensaje2);
        emails.add(mensaje3);
        emails.add(mensaje4);
        System.out.println(emails); 
        
        
        Map <String, Integer> filtroSpam = new HashMap<>();
        filtroSpam.put("publicidad.com", 1);
        filtroSpam.put("ads.org", 5);
        filtroSpam.put("ads.com", 3);
        System.out.println(filtroSpam); 
        
        distribuirMail(emails, filtroSpam); 
        
        
    }
    
    public static Map<String, ArrayList<LinkedList<Email>>> distribuirMail(Queue<Email> emails, Map<String, Integer> filtrospam) {
        Map <String, Integer> organizarBandeja = new HashMap<>();
        PriorityQueue <Email> colaImportancia = new PriorityQueue <>((o1,o2)->
        {
            if (o1.getImportancia()==o2.getImportancia()) {
                return 0;
            } else if  (o1.getImportancia()<o2.getImportancia()) {
                return 1;
            }else {
                return -1;
            }
        });
        while(!emails.isEmpty()){
            Email mail = emails.poll();
            System.out.println(mail); 
            colaImportancia.add(mail);
            
        }
        System.out.println(colaImportancia); 
        return null;
        
    }
}
