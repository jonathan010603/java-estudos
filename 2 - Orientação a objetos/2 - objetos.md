# Objetos em Orientação a Objetos

Em **Programação Orientada a Objetos (POO)**, um **objeto** é uma **instância de uma classe**.

- **Classe**: o **molde** (exemplo: `Carro`)
- **Objeto**: a **coisa real criada a partir desse molde** (exemplo: `meuCarro`)

A classe define **como um carro deve ser**, e o objeto representa **um carro específico**.

---

## Características de um Objeto

Todo objeto possui três características principais:

| Característica   | Descrição                           |
|------------------|-------------------------------------|
| **Estado**       | Valores atuais dos atributos         |
| **Comportamento**| Ações que o objeto pode executar     |
| **Identidade**   | O objeto específico na memória       |

**Exemplo:**

- **Objeto:** cachorro
- **Estado:** 
    - `nome = Rex`
    - `idade = 5`
- **Comportamento:** 
    - `latir()`
    - `correr()`

---

## Criando um Objeto

Para criar um objeto em Java, usamos a palavra-chave `new`.

```java
Carro carro = new Carro();
```

- `Carro` → classe
- `carro` → objeto
- `new` → cria uma nova instância da classe

---

### Acessando Atributos do Objeto

Podemos acessar os atributos de um objeto usando o operador ponto (`.`):

```java
carro.marca = "Toyota";
carro.modelo = "Corolla";
carro.ano = 2020;
```

---

### Chamando Métodos do Objeto

Métodos também são acessados usando o ponto (`.`):

```java
carro.ligar();
```

Isso faz o objeto executar uma ação.

---

## Exemplo Completo

**Classe:**

```java
class Cachorro {
        String nome;
        int idade;

        void latir() {
                System.out.println(nome + " está latindo!");
        }
}
```

**Criando o objeto:**

```java
Cachorro c = new Cachorro();
c.nome = "Rex";
c.idade = 5;
c.latir();
```

**Saída:**

```
Rex está latindo!
```

---

## Vários Objetos da Mesma Classe

Uma classe pode criar muitos objetos diferentes:

```java
Cachorro c1 = new Cachorro();
Cachorro c2 = new Cachorro();

c1.nome = "Rex";
c2.nome = "Bob";
```

Mesmo usando a mesma classe, cada objeto possui seu próprio estado.

---

## Objetos na Memória

Quando usamos `new`, o objeto é criado na memória do programa (heap).  
A variável guarda apenas uma referência para esse objeto.

```java
Pessoa p = new Pessoa();
```

**Representação simplificada:**

```
p  ----->  objeto Pessoa na memória
```

---

## Resumo

- Objeto é uma instância de uma classe
- Possui estado, comportamento e identidade
- É criado usando a palavra-chave `new`
- Pode acessar atributos e métodos da classe
- Uma classe pode gerar muitos objetos diferentes

> Objetos são a base da Programação Orientada a Objetos, pois representam entidades do mundo real dentro do programa.
