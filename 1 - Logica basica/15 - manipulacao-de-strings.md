# Manipulação de Strings em Java

Java oferece diversas funções para manipular strings. Abaixo estão as principais, com exemplos:

## 1. `length()`
Retorna o tamanho da string.

```java
String texto = "Java";
int tamanho = texto.length(); // 4
```

## 2. `charAt(int index)`
Retorna o caractere na posição especificada.

```java
char letra = texto.charAt(1); // 'a'
```

## 3. `substring(int beginIndex, int endIndex)`
Extrai parte da string.

```java
String sub = texto.substring(1, 3); // "av"
```

## 4. `toLowerCase()` e `toUpperCase()`
Converte para minúsculas ou maiúsculas.

```java
texto.toLowerCase(); // "java"
texto.toUpperCase(); // "JAVA"
```

## 5. `trim()`
Remove espaços no início e fim.

```java
String nome = "  Ana  ";
nome.trim(); // "Ana"
```

## 6. `replace(CharSequence old, CharSequence new)`
Substitui partes da string.

```java
String frase = "Olá Mundo";
frase.replace("Mundo", "Java"); // "Olá Java"
```

## 7. `split(String regex)`
Divide a string em partes, usando um delimitador.

```java
String dados = "a,b,c";
String[] partes = dados.split(","); // ["a", "b", "c"]
```

## 8. `equals()` e `equalsIgnoreCase()`
Compara strings.

```java
texto.equals("Java"); // true
texto.equalsIgnoreCase("java"); // true
```

## 9. `contains(CharSequence seq)`
Verifica se contém uma sequência.

```java
texto.contains("av"); // true
```

## 10. `startsWith()` e `endsWith()`
Verifica início ou fim da string.

```java
texto.startsWith("J"); // true
texto.endsWith("a"); // true
```

Essas funções são essenciais para manipular textos em Java.