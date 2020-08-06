package com.example.demo.domain;

import com.example.demo.repository.PaysService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.bridge.StringBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * L'injection est "magique" et gérée par Hibernate Search, comme expliqué ici:
 * https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#section-bridge-dependency-injection
**/
@Slf4j
@Component
public class PaysBridge implements StringBridge {

     @Autowired
    PaysService paysService;

    public String objectToString(Object object) {
        Pays p = paysService.findByCode((String) object);
        return p.getName();
    }

}