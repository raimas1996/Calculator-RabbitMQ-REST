# Calculator-RabbitMQ-REST
 Springboot project of a Calculator, using REST APIs and RabbitMQ
 
## Docker Instalation

To run the docker containers, first [Docker](https://www.docker.com/products/docker-desktop/) need to be installed on the operating system:

## Usage
### Starting the Docker containers

To start the docker containers, run this command on the project's root directory:
```bash
docker-compose up -d
```

### Sending the REST GET Requests

With both containers active, requests can be made so that the calculator performs 4 different types of arithmetic operations among two operands (`a` and `b`):
- **`Sum`**: http://127.0.0.1:8081/divide?a=0&b=0
- **`Subtract`**: http://127.0.0.1:8081/subtract?a=10&b=0
- **`Multiply`**: http://127.0.0.1:8081/multiply?a=10&b=0
- **`Divide`**: http://127.0.0.1:8081/divide?a=10&b=0

The response will be similar between operations, using this format

```
{
    "result": <?>
}
```
