import java.io.*;
import java.util.Scanner;

public class PrintScanner {
    public static void main(String[] args) {
        /* Crear un archivo de texto para escribir y envolverlo con un PrintWriter. Imprimir varias lineas al archivo usando println.*/

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/archivosTxt/Segundo.txt"));
            printWriter.println("HOLA COMO ESTAS");
            printWriter.println("El dia esta gris");
            printWriter.println("HOLA COMO ESTAS");
            printWriter.println("El dia esta gris");
            printWriter.println("HOLA COMO ESTAS");
            printWriter.println("El dia esta gris");
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Abrir el mismo archivo para leer y envolverlo con un Scanner. Leer todas las lineas del archivo usando nextLine().
        Construir un string con el contenido del archivo usando StringBuilder y a la vez mostrar la cantidad de lineas del archivo.*/

        try {
            Scanner scanner = new Scanner(new FileReader("src/archivosTxt/Segundo.txt"));
            int canLineas = 0;
            StringBuilder builder = new StringBuilder();

            while (true) {
                if (!scanner.hasNext()) break;
                builder.append(scanner.nextLine());
                builder.append("\n");
                canLineas++;
            }
            scanner.close();
            System.out.println("La cantidad de lineas es: "+canLineas);
            String texto= builder.toString();
            System.out.println("El texto es: \n"+ texto);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
