## List
Diferente do Set, aqui a ordem importa e duplicatas são bem-vindas.

- **Aceita** duplicatas
- **Usa** índice
- **Mantém** ordem de inserção

#### Métodos importantes
- **add(int index, E e)** → empurra todo mundo pra frente e enfia o elemento ali
- **get(int index)** → acesso direto
- **set(int index, E e)** → altera elemento
- **remove(int index)** → tira o cara e reorganiza a fila
- **indexOf(Object o)** → posição do elemento

---

## ArrayList
Funciona como um array que cresce sozinho.

#### Características
- **Acesso (get/set): Extremamente rápido ($O(1)$)** - O Java sabe exatamente onde o dado está na memória.
- **Inserção/Remoção**: 
    - No final da lista: muito rápido
    - No início ou no meio: Lento ($O(n)$), porque o Java precisa deslocar todos os outros elementos para o lado. 
- **Uso**: Leitura frequente e adições ao final da lista.

#### Exemplo ArrayList:
```java
public class ArrayListExemplo {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Ana"); // permitido

        System.out.println(nomes.get(0)); // Ana
        System.out.println(nomes); // [Ana, Carlos, Ana]
    }
}
```

---

## LinkedList
Aqui os elementos são "nós" que apontam um para o outro (lista duplamente ligada).

#### Características
- **Acesso (get/set): Lento ($O(n)$)** - Para pegar o 10º elemento, o Java tem que percorrer do 1º ao 9º primeiro.
- **Inserção/remoção**:
    - Se você já estiver com o "ponteiro" no lugar certo: Muito rápido ($O(1)$), pois ele só troca os endereços dos nós vizinhos.
    - Mito comum: "Inserir no meio é sempre mais rápido". Na verdade, para inserir no índice 500, ele primeiro gasta tempo chegando no índice 500.
- **Acesso mais lento**
- **Uso**: Quando há muitas inserções e remoções
- **Bônus**: Ela também implementa a interface Deque, então serve como Fila (Queue) ou Pilha (Stack).

#### Exemplo LinkedList:
```java
public class LinkedListExemplo {
    public static void main(String[] args) {
        List<String> nomes = new LinkedList<>();

        nomes.add("Ana");
        nomes.add("Bruno");

        nomes.add(1, "Carlos"); // insere no meio

        System.out.println(nomes); // [Ana, Carlos, Bruno]
    }
}
```

---

#### Dica de Performance

Sempre que possível, ao criar um ArrayList, se você já souber que terá 1000 itens, declare assim:

```java
List<String> lista = new ArrayList<>(1000);
```

Isso evita que o Java perca tempo redimensionando o array interno várias vezes enquanto ele cresce.