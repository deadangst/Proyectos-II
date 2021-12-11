package AccesoDatos;

import Entidades.Excepciones.TiendaExcepcion;
import Entidades.Tienda;
import java.util.ArrayList;
import java.util.List;

public class TiendaData implements ITiendaData {

    @Override
    public String insertar(Tienda tienda) throws TiendaExcepcion, Exception {

        String lineaTienda = creaLineaTienda(tienda);
        boolean inserta = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_CARRITO, lineaTienda);
        if (inserta) {
            return tienda.getNombre();
        }
        return "Error";
    }

    @Override
    public String actualizar(Tienda tienda) throws TiendaExcepcion, Exception {
        String lineaProducto = creaLineaTienda(tienda);
        boolean actualizar = false;
        actualizar = UtilidadesArchivos.actualizar(UtilidadesArchivos.ARCHIVO_CARRITO, tienda.getCodigo(), lineaProducto);
        if (actualizar) {
            return tienda.getCodigo();
        }

        return "Error";
    }

    @Override
    public String eliminar(Tienda tienda) throws TiendaExcepcion, Exception {
        boolean eliminar = UtilidadesArchivos.eliminar(UtilidadesArchivos.ARCHIVO_CARRITO, tienda.getCodigo());
        if (eliminar) {
            return tienda.getCodigo();
        }
        return "Error";
    }

    @Override
    public List<Tienda> consultarTodasLasVentas() throws TiendaExcepcion, Exception {
        List<Tienda> listaCarrito = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_CARRITO);
        for (String listaLinea : listaLineas) {
            Tienda productoTemporal = mapeaLineaCarrito(listaLinea);
            listaCarrito.add(productoTemporal);
        }

        return listaCarrito;
    }

    private Tienda mapeaLineaCarrito(String lineaLinea) {
        Tienda tienda = new Tienda();
        String[] datosTienda = lineaLinea.split(UtilidadesArchivos.TOKEN);
        tienda.setCodigo(datosTienda[0]);
        tienda.setNombre(datosTienda[1]);
        tienda.setPrecio(Double.parseDouble(datosTienda[2]));
        tienda.setCantidad(Integer.parseInt(datosTienda[3]));
        tienda.setTotal(Double.parseDouble(datosTienda[4]));
        tienda.setCategoría(datosTienda[5]);
        return tienda;
    }

    private String creaLineaTienda(Tienda tienda) {
        StringBuilder lineaTienda = new StringBuilder();
        lineaTienda.append(tienda.getCodigo()).append(UtilidadesArchivos.TOKEN);
        lineaTienda.append(tienda.getNombre()).append(UtilidadesArchivos.TOKEN);
        lineaTienda.append(tienda.getPrecio()).append(UtilidadesArchivos.TOKEN);
        lineaTienda.append(tienda.getCantidad()).append(UtilidadesArchivos.TOKEN);
        lineaTienda.append(tienda.getTotal()).append(UtilidadesArchivos.TOKEN);
        lineaTienda.append(tienda.getCategoría()).append(UtilidadesArchivos.TOKEN);
        return lineaTienda.toString();
    }

}
