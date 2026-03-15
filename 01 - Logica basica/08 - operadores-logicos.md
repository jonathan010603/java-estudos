# Operadores Lógicos em Java

Os operadores lógicos são usados para combinar expressões booleanas e controlar o fluxo de decisões em programas Java.

## Principais operadores

| Operador | Descrição         | Exemplo           |
|----------|-------------------|-------------------|
| `&&`     | E lógico (AND)    | `a && b`          |
| `||`     | OU lógico (OR)    | `a || b`          |
| `!`      | NÃO lógico (NOT)  | `!a`              |

## Exemplos

```java
boolean a = true;
boolean b = false;

// AND: verdadeiro se ambos forem verdadeiros
System.out.println(a && b); // false

// OR: verdadeiro se pelo menos um for verdadeiro
System.out.println(a || b); // true

// NOT: inverte o valor booleano
System.out.println(!a);     // false
```

## Uso prático

```java
int idade = 20;
boolean temCarteira = true;

if (idade >= 18 && temCarteira) {
    System.out.println("Pode dirigir.");
} else {
    System.out.println("Não pode dirigir.");
}
```
