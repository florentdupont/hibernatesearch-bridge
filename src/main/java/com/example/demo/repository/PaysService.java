package com.example.demo.repository;


import com.example.demo.domain.Pays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaysService {

    static final Pays FRANCE = new Pays("fr", "France");
    static final Pays US = new Pays("us", "Etats-Unis");
    static final Pays DE = new Pays("de", "Allemagne");

    public Pays findByCode(String code) {

        // mise en cache "MAISON" dans le cadre du POC. En vrai, on ferai l'appel à une API ou un cache, etc...
        if("fr".equals(code))
            return FRANCE;

        if("us".equals(code))
            return US;

        return DE;
    }

}
