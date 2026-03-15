# Princípios da Programação Orientada a Objetos (OOP)

A **Programação Orientada a Objetos (OOP)** é um paradigma que organiza o código em **classes** e **objetos**, representando entidades do mundo real. Diferente de abordagens focadas apenas em funções, a OOP permite estruturar sistemas de forma modular, reutilizável e fácil de manter.

Os quatro princípios fundamentais da OOP são:

- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **Abstração**

Eles ajudam a construir sistemas organizados, flexíveis e evolutivos.

---

## Encapsulamento

O **encapsulamento** protege os dados internos de uma classe, controlando como são acessados ou modificados. Em Java, utiliza-se modificadores de acesso (`private`, `public`, `protected`) para evitar alterações indevidas no estado de um objeto.

```java
class ContaBancaria {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

> O atributo `saldo` só pode ser acessado por métodos definidos na própria classe, garantindo maior controle sobre o estado da conta.

---

## Herança

A **herança** permite que uma classe reutilize atributos e métodos de outra, evitando duplicação de código. Em Java, utiliza-se a palavra-chave `extends`.

```java
class Animal {
    void fazerSom() {
        System.out.println("Animal fazendo som");
    }
}

class Cachorro extends Animal {
    void latir() {
        System.out.println("Au Au");
    }
}

// Uso:
Cachorro c = new Cachorro();
c.fazerSom(); // herdado de Animal
c.latir();    // próprio de Cachorro
```

> A classe `Cachorro` herda o método `fazerSom` da classe `Animal` e define seu próprio método `latir`.

---

## Polimorfismo

O **polimorfismo** permite que diferentes objetos respondam de maneiras distintas ao mesmo método, aumentando a flexibilidade do sistema.

### Sobrescrita de métodos (Override)

```java
class Animal {
    void fazerSom() {
        System.out.println("Som genérico");
    }
}

class Cachorro extends Animal {
    @Override
    void fazerSom() {
        System.out.println("Au Au");
    }
}

// Uso:
Animal animal = new Cachorro();
animal.fazerSom(); // "Au Au"
```

> O método sobrescrito executa o comportamento específico do objeto real, mesmo que a referência seja do tipo base.

### Sobrecarga de métodos (Overload)

```java
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }

    int somar(int a, int b, int c) {
        return a + b + c;
    }
}
```

> Métodos com o mesmo nome, mas parâmetros diferentes, oferecem múltiplas formas de uso.

---

## Upcasting e Downcasting

**Upcasting** é quando uma referência de uma subclasse é atribuída a uma variável do tipo da superclasse. É seguro e ocorre implicitamente.

```java
Animal animal = new Cachorro(); // Upcasting
```

**Downcasting** é quando uma referência da superclasse é convertida para uma subclasse. É explícito e pode causar erros se não for feito corretamente.

```java
Animal animal = new Cachorro();
Cachorro cachorro = (Cachorro) animal; // Downcasting
```

> Upcasting permite tratar objetos de subclasses como objetos da superclasse. Downcasting é usado para acessar métodos específicos da subclasse, mas requer cuidado.

---

## Classes e Métodos `final`

A palavra-chave `final` impede que classes sejam herdadas ou métodos sejam sobrescritos.

```java
final class Util { 
    // Não pode ser herdada
}

class Base {
    final void metodo() {
        // Não pode ser sobrescrito
    }
}
```

> Classes `final` garantem que não haverá subclasses. Métodos `final` garantem que o comportamento não será alterado por subclasses.

---

## Classes e Métodos Abstratos

Classes abstratas não podem ser instanciadas e servem como base para outras classes. Métodos abstratos não possuem implementação e devem ser sobrescritos pelas subclasses.

```java
abstract class Forma {
    abstract double calcularArea();
}

class Circulo extends Forma {
    double calcularArea() {
        // Implementação específica
    }
}
```

> Classes abstratas definem um contrato para subclasses. Métodos abstratos obrigam subclasses a fornecer uma implementação.

---

## Abstração

A **abstração** representa apenas as características essenciais de um objeto, escondendo detalhes complexos. Em Java, é implementada com classes abstratas ou interfaces.

```java
interface Veiculo {
    void ligar();
    void acelerar();
}

class Carro implements Veiculo {
    public void ligar() {
        System.out.println("Carro ligado");
    }

    public void acelerar() {
        System.out.println("Carro acelerando");
    }
}
```

> A interface define o comportamento esperado, enquanto a classe fornece a implementação concreta.

---

## Resumo dos Princípios

| Princípio        | Descrição                                      |
|------------------|------------------------------------------------|
| Encapsulamento   | Protege dados e controla acesso                 |
| Herança          | Reutiliza código e define hierarquias           |
| Polimorfismo     | Permite múltiplas formas de interação           |
| Abstração        | Foca nas características essenciais             |
| Upcasting        | Trata objetos da subclasse como superclasse     |
| Downcasting      | Converte referência da superclasse para subclasse|
| final            | Impede herança ou sobrescrita                   |
| abstrato         | Define contratos e obriga implementação         |

---

## Conclusão

Quando aplicados corretamente, esses princípios resultam em código organizado, reutilizável e fácil de manter, fundamental para o desenvolvimento de sistemas modernos.