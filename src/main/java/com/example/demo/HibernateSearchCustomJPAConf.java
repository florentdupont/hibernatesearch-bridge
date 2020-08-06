package com.example.demo;

import org.hibernate.search.cfg.Environment;
import org.hibernate.search.cfg.SearchMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * https://www.docs4dev.com/docs/en/spring-boot/2.1.1.RELEASE/reference/howto-data-access.html#howto-configure-jpa-properties
 */
@Component
public class HibernateSearchCustomJPAConf implements HibernatePropertiesCustomizer {

    @Autowired(required = false)
    SearchMapping searchMapping;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(Environment.MODEL_MAPPING, searchMapping);
    }

}
