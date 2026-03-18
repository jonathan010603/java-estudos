## Queue

**Queues ou filas** estruturas lineares que seguem o FIFO (First In, First Out) -> O primeiro que entra é o primeiro que sai

---

## Características:
- **Fila de pessoas**: quem chega primeiro é o primeiro a ser atendido
- **rear**: inserção acontece no final
- **front**: remoção acontece no início
- Acesso controlado (início e fim)
- Mantém ordem de chegada
- Pode ser implementada com array ou linked list

---

## Inicialização

```java
Queue<Integer> fila = new LinkedList<>();

// ou

class Queue {
    int[] arr = new int[5];
    int front = 0;
    int rear = -1;
}

```

---

## Exemplo em Java:
```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.add(10); // adiciona
        fila.add(20);
        fila.add(30);

        System.out.println(fila.remove()); // remove 10
        System.out.println(fila.peek());   // próximo (20)
    }
}
```

