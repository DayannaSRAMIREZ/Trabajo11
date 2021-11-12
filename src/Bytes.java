import java.io.*;
import java.nio.charset.StandardCharsets;

public class Bytes {
    public static void main(String[] args) {

        /*
        Crear un archivo para escribir bytes con FileOutputStream.
        Crear un string con un texto y pasarlo a array de bytes con getBytes(). Escribir los bytes.
         Verificar que se escribió.
         */

        try {
            FileOutputStream fileOut = new FileOutputStream("src/archivosTxt/miarchivo.txt");
            String miFrase = "Creando archivos";
            byte[] miArray = miFrase.getBytes(StandardCharsets.UTF_8);
            fileOut.write(miArray);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*Crear un archivo para escribir bytes. Envolverlo con un DataOutputStream.
         Escribir varios valores usando writeFloat, writeDouble, writeBoolean, etc…
         Verificar que se escribió pero no son valores de texto.*/
        try {
            DataOutputStream entrada = new DataOutputStream(new FileOutputStream("src/archivosTxt/otroarchivo.txt"));
            entrada.writeBoolean(true);
            entrada.writeDouble(200.3d);
            entrada.writeFloat(2.00f);
            entrada.writeInt(2000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Abrir el mismo archivo para leer bytes. Envolverlo con un DataInputStream.
        Hacer reads en el mismo orden que los writes. Verificar que se leen los mismos valores.*/
        try {
            DataInputStream dataInputStream= new DataInputStream(new FileInputStream("src/archivosTxt/otroarchivo.txt"));
            boolean b= dataInputStream.readBoolean();
            System.out.println(b);
            double d= dataInputStream.readDouble();
            System.out.println(d);
            float f= dataInputStream.readFloat();
            System.out.println(f);
            int i= dataInputStream.readInt();
            System.out.println(i);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
