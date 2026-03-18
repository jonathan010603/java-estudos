## Stacks

**Stacks ou pilhas** estruturas lineares que seguem o LIFO (Last In, First Out) -> O último que entra é o primeiro que sai

---

## Características:
- **Pilha de pratos**: elementos entram e saem pelo topo da pilha

---

## Inicialização

- É necessário criar e encadear os nós manualmente:
```java
Stack<String> pilha = new Stack<>();

pilha.push("prato de baixo"); // adiciona
pilha.push("prato do meio");
pilha.push("prato de cima");
```

---

## Exemplo em Java:
```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();

        pilha.push(10); // adiciona
        pilha.push(20);
        pilha.push(30);

        System.out.println(pilha.pop()); // remove 30
        System.out.println(pilha.peek()); // topo atual (20)
    }
}
```

