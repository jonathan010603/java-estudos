# Funções Matemáticas em Java

## 1. `Math.sqrt(double a)`
Raiz quadrada de um número.

```java
double raiz = Math.sqrt(16); // resultado: 4.0
```

## 2. `Math.pow(double a, double b)`
Potência de um número.

```java
double potencia = Math.pow(2, 3); // resultado: 8.0
```

## 3. `Math.abs(int a)`
Retorna o valor absoluto (módulo).

```java
int absoluto = Math.abs(-10); // resultado: 10
```

## 4. `Math.max(a, b)` e `Math.min(a, b)`
Maior ou menor valor entre dois números.

```java
int maior = Math.max(5, 10); // resultado: 10
int menor = Math.min(5, 10); // resultado: 5
```

## 5. `Math.round(double a)`
Arredonda para o inteiro mais próximo.

```java
long arredondado = Math.round(3.6); // resultado: 4
```

## 6. `Math.floor(double a)` e `Math.ceil(double a)`
Arredonda para baixo (`floor`) ou para cima (`ceil`).

```java
double baixo = Math.floor(3.7); // resultado: 3.0
double cima = Math.ceil(3.2);   // resultado: 4.0
```

## 7. `Math.random()`
Gera um número aleatório entre 0.0 e 1.0.

```java
double aleatorio = Math.random(); // exemplo: 0.54321
```