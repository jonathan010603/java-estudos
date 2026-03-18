# Scanner em Java

Usado para ler entrada, como texto digitado pelo usuário, arquivos ou strings. Facilita a leitura de diferentes tipos de dados (int, double, String, etc.) de diversas fontes.

## Como funciona

```java
import java.util.Scanner;

// Passamos o fluxo de entrada desejado
// No caso, System.in
Scanner scanner = new Scanner(System.in);

System.out.print("Digite um número inteiro: ");

int numero = scanner.nextInt();
System.out.println("Você digitou: " + numero);

scanner.close();
```

- O `Scanner` possui métodos para ler diferentes tipos de dados:
    - `nextInt()` para inteiros
    - `nextDouble()` para números decimais
    - `nextLine()` para linhas de texto
    - `next()` para palavras

- Após o uso, recomenda-se fechar o scanner para liberar recursos.
    ```java
    scanner.close();
    ```

## Exemplos

### Ler um número inteiro

```java
import java.util.Scanner;

public class ExemploInt {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Digite um número inteiro: ");
          int numero = scanner.nextInt();
          System.out.println("Você digitou: " + numero);
          scanner.close();
     }
}
```

### Ler uma linha de texto

```java
import java.util.Scanner;

public class ExemploTexto {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Digite seu nome: ");
          String nome = scanner.nextLine();
          System.out.println("Olá, " + nome + "!");
          scanner.close();
     }
}
```

### Ler múltiplos tipos de dados

```java
import java.util.Scanner;

public class ExemploMultiplo {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Digite sua idade: ");
          int idade = scanner.nextInt();
          scanner.nextLine(); // Limpa o buffer
          System.out.print("Digite seu nome: ");
          String nome = scanner.nextLine();
          System.out.println(nome + " tem " + idade + " anos.");
          scanner.close();
     }
}
```

## Observações

- Ao alternar entre métodos como `nextInt()` e `nextLine()`, pode ser necessário limpar o buffer usando `scanner.nextLine()`.
- O `Scanner` pode ler de outras fontes, como arquivos (`new Scanner(new File("arquivo.txt"))`).

## Resumo

O `Scanner` é uma ferramenta prática para entrada de dados em Java, permitindo ler diferentes tipos de valores de várias fontes de maneira simples e eficiente.