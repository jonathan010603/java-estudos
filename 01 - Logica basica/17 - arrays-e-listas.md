# Arrays, Listas e Dictionaries: Conceitos e Manipulação

## Arrays (Vetores)

**array** (ou **vetor**) armazena elementos de **mesmo tipo** em **sequência**.
São acessados através de um **índice**, que geralmente começa em `0`.

**Exemplo em Java:**

```java
int[] numeros = new int[5]; // Array de 5 inteiros
numeros[0] = 10;
numeros[1] = 20;
System.out.println(numeros[0]); // Imprime 10
```

**Representação em memória:**

| Índice | 0  | 1  | 2 | 3 | 4 |
|--------|----|----|---|---|---|
| Valor  | 10 | 20 | 0 | 0 | 0 |

Arrays possuem **tamanho fixo**, definido no momento da criação.

### Inicialização de Arrays

Arrays podem ser inicializados diretamente:

```java
int[] numeros = {10, 20, 30, 40};
```

Ou com tamanho definido:

```java
int[] numeros = new int[4];
```

Valores padrão:

| Tipo     | Valor padrão |
|----------|--------------|
| int      | 0            |
| double   | 0.0          |
| boolean  | false        |
| objetos  | null         |

### Matrizes (Arrays Multidimensionais)

Uma matriz é um array que contém outros arrays.

**Exemplo de matriz 2D:**

```java
int[][] matriz = new int[3][3];
matriz[0][1] = 5;
```

**Percorrendo a matriz:**

```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.println(matriz[i][j]);
    }
}
```

---

## Listas

Listas são estruturas de dados **dinâmicas**, ou seja, seu tamanho pode aumentar ou diminuir conforme necessário. Em Java, a implementação mais comum é `ArrayList`.

**Exemplo:**

```java
import java.util.ArrayList;

ArrayList<String> nomes = new ArrayList<>();
nomes.add("Ana");
nomes.add("Carlos");
nomes.add("Maria");

System.out.println(nomes.get(0)); // Imprime "Ana"
nomes.remove("Carlos");
```

**Vantagens das listas:**

- Tamanho dinâmico
- Métodos prontos para manipulação
- Facilidade de uso

---

## Dictionaries (Mapas)

Um **dictionary** (ou **mapa**) armazena pares **chave-valor**. Em Java, usamos `HashMap`.

**Exemplo:**

```java
import java.util.HashMap;

HashMap<String, Integer> idades = new HashMap<>();
idades.put("Ana", 25);
idades.put("Carlos", 30);

System.out.println(idades.get("Ana")); // Imprime 25
```

**Estrutura conceitual:**

- Ana → 25
- Carlos → 30

Dictionaries são úteis para acessar dados através de chaves únicas.

---

## Tipos por Valor e Tipos por Referência

Em muitas linguagens existem dois tipos principais de dados:

| Tipo             | Característica                |
|------------------|------------------------------|
| Tipo por valor   | Armazena o valor diretamente |
| Tipo por referência | Armazena referência para objeto |

### Tipos por Valor

Armazenam o valor diretamente na variável.

**Exemplos:** `int`, `double`, `boolean`, `char`

```java
int a = 10;
int b = a;
b = 20;
// a = 10, b = 20
```

Cada variável possui sua própria cópia do valor.

### Tipos por Referência

Armazenam um endereço de memória que aponta para um objeto.

**Exemplos:** objetos, arrays, listas, mapas

```java
int[] a = {1,2,3};
int[] b = a;
b[0] = 10;
// a[0] = 10, b[0] = 10
```

Ambas as variáveis apontam para o mesmo objeto na memória.

---

## Escopo Local

O escopo determina onde uma variável pode ser acessada. Um escopo local significa que a variável existe apenas dentro de um bloco de código.

```java
void exemplo() {
    int x = 10;
    // x só existe aqui dentro
}
```

Após a execução do método, a variável deixa de existir.

---

## Gerenciamento de Memória

Quando objetos são criados em linguagens como Java, eles ocupam memória.

```java
Pessoa p = new Pessoa();
```

- Memória é alocada
- O objeto é criado
- A variável guarda referência para esse objeto

---

## Garbage Collector

O **Garbage Collector (GC)** é um mecanismo automático responsável por liberar memória ocupada por objetos que não são mais utilizados.

```java
Pessoa p = new Pessoa();
p = null; // GC pode remover o objeto da memória
```

Isso evita problemas como vazamento de memória.

---

## Desalocação de Memória

Em linguagens como C ou C++, o programador precisa liberar memória manualmente.

```cpp
delete objeto;
```

Em linguagens gerenciadas como Java, essa tarefa é realizada automaticamente pelo garbage collector.

---

## Boxing e Unboxing

- **Boxing:** converte um tipo primitivo em um objeto.
- **Unboxing:** processo inverso.

```java
Integer numero = 10; // Boxing automático
int valor = numero;  // Unboxing automático
```

---

## Wrapper Classes

As wrapper classes encapsulam tipos primitivos.

| Tipo primitivo | Wrapper    |
|----------------|-----------|
| int            | Integer   |
| double         | Double    |
| boolean        | Boolean   |
| char           | Character |

**Exemplo:**

```java
Integer numero = Integer.valueOf(10);
```

Wrappers são necessários em situações como:

- Uso em coleções (`ArrayList`)
- Manipulação de objetos
- Conversões

---

## Iteração com foreach

O `foreach` é uma forma simplificada de percorrer coleções e arrays.

**Exemplo com array:**

```java
int[] numeros = {1,2,3,4};
for (int n : numeros) {
    System.out.println(n);
}
```

**Exemplo com lista:**

```java
ArrayList<String> nomes = new ArrayList<>();
nomes.add("Ana");
nomes.add("Carlos");

for (String nome : nomes) {
    System.out.println(nome);
}
```

O `foreach` é útil quando não precisamos acessar o índice.

---

## Comparação entre Arrays, Listas e Dictionaries

| Estrutura  | Característica     |
|------------|-------------------|
| Array      | Tamanho fixo      |
| Lista      | Tamanho dinâmico  |
| Dictionary | Chave → valor     |

---

## Conclusão

Arrays, listas e dictionaries são estruturas essenciais para armazenar e manipular dados em programas. Arrays oferecem acesso rápido e estrutura simples, mas possuem tamanho fixo. Listas oferecem flexibilidade e métodos prontos para manipulação de dados. Dictionaries permitem associar valores a chaves, facilitando buscas rápidas.

Compreender conceitos como tipos por valor e referência, gerenciamento de memória, garbage collector, boxing, unboxing e wrapper classes é fundamental para entender como os dados são armazenados e manipulados internamente. Esses conhecimentos ajudam a escrever código mais eficiente, seguro e fácil de manter.
