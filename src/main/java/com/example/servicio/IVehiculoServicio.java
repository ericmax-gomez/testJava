
package com.example.servicio;

import com.example.domain.Vehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// declaramos todos los servicios que dsp se implementan en VehiculoServicio
public interface IVehiculoServicio {
    
    public List<Vehiculo> listaVehiculos();
    
    public List<Vehiculo> filtrado(String clave);
    
    public void salvar(Vehiculo vehiculo);
    
    public void eliminar(Vehiculo vehiculo);
    
    public Vehiculo buscarVehiculo(Vehiculo vehiculo);
    
    public Page<Vehiculo> getAll(Pageable pageable);
}
