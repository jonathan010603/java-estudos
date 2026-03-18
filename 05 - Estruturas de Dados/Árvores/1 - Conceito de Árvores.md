## Árvores

São estruturas hierárquicas formadas por elementos (nós) conectados, que podem ter filhos.

---

## Características:
- **Raiz (root)** → primeiro nó da árvore
- **Folha (leaf)** → nó sem filhos
- **Pai / Filho** → relação entre nós
- **Altura** → maior caminho da raiz até uma folha
- **Subárvore** → qualquer parte da árvore

---

## Tipos comuns de Árvores
- **Árvore Binária** → cada nó tem no máximo 2 filhos
- **Árvore Binária de Busca (BST)** → esquerda < raiz < direita
- **Heap** → usada em filas de prioridade
- **Árvore AVL / Red-Black** → árvores balanceadas

---

## Inicialização

```java
// Criamos um node que recebe um dado
// Ele tem espaço para dois filhos
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Instanciamos o root e vamos adicionando os filhos
Node root = new Node(10);
root.left = new Node(5);
root.right = new Node(20);
```

---

## Exemplo em Java:
```java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);
        root.left.right = new Node(7);
    }
}
```

