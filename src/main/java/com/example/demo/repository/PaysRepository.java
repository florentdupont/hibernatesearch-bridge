package com.example.demo.repository;


import com.example.demo.domain.Pays;
import org.springframework.stereotype.Component;

@Component
public class PaysRepository {

    static final Pays FRANCE = new Pays("fr", "France");
    static final Pays US = new Pays("us", "Etats-Unis");
    static final Pays DE = new Pays("de", "Allemagne");

    public Pays findByCode(String code) {

        // mise en cache "MAISON" dans le cadre du POC. En vrai, on ferai l'appel au cache, etc...
        if("fr".equals(code))
            return FRANCE;

        if("us".equals(code))
            return US;

        return DE;
    }

}
