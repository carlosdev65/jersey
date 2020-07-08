# jersey
Projeto utilizando implementação Eclipse Jersey https://eclipse-ee4j.github.io/jersey/
Utilizando JPA/Hibernate e H2.
O projeto precida de Java 11 instalado.
Depois que realizar a transferência do arquivos acessar a pasta jersey e executar os comandos:
mvn clean package
mvn exec:java

Para testar, abra um terminal e execute os comandos:
curl -i http://localhost:8080/user

curl -i http://localhost:8080/user/2

curl -i -X POST -d "{\"nome\":\"Ana\", \"email\":\"ana@gmail.com\"}" -H "Content-Type:application/json"  http://localhost:8080/user

curl -i -X DELETE http://localhost:8080/user/3 

curl -i -X PUT -d "{\"nome\":\"Pedro 2\", \"email\":\"pedro2@gmail.com\"}" -H "Content-Type:application/json" http://localhost:8080/user/2



