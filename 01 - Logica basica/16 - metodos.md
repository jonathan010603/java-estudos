# Métodos em Java

## Estrutura de um Método

```java
public static int soma(int a, int b) {
    return a + b;
}
```

### Partes de um Método

- **Modificadores de acesso** (`public`, `private`, `protected`):  
  Definem quem pode acessar o método.  
  - `public`: acessível por qualquer classe.
  - `private`: acessível apenas na própria classe.
  - `protected`: acessível em subclasses.

- **Modificador static**:  
  Indica que o método pertence à classe, não a uma instância. Pode ser chamado sem criar um objeto.

- **Tipo de retorno** (`int`, `void`, etc):  
  Define o tipo de valor que o método retorna.  
  - `void`: não retorna valor.

- **Nome do método**:  
  Identificador do método. Deve seguir as regras de nomes em Java.

- **Argumentos (parâmetros)**:  
  Valores que o método recebe para processar.  
  - Exemplo: `int a, int b` são dois argumentos do tipo inteiro.

- **Corpo do método**:  
  Bloco de código entre `{}` que define o que o método faz.

## Exemplo Completo

```java
public class Calculadora {
    public static int soma(int a, int b) {
        return a + b;
    }

    private void imprimirResultado(int resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
```

- `soma`: método público e estático, retorna um inteiro, recebe dois argumentos.
- `imprimirResultado`: método privado, não retorna valor (`void`), recebe um argumento.

## Como Chamar um Método

```java
int resultado = Calculadora.soma(5, 3); // Chama método estático
```

Para métodos não estáticos:

```java
Calculadora calc = new Calculadora();
calc.imprimirResultado(resultado);
```