package libreria.servicios;

import java.util.UUID;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorService {

     private AutorDAO autorDAO;

    public AutorService() {
        autorDAO = new AutorDAO();

    }

    public Autor creaautor(String nombre) {
        Autor autornuevo = new Autor();
        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del autor");
            }
            autornuevo.setNombre(nombre);
            autornuevo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            autornuevo.setAlta(Boolean.TRUE);
            autorDAO.guardarAutor(autornuevo);

            return autornuevo;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void eliminarautor(String nombre) {

        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del autor");
            }
            autorDAO.eliminarPorNombre(nombre);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void modificarautor(String nombre, String nuevonombre) {
        Autor aux = null;
        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del autor");
            }
            if (nuevonombre == null || nuevonombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del autor");
            }
            aux = autorDAO.buscarPorNombre(nombre);
            aux.setNombre(nuevonombre);
            autorDAO.modificarAutor(aux);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
    public Autor buscaAutor(String nombre){
        
        Autor buscado = null;
        
        try
        {
            if (nombre == null || nombre.trim().isEmpty())
            {
                throw new Exception("Debe indicar el nombre del Autor");
            }
            
            buscado = autorDAO.buscarPorNombre(nombre);
            
            return buscado;
            
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
                
    }

}