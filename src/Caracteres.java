import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Caracteres {
    public static void main(String[] args) {
        /*Crear un archivo de texto para escribir caracteres con un FileWriter.
         Escribir “hola” escribiendo carácter por carácter. Hacer flush y cerrarlo. Verificar que se escribió.*/


        char[] miArray = {'H', 'o', 'l', 'a'};
        try {
            escribirArchivo("src/archivosTxt/Hola.txt", miArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Abrir el mismo archivo para leer caracteres con un FileReader. Leer todos los caracteres con un loop hasta
        que devuelva -1. Construir un string con el contenido del archivo usando StringBuilder.*/

        try {
            System.out.println(leerArchivo("src/archivosTxt/Hola.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void crearArchivo(String nombreArchivo) throws IOException {

        FileWriter fileWriter = new FileWriter(nombreArchivo);
        fileWriter.close();
    }

    public static void escribirArchivo(String nombreArchivo, char[] texto) throws IOException {
        FileWriter fileWriter = new FileWriter(nombreArchivo);
        char[] miArray = texto;
        fileWriter.write(miArray);
        fileWriter.flush();//-> FUNCIONA SOLO CON CLOSE PERO LO PONGO IGUAL
        fileWriter.close();


    }

    public static String leerArchivo(String nombreArchivo) throws IOException {

        FileReader fileReader = new FileReader(nombreArchivo);
        StringBuilder constructor = new StringBuilder();
        String palabra = null;
        while (true) {
            int a = fileReader.read();
            if (a == -1) break;
            constructor.append((char) a);
        }
        fileReader.close();
        palabra = constructor.toString();
        return palabra;

    }
}