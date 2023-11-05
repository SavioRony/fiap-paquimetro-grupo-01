# 📜 Objetivo
O objetivo principal é refazer uma solução de parquímetros, que atualmente apresenta atrasos e erros na gravação e leitura dos dados. Você deve modernizar o código, implementando uma solução otimizada e eficiente.

# ⚒️ Documentação das APIs

**Path do projeto:**
**`/fiap-paquimetro-grupo01`**

## **Condutor**

### **Cadastro de condutor**

**Requisição**

**`POST /condutor`**

**Parâmetros da requisição**

| Parâmetro           | Tipo   |
|---------------------|--------|
| documento           | String |
| nome                | String |
| telefone            | String |
| email               | String |
| tipoDePagamento     | String |
| endereco            | Object |
| endereco.cep        | String |
| endereco.logradouro | String |
| endereco.numero     | String |
| endereco.complemento| String |


**Request**

```
{
  "documento": "12354689",
  "nome": "nome_121ed326b92a",
  "telefone": "telefone_59861936f193",
  "email": "email_65738fcb13c3",
  "tipoDePagamento": "tipoDePagamento_70479b4126a0",
  "endereco": {
    "cep": "cep_97a1879a08ed",
    "logradouro": "logradouro_71279b60d46f",
    "numero": "numero_aac6894c44f6",
    "complemento": "complemento_ea24088ec341"
  }
}
```
**Resposta**
```
{
  "documento": "12354689",
  "nome": "nome_121ed326b92a",
  "telefone": "telefone_59861936f193",
  "email": "email_65738fcb13c3",
  "tipoDePagamento": "tipoDePagamento_70479b4126a0",
  "endereco": {
    "id": 1,
    "cep": "cep_97a1879a08ed",
    "logradouro": "logradouro_71279b60d46f",
    "numero": "numero_aac6894c44f6",
    "complemento": "complemento_ea24088ec341"
  }
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 201    | Creat       |
| 400    | Bad Request |

### **Buscar condutor por documento**

**Requisição**

**`GET /condutor/{documento}`**


**Resposta**

```
{
  "documento": "documento_42fbdb3e5cd1",
  "nome": "nome_621340cd0e72",
  "telefone": "telefone_bb855c3ee927",
  "email": "email_d0e2d49ca7d8",
  "tipoDePagamento": "tipoDePagamento_89580a5eee80",
  "endereco": {
    "cep": "cep_bd522632a5b6",
    "logradouro": "logradouro_c31aba3daf02",
    "numero": "numero_049878c28fb2",
    "complemento": "complemento_27fdf1a99fa7"
  }
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Update de condutor**

**Requisição**

**`PUT /condutor`**

**Parâmetros da requisição**

| Parâmetro           | Tipo   |
|---------------------|--------|
| documento           | String |
| nome                | String |
| telefone            | String |
| email               | String |
| tipoDePagamento     | String |
| endereco            | Object |
| endereco.cep        | String |
| endereco.logradouro | String |
| endereco.numero     | String |
| endereco.complemento| String |


**Request**

```
{
  "documento": "12354689",
  "nome": "nome_121ed326b92a",
  "telefone": "telefone_59861936f193",
  "email": "email_65738fcb13c3",
  "tipoDePagamento": "tipoDePagamento_70479b4126a0",
  "endereco": {
    "cep": "cep_97a1879a08ed",
    "logradouro": "logradouro_71279b60d46f",
    "numero": "numero_aac6894c44f6",
    "complemento": "complemento_ea24088ec341"
  }
}
```
**Resposta**

```
{
  "documento": "12354689",
  "nome": "nome_121ed326b92a",
  "telefone": "telefone_59861936f193",
  "email": "email_65738fcb13c3",
  "tipoDePagamento": "tipoDePagamento_70479b4126a0",
  "endereco": {
    "cep": "cep_97a1879a08ed",
    "logradouro": "logradouro_71279b60d46f",
    "numero": "numero_aac6894c44f6",
    "complemento": "complemento_ea24088ec341"
  }
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

## **Veiculo**

### **Cadastro de veiculo**

**Requisição**

**`POST /veiculo`**

**Parâmetros da requisição**

| Parâmetro | Tipo       |
|----------- |------------|
| placa     | String     |
| modelo    | String     |
| cor       | String     |
| condutor  | Object     |
| - documento | String     |



**Request**

```
{
  "placa": "placa_6dc5e75267b5",
  "modelo": "modelo_f1e741e270c8",
  "cor": "cor_51b671da739b",
  "condutor": {
    "documento": "documento_0f6844bb72e0"
  }
}
```

**Response**

```
{
  "placa": "placa_6dc5e75267b5",
  "modelo": "modelo_f1e741e270c8",
  "cor": "cor_51b671da739b",
  "condutor": {
    "documento": "documento_0f6844bb72e0"
  }
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 201    | Creat       |
| 400    | Bad Request |

### **Buscar veiculo por placa**

**Requisição**

**`GET /veiculo/{placa}`**


**Response**

```
{
  "placa": "string",
  "modelo": "string",
  "condutor": {
    "documento": "string"
  },
  "cor": "string"
}
```

**Códigos de Resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Update de veiculo**

**Requisição**

**`PUT /veiculo`**

**Parâmetros da requisição**

| Parâmetro | Tipo       |
|----------- |------------|
| placa     | String     |
| modelo    | String     |
| cor       | String     |
| condutor  | Object     |
| - documento | String     |


**Request**

```
{
  "placa": "string",
  "condutor": {
    "documento": "string"
  },
  "modelo": "string",
  "cor": "string"
}
```
**Response**

```
{
  "placa": "string",
  "modelo": "string",
  "condutor": {
    "documento": "string"
  },
  "cor": "string"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar veiculos por condutor**

**Requisição**
**`GET /veiculo/condutor/{documento}`**

**Response**

```
[
    {
      "placa": "string",
      "modelo": "string",
      "condutor": {
        "documento": "string"
      },
      "cor": "string"
    }
]
```

**Códigos de Resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **DELETE de veiculo**

**Requisição**

**`DELETE /veiculo/{placa}`**

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Resgistro de estacionamento**

**Requisição**

**`POST /estacionamento/registro`**

**Parâmetros da requisição**

| Parâmetro       | Tipo    |
|-----------------|---------|
| quantidadeHoras | Number  |
| tipo            | String  |
| valorHora       | Number  |
| condutor        | Object  |
| - documento     | String  |
| veiculo         | Object  |
| - placa         | String  |


**Request**

```
{
  "quantidadeHoras": 0,
  "tipo": "FIXO",
  "valorHora": 0,
  "condutor": {
    "documento": "string"
  },
  "veiculo": {
    "placa": "string"
  }
}
```
**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Fechamento de estacionamento**

**Requisição**

**`POST /estacionamento/fechamento`**

**Parâmetros da requisição**

| Parâmetro     | Tipo    |
|---------------|---------|
| placa         | String  |


**Request**

```
{
  "placa": "string"
}
```

**Response**

```
{
  "placa": "string",
  "valorTotal": 0,
  "tipoPagamento": "DEBITO",
  "quantidadeHoras": 0,
  "dataHoraInicio": "string",
  "dataHoraFim": "string"
}
```
**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar estacionamento aberto por veiculo**

**Requisição**

**`GET /estacionamento/{placa}`**

**Parâmetros da requisição**

| Parâmetro     | Tipo    |
|---------------|---------|
| placa         | String  |


**Response**

```
{
  "id": 0,
  "dataHoraInicio": "2023-10-29T18:34:54.137Z",
  "dataHoraFim": "2023-10-29T18:34:54.137Z",
  "quantidadeHoras": 0,
  "tipo": "FIXO",
  "valorHora": 0,
  "condutor": {
    "documento": "string"
  },
  "veiculo": {
    "placa": "string"
  }
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar estacionamentos por condutor**

**Requisição**

**`GET /estacionamento/condutor/{documento}`**

**Parâmetros da requisição**

| Parâmetro | Tipo    |
|-----------|---------|
| documento | String  |


**Response**

```
[
  {
    "id": 0,
    "dataHoraInicio": "2023-10-29T18:38:54.214Z",
    "dataHoraFim": "2023-10-29T18:38:54.214Z",
    "quantidadeHoras": 0,
    "tipo": "FIXO",
    "valorHora": 0,
    "condutor": {
      "documento": "string"
    },
    "veiculo": {
      "placa": "string"
    }
  }
]
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Alerta de estacionamento por veiculo**

**Requisição**

**`GET /estacionamento/alerta/{placa}`**

**Parâmetros da requisição**

| Parâmetro | Tipo    |
|-----------|---------|
| placa     | String  |


**Response**

```
{
  "placa": "abc123",
  "alerta": "Não existe nenhum estacionamento aberto para este veiculo !"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

# Deploy com CDK na AWS

- Projeto CDK usado para deploy: ``https://github.com/SavioRony/aws-deploy-paquimetro``
- Link do swagger da aplicação na aws: `` ``

## Arquitetura do projeto na AWS

![Infraestura da aplicação na aws](.\src\main\resources\img\Infra ECS.drawio.png)


## Recursos AWS Utilizados no Deploy
Aqui estão os recursos AWS usados no deploy com CDK:

### 1. VPC (Virtual Private Cloud)
A VPC (Virtual Private Cloud) é uma rede virtual privada que permite isolar e personalizar a infraestrutura de rede. Com ela, é possível configurar sub-redes, tabelas de roteamento e grupos de segurança para criar um ambiente seguro e isolado.

### 2. ECR (Elastic Container Registry)
O ECR (Elastic Container Registry) é um repositório gerenciado de imagens Docker. É o local onde as imagens Docker do projeto Spring são armazenadas e disponibilizadas para a criação de contêineres em clusters ECS (Elastic Container Service).

### 3. Cluster ECS (Elastic Container Service)
Um cluster ECS (Elastic Container Service) é uma plataforma gerenciada que permite a execução de contêineres Docker, incluindo a aplicação Spring. Ele oferece escalabilidade e alta disponibilidade para os contêineres e é o ambiente no qual os contêineres são implantados e gerenciados.

### 4. Task Definition
A definição de tarefa descreve como a aplicação é executada em contêineres, especificando a imagem Docker a ser usada, os recursos necessários (CPU, memória) e configurações como variáveis de ambiente.

### 5. Service
O serviço do ECS gerencia a execução das tarefas, garantindo que o número desejado de instâncias esteja em execução e controlando o processo de implantação de novas versões da definição da tarefa. Isso permite atualizar a aplicação de forma controlada e sem tempo de inatividade.

### 6. Auto Scaling
O Auto Scaling permite que o serviço ECS aumente ou diminua o número de instâncias de contêineres com base em métricas específicas, como consumo de CPU, RAM e quantidade de requisições. Ele monitora essas métricas e, com base em políticas de escalabilidade configuradas, ajusta automaticamente o número de instâncias para otimizar o uso de recursos e garantir que a aplicação funcione de forma eficiente, mesmo sob carga variável.

### 7. ALB (Application Load Balancer)
Um Application Load Balancer (ALB) é usado para centralizar e distribuir as requisições dos clientes entre as instâncias do projeto Spring em execução no cluster ECS. Isso equilibra a carga de trabalho, melhora a escalabilidade e garante que todas as instâncias recebam tráfego de forma equitativa.

### 8. Target Group
O Target Group é associado ao ALB e permite monitorar a saúde das instâncias por meio de verificações de integridade (Health Check). Se uma instância for considerada não saudável, o serviço a substituirá automaticamente, garantindo alta disponibilidade e confiabilidade da aplicação.

### 9. Security Group
Os grupos de segurança são usados para aplicar regras de segurança às instâncias e recursos da AWS, controlando quais portas e protocolos têm acesso.

### 10. RDS (Relational Database Service)
O RDS (Relational Database Service) é um serviço gerenciado de banco de dados relacional que hospeda o banco de dados MySQL da aplicação.

# 📗 Acessando o Swagger da Aplicação local
A documentação da API da nossa aplicação está disponível através do Swagger,
uma interface interativa que permite explorar e testar os endpoints da API.
Siga os passos abaixo para acessar o Swagger:

1 - Certifique-se de que a aplicação esteja em execução.

2 - Abra seu navegador da web favorito.

3 - Na barra de endereços do navegador, insira o seguinte URL:
```
http://localhost:8080/fiap-paquimetro-grupo01/swagger-ui/index.html#/
```
4 - Substitua porta_da_aplicacao pela porta em que a aplicação está sendo executada localmente. Por padrão, muitas vezes a porta é 8080.

5 - Pressione Enter para acessar a página do Swagger.

Agora você está na interface do Swagger, onde pode ver a lista de todos os endpoints disponíveis, seus detalhes e parâmetros. Explore e teste os endpoints interativamente.

# 🐋 Como iniciar o MySql e PhpMyAdmin com Docker local
1 - Antes de qualquer coisa certifique-se de ter o Docker já instalado e configurado em sua maquina:
- https://docs.docker.com/get-docker/

2 -  Abra o terminal no caminho do arquivo ``mysql-docker-compose.yml``:
```
...\fiap-paquimetro-grupo-01\src\main\resources\docker
```
3 -  Execulte o seguinte comando no terminal:
```
docker compose -f mysql-docker-compose.yml up -d
```
4 - Pronto agora basta iniciar o projeto.

5 - Para acessar a ferramenta phpMyAdmin para ter acesso ao banco de dados basta inserir a url no seu navegador de preferência:
```
http://localhost:8000/
```
6 - Entre com usuario e senha configurado no ``application.yml`` que esta como padrão:
- Usuario: ``root``
- Senha: ``root``


# ✔️ Tecnologias e Ferramentas utilizadas

- ``Java``
- ``Maven``
- ``Spring Boot``
- ``Intellij``
- ``Postman``
- ``Docker``
- ``MySql``
- ``Swagger``
- ``AWS``

