package servertcpstr;
import java.io.*;
import java.net.*;
import java.util.*;


public class ServerTcpStr {  
  ServerSocket server      = null;
  Socket client            = null;
  String stringaRicevuta   = null;
  String stringaModificata = null;  
  BufferedReader inDalClient;
  DataOutputStream outVersoClient;

    public static void main(String[] args) {


  ServerTcpStr servente = new ServerTcpStr();
  servente.attendi();
  servente.comunica();
}
    
public Socket attendi(ServerSocket server, Socket client, BufferedReader inDalClient, DataOutputStream outVersoClient)
{
  try
  {
   System.out.println("1 SERVER partito in esecuzione...");
   server = new ServerSocket(6789);
   client = server.accept();
   server.close();
inDalClient= new BufferedReader(new InputStreamReader(client.getInputStream()));
   outVersoClient = new DataOutputStream(client.getOutputStream());
  }

catch (IOException e)
{
 System.out.println(e.getMessage());
 System.out.println("Errore durante l'istanza del server!");
 System.exit(1);
}
return client;
}

public void comunica ()
{
 try
 {
  System.out.println("3 Benvenuto client, scrivi una frase e la trasformo in "
          + "maiuscolo. Attendo...");
  System.out.println("6 Ricevuta la stringa dal cliente:" + stringaRicevuta);
 
  stringaModificata=stringaRicevuta.toUpperCase();
  System.out.println("7 Invio la stringa modificata al client...");
  outVersoClient.writeBytes(stringaModificata+'\n');
  
  System.out.println("9 SERVER: fine elaborazione ... buona notte!");
  client.close();
 }
 catch(IOException e){}
}
     // Copia del metodo attendi
    private Socket attendi() {
        try
  {
   System.out.println("1 SERVER partito in esecuzione...");
   server = new ServerSocket(6789);                                             //porta 
   client = server.accept();
   server.close();
inDalClient= new BufferedReader(new InputStreamReader(client.getInputStream()));
   outVersoClient = new DataOutputStream(client.getOutputStream());
  } 

catch (IOException e)
{
 System.out.println(e.getMessage());
 System.out.println("Errore durante l'istanza del server!");
 System.exit(1);
}
return client;
    }
  } 