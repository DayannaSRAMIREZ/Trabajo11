import java.io.*;

public class Exepciones {
    public static void main(String[] args) {

        //Intentar abrir un archivo para lectura que no exista. Atrapar la excepción.
        try {
            FileInputStream fileIn = new FileInputStream("archivoInxistente.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No Existe el archivo");
        }

        //Escribir a un archivo después de haber hecho close. Atrapar la excepción.
        try {
            FileWriter fileWriter = new FileWriter ("src/archivosTxt/archivo.txt");
            fileWriter.close();
            fileWriter.write("HOLA COMO ESTAS");
        } catch (IOException e) {
            System.out.println("Ya cerraste el archivo");
        }

    }
}
