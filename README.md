# POC Hibernate Search et Bridge

POC pour valider le fait d'indexer des données qui ne sont pas portée par JPA à partir d'une Entité JPA.

Par exemple : 
```
User {
 name,        // John Smith
 countryCode  // us
}

Country {
 code,        // us
 label        // United States
}
```

Dans ce POC, seul le User est indexé (pas Country) et le Country est indexé via son label.
Ce qui permet de faire des recherche d'utilisateur par le nom de pays, alors qu'en BDD, ce nom de Pays n'est pas associé
directement à l'entité.

Dans ElasticSearch, nous avons : 
```
 "_source": {
    "id": "3",
    "name": "John Smith",
    "pays": "Etats-Unis"
},
```

On s'appuie sur les FieldBridge pour résoudre cette problématique. 


## Lancement préalable
```
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:5.6.16
```

Pour lister tous les documents d'un index donné :
```bash
http ":9200/com.example.demo.domain.user/_search?pretty=true&q=*:*"
```

