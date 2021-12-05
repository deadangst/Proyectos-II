package AccesoDatos;

import Entidades.*;
import Entidades.Excepciones.*;
import java.util.List;

public interface ICategoriaData {

    String insertar(Categoria categoria) throws CategoriaExcepcion, Exception;
    String eliminar(Categoria categoria) throws CategoriaExcepcion, Exception;

    List<Categoria> consultarTodasLasCategorias() throws CategoriaExcepcion, Exception;
}
