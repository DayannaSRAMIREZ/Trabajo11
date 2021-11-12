package serializable.coladebanco;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/*
 - agregar(persona) que si la persona no está en la cola, la agrega.
 - atender(persona) que devuelve la persona de la cabecera de la cola y la elimina de la cola
Luego, queremos que las personas mayores de 60 tengan prioridad para ser atendidas.
Modificar la clase para usar Deque y que el metodo agregar, agregue las personas mayores de 60 al principio de la cola.
*/
public class ColaDeBanco implements Serializable {
    Deque<Persona> personasList = new LinkedList<>();

    public ColaDeBanco(Deque<Persona> personasList) {
        this.personasList = personasList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    public Deque<Persona> agregarPersona(Persona persona) {
        if (!personasList.contains(persona)) {
            if (persona.edad > 60) {
                personasList.addFirst(persona);
            } else {
                personasList.add(persona);
            }
        }
        return personasList;
    }

    public Persona atender() {
        Persona atendida = personasList.element();

        personasList.remove(personasList.element());
        return atendida;

    }
}
