## Arrays (Vetores)

**array** (ou **vetor**) armazena elementos de **mesmo tipo** em **sequência**.
São acessados através de um **índice**, que geralmente começa em `0`.

---

## Características:
- **Tamanho definido**: delimita um espaço na memória
- **Armazenamento em espaço contínuo**: elementos são "vizinhos" na memória
- **Acesso por índice**: cada elemento possui um índice no Array

---

## Inicialização

Arrays podem ser inicializados diretamente:

```java
int[] numeros = {10, 20, 30, 40};
```

Ou com tamanho definido:

```java
int[] numeros = new int[4];
```

---

## Valores padrão:
Elementos **sem valor definido** recebem um valor padrão dependendo do tipo do Array:

| Tipo     | Valor padrão |
|----------|--------------|
| int      | 0            |
| double   | 0.0          |
| boolean  | false        |
| objetos  | null         |


---

## Exemplo em Java:
```java
int[] numeros = new int[5]; // Array de 5 inteiros
numeros[0] = 10;
numeros[1] = 20;
System.out.println(numeros[0]); // Imprime 10
```