package serializable.coladebanco;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Persona persona1= new Persona(34739771, "Alan", 28);
        Persona persona2= new Persona(32514744,"Maria", 32);
        Persona persona3= new Persona(3252122, "Pedro", 61);

        Deque<Persona> miLista= new LinkedList<>();
        ColaDeBanco cola1= new ColaDeBanco(miLista);

        miLista.add(persona1);
        miLista.add(persona2);
        miLista.add(persona3);

        Persona persona4= new Persona(3472584, "Lucia", 33);
        cola1.agregarPersona(persona4);
        System.out.println(cola1.atender());
        System.out.println(miLista);

        /*Escritura de objetos en fichero*/

        try {
            ObjectOutputStream serializador= new ObjectOutputStream(new FileOutputStream(new File("mifichero.bin")));

            serializador.writeObject(persona1);
            serializador.writeObject(persona2);
            serializador.writeObject(persona3);
            serializador.writeObject(persona4);
            serializador.writeObject(cola1);
            serializador.flush();
            serializador.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*Lectura de objetos en fichero*/

        try {
            ObjectInputStream deserializador= new ObjectInputStream(new FileInputStream (new File("mifichero.bin")));
            Persona personaNueva1= (Persona) deserializador.readObject();
            System.out.println(personaNueva1);
            Persona personaNueva2= (Persona) deserializador.readObject();
            System.out.println(personaNueva2);
            Persona personaNueva3= (Persona) deserializador.readObject();
            System.out.println(personaNueva3);
            Persona personaNueva4= (Persona) deserializador.readObject();
            System.out.println(personaNueva4);
            ColaDeBanco nuevaCola=(ColaDeBanco) deserializador.readObject();
            System.out.println(nuevaCola.personasList);
            deserializador.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
