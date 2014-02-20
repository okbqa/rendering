rendering
=========

Modules for rendering results that the OKBQA implementation computed to questions.

Installing:
```
git clone https://github.com/okbqa/rendering.git
cd rendering
mvn clean install
```

Running server:
```
mvn exec:java -Dexec.mainClass="org.okbqa.rendering.Server"
```

Using:
```
curl -X POST http://localhost:2020/rest/render \
     -d "json={ 'question': 'How many students does the Free University of Berlin have?','bindings': [ [ { 'var' : '?x',  'binding': '250000',  'endpoint': 'http://dbpedia.org/sparql'} ] ] }"
```


License: 
* Apache V2

Documentation
* [IO Specification](https://github.com/okbqa/rendering/wiki/IO-Specification)
* [Vision](https://docs.google.com/document/d/1CP3DzOMKPUyXPZwbZXzPhcX3LahBddu9lRlTpuJjXmA/edit#heading=h.1oy90wr3ru11) 
