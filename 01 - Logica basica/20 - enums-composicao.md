# Enums e Composição em Java

Dentro da Programação Orientada a Objetos, dois conceitos fundamentais para modelar sistemas são **Enums** e **Composição**. Eles ajudam a representar dados de forma clara e estruturada, além de contribuir para a organização e reutilização de código.

- **Enums**: usados para representar **conjuntos fixos de valores**.
- **Composição**: princípio de design onde **objetos são formados por outros objetos**, criando relações entre classes.

---

## Enums

Um **Enum (enumeration)** é um tipo especial que representa um **conjunto fixo de constantes**. Ele é usado quando um valor só pode assumir algumas opções específicas.

**Exemplos comuns:**
- Dias da semana
- Estados de um pedido
- Tipos de usuário
- Níveis de acesso

Enums tornam o código **mais seguro, legível e organizado**, evitando o uso de valores arbitrários como números ou strings.

---

### Criando um Enum

Em Java, um enum é definido usando a palavra-chave `enum`:

```java
enum DiaSemana {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO
}
```

Nesse exemplo, o tipo `DiaSemana` só pode assumir um dos valores definidos.

**Usando Enums:**

```java
DiaSemana hoje = DiaSemana.SEGUNDA;
System.out.println(hoje);
```

Isso garante que a variável só possa receber valores válidos do enum.

---

### Enums em Condicionais

Enums são frequentemente usados com `switch`:

```java
DiaSemana dia = DiaSemana.SEXTA;

switch (dia) {
    case SEGUNDA:
        System.out.println("Início da semana");
        break;
    case SEXTA:
        System.out.println("Quase fim de semana");
        break;
    default:
        System.out.println("Dia normal");
}
```

---

### Enums com Atributos

Enums podem possuir atributos, construtores e métodos:

```java
enum NivelAcesso {
    ADMIN(3),
    MODERADOR(2),
    USUARIO(1);

    private int nivel;

    NivelAcesso(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
```

**Uso:**

```java
NivelAcesso acesso = NivelAcesso.ADMIN;
System.out.println(acesso.getNivel());
```

---

### Métodos úteis em Enums

- `values()`: retorna todos os valores do enum.

    ```java
    for (DiaSemana d : DiaSemana.values()) {
        System.out.println(d);
    }
    ```

- `valueOf()`: converte uma string para um valor do enum.

    ```java
    DiaSemana dia = DiaSemana.valueOf("SEGUNDA");
    ```

---

## Composição

A composição é um princípio da programação orientada a objetos onde uma classe é formada por outras classes. Em vez de herdar comportamento de outra classe, um objeto possui outros objetos como parte de sua estrutura.

**Relação "tem um" (has-a):**

- Um Carro tem um Motor.

---

### Exemplo em Java

**Classe Motor:**

```java
class Motor {
    int potencia;
}
```

**Classe Carro:**

```java
class Carro {
    Motor motor;

    Carro() {
        motor = new Motor();
    }
}
```

**Uso:**

```java
Carro carro = new Carro();
carro.motor.potencia = 150;
```

Aqui o objeto `Carro` possui um `Motor`.

---

### Composição vs Herança

| Herança           | Composição         |
|-------------------|-------------------|
| Relação "é um"    | Relação "tem um"  |
| Forte acoplamento | Mais flexível     |
| Menos reutilização| Maior modularidade|

**Exemplo:**
- Carro é um Veículo → Herança
- Carro tem um Motor → Composição

---

### Composição com Múltiplos Objetos

Uma classe pode conter vários objetos.

**Exemplo:** um Pedido possui vários Itens.

**Classe Item:**

```java
class Item {
    String nome;
    double preco;
}
```

**Classe Pedido:**

```java
import java.util.ArrayList;

class Pedido {
    ArrayList<Item> itens = new ArrayList<>();
}
```

**Uso:**

```java
Pedido pedido = new Pedido();

Item item = new Item();
item.nome = "Notebook";
item.preco = 3500;

pedido.itens.add(item);
```

Nesse caso, o pedido é composto por vários itens.

---

### Composição Forte

Em alguns casos, o objeto interno não existe sem o objeto principal.

**Exemplo:** Casa → Cômodos  
Se a casa deixa de existir, os cômodos também deixam.  
Isso é chamado de **composição forte**.

---

### Benefícios da Composição

- Maior reutilização de código
- Menor acoplamento
- Maior flexibilidade
- Melhor organização de classes
- Facilidade de manutenção

> **Princípio famoso:**  
> "Prefira composição em vez de herança"

---

## Usando Enum dentro de uma Classe

Enums também podem ser usados como parte da composição de uma classe.

**Exemplo:**

```java
enum StatusPedido {
    PENDENTE,
    PROCESSANDO,
    ENVIADO,
    ENTREGUE
}

class Pedido {
    StatusPedido status;
}
```

**Uso:**

```java
Pedido pedido = new Pedido();
pedido.status = StatusPedido.PENDENTE;
```

Isso garante que o status só possa assumir valores válidos.

---

## Conclusão

- **Enums** permitem representar conjuntos fixos de constantes de forma segura e organizada, evitando erros comuns associados ao uso de strings ou números arbitrários. Eles também podem conter atributos e métodos, tornando-se estruturas poderosas dentro da linguagem.
- **Composição** é um princípio fundamental da programação orientada a objetos que permite construir objetos complexos a partir de outros objetos. Essa abordagem cria sistemas mais flexíveis, reutilizáveis e fáceis de manter.

Quando utilizados corretamente, Enums e composição ajudam a melhorar a modelagem do domínio e a clareza do código, sendo amplamente utilizados no desenvolvimento de aplicações modernas em Java.
