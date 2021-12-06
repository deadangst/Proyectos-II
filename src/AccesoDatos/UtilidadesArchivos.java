
package AccesoDatos;

import java.io.*;
import java.util.ArrayList;

public class UtilidadesArchivos {

    public static final String ARCHIVO_PRODUCTOS = "C:\\archivos\\productos.txt";
    public static final String ARCHIVO_CATEGORIA = "C:\\archivos\\categoria.txt";    
    public static final String ARCHIVO_USUARIOSTIENDA = "C:\\archivos\\usuariostienda.txt";
    public static final String ARCHIVO_HISTORICO = "C:\\archivos\\historico.txt";
    public static final String ARCHIVO_CARRITO = "C:\\archivos\\carrito.txt";
    public static final String ARCHIVO_LOGINTIENDA = "C:\\archivos\\logintienda.txt";
    
    
    public static final String TOKEN = ";";

    public static boolean grabaArchivo(String nombreArchivo, String linea) throws Exception {
        FileWriter fichero = null;
        PrintWriter printWriter = null;
        try {

            ArrayList<String> archivoEnLineas = arregloArchivo(nombreArchivo);
            archivoEnLineas.add(linea);
            fichero = new FileWriter(nombreArchivo);
            printWriter = new PrintWriter(fichero);
            printWriter.println(arrayToString(archivoEnLineas));

        } catch (IOException exception) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
        return true;
    }

    private static String arrayToString(ArrayList<String> lineas) {
        StringBuilder builder = new StringBuilder();
        for (String linea : lineas) {
            builder.append(linea + "\n");
        }
        return builder.toString();
    }

    public static ArrayList<String> arregloArchivo(String nombreArchivo) throws Exception {
        ArrayList<String> lineas = new ArrayList<>();
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {

                if (linea.length() > 0) {
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }

    public static String buscarEnArchivo(String nombreArchivo, String criterio) {

        File archivo = null;
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                // exception.printStackTrace();
            }
        } else {

            try {
                archivo = new File(nombreArchivo);
                fileReader = new FileReader(archivo);
                bufferReader = new BufferedReader(fileReader);

                String linea;
                while ((linea = bufferReader.readLine()) != null) {
                    if (isBuscarEnlinea(criterio, linea)) {
                        return linea;
                    }
                }
            } catch (Exception exception) {
                // exception.printStackTrace();
            } finally {
                try {
                    if (null != fileReader) {
                        fileReader.close();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;

    }

    private static boolean isBuscarEnlinea(String criterio, String linea) {
        boolean bandera = false;
        String[] array = linea.split(";");
        for (String temporal : array) {
            if (criterio.trim().equals(temporal.trim())) {
                bandera = true;
                return bandera;
            }
        }
        return bandera;
    }

    private static String buscarEnlinea(String criterio, String linea) {
        String[] array = linea.split(";");
        for (String temporal : array) {
            if (criterio.trim().equals(temporal.trim())) {
                return temporal;
            }
        }
        return "";
    }

    public static boolean eliminar(String nombreArchivo, String criterio) throws Exception {
        FileWriter fichero = null;
        PrintWriter printWriter = null;
        try {
            String borrar = "";
            ArrayList<String> archivoEnLineas = arregloArchivo(nombreArchivo);
            for (String lineaTemporal : archivoEnLineas) {
                if (isBuscarEnlinea(criterio, lineaTemporal)) {
                    borrar = lineaTemporal;
                }
            }
            archivoEnLineas.remove(borrar);
            fichero = new FileWriter(nombreArchivo);
            printWriter = new PrintWriter(fichero);
            printWriter.println(arrayToString(archivoEnLineas));

        } catch (IOException exception) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
        return true;
    }

    public static boolean actualizar(String nombreArchivo, String criterio, String linea) throws Exception {
        FileWriter fichero = null;
        PrintWriter printWriter = null;
        try {
            String borrar = "";
            ArrayList<String> archivoEnLineas = arregloArchivo(nombreArchivo);
            for (String lineaTemporal : archivoEnLineas) {
                if (isBuscarEnlinea(criterio, lineaTemporal)) {
                    borrar = lineaTemporal;
                }
            }
            archivoEnLineas.remove(borrar);
            archivoEnLineas.add(linea);
            fichero = new FileWriter(nombreArchivo);
            printWriter = new PrintWriter(fichero);
            printWriter.println(arrayToString(archivoEnLineas));

        } catch (IOException exception) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
        return true;
    }
}