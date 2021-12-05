package AccesoDatos;

import Entidades.*;
import Entidades.Excepciones.*;
import java.util.List;

public interface IInventarioData {

    String insertar(Inventario inventario) throws InventarioExcepcion, Exception;
    String eliminar(Inventario inventario) throws InventarioExcepcion, Exception;
    String actualizar(Inventario inventario) throws InventarioExcepcion, Exception;

    List<Inventario> consultarTodosLosProductos() throws InventarioExcepcion, Exception;
}
