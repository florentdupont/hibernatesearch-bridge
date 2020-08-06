package com.example.demo.repository;

import com.example.demo.domain.User;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * voir https://discourse.hibernate.org/t/5-10-4-final-doesnt-work-with-fulltextentitymanager/1551
 *
 */
@Component
public class SearchUserRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<User> search() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextSession((Session) entityManager.getDelegate());
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();

        // Attention, ici par défaut, ca passe par le Fieldbridge pour mapper la valeur indiquée dans le "matching"
        // et le convertir.
        // Ce n'est pas ce que l'on veut dans notre cas, car on veut bien faire une recherche avec la valeur réellement indexée.
        //
        // Il faut donc ignorer la prise en compte du fieldbridge pour la recherche avec l'option "ignoreFieldBridge()"
        Query q = qb.keyword().onField("pays")
                .ignoreFieldBridge()
                .matching("france")
                .createQuery();
        FullTextQuery query = fullTextEntityManager.createFullTextQuery(q, User.class);

        return (List<User>) query.getResultList();
    }

    public void indexFullText() throws InterruptedException {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextSession((Session) entityManager.getDelegate());
        fullTextEntityManager.createIndexer().startAndWait();
    }

}
