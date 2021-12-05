package Negocio;

import java.util.List;
import AccesoDatos.IInventarioData;
import AccesoDatos.InventarioData;
import Entidades.Inventario;
import Entidades.Excepciones.InventarioExcepcion;

public class InventarioNegocio {

    private final IInventarioData inventarioData;

    public InventarioNegocio() {
        inventarioData = new InventarioData();
    }

    public List<Inventario> consultarTodosLosProductos() throws InventarioExcepcion, Exception {

        return inventarioData.consultarTodosLosProductos();
    }

    public String insertar(Inventario inventario) throws InventarioExcepcion, Exception {
        return inventarioData.insertar(inventario);
    }

    public String eliminar(Inventario inventario) throws InventarioExcepcion, Exception {
        return inventarioData.eliminar(inventario);
    }

    public String actualizar(Inventario inventario) throws InventarioExcepcion, Exception {
        return inventarioData.actualizar(inventario);
    }
}
