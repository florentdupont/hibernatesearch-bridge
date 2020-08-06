package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
//import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
//import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
//import org.apache.lucene.analysis.standard.StandardFilterFactory;
//import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "t_user")
@NoArgsConstructor
@Getter
@Setter
//@Indexed
//@AnalyzerDef(name = "customanalyzer",
//        tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class),
//        filters = {
//                @TokenFilterDef(factory = StandardFilterFactory.class),
//                @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
//                @TokenFilterDef(factory = LowerCaseFilterFactory.class)
//        })
public class User {

    public User(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
//   @Field
//    @Analyzer(definition = "customanalyzer")
    private String name;

    @Column
//    @Field(name="pays")
//    @Analyzer(definition = "customanalyzer")
//    @FieldBridge(impl = PaysBridge.class)
    private String countryCode;

}
