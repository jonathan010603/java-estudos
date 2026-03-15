# S — Single Responsibility Principle (SRP)

O **Single Responsibility Principle** é o primeiro princípio do **SOLID**. Ele afirma que:

> **Uma classe deve ter apenas uma única responsabilidade.**

Ou seja, uma classe deve ter **apenas um motivo para mudar**. Se uma classe faz **muitas coisas diferentes**, qualquer alteração em uma dessas responsabilidades pode quebrar outras partes do sistema.

---

## O que é "Responsabilidade"?

Responsabilidade significa **uma função ou papel dentro do sistema**. Exemplos:

- Salvar dados
- Processar lógica de negócio
- Enviar emails
- Gerar relatórios

Cada uma dessas tarefas deveria ficar **em classes separadas**.

---

## Exemplo sem SRP (Código ruim)

```java
class Usuario {
    String nome;
    String email;

    void salvarUsuario() {
        // salva no banco
    }

    void enviarEmailBoasVindas() {
        // envia email
    }
}
```

**Problema:**  
Essa classe possui duas responsabilidades:

- Gerenciar dados do usuário
- Enviar emails

Se o sistema de email mudar, a classe `Usuario` também precisará mudar. Isso viola o SRP.

---

## Aplicando SRP (Código melhor)

**Separando as responsabilidades:**

```java
class Usuario {
    String nome;
    String email;
}
```

**Classe responsável por salvar usuários:**

```java
class UsuarioRepository {
    void salvar(Usuario usuario) {
        // salva no banco
    }
}
```

**Classe responsável por email:**

```java
class EmailService {
    void enviarBoasVindas(Usuario usuario) {
        // envia email
    }
}
```

Agora cada classe possui uma única responsabilidade.

---

## Benefícios do SRP

Aplicar o Single Responsibility Principle traz várias vantagens:

- Código mais organizado
- Menor acoplamento
- Manutenção mais fácil
- Classes menores
- Testes mais simples

---

## Como identificar violação de SRP

Sinais de alerta:

- Classes muito grandes
- Muitos métodos diferentes
- Responsabilidades misturadas
- Muitas mudanças na mesma classe

Se uma classe faz muitas coisas, provavelmente ela está violando SRP.

---

## Regra prática

Pergunta simples para aplicar SRP:

> Essa classe tem mais de um motivo para mudar?

Se a resposta for **sim**, provavelmente ela deveria ser dividida em várias classes.

---

## Resumo

- SRP significa **Single Responsibility Principle**
- Uma classe deve ter apenas uma responsabilidade
- Isso significa um único motivo para mudança
- Responsabilidades diferentes devem ser separadas em classes diferentes
- Esse princípio ajuda a criar código mais limpo, modular e fácil de manter
