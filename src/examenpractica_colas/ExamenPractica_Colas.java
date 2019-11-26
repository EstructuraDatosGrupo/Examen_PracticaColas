/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpractica_colas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * //Como sacamos los valores del mapa en orden de menor riesgo ? Con una PriorityQueue
 * // Una forma de iterar sobre un mapa con for each 
        //filtrospam.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
        Iterator it = filtroSpam.entrySet().iterator();
	ArrayList listaClaves = new ArrayList();
	while (it.hasNext()){
	    Map.Entry entrada = (Map.Entry)it.next();
	    listaClaves.add(entrada.getKey());
	}
        Collections.sort(listaClaves);
        System.out.println(listaClaves); 
        
        //Otra forma de iterar sobre un mapa 
        for (Map.Entry<String, Integer> entry : filtroSpam.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
 */
public class ExamenPractica_Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Conjunto de mensajes en una cola 
        Queue <Email> emails = new LinkedList <Email> ();
        
        Email mensaje1 = new Email ("nicole@espol.edu.ec", "daniela@hotmail.com", 1, "adios");
        Email mensaje2 = new Email ("nicole@hotmail.com", "daniela@hotmail.com", 3, "chao");
        Email mensaje3 = new Email ("eduardo@hotmail.com", "daniela@hotmail.com", 6, "bye");
        Email mensaje4 = new Email ("edison@hotmail.com", "daniela@hotmail.com", 4, "tarea");

        emails.add(mensaje1);
        emails.add(mensaje2);
        emails.add(mensaje3);
        emails.add(mensaje4);
        System.out.println("emails " + emails); 
        
        
        Map <String, Integer> filtroSpam = new HashMap<>();
        filtroSpam.put("publicidad.com", 1);
        filtroSpam.put("ads.org", 5);
        filtroSpam.put("ads.com", 3);
        System.out.println("filtroSpam " + filtroSpam); 
        System.out.println("-----"); 
        System.out.println(distribuirMail(emails, filtroSpam)); 
        
    }
    
    public static Map<String, ArrayList<LinkedList<Email>>> distribuirMail(Queue<Email> emails, Map<String, Integer> filtroSpam) {
        Map<String, ArrayList<LinkedList<Email>>> organizarBandeja = new HashMap<>();
        String correo;
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
            colaImportancia.add(mail);
        }
        Email m = colaImportancia.peek();
        correo= m.getDestinatario();
        
        //LinkedList de bandeja de entrada
        LinkedList<Email> bandejaEntrada = new LinkedList<> ();
        while(!colaImportancia.isEmpty()){
            bandejaEntrada.add(colaImportancia.poll());
        }
       
        //LinkedList de bandeja de spam 
        LinkedList<Email> bandejaSpam = new LinkedList<> ();
        
        ArrayList <LinkedList<Email>> lista = new ArrayList<>();
        lista.add(bandejaEntrada);
        lista.add(bandejaSpam);
        organizarBandeja.put(correo, lista);
        return organizarBandeja;
        
    }
}
