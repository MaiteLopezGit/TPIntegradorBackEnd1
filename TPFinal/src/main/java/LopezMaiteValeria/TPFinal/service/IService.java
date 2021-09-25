package LopezMaiteValeria.TPFinal.service;

import java.util.List;
import java.util.Set;

public interface IService<T> {
    T crear(T t);
    T buscar(Integer id);
    List<T> buscarTodos();
    T actualizar(T t);
    void eliminar(Integer id);
}
