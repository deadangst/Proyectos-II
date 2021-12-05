package AccesoDatos;

import Entidades.*;
import Entidades.Excepciones.*;
import java.util.List;

public interface ITiendaData {

    String insertar(Tienda tienda) throws TiendaExcepcion, Exception;

    String actualizar(Tienda tienda) throws TiendaExcepcion, Exception;

    String eliminar(Tienda tienda) throws TiendaExcepcion, Exception;

    List<Tienda> consultarTodasLasVentas() throws TiendaExcepcion, Exception;
}
