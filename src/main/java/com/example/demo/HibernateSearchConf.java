package com.example.demo;

import com.example.demo.domain.PaysBridge;
import com.example.demo.domain.User;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.hibernate.search.cfg.SearchMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.annotation.ElementType.FIELD;


@Configuration
public class HibernateSearchConf {

    private static final String ANALYZER_STANDARD = "standard";

    @Bean
    public SearchMapping getSearchMapping() {
        SearchMapping mapping = new SearchMapping();

        mapping.analyzerDef(ANALYZER_STANDARD, WhitespaceTokenizerFactory.class)
                .filter(StandardFilterFactory.class)
                .filter(ASCIIFoldingFilterFactory.class)
                .filter(LowerCaseFilterFactory.class);


        mapping.entity(User.class)
                .indexed()

                .property("name", FIELD)
                .field()
                .name("name")
                .analyzer(ANALYZER_STANDARD)

                .property("countryCode", FIELD)
                .field()
                .bridge(PaysBridge.class)
                .name("pays")
                .analyzer(ANALYZER_STANDARD)
                ;

        return mapping;
    }

}
