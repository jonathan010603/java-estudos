# Tipos Primitivos em Java

Java possui 8 tipos primitivos:

| Tipo    | Descrição                       | Exemplo                |
|---------|---------------------------------|------------------------|
| `byte`  | Inteiro de 8 bits               | `byte b = 100;`        |
| `short` | Inteiro de 16 bits              | `short s = 1000;`      |
| `int`   | Inteiro de 32 bits              | `int i = 100000;`      |
| `long`  | Inteiro de 64 bits              | `long l = 100000L;`    |
| `float` | Ponto flutuante de 32 bits      | `float f = 10.5f;`     |
| `double`| Ponto flutuante de 64 bits      | `double d = 20.99;`    |
| `char`  | Caractere Unicode de 16 bits    | `char c = 'A';`        |
| `boolean`| Valores verdadeiro ou falso    | `boolean flag = true;` |

# Type Casting

Podemos converter um tipo de dado em outro.

**1 - Widening Type Casting**

Converter um tipo de dado menor para um maior, é um processo **automático** e seguro que acontece quando:

- O tipo-alvo é maior que o tipo-fonte
- Os dois tipos são compatíveis

>byte -> short -> char -> int -> long -> float -> double 

**Exemplo:**
```java
int teste = 2;
double var = teste;
// var = 2.0
```

---

**2 - Narrowing Type Casting**

O contrário do widening. Converter um tipo de dado maior para um menor.
* Processo **manual**
* Não é seguro, risco de perda de dados na conversão

>double -> float -> long -> int -> char -> short -> byte

**Exemplo:**
```java
double teste = 2.0;
int var = (int) teste;
// var = 2
// Foi necessário explicitar a conversão com (int)
// Processo não é automático como no widening type casting
```

---

**3 - Int para String**

```java
int num = 50;
String strNum = String.valueOf(num);
```

---

**4 - String para Int**

```java
String str = "50";
int num = Integer.parseInt(str);
```