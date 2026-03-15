# Operador Ternário em Java

O operador ternário é uma forma concisa de realizar decisões condicionais. Sua sintaxe é:

```java
condição ? valor_se_verdadeiro : valor_se_falso;
```

## Exemplos

### 1. Verificando se um número é par ou ímpar

```java
int numero = 5;
String resultado = (numero % 2 == 0) ? "Par" : "Ímpar";
System.out.println(resultado); // Ímpar
```

### 2. Atribuindo valor com base em condição

```java
int idade = 18;
String status = (idade >= 18) ? "Maior de idade" : "Menor de idade";
System.out.println(status); // Maior de idade
```

### 3. Usando o operador ternário para retornar valores

```java
int a = 10, b = 20;
int maior = (a > b) ? a : b;
System.out.println(maior); // 20
```

O operador ternário é útil para simplificar expressões condicionais, tornando o código mais enxuto.