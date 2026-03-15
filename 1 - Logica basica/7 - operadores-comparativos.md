# Operadores Comparativos em Java

Os operadores comparativos são usados para comparar valores e retornar um resultado booleano (`true` ou `false`). Eles são essenciais em estruturas de decisão como `if`, `while`, etc.

## Principais Operadores

| Operador | Significado           | Exemplo         |
|----------|----------------------|-----------------|
| `==`     | Igual a              | `a == b`        |
| `!=`     | Diferente de         | `a != b`        |
| `>`      | Maior que            | `a > b`         |
| `<`      | Menor que            | `a < b`         |
| `>=`     | Maior ou igual a     | `a >= b`        |
| `<=`     | Menor ou igual a     | `a <= b`        |

## Exemplos em Código

```java
int a = 10;
int b = 20;

System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a > b);  // false
System.out.println(a < b);  // true
System.out.println(a >= b); // false
System.out.println(a <= b); // true
```

> Para comparar objetos (como `String`), use o método `.equals()`:
```java
String s1 = "Java";
String s2 = "Java";
System.out.println(s1.equals(s2)); // true
```
