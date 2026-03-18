## Queue
Representa uma fila, focada na ordem de saída e não no acesso aleatório.

- **Sem índice**: Você só interage com o elemento que está no topo (cabeça) da fila.
- **Mantém** ordem de inserção
- **Aceita** duplicatas
- **FIFO**: First In First Out

#### Métodos importantes
- **add(E e)** → adiciona (erro se falhar)
- **offer(E e)** → adiciona (false se falhar)
- **remove()** → remove o primeiro (erro se vazio)
- **poll()** → remove o primeiro (null se vazio)
- **element()** → acessa o primeiro (erro se vazio)
- **peek()** → acessa o primeiro (null se vazio)

---

## QueueLinkedList
É pau para toda obra e implementa Queue.
#### Características
- Como cada elemento aponta para o próximo, remover o primeiro da fila é $O(1)$ (muito rápido).
- **Mantém ordem de inserção**
- **Permite inserção e remoção eficiente**
- **Vantagem**: Permite elementos null (embora não seja recomendado usar null em filas para não confundir com o retorno do poll()).
- **Uso**: quando você quer uma fila simples (FIFO)

#### Exemplo QueueLinkedList:
```java
public class QueueLinkedListExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Bruno");

        System.out.println(fila.poll()); // Ana (remove primeiro)
        System.out.println(fila); // [Carlos, Bruno]
    }
}
```

---

## PriorityQueue
Aqui a ordem não é por chegada, mas por importância.
#### Características
- **Estrutura de Heap Binária (fila de prioridade)**: os elementos são organizados para que o "menor" (ou de maior prioridade) saia primeiro.
- **Ordena automaticamente (prioridade)**
- **Rápido**: Inserção e remoção em $O(\log n)$.
- **Atenção**: Se você imprimir a PriorityQueue diretamente, ela vai parecer bagunçada. A ordem correta só é garantida no momento em que você remove o elemento com poll().
- **Uso**: quando a ordem depende de prioridade (menor/maior valor)

#### Exemplo PriorityQueue:
```java
public class PriorityQueueExemplo {
    public static void main(String[] args) {
        Queue<Integer> fila = new PriorityQueue<>();

        fila.add(30);
        fila.add(10);
        fila.add(20);

        System.out.println(fila.poll()); // 10 (menor primeiro)
        System.out.println(fila); // ordem interna não garantida visualmente
    }
}
```

---

## ArrayDeque
É uma "Fila de Duas Pontas" (Double Ended Queue) baseada em array circular.
#### Características
- **Implementa Queue e Deque**
- **Performance**: É mais rápida que a LinkedList tanto para Fila (FIFO) quanto para Pilha (LIFO), porque tem melhor localização de cache e menos objetos criados na memória.
- **Flexibilidade**: Você pode usar addFirst(), addLast(), removeFirst(), removeLast().
- **Restrição**: Não permite null. Se tentar adicionar, o Java lança erro na hora.
- **Uso**: **Recomendado quando você quer alta performance**

#### Exemplo ArrayDeque:
**Como Fila**:
```java
public class ArrayDequeExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new ArrayDeque<>();

        fila.offer("Ana");
        fila.offer("Carlos");

        System.out.println(fila.poll()); // Ana
    }
}
```

**Como Pilha**:
```java
public class ArrayDequeExemplo {
    public static void main(String[] args) {
        Deque<String> pilha = new ArrayDeque<>();

        pilha.push("Livro 1"); // Adiciona no topo
        pilha.push("Livro 2");

        System.out.println(pilha.pop()); // Livro 2 (remove o último que entrou)
    }
}
```

---

## Requisito de Comparação

Assim como no TreeSet, para a PriorityQueue funcionar com objetos seus (ex: Pessoa), a classe deve implementar Comparable ou você deve passar um Comparator no construtor. Caso contrário, o Java não saberá quem deve sair primeiro da fila.

### 1. Usando Comparable (Ordem Natural)
Você usa isso quando a classe tem uma ordem padrão que quase sempre será usada (ex: ID ou Nome). Você mexe na própria classe do objeto.
```java
// "implements Comparable" diz que o Produto sabe se comparar
class Produto implements Comparable<Produto> {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto outro) {
        // Ordena pelo preço (do menor para o maior)
        return Double.compare(this.preco, outro.preco);
    }

    @Override
    public String toString() {
        return nome + ": R$" + preco;
    }
}

public class ExemploComparable {
    public static void main(String[] args) {
        // PriorityQueue vai usar o compareTo automaticamente
        Queue<Produto> fila = new PriorityQueue<>();
        
        fila.add(new Produto("Teclado", 150.0));
        fila.add(new Produto("Mouse", 80.0));
        fila.add(new Produto("Monitor", 900.0));

        // Vai sair o Mouse primeiro (menor preço)
        while (!fila.isEmpty()) {
            System.out.println(fila.poll());
        }
    }
}
```

### 2. Usando Comparator (Ordem Personalizada)
Você usa isso quando quer uma ordem diferente da padrão ou quando não pode mexer no código da classe (ex: uma classe de uma biblioteca pronta). Você cria uma "regra de fora".
```java
class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() { return nome; }
}

public class ExemploComparator {
    public static void main(String[] args) {
        // Criando uma regra: Ordem Alfabética do Nome
        Comparator<Produto> ordemAlfabetica = (p1, p2) -> p1.nome.compareTo(p2.nome);

        // Passo a regra no construtor da Fila
        Queue<Produto> fila = new PriorityQueue<>(ordemAlfabetica);

        fila.add(new Produto("Zebra", 10.0));
        fila.add(new Produto("Abajur", 50.0));

        System.out.println(fila.poll()); // Sai "Abajur" mesmo sendo mais caro
    }
}
```

**Qual a diferença real?**
- **Comparable**: A lógica de comparação está dentro da classe. É a "Ordem Natural". (Usa o método compareTo).

- **Comparator**: A lógica está fora da classe. Serve para criar várias ordenações diferentes para o mesmo objeto. (Usa o método compare).

- **Dica de Ouro**: No dia a dia, use Comparable para o que for óbvio (tipo ID ou Data) e Comparator para filtros de usuário (tipo "Ordenar por mais barato", "Ordenar por avaliações").