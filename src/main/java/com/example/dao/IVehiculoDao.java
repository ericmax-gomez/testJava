package com.example.dao;

import com.example.domain.Vehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// implementamos el dao donde busca los vehiculos de una pagina o si busca los vehiculos segun el filtro
public interface IVehiculoDao extends CrudRepository<Vehiculo, Integer>, JpaRepository<Vehiculo, Integer> {

    public Page<Vehiculo> findAll(Pageable pageable);
    
    @Query(value="SELECT v.* FROM vehiculo v WHERE"
            + " CONCAT(v.marca,v.modelo,v.matricula,v.color,v.anio)"
            + " LIKE %?1%", nativeQuery = true)
    public List<Vehiculo> filtrar(String clave);
}
