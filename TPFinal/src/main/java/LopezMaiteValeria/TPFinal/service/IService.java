package LopezMaiteValeria.TPFinal.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IService<T> {
    void crear(T t);
    T buscar(Integer id);
    Set<T> buscarTodos();
    void actualizar(T t);
    void eliminar(Integer id);


}
