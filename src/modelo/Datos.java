package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Datos implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "datos.dat";

    public static void guardarDatos(List<?> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<?> cargarDatos() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}