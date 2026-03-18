# Declarando Variáveis em Java

Você pode inicializar a variável em outra parte do códgo:

```java
int idade;
double salario;
char inicial;
boolean ativo;
String nome;

idade = 25;
salario = 3500.50;
inicial = 'J';
ativo = true;
nome = "João";
```

ou já na declaração:
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