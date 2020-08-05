package com.example.demo.domain;

import com.example.demo.repository.PaysRepository;
import org.hibernate.search.bridge.StringBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * L'injection est "magique" et gérée par Hibernate Search, comme expliqué ici:
 * https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#section-bridge-dependency-injection
**/
@Component
public class PaysBridge implements StringBridge {

    @Autowired
    PaysRepository paysRepository;

    public String objectToString(Object object) {
        Pays p = paysRepository.findByCode((String) object);
        return p.getName();
    }

}