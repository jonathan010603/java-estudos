# Operações Bitwise em Java

Operações **bitwise** manipulam diretamente os **bits** (0 e 1) de números inteiros.

Computadores armazenam números em **binário**. Por exemplo:

```
5 = 00000101
3 = 00000011
```

As operações bitwise trabalham **bit por bit**, comparando ou movendo esses valores.

Elas são usadas em:

- Otimizações de performance
- Manipulação de **flags**
- Criptografia
- Compressão de dados
- Programação de baixo nível

---

## Operadores Bitwise

| Operador | Nome                   | O que faz                                      |
|----------|------------------------|------------------------------------------------|
| `&`      | AND                    | 1 apenas se **os dois bits forem 1**           |
| `\|`     | OR                     | 1 se **pelo menos um bit for 1**               |
| `^`      | XOR                    | 1 se **os bits forem diferentes**              |
| `~`      | NOT                    | **Inverte todos os bits**                      |
| `<<`     | Left Shift             | Move os bits **para esquerda**                 |
| `>>`     | Right Shift            | Move os bits **para direita mantendo o sinal** |
| `>>>`    | Unsigned Right Shift   | Move os bits **para direita preenchendo com 0**|

---

## Exemplos

### AND (`&`)

Compara bit por bit. Só retorna 1 se ambos forem 1.

```java
int a = 5;   // 00000101
int b = 3;   // 00000011

// Operação:
    00000101
& 00000011
-----------
    00000001

int result = a & b; // 1
```

---

### OR (`|`)

Retorna 1 se pelo menos um bit for 1.

```java
// Operação:
    00000101
| 00000011
-----------
    00000111

int result = a | b; // 7
```

---

### XOR (`^`)

Retorna 1 apenas se os bits forem diferentes.

```java
// Operação:
    00000101
^ 00000011
-----------
    00000110

int result = a ^ b; // 6
```

---

### NOT (`~`)

Inverte todos os bits.

```java
int a = 5;      // 00000101
int result = ~a; // 11111010 (em Java: -6, por complemento de dois)
```

---

## Shift

Shift significa "deslocar bits", ou seja, mover os bits para esquerda ou direita dentro do número binário.

### Shift à Esquerda (`<<`)

Move os bits para esquerda. Normalmente equivale a multiplicar por 2.

```java
int a = 5; // 00000101

int result = a << 1; // 00001010 = 10
int result2 = a << 2; // 00010100 = 20
int result3 = a << 3; // 00101000 = 40
```

---

### Shift à Direita (`>>`)

Move os bits para direita. Normalmente equivale a dividir por 2.

```java
int a = 8; // 00001000

int result = a >> 1; // 00000100 = 4
int result2 = a >> 2; // 00000010 = 2
```

---

### Shift à Direita Lógico (`>>>`)

Parecido com `>>`, mas sempre preenche com 0 na esquerda, ignorando o sinal do número.

```java
int a = -8;
int result = a >>> 1;
```

---

## Resumo

- Bitwise manipula diretamente bits (0 e 1)
- AND compara bits
- OR combina bits
- XOR detecta diferenças
- NOT inverte bits
- Shift move bits para esquerda ou direita

Essas operações são extremamente rápidas, pois trabalham diretamente no nível do processador.