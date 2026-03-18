# Escopos em Java

## 1. Escopo de bloco
Variáveis declaradas dentro de blocos (`{}`), como em loops ou condicionais, só podem ser usadas dentro desse bloco.

```java
if (true) {
    int x = 10;
    System.out.println(x); // válido
}
// System.out.println(x); // inválido, x não existe aqui
```

## 2. Escopo de método
Variáveis declaradas dentro de métodos só existem durante a execução do método.

```java
void exemplo() {
    int y = 20;
    System.out.println(y); // válido
}
// System.out.println(y); // inválido, y não existe fora do método
```

## 3. Escopo de classe (atributos)
Variáveis declaradas na classe (fora de métodos) podem ser acessadas por todos os métodos da classe.

```java
public class Pessoa {
    String nome; // escopo de classe

    void mostrarNome() {
        System.out.println(nome); // válido
    }
}
```

## 4. Escopo global
Em Java, não existe escopo global como em algumas outras linguagens. Tudo está dentro de classes.