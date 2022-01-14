import java.io.*;

public class MainApp {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Faltan argumentos");
            System.exit(0);
        }

        String fileName = args[0]; // Toma el nombre de la primera posicion de argumentos

        //InputStreamReader inputStreamReader = new InputStreamReader();

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName); //intenta buscar el archivo por el nombre del que nosotros mandamos
        } catch (FileNotFoundException e){
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(fileReader); //

        String textLine = null;
        int contador =0;
        //in.readLine();//lee el archivo y cuando llega al final, devuelve null
        while (true){
            try {
                if (!((textLine = in.readLine()) != null))//Sirve para detectar si el archivo tiene lineas de texto
                break;// cierra el ciclo while
            } catch (IOException e) {
                System.out.println("Error al leer el nombre de entrada");
                System.exit(2);
            }
            contador++; //contador para contar las lineas del archivo de texto
        }

        try {
            in.close(); //cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo "+ fileName+" tiene "+contador+ " lineas");



    }

}
