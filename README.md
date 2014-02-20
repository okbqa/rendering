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
