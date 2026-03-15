# Interfaces em Orientação a Objetos

Em **Programação Orientada a Objetos (POO)**, uma **interface** define **um conjunto de métodos que uma classe deve implementar**.  
Ela funciona como um **contrato**: se uma classe implementa uma interface, ela **é obrigada a implementar todos os métodos definidos nela**.

Interfaces são usadas para:

- Definir comportamentos comuns
- Permitir **baixo acoplamento**
- Facilitar **polimorfismo**
- Organizar sistemas grandes
- Suportar **inversão de controle** e **injeção de dependência**

---

## Ideia Básica

Uma interface apenas **define o que deve ser feito**, mas **não como será feito**.

**Exemplo conceitual:**

```java
interface Animal {
    void fazerSom();
    void mover();
}
```

Cada classe decide **como implementar** esses métodos.

---

## Herança vs Cumprir Contrato

- **Herdar** (herança): Uma classe herda comportamento e estado de uma classe base.
- **Cumprir contrato** (interface): Uma classe se compromete a implementar métodos definidos pela interface, sem herdar implementação.

---

## Declarando uma Interface

Em Java, usamos a palavra-chave `interface`:

```java
interface Animal {
    void fazerSom();
    void mover();
}
```

Os métodos não possuem implementação, apenas a assinatura.

---

## Implementando uma Interface

Uma classe implementa uma interface usando a palavra-chave `implements`:

```java
class Cachorro implements Animal {
    public void fazerSom() {
        System.out.println("Au Au");
    }
    public void mover() {
        System.out.println("O cachorro está correndo");
    }
}
```

A classe é **obrigada a implementar todos os métodos** da interface.

---

## Usando a Interface: Inversão de Controle e Injeção de Dependência

Interfaces permitem **inversão de controle** e **injeção de dependência**.  
Você pode programar para interfaces e fornecer implementações em tempo de execução:

```java
class Servico {
    private Veiculo veiculo;

    // Injeção de dependência via construtor
    public Servico(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void iniciar() {
        veiculo.ligar();
    }
}
```

---

## Herança Múltipla e Problema do Diamante

- **Herança múltipla** de classes não é permitida em Java (uma classe só pode herdar de uma classe).
- Interfaces permitem herança múltipla: uma classe pode implementar várias interfaces.
- O **problema do diamante** ocorre quando duas interfaces possuem métodos default com a mesma assinatura.  
  O desenvolvedor precisa resolver o conflito implementando o método na classe.

---

## Uma Classe Pode Implementar Várias Interfaces

```java
interface Nadador {
    void nadar();
}

interface Corredor {
    void correr();
}

class Atleta implements Nadador, Corredor {
    public void nadar() {
        System.out.println("Nadando...");
    }
    public void correr() {
        System.out.println("Correndo...");
    }
}
```

---

## Métodos Default em Interfaces

Desde Java 8, interfaces podem ter métodos com implementação (`default methods`):

```java
interface Veiculo {
    void ligar();
    default void acelerar() {
        System.out.println("Acelerando...");
    }
}
```

Isso permite adicionar novos métodos sem quebrar implementações existentes.

---

## Interface Comparable

A interface `Comparable<T>` define um contrato para comparar objetos:

```java
class Pessoa implements Comparable<Pessoa> {
    private String nome;

    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }
}
```

Permite ordenar coleções de objetos.

---

## Interfaces vs Classes Abstratas

| Interface                      | Classe Abstrata           |
|---------------------------------|---------------------------|
| Define apenas comportamento     | Pode ter comportamento e estado |
| Não possui atributos comuns     | Pode ter atributos        |
| Uma classe pode implementar várias | Só pode herdar uma      |
| Usada para contratos           | Usada para base de herança |
| Suporta métodos default         | Pode ter métodos implementados |

---

## Exemplo Completo

**Interface:**

```java
interface Veiculo {
    void ligar();
    default void acelerar() {
        System.out.println("Veiculo acelerando");
    }
}
```

**Classe que implementa:**

```java
class Carro implements Veiculo {
    public void ligar() {
        System.out.println("Carro ligado");
    }
    // Pode usar o método default acelerar()
}
```

**Uso:**

```java
Veiculo v = new Carro();

v.ligar();      // Carro ligado
v.acelerar();   // Veiculo acelerando
```

---

## Resumo

- Interface define um contrato de métodos
- Classes usam `implements` para implementá-la
- A classe deve implementar todos os métodos abstratos
- Permite polimorfismo, inversão de controle e injeção de dependência
- Uma classe pode implementar várias interfaces (herança múltipla)
- Interfaces podem ter métodos default
- Problema do diamante pode ocorrer com métodos default
- Interfaces como `Comparable` são usadas para ordenar objetos
- Interfaces organizam grandes sistemas e garantem consistência entre classes