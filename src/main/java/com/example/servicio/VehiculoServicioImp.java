
package com.example.servicio;

import com.example.dao.IVehiculoDao;
import com.example.domain.Vehiculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// todos los metodos creados por IVehiculoServicio los implementa y utiliza el dao para ejecutar distintas funciones

@Service
public class VehiculoServicioImp implements IVehiculoServicio{

    @Autowired
    private IVehiculoDao vehiculoDao;  
    
    // lista todos los vehiculos
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> listaVehiculos() {
       return (List<Vehiculo>) vehiculoDao.findAll();
    }
    
    // lista todos los vehiculos segun el filtro
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> filtrado(String clave) {
       if(clave != null){
           return (List<Vehiculo>) vehiculoDao.filtrar(clave);
       }
        return (List<Vehiculo>) vehiculoDao.findAll();
    }

    // inserta un vehiculo en la base
    @Override
    @Transactional
    public void salvar(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    // elimina un vehiculo de la base
    @Override
    @Transactional
    public void eliminar(Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    // busca un vehiculo
    @Override
    @Transactional(readOnly = true)
    public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getId()).orElse(null);
    }
    
    // trae todos los vehiculos de una pagina, como usamos el filtro este metodo queda en stand by por si necesitan utilizar la paginacion sin filtro
    @Override
    public Page<Vehiculo> getAll(Pageable pageable) {
        return vehiculoDao.findAll(pageable);
    }
    
}
