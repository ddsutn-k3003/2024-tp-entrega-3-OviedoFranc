package ar.edu.utn.dds.k3003.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//@Entity
public class SensorTemperatura {
  //  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer heladeraIdPerteneciente;
    //@OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<Temperatura> temperaturas = new ArrayList<>();
    Integer ultimaTemperaRegistrada;

    public SensorTemperatura(){}

    public SensorTemperatura(Integer heladeraId){
        this.heladeraIdPerteneciente = heladeraId;
    }

    public Integer getId() {
        return id;
    }

    public Map<Integer, LocalDateTime> obtenerTodasLasTemperaturas(){
        Map<Integer, LocalDateTime> temperaturasMap = new HashMap<>();
        for (Temperatura temperatura: temperaturas)
        {
            temperaturasMap.put(temperatura.gettemperatura(), temperatura.gettiempo());
        }
        return temperaturasMap;
    }

    public Map.Entry<Integer, LocalDateTime> obtenerTemperatura(){
        return setNuevaTemperatura( (int) (Math.random() * 10) , LocalDateTime.now() );
    }

    public Map.Entry<Integer, LocalDateTime> setNuevaTemperatura(Integer temperatura, LocalDateTime tiempo) {
        Temperatura temperaturaNueva = new Temperatura(this,temperatura,tiempo);
        this.temperaturas.add(temperaturaNueva);
        this.ultimaTemperaRegistrada = temperatura;
        return new AbstractMap.SimpleEntry<>(temperatura, tiempo);
    }

}
