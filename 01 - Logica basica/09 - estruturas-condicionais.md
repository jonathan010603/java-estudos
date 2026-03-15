# Estruturas Condicionais em Java

Estruturas condicionais permitem executar diferentes blocos de código dependendo de condições lógicas.

## `if`, `else if`, `else`

```java
int idade = 18;

if (idade < 18) {
    System.out.println("Menor de idade");
} else if (idade == 18) {
    System.out.println("Tem 18 anos");
} else {
    System.out.println("Maior de idade");
}
```

## `switch`

O `switch` é usado para múltiplas opções.

```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Domingo");
        break;
    case 2:
        System.out.println("Segunda-feira");
        break;
    case 3:
        System.out.println("Terça-feira");
        break;
    default:
        System.out.println("Outro dia");
}
```

## Operador Ternário

Forma compacta de condição.

```java
int numero = 10;
String resultado = (numero % 2 == 0) ? "Par" : "Ímpar";
System.out.println(resultado);
```
