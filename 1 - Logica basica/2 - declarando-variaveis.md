# Declarando Variáveis em Java

Em Java, para declarar uma variável, você precisa informar o tipo de dado, seguido do nome da variável. Exemplos:

```java
int idade;           // Variável inteira
double salario;      // Variável de ponto flutuante
char inicial;        // Variável de caractere
boolean ativo;       // Variável booleana
String nome;         // Variável de texto (string)
```

Você pode também inicializar a variável ao declará-la:

```java
int idade = 25;
double salario = 3500.50;
char inicial = 'J';
boolean ativo = true;
String nome = "João";
```

## Regras para nomes de variáveis
- Devem começar com uma letra, `$` ou `_`.
- Não podem conter espaços.
- Não podem ser palavras reservadas do Java.

## Exemplo completo

```java
public class ExemploVariaveis {
    public static void main(String[] args) {
        int idade = 30;
        String nome = "Maria";
        boolean ativo = false;

        System.out.println(nome + " tem " + idade + " anos.");
        System.out.println("Está ativo? " + ativo);
    }
}
```