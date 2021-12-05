package AccesoDatos;

import Entidades.Inventario;
import Entidades.Excepciones.InventarioExcepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InventarioData implements IInventarioData {

    @Override
    public String insertar(Inventario inventario) throws InventarioExcepcion, Exception {
        inventario.setCodigo(CodigoProducto());
        String lineaProducto = creaLineaProducto(inventario);
        boolean inserta = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_PRODUCTOS, lineaProducto);
        if (inserta) {
            return inventario.getCodigo();
        }
        return "Error";
    }

    @Override
    public String eliminar(Inventario inventario) throws InventarioExcepcion, Exception {
        boolean eliminar = UtilidadesArchivos.eliminar(UtilidadesArchivos.ARCHIVO_PRODUCTOS, inventario.getCodigo());
        if (eliminar) {
            return inventario.getCodigo();
        }
        return "Error";
    }

    @Override
    public String actualizar(Inventario inventario) throws InventarioExcepcion, Exception {
        String lineaProducto = creaLineaProducto(inventario);
        boolean actualizar = false;
        actualizar = UtilidadesArchivos.actualizar(UtilidadesArchivos.ARCHIVO_PRODUCTOS, inventario.getCodigo(), lineaProducto);
        if (actualizar) {
            return inventario.getCodigo();
        }

        return "Error";
    }

    @Override
    public List<Inventario> consultarTodosLosProductos() throws InventarioExcepcion, Exception {
        List<Inventario> listaProductos = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_PRODUCTOS);
        for (String listaLinea : listaLineas) {
            Inventario productoTemporal = mapeaLineaProductos(listaLinea);
            listaProductos.add(productoTemporal);
        }

        return listaProductos;
    }

    private Inventario mapeaLineaProductos(String lineaLinea) {
        Inventario producto = new Inventario();
        String[] datosProductos = lineaLinea.split(UtilidadesArchivos.TOKEN);
        producto.setCodigo(datosProductos[0]);
        producto.setNombre(datosProductos[1]);
        producto.setPrecio(Double.parseDouble(datosProductos[2]));
        producto.setCantidad(Integer.parseInt(datosProductos[3]));
        producto.setCategoria(datosProductos[4]);
        return producto;
    }

    private String CodigoProducto() {
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        int numero;
        int forma;
        forma = (int) (aleatorio.nextDouble() * alfa.length() - 1 + 0);
        numero = (int) (aleatorio.nextDouble() * 99 + 100);
        cadena = cadena + alfa.charAt(forma) + numero;
        return cadena;
    }

    private String creaLineaProducto(Inventario producto) {
        StringBuilder lineaProducto = new StringBuilder();
        lineaProducto.append(producto.getCodigo()).append(UtilidadesArchivos.TOKEN);
        lineaProducto.append(producto.getNombre()).append(UtilidadesArchivos.TOKEN);
        lineaProducto.append(producto.getPrecio()).append(UtilidadesArchivos.TOKEN);
        lineaProducto.append(producto.getCantidad()).append(UtilidadesArchivos.TOKEN);
        lineaProducto.append(producto.getCategoria()).append(UtilidadesArchivos.TOKEN);

        return lineaProducto.toString();
    }
}
