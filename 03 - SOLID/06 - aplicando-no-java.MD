# Aplicando SOLID em Java

**SOLID** é um conjunto de **cinco princípios de design de software** que ajudam a criar sistemas **mais organizados, flexíveis e fáceis de manter**.

Os princípios foram popularizados por **Robert C. Martin (Uncle Bob)** e são amplamente usados em **programação orientada a objetos**, especialmente em linguagens como Java.

## O que significa SOLID?

| Letra | Princípio                        |
|-------|----------------------------------|
| **S** | Single Responsibility Principle  |
| **O** | Open/Closed Principle            |
| **L** | Liskov Substitution Principle    |
| **I** | Interface Segregation Principle  |
| **D** | Dependency Inversion Principle   |

Aplicar esses princípios ajuda a reduzir **acoplamento**, aumentar **coerência** e melhorar a **manutenibilidade** do código.

---

## Por que SOLID é importante?

Em sistemas grandes, código mal estruturado causa problemas como:

- Classes gigantes
- Dependências rígidas
- Código difícil de modificar
- Alto risco de bugs
- Dificuldade para testar

SOLID ajuda a resolver esses problemas criando **arquiteturas mais limpas e modulares**.

---

## S — Single Responsibility Principle (SRP)

Uma classe deve ter **apenas uma responsabilidade**.

### Código ruim

```java
class UsuarioService {
    void salvarUsuario() {
        // salvar no banco
    }
    void enviarEmailBoasVindas() {
        // enviar email
    }
}
```

> **Problema:** a classe tem duas responsabilidades: persistência e envio de email.

### Aplicando SRP

```java
class UsuarioRepository {
    void salvar(Usuario usuario) {
        // salvar no banco
    }
}
class EmailService {
    void enviarBoasVindas(Usuario usuario) {
        // enviar email
    }
}
```

Agora cada classe possui uma única responsabilidade.

---

## O — Open/Closed Principle (OCP)

Classes devem estar **abertas para extensão** e **fechadas para modificação**.

### Código ruim

```java
class CalculadoraDesconto {
    double calcular(String tipo, double valor) {
        if (tipo.equals("VIP")) {
            return valor * 0.10;
        }
        if (tipo.equals("COMUM")) {
            return valor * 0.05;
        }
        return 0;
    }
}
```

> Toda vez que surge um novo tipo, precisamos modificar a classe.

### Aplicando OCP

Criamos uma abstração:

```java
interface Desconto {
    double calcular(double valor);
}
class DescontoVip implements Desconto {
    public double calcular(double valor) {
        return valor * 0.10;
    }
}
class DescontoComum implements Desconto {
    public double calcular(double valor) {
        return valor * 0.05;
    }
}
class CalculadoraDesconto {
    double calcular(Desconto desconto, double valor) {
        return desconto.calcular(valor);
    }
}
```

Agora podemos criar novos descontos sem alterar código existente.

---

## L — Liskov Substitution Principle (LSP)

Subclasses devem poder substituir a classe base sem quebrar o comportamento esperado.

### Exemplo problemático

```java
class Ave {
    void voar() {
        System.out.println("Voando");
    }
}
class Pinguim extends Ave {
    void voar() {
        throw new UnsupportedOperationException();
    }
}
```

> **Problema:** pinguins não voam, então a subclasse quebra o comportamento esperado.

### Melhor solução

Separar responsabilidades:

```java
interface Ave {}
interface AveVoadora {
    void voar();
}
class Aguia implements Ave, AveVoadora {
    public void voar() {
        System.out.println("Águia voando");
    }
}
class Pinguim implements Ave {}
```

Agora cada classe respeita seu comportamento natural.

---

## I — Interface Segregation Principle (ISP)

Interfaces devem ser **pequenas e específicas**.

### Código ruim

```java
interface Impressora {
    void imprimir();
    void escanear();
    void enviarFax();
}
class ImpressoraSimples implements Impressora {
    public void imprimir() {}
    public void escanear() {
        throw new UnsupportedOperationException();
    }
    public void enviarFax() {
        throw new UnsupportedOperationException();
    }
}
```

> Impressoras simples precisam implementar métodos que não usam.

### Aplicando ISP

Dividimos a interface:

```java
interface Impressora {
    void imprimir();
}
interface Scanner {
    void escanear();
}
interface Fax {
    void enviarFax();
}
```

Agora cada classe implementa apenas o que precisa.

---

## D — Dependency Inversion Principle (DIP)

Classes devem depender de **abstrações**, não de implementações concretas.

### Código ruim

```java
class PedidoService {
    private EmailService emailService = new EmailService();
    void processarPedido() {
        emailService.enviarEmail("Pedido confirmado");
    }
}
```

> A classe depende diretamente de `EmailService`.

### Aplicando DIP

Criamos uma interface:

```java
interface ServicoNotificacao {
    void enviar(String mensagem);
}
class EmailService implements ServicoNotificacao {
    public void enviar(String mensagem) {
        System.out.println("Email: " + mensagem);
    }
}
class PedidoService {
    private ServicoNotificacao notificacao;
    PedidoService(ServicoNotificacao notificacao) {
        this.notificacao = notificacao;
    }
    void processarPedido() {
        notificacao.enviar("Pedido confirmado");
    }
}
```

Uso:

```java
ServicoNotificacao servico = new EmailService();
PedidoService pedido = new PedidoService(servico);
pedido.processarPedido();
```

Agora podemos trocar a implementação facilmente.

---

## Benefícios de aplicar SOLID em Java

Seguir SOLID traz várias vantagens:

- Código mais limpo
- Menor acoplamento
- Maior reutilização
- Facilidade de testes
- Sistemas mais flexíveis
- Manutenção mais simples

---

## Quando usar SOLID

SOLID é especialmente útil em:

- Sistemas grandes
- APIs
- Arquiteturas em camadas
- Microservices
- Projetos de longo prazo

Em projetos muito pequenos, aplicar todos os princípios pode ser desnecessário.

---

## Boas práticas para aplicar SOLID

- Preferir composição em vez de herança
- Usar interfaces
- Manter classes pequenas
- Evitar dependências diretas
- Dividir responsabilidades claramente

---

## Resumo

SOLID é um conjunto de princípios que ajudam a criar software bem estruturado.

| Princípio | Objetivo                                 |
|-----------|------------------------------------------|
| SRP       | Uma classe deve ter uma responsabilidade |
| OCP       | Código aberto para extensão              |
| LSP       | Subclasses devem respeitar a classe base |
| ISP       | Interfaces pequenas e específicas        |
| DIP       | Depender de abstrações                   |

Aplicar SOLID em Java ajuda a criar sistemas escaláveis, flexíveis e fáceis de manter.
