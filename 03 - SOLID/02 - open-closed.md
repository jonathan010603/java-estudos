# O — Open/Closed Principle (OCP)

O **Open/Closed Principle** é o segundo princípio do **SOLID**.

> **Entidades de software devem estar abertas para extensão, mas fechadas para modificação.**

Isso significa que devemos poder **adicionar novos comportamentos ao sistema sem alterar o código existente**. Em vez de modificar classes já existentes, criamos **novas classes que estendem o comportamento**.

---

## Por que isso é importante?

Modificar código existente pode causar problemas:

- Introduzir **bugs**
- Quebrar funcionalidades que já funcionavam
- Dificultar manutenção
- Aumentar o risco em sistemas grandes

Seguindo o OCP, evitamos alterar código já testado.

---

## Exemplo sem OCP (Código ruim)

Imagine um sistema que calcula descontos:

```java
class CalculadoraDesconto {
    double calcular(String tipoCliente, double valor) {
        if (tipoCliente.equals("COMUM")) {
            return valor * 0.05;
        }
        if (tipoCliente.equals("VIP")) {
            return valor * 0.10;
        }
        return 0;
    }
}
```

**Problema:**  
Sempre que surgir um novo tipo de cliente, será necessário modificar a classe, por exemplo:

- CLIENTE_PREMIUM
- CLIENTE_EMPRESA
- CLIENTE_PARCEIRO

Isso viola o Open/Closed Principle.

---

## Aplicando OCP

Criamos uma estrutura que permite adicionar novos comportamentos sem alterar código existente.

### Interface

```java
interface Desconto {
    double calcular(double valor);
}
```

### Implementações

```java
class DescontoComum implements Desconto {
    public double calcular(double valor) {
        return valor * 0.05;
    }
}

class DescontoVip implements Desconto {
    public double calcular(double valor) {
        return valor * 0.10;
    }
}
```

### Classe que usa o desconto

```java
class CalculadoraDesconto {
    double calcular(Desconto desconto, double valor) {
        return desconto.calcular(valor);
    }
}
```

### Uso

```java
CalculadoraDesconto calculadora = new CalculadoraDesconto();
double desconto = calculadora.calcular(new DescontoVip(), 100);
```

### Adicionando novo tipo de desconto

Agora podemos criar um novo desconto sem modificar o código existente:

```java
class DescontoPremium implements Desconto {
    public double calcular(double valor) {
        return valor * 0.20;
    }
}
```

O sistema continua funcionando normalmente.

---

## Benefícios do OCP

Seguir o Open/Closed Principle traz várias vantagens:

- Código mais flexível
- Menor risco de quebrar funcionalidades
- Sistema mais extensível
- Melhor organização de responsabilidades

---

## Como identificar violação de OCP

Sinais comuns:

- Muitos `if` ou `switch` baseados em tipo
- Necessidade constante de editar a mesma classe
- Código difícil de estender

**Regra prática:**  
Se toda vez que surge um novo comportamento você precisa editar uma classe existente, provavelmente o código não está seguindo OCP.  
O ideal é poder simplesmente criar uma nova classe.

---

## Resumo

- OCP significa **Open/Closed Principle**
- Código deve estar **aberto para extensão**
- Código deve estar **fechado para modificação**
- Novos comportamentos devem ser adicionados **sem alterar código existente**
- Esse princípio ajuda a criar sistemas mais seguros, extensíveis e fáceis de manter.
