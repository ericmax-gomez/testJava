package com.example.demo;

import com.example.dao.IVehiculoDao;
import com.example.domain.Vehiculo;
import com.example.servicio.IVehiculoServicio;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;


// declaramos los test para el proyecto y vemos si funciona todo ok
@SpringBootTest
class DemoApplicationTests {

        @Autowired
        private IVehiculoDao vehiculoDao;  
        
        @Autowired
        private IVehiculoServicio vehiculoServicio;
    
        @BeforeAll
        public static void antes(){
            System.out.println("beforeAll");
        }
        
        @AfterAll
        public static void despues(){
            System.out.println("afterAll");
        }
        
        @BeforeEach
        public void iniciar(){
            System.out.println("beforeEach");
        }
        
        @AfterEach
        public void terminar(){
            System.out.println("afterEach");
        }
    
        @Test
        public void listar(){
            List<Vehiculo> lista = vehiculoServicio.listaVehiculos();
            for(Vehiculo vehi: lista){
                System.out.println(vehi);
            }
        }
        
        @Test
        public void filtrar(){
            List<Vehiculo> lista = vehiculoServicio.filtrado("fiat");
            for(Vehiculo vehi: lista){
                System.out.println(vehi);
            }
        }
        
        @Test
        public void Buscar(){
            Vehiculo v1 = new Vehiculo(1,"Peugeot","504","AA 111 AA","Blanco","2014");
            Vehiculo buscado = vehiculoServicio.buscarVehiculo(v1);
          
            System.out.println(buscado); 
        }
        
        @Test
        public void Guardar(){
            Vehiculo v1 = new Vehiculo(1,"Peugeot","504","AA 111 AA","Blanco","2014");
            vehiculoServicio.salvar(v1);
        }
        
        @Test
        public void eliminar(){
            Vehiculo v1 = new Vehiculo(1,"Peugeot","504","AB 111 AA","Blanco","2014");
            vehiculoServicio.eliminar(v1);
        }
        
        
}
