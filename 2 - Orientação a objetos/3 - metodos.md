# Métodos em Orientação a Objetos

Em **Programação Orientada a Objetos (POO)**, um **método** é uma função definida dentro de uma classe. Os métodos representam **ações ou comportamentos** que um objeto pode executar.

Por exemplo, na classe `Carro`, alguns métodos possíveis seriam:

```java
ligar()
acelerar()
frear()
```

Esses métodos descrevem **o que o objeto pode fazer**.

---

## Estrutura de um Método

Um método em Java possui geralmente a seguinte estrutura:

```java
tipoRetorno nomeMetodo(parametros) {
    // código executado pelo método
}
```

**Exemplo:**

```java
void falar() {
    System.out.println("Olá!");
}
```

**Partes do método:**

| Parte         | Descrição                  |
|---------------|---------------------------|
| `void`        | Tipo de retorno            |
| `falar`       | Nome do método             |
| `()`          | Parâmetros                 |
| `{}`          | Bloco de código executado  |

---

### Método sem Retorno

Quando um método não retorna nenhum valor, usamos o tipo `void`.

**Exemplo:**

```java
void ligar() {
    System.out.println("O carro está ligado");
}
```

**Uso:**

```java
carro.ligar();
```

---

### Método com Retorno

Um método pode retornar um valor após executar alguma operação.

**Exemplo:**

```java
int somar(int a, int b) {
    return a + b;
}
```

**Uso:**

```java
int resultado = somar(5, 3); // resultado: 8
```

---

### Parâmetros

Parâmetros são valores que o método recebe para trabalhar.

**Exemplo:**

```java
void saudacao(String nome) {
    System.out.println("Olá " + nome);
}
```

**Uso:**

```java
saudacao("João"); // Saída: Olá João
```

---

## Métodos em Classes

Os métodos normalmente fazem parte de uma classe.

**Exemplo:**

```java
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }
}
```

**Uso:**

```java
Calculadora calc = new Calculadora();
int resultado = calc.somar(2, 3);
```

---

## Métodos e Objetos

Os métodos geralmente são chamados através de objetos.

**Exemplo:**

```java
Pessoa p = new Pessoa();
p.falar();
```

- `p` é o objeto
- `falar()` é o método chamado

---

## Exemplo Completo

```java
class Cachorro {
    String nome;

    void latir() {
        System.out.println(nome + " está latindo!");
    }
}
```

**Uso:**

```java
Cachorro c = new Cachorro();
c.nome = "Rex";
c.latir(); // Saída: Rex está latindo!
```

---

## Resumo

- Métodos representam ações que objetos podem executar
- São definidos dentro de classes
- Podem receber parâmetros
- Podem retornar valores
- São chamados através de objetos

Métodos permitem que objetos interajam e executem comportamentos dentro do programa.