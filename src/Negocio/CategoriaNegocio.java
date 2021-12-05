
package Negocio;
import AccesoDatos.CategoriaData;
import AccesoDatos.ICategoriaData;
import Entidades.Categoria;
import Entidades.Excepciones.CategoriaExcepcion;
import java.util.List;

public class CategoriaNegocio {
    private final ICategoriaData categoriaData;

    public CategoriaNegocio() {
        
        categoriaData = new CategoriaData();
    }
    
    public List<Categoria> consultarTodasLasCategorias() throws CategoriaExcepcion, Exception{
    
        return categoriaData.consultarTodasLasCategorias();
    }
    
    public String insertar (Categoria categoria) throws CategoriaExcepcion, Exception{
    return categoriaData.insertar(categoria);
    }
    
        public String eliminar (Categoria categoria) throws CategoriaExcepcion, Exception{
    return categoriaData.eliminar(categoria);
    }
}
