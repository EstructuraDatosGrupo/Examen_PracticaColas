package examenpractica_colas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicole
 */
public class Email implements Comparable{
    private String remitente;
    private String destinatario;
    private int importancia;
    private String mensaje;

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Email(String remitente, String destinatario, int importancia, String mensaje) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.importancia = importancia;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Email{" + "remitente=" + remitente + ", destinatario=" + destinatario + ", importancia=" + importancia + ", mensaje=" + mensaje + '}';
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
