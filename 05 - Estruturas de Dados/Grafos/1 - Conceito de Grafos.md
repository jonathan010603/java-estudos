## Grafos

São estruturas sem hierarquia obrigatória, formadas por vértices (nós) e arestas (ligações). Suas conecões são mais flexíveis e cada nó pode ter várias conexões com outros, sem uma hierarquia fixa.

---

## Características:
- **Raiz (root)** → primeiro nó da árvore
- **Folha (leaf)** → nó sem filhos
- **Pai / Filho** → relação entre nós
- **Altura** → maior caminho da raiz até uma folha
- **Subárvore** → qualquer parte da árvore

- **Vértice (vertex)** → ponto do grafo
- **Aresta (edge)** → conexão entre vértices
- **Grafo direcionado** → arestas têm direção
- **Grafo não direcionado** → conexões bidirecionais
- **Caminho** → sequência de vértices conectados
- **Ciclo** → caminho que começa e termina no mesmo nó
- Estrutura não linear
- Pode ter ciclos
- Extremamente flexível (modela quase tudo)
- Pode ser:
    - direcionado ou não
    - ponderado (com pesos) ou não

---

## Tipos comuns de Árvores
- **Grafo simples** → sem laços ou múltiplas arestas
- **Grafo direcionado** (digrafo)
- **Grafo ponderado** → arestas com valores (peso)
- **Grafo completo** → todos conectados entre si

---

## Inicialização

```java
// Forma comum: lista de adjacência
Map<Integer, List<Integer>> grafo = new HashMap<>();
grafo.put(1, new ArrayList<>());

// Ou matriz de adjacência:

int[][] matriz = new int[4][4];
```

---

## Exemplo em Java:
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> grafo = new HashMap<>();

        // criando conexões
        grafo.put(1, Arrays.asList(2, 3));
        grafo.put(2, Arrays.asList(1, 4));
        grafo.put(3, Arrays.asList(1));
        grafo.put(4, Arrays.asList(2));

        // imprimindo conexões do nó 1
        System.out.println(grafo.get(1)); // [2, 3]
    }
}
```

