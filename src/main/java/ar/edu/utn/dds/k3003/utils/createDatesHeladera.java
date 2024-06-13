package ar.edu.utn.dds.k3003.utils;

import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.model.Heladera;

import javax.persistence.EntityManager;

public class createDatesHeladera {

    EntityManager entityManager;

    public createDatesHeladera(EntityManager entityManager){
        Heladera heladera = new Heladera("Heladera1");
        entityManager.getTransaction().begin();
        entityManager.persist(heladera);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
