# D — Dependency Inversion Principle (DIP)

O **Dependency Inversion Principle** é o quinto princípio do **SOLID**. Ele afirma:

> **Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.**
>
> **Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.**

Em termos simples:  
**devemos depender de interfaces ou abstrações, e não de implementações concretas.**

---

## O problema das dependências diretas

Imagine um sistema que envia notificações por email:

```java
class EmailService {
    void enviarEmail(String mensagem) {
        System.out.println("Enviando email: " + mensagem);
    }
}

class Notificacao {
    private EmailService emailService = new EmailService();

    void enviar(String mensagem) {
        emailService.enviarEmail(mensagem);
    }
}
```

**Problema:**  
A classe `Notificacao` está diretamente dependente de `EmailService`.  
Se quisermos enviar notificações por SMS, WhatsApp ou Push Notification, teremos que modificar a classe `Notificacao`.  
Isso viola o Dependency Inversion Principle.

---

## Aplicando DIP

Primeiro, criamos uma abstração (interface):

```java
interface ServicoMensagem {
    void enviarMensagem(String mensagem);
}
```

### Implementações

**Email:**

```java
class EmailService implements ServicoMensagem {
    public void enviarMensagem(String mensagem) {
        System.out.println("Email: " + mensagem);
    }
}
```

**SMS:**

```java
class SmsService implements ServicoMensagem {
    public void enviarMensagem(String mensagem) {
        System.out.println("SMS: " + mensagem);
    }
}
```

### Classe de alto nível

Agora, `Notificacao` depende da interface, não da implementação:

```java
class Notificacao {
    private ServicoMensagem servico;

    Notificacao(ServicoMensagem servico) {
        this.servico = servico;
    }

    void enviar(String mensagem) {
        servico.enviarMensagem(mensagem);
    }
}
```

### Uso

```java
ServicoMensagem servico = new EmailService();
Notificacao notificacao = new Notificacao(servico);
notificacao.enviar("Olá mundo!");
```

Se quisermos usar SMS:

```java
ServicoMensagem servico = new SmsService();
```

Nenhuma mudança na classe `Notificacao` é necessária.

---

## Benefícios do DIP

Seguir o Dependency Inversion Principle traz várias vantagens:

- Baixo acoplamento
- Código mais flexível
- Facilidade para testes
- Facilidade para trocar implementações
- Sistemas mais escaláveis

---

## Injeção de Dependência

Uma técnica comum para aplicar DIP é a **Injeção de Dependência** (Dependency Injection), passando a dependência de fora para dentro da classe, geralmente pelo construtor:

```java
Notificacao notificacao = new Notificacao(new EmailService());
```

A classe não cria a dependência, ela recebe a dependência.

---

## Sinais de violação de DIP

Alguns sinais comuns:

- Classes criando dependências com `new`
- Classes fortemente acopladas a implementações
- Dificuldade em trocar implementações
- Dificuldade em escrever testes

---

## Regra prática

Sempre que possível:

- Dependa de interfaces  
  **em vez de**
- Depender de classes concretas

---

## Resumo

- DIP significa **Dependency Inversion Principle**
- Módulos de alto nível devem depender de abstrações
- Abstrações não devem depender de detalhes
- Detalhes devem depender de abstrações
- Normalmente aplicado com interfaces + injeção de dependência

Esse princípio ajuda a criar sistemas flexíveis, desacoplados e fáceis de manter.
