#### Requirements
- JDK 13.0.2-8
- Maven 3.6.3

#### Set up mySQL database
- Create user:
    - name: ```root```
    - password: ```password```

#### How to run (Command Line)
- ``` git clone https://github.com/UbaidurRehman1/miniature-memory.git ```
- ``` cd naming-server ```
- ``` mvn spring-boot:run```
- open new terminal on same directory
- ``` cd api-gateway-server ```
- ``` mvn spring-boot:run```
- open new terminal on same directory
- ``` cd todo-ms ```
- ``` mvn spring-boot:run```

#### IntelliJ Idea
- Import this project in your intelliJ Idea
- Start Services in the following sequence:
    - NamingServerApplication
    - ApiGatewayServerApplication
    - TodoMsApplication
    - ApiApplication

#### API endpoints docs
- http://localhost:8080/swagger-ui.html

### API end points:
- http://localhost:8080/todos (GET Todos)
- http://localhost:8080/todos/{id} (GET a Todo)
- http://localhost:8080/todos/{id} (DELETE a todo)
- http://localhost:8080/ (POST a todo)

### 