# Classes em Orientação a Objetos

Em **Programação Orientada a Objetos (POO)**, uma **classe** é um modelo usado para criar objetos.  
Ela define **quais dados um objeto possui** e **quais ações ele pode executar**.

> Podemos pensar em uma classe como uma **planta de construção**:  
> A planta define como a casa será construída, mas **não é a casa em si**.

---

## Classe vs Objeto

| Conceito    | Descrição                                         |
|-------------|---------------------------------------------------|
| **Classe**  | Modelo que define propriedades e comportamentos   |
| **Objeto**  | Instância real criada a partir da classe          |

**Exemplo conceitual:**

- Classe: `Carro`
- Objeto: `meuCarro`

A classe descreve **como um carro é**, enquanto o objeto é **um carro específico**.

---

## Estrutura de uma Classe

Uma classe normalmente possui:

- **Atributos** → dados do objeto
- **Métodos** → ações que o objeto pode executar
- **Construtor** → método usado para criar o objeto

### Exemplo em Java

```java
class Carro {
    String marca;
    String modelo;
    int ano;

    void ligar() {
        System.out.println("O carro está ligado");
    }
}
```

---

## Criando um Objeto

Para usar uma classe, precisamos criar um objeto dela:

```java
Carro meuCarro = new Carro();

meuCarro.marca = "Toyota";
meuCarro.modelo = "Corolla";
meuCarro.ano = 2020;

meuCarro.ligar();
```

- `Carro` é a classe
- `meuCarro` é o objeto

---

## Atributos

Atributos são variáveis que pertencem ao objeto e armazenam seu estado.

```java
class Pessoa {
    String nome;
    int idade;
}
```

Cada objeto dessa classe terá seu próprio nome e idade.

---

## Métodos

Métodos são funções dentro da classe que definem comportamentos do objeto.

```java
class Pessoa {
    String nome;

    void falar() {
        System.out.println("Olá!");
    }
}
```

**Uso:**

```java
Pessoa p = new Pessoa();
p.falar();
```

---

## Construtores

Construtores são métodos especiais usados para inicializar objetos.  
Eles têm o mesmo nome da classe.

```java
class Pessoa {
    String nome;

    Pessoa(String nome) {
        this.nome = nome;
    }
}
```

**Criando o objeto:**

```java
Pessoa p = new Pessoa("João");
```

---

## Encapsulamento

Encapsulamento significa proteger os dados da classe, usando modificadores como `private`, `public` e `protected`.

```java
class Conta {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

Assim, o saldo não pode ser alterado diretamente.

---

## Exemplo Completo

```java
class Cachorro {
    String nome;
    int idade;

    void latir() {
        System.out.println(nome + " está latindo!");
    }
}
```

**Uso:**

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

## Resumo

- **Classe** é um molde para criar objetos
- **Objeto** é uma instância da classe
- **Atributos** armazenam dados
- **Métodos** definem comportamentos
- **Construtores** inicializam objetos
- **Encapsulamento** protege os dados

A classe é um dos pilares fundamentais da Programação Orientada a Objetos.

