# Tratamento de Exceções em Java

Durante a execução de um programa, diversos problemas podem ocorrer: arquivos podem não existir, divisões podem envolver zero, conexões podem falhar ou dados podem estar em formato inválido. Esses problemas são chamados de **exceções**.

O **tratamento de exceções** permite que o programa lide com esses erros de forma controlada, evitando que a aplicação pare de funcionar e permitindo reagir adequadamente ao problema.

Java possui um sistema robusto de tratamento de erros baseado em **objetos de exceção**, utilizando principalmente as estruturas `try`, `catch`, `finally` e a criação de **exceções personalizadas**.

---

## O que é uma Exceção

Uma **exceção** é um evento que ocorre durante a execução de um programa e interrompe o fluxo normal de execução.

**Exemplo clássico:**

```java
int x = 10;
int y = 0;
int resultado = x / y; // Gera ArithmeticException: / by zero
```

Sem tratamento adequado, o programa é interrompido.

---

## Hierarquia de Exceções em Java

Todas as exceções em Java derivam da classe base `java.lang.Throwable`. A hierarquia principal é:

```
Throwable
 ├── Error
 └── Exception
    ├── RuntimeException
    └── outras exceções verificadas
```

- **Error**: Representa erros graves da JVM, normalmente não tratados pelo programa (ex: `OutOfMemoryError`, `StackOverflowError`).
- **Exception**: Representa condições que podem ser tratadas pelo programa.

### Tipos de Exceções

| Tipo                | Característica                                 |
|---------------------|------------------------------------------------|
| Checked Exceptions  | Precisam ser tratadas ou declaradas            |
| Unchecked Exceptions| Ocorrem em tempo de execução                   |

#### Checked Exceptions

São exceções que o compilador exige que sejam tratadas.

**Exemplo:**  
- `IOException`
- `SQLException`

O programador deve usar `try-catch` ou `throws`.

#### Unchecked Exceptions

São exceções que ocorrem em tempo de execução.

**Exemplo:**  
- `NullPointerException`
- `ArithmeticException`
- `ArrayIndexOutOfBoundsException`

Essas não precisam ser declaradas explicitamente.

---

## Estrutura try-catch

O bloco `try-catch` é usado para capturar exceções e tratá-las.

**Estrutura básica:**

```java
try {
    // código que pode gerar erro
} catch (TipoDaExcecao e) {
    // tratamento da exceção
}
```

**Exemplo:**

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Não é possível dividir por zero");
}
```

Nesse caso, o programa captura o erro e continua executando.

---

### Múltiplos Blocos catch

Um `try` pode possuir vários `catch` para diferentes tipos de exceção.

```java
try {
    int[] numeros = new int[3];
    numeros[5] = 10;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Índice inválido");
} catch (Exception e) {
    System.out.println("Erro genérico");
}
```

O Java executa o primeiro `catch` compatível.

---

## Stack Trace (Pilha de Chamadas)

Quando uma exceção ocorre, o Java gera um *stack trace*, mostrando a sequência de chamadas de métodos até o erro.

**Exemplo:**
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.calcular(Main.java:10)
    at Main.main(Main.java:5)
```

O stack trace ajuda a identificar onde o erro ocorreu.

---

## Obtendo informações da exceção

O objeto da exceção possui métodos úteis.

**Exemplo:**

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println(e.getMessage());
    e.printStackTrace();
}
```

| Método            | Função                      |
|-------------------|----------------------------|
| `getMessage()`    | Retorna a mensagem do erro  |
| `printStackTrace()`| Imprime o stack trace      |

---

## Bloco finally

O bloco `finally` contém código que sempre será executado, independentemente de ocorrer ou não uma exceção.

**Estrutura:**

```java
try {
    // operação
} catch (Exception e) {
    // tratamento
} finally {
    // sempre executa
}
```

**Exemplo:**

```java
try {
    System.out.println("Executando operação");
} catch (Exception e) {
    System.out.println("Erro");
} finally {
    System.out.println("Sempre executa");
}
```

Uso comum do `finally`:
- Fechar arquivos
- Fechar conexões
- Liberar recursos

---

## Lançando Exceções (`throw`)

Também é possível lançar exceções manualmente usando `throw`.

**Exemplo:**

```java
if (idade < 18) {
    throw new IllegalArgumentException("Idade inválida");
}
```

---

## Declarando Exceções (`throws`)

Quando um método pode gerar uma exceção, ele pode declarar isso com `throws`.

```java
public void lerArquivo() throws IOException {
    // código
}
```

Quem chamar esse método deverá tratar ou declarar a exceção.

---

## Criando Exceções Personalizadas

É possível criar exceções específicas para regras de negócio, tornando o código mais claro e organizado.

**Exemplo:**

```java
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
      super(mensagem);
    }
}
```

**Uso:**

```java
if (valor > saldo) {
    throw new SaldoInsuficienteException("Saldo insuficiente");
}
```

---

## Más Práticas no Tratamento de Exceções

Algumas formas de lidar com exceções são consideradas ruins.

**Ignorar a exceção (muito ruim):**

```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    // catch vazio
}
```

Isso esconde erros e dificulta o debug.

**Apenas imprimir a mensagem (ruim):**

```java
catch (Exception e) {
    System.out.println("Erro");
}
```

Isso perde informações importantes do erro.

**Boa prática:**

Registrar o erro e tratar adequadamente.

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Erro ao dividir números");
    e.printStackTrace();
}
```

---

## Boas Práticas no Tratamento de Exceções

- Tratar exceções específicas
- Não ignorar erros
- Registrar logs
- Criar exceções personalizadas quando necessário
- Não capturar exceções genéricas sem necessidade
- Nunca deixar um `catch` vazio
- Usar exceções para situações excepcionais
- Criar exceções específicas para regras de negócio

---

## Conclusão

O tratamento de exceções é essencial para construir aplicações robustas e confiáveis. Ele permite controlar erros que ocorrem durante a execução do programa e evitar falhas inesperadas.

Java oferece um mecanismo poderoso baseado em `try`, `catch`, `finally`, `throw` e `throws`, além da possibilidade de criar exceções personalizadas. Quando usado corretamente, esse sistema melhora significativamente a manutenibilidade, estabilidade e qualidade do software.
