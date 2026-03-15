# I — Interface Segregation Principle (ISP)

O **Interface Segregation Principle** é o quarto princípio do **SOLID**.

> **Clientes não devem ser forçados a depender de interfaces que não utilizam.**

Ou seja, **interfaces devem ser pequenas e específicas**, em vez de grandes e genéricas.

Se uma interface possui muitos métodos que nem todas as classes precisam usar, provavelmente ela deveria ser **dividida em interfaces menores**.

---

## O problema das interfaces grandes

Imagine uma interface para trabalhadores:

```java
interface Trabalhador {
    void trabalhar();
    void comer();
    void dormir();
}
```

Agora criamos um robô:

```java
class Robo implements Trabalhador {
    public void trabalhar() {
        System.out.println("Robô trabalhando");
    }
    public void comer() {
        // robôs não comem
    }
    public void dormir() {
        // robôs não dormem
    }
}
```

**Problema:**  
O robô foi forçado a implementar métodos que não fazem sentido.  
Isso viola o Interface Segregation Principle.

---

## Aplicando o ISP

Dividimos a interface em interfaces menores e específicas:

```java
interface Trabalhador {
    void trabalhar();
}
interface Alimentavel {
    void comer();
}
interface Dormivel {
    void dormir();
}
```

### Implementações

Agora cada classe implementa apenas o que realmente precisa.

**Pessoa:**

```java
class Pessoa implements Trabalhador, Alimentavel, Dormivel {
    public void trabalhar() {
        System.out.println("Pessoa trabalhando");
    }
    public void comer() {
        System.out.println("Pessoa comendo");
    }
    public void dormir() {
        System.out.println("Pessoa dormindo");
    }
}
```

**Robô:**

```java
class Robo implements Trabalhador {
    public void trabalhar() {
        System.out.println("Robô trabalhando");
    }
}
```

Agora o robô não precisa implementar métodos desnecessários.

---

## Benefícios do ISP

Seguir o Interface Segregation Principle traz várias vantagens:

- Interfaces mais simples
- Código mais organizado
- Menos implementações inúteis
- Maior flexibilidade

---

## Sinais de violação de ISP

Alguns sinais comuns:

- Interfaces muito grandes
- Classes implementando métodos vazios
- Métodos que lançam exceções como `UnsupportedOperationException`
- Classes implementando funcionalidades que não usam

---

## Regra prática

Uma boa regra é:

> Prefira várias interfaces pequenas em vez de uma interface grande.

Assim, cada classe implementa apenas o que realmente precisa.

---

## Resumo

- ISP significa Interface Segregation Principle
- Interfaces devem ser pequenas e específicas
- Classes não devem implementar métodos que não utilizam
- Prefira múltiplas interfaces especializadas

Esse princípio ajuda a criar sistemas mais flexíveis, organizados e fáceis de manter.
