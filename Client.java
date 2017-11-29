package clientstr;

import java.io.*;
import java.net.*;
public class ClientStr {
  String nomeServer = "localhost";                                         
  int portaServer =5002;                                                  
  Socket mioSocket;
  BufferedReader tastiera;                                               
  String stringaUtente;                                                  
  String stringaRicevutaDalServer;                                      
  DataOutputStream outVersoServer;
  BufferedReader inDalServer;

public void comunica() {
  try
  {
System.out.println("4 ... inserisci la stringa da trasmettere al server:"+'\n');
   stringaUtente = tastiera.readLine();
   
   System.out.println("5 ... invio la stringa al server e attendo ...");
   outVersoServer.writeBytes( stringaUtente+'\n');
   
   stringaRicevutaDalServer=inDalServer.readLine();
System.out.println("8 ... risposta del server "+'\n'+stringaRicevutaDalServer );
   
   System.out.println("9 CLIENT: termina elaborazione e chiude connessione");
   mioSocket.close();
 }
catch (Exception e)
{
 System.out.println(e.getMessage());
 System.out.println("Errore durante la comunicazione col server!");
 System.exit(1);
}
}

public Socket connetti () {
 System.out.println ("2 CLIENT partito in esecuzione ...");

 try
 {
  tastiera = new BufferedReader(new InputStreamReader(System.in));

  mioSocket = new Socket(nomeServer, portaServer);

  //miosocket = new Socket(InetAddress.getLocalHost(), 6789);
 outVersoServer = new DataOutputStream(mioSocket.getOutputStream());

inDalServer = new BufferedReader(new InputStreamReader (mioSocket.getInputStream()));
 }
catch (UnknownHostException e) {
System.err.println ("Host sconosciuto"); }
catch (Exception e)
{
System.out.println(e.getMessage());
System.out.println("Errore durante la connessione!");
System.exit(1);
}

return mioSocket;

}


public static void main(String args[]) {
 ClientStr cliente = new ClientStr();
 cliente.connetti();
 cliente.comunica();
}
}
