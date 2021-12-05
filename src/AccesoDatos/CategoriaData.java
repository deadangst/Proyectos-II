package AccesoDatos;

import Entidades.Categoria;
import Entidades.Excepciones.CategoriaExcepcion;
import java.util.ArrayList;
import java.util.List;

public class CategoriaData implements ICategoriaData {

    @Override
    public String insertar(Categoria categoria) throws CategoriaExcepcion, Exception {

        String lineaCategoria = creaLineaCategoria(categoria);
        boolean inserta = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_CATEGORIA, lineaCategoria);
        if (inserta) {
            return categoria.getCategoria();
        }
        return "Error";
    }

    @Override
    public String eliminar(Categoria categoria) throws CategoriaExcepcion, Exception {
        boolean eliminar = UtilidadesArchivos.eliminar(UtilidadesArchivos.ARCHIVO_CATEGORIA, categoria.getCategoria());
        if (eliminar) {
            return categoria.getCategoria();
        }
        return "Error";
    }

    @Override
    public List<Categoria> consultarTodasLasCategorias() throws CategoriaExcepcion, Exception {
        List<Categoria> listaCategorias = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_CATEGORIA);
        for (String listaLinea : listaLineas) {
            Categoria categoriaTemporal = mapeaLineaCategorias(listaLinea);
            listaCategorias.add(categoriaTemporal);
        }

        return listaCategorias;
    }

    private Categoria mapeaLineaCategorias(String lineaLinea) {
        Categoria categoria = new Categoria();
        String[] datosCategoria = lineaLinea.split(UtilidadesArchivos.TOKEN);
        categoria.setCategoria(datosCategoria[0]);
        return categoria;
    }

    private String creaLineaCategoria(Categoria categoria) {
        StringBuilder lineaCategoria = new StringBuilder();
        lineaCategoria.append(categoria.getCategoria()).append(UtilidadesArchivos.TOKEN);

        return lineaCategoria.toString();

    }

}
