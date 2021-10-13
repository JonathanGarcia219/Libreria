
package libreria.servicios;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialService {
   private EditorialDAO editorialDAO;

    public EditorialService() {
        editorialDAO = new EditorialDAO();

    }

    public Editorial creaEditorial(String nombre) {
        Editorial editorialnuevo = new Editorial();
        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del editorial");
            }
            editorialnuevo.setNombre(nombre);
            editorialnuevo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            editorialnuevo.setAlta(Boolean.TRUE);
            editorialDAO.guardarEditorial(editorialnuevo);

            return editorialnuevo;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void eliminarEditorial(String nombre) {

        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del editorial");
            }
            editorialDAO.eliminarPorNombre(nombre);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void modificarEditorial(String nombre, String nuevonombre) {
        Editorial aux = null;
        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre de la Editorial");
            }
            if (nuevonombre == null || nuevonombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre de la Editorial");
            }
            aux = editorialDAO.buscarPorNombre(nombre);
            aux.setNombre(nuevonombre);
            editorialDAO.modificarEditorial(aux);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public List<Editorial> buscaTodo() {
        List<Editorial> buscado = null;

        try
        {

            buscado = editorialDAO.listarTodos();

            return buscado;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }
}