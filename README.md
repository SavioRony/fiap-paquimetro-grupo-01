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

**`PUT /veiculo/{placa}`**

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



# 📗 Acessando o Swagger da Aplicação
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

# 🐋 Como iniciar o MySql e PhpMyAdmin com Docker
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


