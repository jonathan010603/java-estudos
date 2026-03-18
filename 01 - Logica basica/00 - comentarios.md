# Comentários em Java

### 1. Comentário de uma linha

```java
// Este é um comentário de uma linha
int x = 10; // Comentário ao lado do código
```

### 2. Comentário de múltiplas linhas

```java
/*
Este é um comentário
de múltiplas linhas
*/
int y = 20;
```

### 3. Comentário de documentação

Use `/** ... */` para gerar documentação com ferramentas como o Javadoc.

```java
/**
 * Soma dois números.
 * @param a Primeiro número
 * @param b Segundo número
 * @return Soma de a e b
 */
public int soma(int a, int b) {
    return a + b;
}
```

## Dicas

- Use comentários para explicar partes complexas do código.
- Evite comentários desnecessários em código óbvio.
- Comentários de documentação ajudam a criar manuais automáticos.
