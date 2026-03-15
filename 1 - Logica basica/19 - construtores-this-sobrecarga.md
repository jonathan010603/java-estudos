# Construtores, `this`, `super` e Sobrecarga em Java

Em **Programação Orientada a Objetos**, construtores, as palavras-chave `this` e `super`, e o conceito de **sobrecarga** são fundamentais para inicializar objetos corretamente e estruturar hierarquias de classes. Esses mecanismos permitem controlar como objetos são criados, como classes se relacionam entre si e como evitar duplicação de código.

---

## Construtores

Um **construtor** é um método especial responsável por **inicializar um objeto no momento em que ele é criado**. Ele é executado automaticamente quando usamos a palavra-chave `new`.

**Características dos construtores:**
- Possuem **o mesmo nome da classe**
- **Não possuem tipo de retorno**
- São chamados automaticamente na criação do objeto

**Exemplo:**

```java
class Pessoa {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

// Uso:
Pessoa p = new Pessoa("João", 25);
```

Quando o objeto é criado, o construtor inicializa os atributos `nome` e `idade`.

### Construtor padrão (Default Constructor)

Se uma classe não declarar nenhum construtor, o compilador cria automaticamente um construtor padrão sem parâmetros.

**Exemplo:**

```java
class Produto {
    String nome;
    double preco;
}

// Uso:
Produto p = new Produto();
```

Os atributos recebem valores padrão:

| Tipo     | Valor padrão |
|----------|--------------|
| int      | 0            |
| double   | 0.0          |
| boolean  | false        |
| objetos  | null         |

> Se qualquer construtor for definido manualmente, o construtor padrão não será criado automaticamente.

---

## Palavra-chave `this`

A palavra-chave `this` representa o objeto atual da classe. Ela é usada principalmente para:
- Acessar atributos da própria classe
- Evitar ambiguidades entre variáveis
- Chamar outros construtores da mesma classe

**Exemplo:**

```java
class Pessoa {
    String nome;

    Pessoa(String nome) {
        this.nome = nome;
    }
}
```

Aqui existem duas variáveis chamadas `nome`:
- `this.nome` → atributo da classe
- `nome` → parâmetro do construtor

Sem `this`, o código ficaria ambíguo.

### Chamando outro construtor com `this()`

O `this()` pode ser usado para chamar outro construtor da mesma classe, permitindo reutilizar código.

**Exemplo:**

```java
class Produto {
    String nome;
    double preco;

    Produto() {
        this("Desconhecido", 0);
    }

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

// Uso:
Produto p = new Produto();
```

Nesse caso, o construtor vazio chama o construtor principal.

---

## Palavra-chave `super`

A palavra-chave `super` é usada para acessar membros da superclasse (classe pai). Ela pode ser utilizada para:
- Acessar métodos da superclasse
- Acessar atributos da superclasse
- Chamar o construtor da superclasse

### Chamando o construtor da superclasse

Quando uma classe herda de outra, é comum que o construtor da classe filha chame o construtor da classe pai usando `super()`.

**Exemplo:**

```java
class Animal {
    String nome;

    Animal(String nome) {
        this.nome = nome;
    }
}

class Cachorro extends Animal {
    Cachorro(String nome) {
        super(nome);
    }
}

// Uso:
Cachorro c = new Cachorro("Rex");
```

- `super(nome)` chama o construtor da classe `Animal`
- O atributo `nome` é inicializado na classe pai

### Acessando métodos da superclasse

Também é possível usar `super` para chamar métodos da classe pai.

**Exemplo:**

```java
class Animal {
    void fazerSom() {
        System.out.println("Som genérico");
    }
}

class Cachorro extends Animal {
    @Override
    void fazerSom() {
        super.fazerSom();
        System.out.println("Au Au");
    }
}
```

Nesse caso:
- Primeiro executa o comportamento da classe `Animal`
- Depois executa o comportamento específico de `Cachorro`

---

## Sobrecarga de Construtores

Uma classe pode ter vários construtores com diferentes parâmetros. Isso é chamado de **sobrecarga de construtores**.

**Exemplo:**

```java
class Produto {
    String nome;
    double preco;

    Produto() {
        nome = "Desconhecido";
        preco = 0;
    }

    Produto(String nome) {
        this.nome = nome;
    }

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

// Uso:
Produto p1 = new Produto();
Produto p2 = new Produto("Notebook");
Produto p3 = new Produto("Notebook", 3500);
```

Cada construtor permite inicializar o objeto de forma diferente.

---

## Sobrecarga de Métodos (Method Overloading)

A sobrecarga de métodos ocorre quando existem vários métodos com o mesmo nome, mas com parâmetros diferentes.

**Exemplo:**

```java
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }

    int somar(int a, int b, int c) {
        return a + b + c;
    }

    double somar(double a, double b) {
        return a + b;
    }
}

// Uso:
Calculadora calc = new Calculadora();

calc.somar(2, 3);
calc.somar(2, 3, 4);
calc.somar(2.5, 3.5);
```

O compilador escolhe automaticamente qual método chamar com base nos parâmetros.

---

## Diferença entre `this` e `super`

| Palavra | Função                      |
|---------|-----------------------------|
| this    | Refere-se ao objeto atual   |
| super   | Refere-se à superclasse     |

**Exemplo comparativo:**

```java
class Animal {
    String nome = "Animal";
}

class Cachorro extends Animal {
    String nome = "Cachorro";

    void mostrarNome() {
        System.out.println(this.nome);
        System.out.println(super.nome);
    }
}

// Saída:
Cachorro
Animal
```

---

## Boas práticas

- Mantenha construtores simples
- Evite lógica complexa dentro de construtores
- Use `this()` para reutilizar código
- Use `super()` quando a superclasse precisa ser inicializada
- Use sobrecarga quando métodos possuem a mesma responsabilidade

---

## Conclusão

Construtores são responsáveis por inicializar objetos quando eles são criados. A palavra-chave `this` permite acessar o objeto atual e chamar outros construtores da mesma classe. Já `super` permite acessar membros da superclasse e chamar seu construtor. A sobrecarga de métodos e construtores possibilita criar múltiplas formas de inicializar ou executar operações dentro de uma classe.

Esses conceitos são essenciais para escrever código orientado a objetos bem estruturado e reutilizável em Java.
