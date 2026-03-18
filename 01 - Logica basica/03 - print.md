# Print

## 1. `System.out.println`
Imprime uma mensagem e pula para a próxima linha.
```java
System.out.println("Olá, mundo!");
```

## 2. `System.out.print`
Imprime uma mensagem sem pular para a próxima linha.
```java
System.out.print("Olá, ");
System.out.print("mundo!");

// "Olá, mundo!"
```

## 3. `System.out.printf`
Permite imprimir mensagens formatadas.
No exemplo abaixo, irá imprimit o número com apenas duas casas decimais:
```java
System.out.printf("O valor é: %.2f", 10.12345);
// 10.12
```

**Resumo:**  
- `println`: imprime e pula linha  
- `print`: imprime sem pular linha  
- `printf`: imprime formatado

## Adicionando valores ao texto com marcadores `%` (ex: `printf`)

Você pode inserir valores em uma string usando marcadores como `%d`, `%s`, `%f` dentro de métodos como `printf` ou `String.format`. Esses marcadores são substituídos pelos valores fornecidos.

**Exemplo com `printf`:**
```java
int idade = 25;
String nome = "João";
System.out.printf("Nome: %s, Idade: %d\n", nome, idade);
```
- `%s`: substituído por uma string
- `%d`: substituído por um número inteiro
- `%f`: substituído por um número decimal

**Exemplo com `String.format`:**
```java
String resultado = String.format("Valor: %.2f", 3.14159);
System.out.println(resultado); // Valor: 3.14
```
- `%.2f`: formata o número decimal com 2 casas