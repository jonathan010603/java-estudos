# Estruturas de Repetição em Java

## 1. For

Usado quando se sabe o número de repetições.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Valor de i: " + i);
}
```

## 2. While

Usado quando não se sabe o número de repetições, mas depende de uma condição.

```java
int i = 0;
while (i < 5) {
    System.out.println("Valor de i: " + i);
    i++;
}
```

## 3. Do-While

Semelhante ao `while`, mas garante pelo menos uma execução.

```java
int i = 0;
do {
    System.out.println("Valor de i: " + i);
    i++;
} while (i < 5);
```

## Observações

- Use `break` para sair do loop antes do término.
- Use `continue` para pular para a próxima iteração.
