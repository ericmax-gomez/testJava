
package com.example.web;

import com.example.domain.Vehiculo;
import lombok.extern.slf4j.Slf4j;
import com.example.servicio.IVehiculoServicio;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class ControladorREST {
    
    // instanciamos la clase que contiene los servicios
   @Autowired
   private IVehiculoServicio vehiculoServicio;
    
   // mapeamos la ruta como la inicial
   @GetMapping("/")
   public String comienzo(@RequestParam Map<String, Object> params, Model model,@Param("clave") String clave,@Param("ok") String ok){
       // en caso de traer por get informacion es porque necesita mostrar el mensaje de cambios confirmados
       if(ok != null){
           model.addAttribute("confirm", "si");
       }
       // listamos los vehiculos que tenemos que mostrar en pantalla y filtramos la palabra ingresada 
       // en caso de que no se haya ingresado se traeran todos los vehiculos
       List<Vehiculo> vehiculos = vehiculoServicio.filtrado(clave);
       if(clave == null) clave="";
       int tam = vehiculos.size();
       int cantXPage = 5;
       model.addAttribute("tam", tam);
       model.addAttribute("vehiculos", vehiculos);
       model.addAttribute("clave", clave);
       
       // calculamos la hoja que se encuentra y los vehiculos a mostrar para la paginacion
       int page = params.get("page") != null?(Integer.valueOf(params.get("page").toString()) - 1): 0;
       PageRequest pageRequest = PageRequest.of(page, cantXPage);
       
       List<Vehiculo> aux =new ArrayList<Vehiculo>();
       int totalPage = vehiculos.size()/cantXPage;
       if((vehiculos.size()%cantXPage)>0) totalPage+=1;
       int cont=0;
       int auxPage = page+1;
       int res = cantXPage * (auxPage-1);
       for(Vehiculo coche: vehiculos){
            if((cont >= res) && (cont<(cantXPage * auxPage))){
                aux.add(coche);
            }
            cont++;
       }
       // guardamos en una lista los numeros que serian las hojas para la paginacion
       if(totalPage > 0){
           List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
           model.addAttribute("pages", pages);
       }

      model.addAttribute("list", aux);
       model.addAttribute("current", page+1);
       model.addAttribute("next",page+2);
       model.addAttribute("prev", page);
       model.addAttribute("last", totalPage);
       return "indice";
   } 
   
   // mapeamos si recibe un get agregar lo redireccione a la plantilla agregar
   @GetMapping("/agregar")
   public String agregar(Vehiculo vehiculo){
       return "agregar";
   }
   
   // mapeamos si recibe un post valida si no tiene errores, en caso de contener errores vuelve a la pagina agregar
   // por el momento esta validando con bootstrap, pero si desactivo bootstrap validaria y mostraria los mensajes en los campos que faltan
   // en caso contrario guarda los cambios en la base de datos y redirecciona al indice
   @PostMapping("/salvar")
   public String salvar(@Valid Vehiculo vehiculo, Errors error){
       if(error.hasErrors()){
           return "agregar";
       }
       vehiculoServicio.salvar(vehiculo);
       return "redirect:/?ok=si";
   }
   
   // mapeamos si recibe un get cambiar con id, busca el vehiculo y redirecciona a la plantilla agregar
   // usamos la misma plantilla ya que los campos son los mismos y no repetimos datos
   @GetMapping("/cambiar/{id}")
   public String cambiar(Vehiculo vehiculo, Model model){
       vehiculo = vehiculo = vehiculoServicio.buscarVehiculo(vehiculo);
       model.addAttribute("vehiculo", vehiculo);
       return "agregar";
   }
   
   // mapeamos si recibe un get borrar con id, elimina el vehiculo recibido y redirecciona al indice
   @GetMapping("/borrar/{id}")
   public String borrar(Vehiculo vehiculo){
       vehiculoServicio.eliminar(vehiculo);
       return "redirect:/";
   }
   
}
