# Welcome to DemoFabrick!

Questa repository è per DemoFabrick, un progetto Springboot per Fabrick.


# Files

Nel file  **demo_schema.transazione.dll** c'è il .dll per la creazione a db della tabella per il salvataggio delle transazioni.

## Funzionalità

|                |Operation                         |Risultato                         |
|----------------|-------------------------------|-----------------------------|
|Account |`Get Account info`            |Account infos            |
|Saldo          |`Get Saldo `            |Saldo            |
|Bonifico          |`Effettuo Bonifico`|Status operazione|
|Transazioni          |`Get Transazioni`|Lista transazioni|
|Transazioni          |`Save Transazioni`|Status operazione|

## Lanciale l'applicativo in locale

Per lanciare l'applicativo in locale lanciare il comando:

```sh
clean install spring-boot:run
```

## Tech

Practies e tools utilizzati:
- [SpringBoot] 
- [SpringMVc]  
- [JAVA-8] 
- [JPA] - persistenza dati
- [mySQL] 
- [Hibernate]  - model
- [Swagger]  - model


 [SpringBoot]: <https://docs.spring.io/spring-boot/docs/current/reference/html/>
  [SpringMVc]: <https://it.wikipedia.org/wiki/Model-view-controller>
   [JPA]: <https://spring.io/projects/spring-data-jpa>
   [Hibernate]: <https://hibernate.org/>
   [Swagger]:<https://swagger.io/>
   

## Developers

-  Vittorio Grimaldi (v.grimaldi1993@gmail.com)

## TO DO
- Test su rest API
- Test connessione a DB
- Descrizione metodi/ descrizioni api
- Ridefinire packaging Dto
- Refactoring Dto
- Differenziare rest bad response
- Rest interceptors per aggiunta api-key e schema
