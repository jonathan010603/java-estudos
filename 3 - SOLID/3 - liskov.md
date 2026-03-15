# L — Liskov Substitution Principle (LSP)

O **Liskov Substitution Principle** é o terceiro princípio do **SOLID**.

> **Objetos de uma classe derivada devem poder substituir objetos da classe base sem alterar o comportamento esperado do programa.**

Se uma classe **B herda de uma classe A**, então **B deve poder ser usada no lugar de A sem quebrar o sistema**.

Esse princípio foi definido por **Barbara Liskov** em 1987.

---

## Ideia Principal

Se temos um código que funciona com uma classe base, ele **também deve funcionar com qualquer subclasse**.

**Exemplo conceitual:**

- Classe base: `Animal`
- Subclasse: `Cachorro`

Se um método espera um `Animal`, ele deve funcionar normalmente quando receber um `Cachorro`.

---

## Exemplo que viola LSP

Imagine uma classe `Retangulo`:

```java
class Retangulo {
    protected int largura;
    protected int altura;

    void setLargura(int largura) {
        this.largura = largura;
    }

    void setAltura(int altura) {
        this.altura = altura;
    }

    int area() {
        return largura * altura;
    }
}
```

Agora criamos uma classe `Quadrado`:

```java
class Quadrado extends Retangulo {
    void setLargura(int largura) {
        this.largura = largura;
        this.altura = largura;
    }

    void setAltura(int altura) {
        this.altura = altura;
        this.largura = altura;
    }
}
```

**Problema:**  
Um quadrado não se comporta exatamente como um retângulo, pois ao alterar a largura também alteramos a altura.

Veja o código:

```java
Retangulo r = new Quadrado();

r.setLargura(5);
r.setAltura(10);

System.out.println(r.area());
```

**Esperado para um retângulo:**

```
5 * 10 = 50
```

**Mas com Quadrado o resultado pode ser:**

```
10 * 10 = 100
```

Isso quebra o comportamento esperado. Portanto, violamos o Liskov Substitution Principle.

---

## Como corrigir

Uma solução é separar comportamentos diferentes em abstrações diferentes.

**Por exemplo:**

```java
interface Forma {
    int area();
}
```

Implementações:

```java
class Retangulo implements Forma {
    int largura;
    int altura;

    Retangulo(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public int area() {
        return largura * altura;
    }
}

class Quadrado implements Forma {
    int lado;

    Quadrado(int lado) {
        this.lado = lado;
    }

    public int area() {
        return lado * lado;
    }
}
```

Agora cada classe tem seu próprio comportamento correto.

---

## Sinais de violação de LSP

- Subclasses que mudam o comportamento esperado
- Necessidade de `if` para tratar subclasses
- Subclasses que ignoram métodos da classe base
- Exceções inesperadas em subclasses

---

## Regra prática

Pergunta importante:

> **Uma subclasse realmente é um tipo da classe base?**

Se a resposta for não, então herança provavelmente está sendo usada de forma errada.

---

## Benefícios do LSP

Seguir o Liskov Substitution Principle traz várias vantagens:

- Código mais previsível
- Herança mais segura
- Menos bugs inesperados
- Melhor reutilização de código

---

## Resumo

- LSP significa **Liskov Substitution Principle**
- Subclasses devem poder substituir a classe base
- O comportamento do programa não deve mudar
- Herança deve respeitar o contrato da classe base

Esse princípio garante que hierarquias de herança sejam corretas e seguras.
