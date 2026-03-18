## Linked Lists

**Listas ligadas** são estruturas onde os elementos **(nós)** são ligados por referência, não por posição de memória(como nos arrays). 

---

## Características:
- **Cada elemento contém**:
    - Valor (data)
    - Referência para o próximo elemento (next)
- **Tamanho dinâmico**: cresce conforme o necessário
- **Não é contínua na memória**: elementos podem estar em qualquer lugar da memória
- **Inserção/remoção eficiente**: sem deslocar elementos 
- **Acesso sequencial**: sem índice direto

---

## Inicialização

- É necessário criar e encadear os nós manualmente:
```java
Node n1 = new Node(10);
Node n2 = new Node(20);
n1.next = n2;

// outro exemplo:

Node head = new Node(10);
head.next = new Node(20);
head.next.next = new Node(30);
```

---

## Exemplo em Java:
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        // Encadeando os nós
        n1.next = n2;
        n2.next = n3;

        // Percorrendo a lista
        Node current = n1;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
```

