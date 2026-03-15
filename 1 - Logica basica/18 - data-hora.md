# Data e Hora em Java

Manipular **datas, horários e durações** é uma necessidade comum em praticamente qualquer sistema: registros de eventos, logs, agendamentos, prazos, relatórios, entre outros. O Java possui um conjunto robusto de APIs para trabalhar com tempo, sendo a mais moderna introduzida no **Java 8**, no pacote `java.time`.

Essa API foi criada para substituir classes antigas como `Date` e `Calendar`, que possuíam diversos problemas de design, falta de imutabilidade e dificuldade de uso.

Este texto apresenta os principais conceitos envolvidos na manipulação de data e hora em Java, incluindo **timezone, padrão ISO 8601, criação de datas, conversões, cálculos e as APIs antigas e modernas**.

---

## Conceitos Fundamentais

Antes de utilizar as classes da API de tempo, é importante entender alguns conceitos fundamentais.

### Data

A **data** representa um ponto no calendário, geralmente composto por:

- ano
- mês
- dia

**Exemplo:**

```
2026-03-15
```

---

### Hora

A **hora** representa um momento dentro de um dia.

Componentes comuns:

- hora
- minuto
- segundo
- nanossegundo

**Exemplo:**

```
14:35:20
```

---

### Data e Hora combinadas

Quando data e hora são combinadas, temos um **timestamp**.

**Exemplo:**

```
2026-03-15T14:35:20
```

Esse formato segue o padrão **ISO 8601**.

---

## Padrão ISO 8601

O **ISO 8601** é um padrão internacional para representação de datas e horários.

**Formato comum:**

```
YYYY-MM-DDTHH:MM:SS
```

**Exemplo:**

```
2026-03-15T14:30:00
```

| Parte | Significado |
|-------|-------------|
| YYYY  | ano         |
| MM    | mês         |
| DD    | dia         |
| T     | separador   |
| HH    | hora        |
| MM    | minuto      |
| SS    | segundo     |

Esse formato é amplamente utilizado em:

- APIs
- bancos de dados
- sistemas distribuídos

---

## Fusos Horários (Timezones)

Um **fuso horário** define a diferença de tempo em relação ao **UTC (Coordinated Universal Time)**.

| Cidade     | Fuso   |
|------------|--------|
| Londres    | UTC+0  |
| São Paulo  | UTC-3  |
| Tóquio     | UTC+9  |

Quando um sistema trabalha com usuários em diferentes regiões, é essencial considerar o timezone.

**Exemplo de data com timezone:**

```
2026-03-15T14:30:00-03:00
```

O `-03:00` indica o deslocamento em relação ao UTC.

---

## API Moderna de Data e Hora (`java.time`)

A API moderna de tempo do Java está no pacote:

```
java.time
```

Principais classes:

| Classe         | Função                      |
|----------------|----------------------------|
| LocalDate      | apenas data                 |
| LocalTime      | apenas hora                 |
| LocalDateTime  | data e hora                 |
| ZonedDateTime  | data e hora com timezone    |
| Instant        | momento global no tempo     |
| Duration       | duração entre tempos        |
| Period         | diferença entre datas       |

---

## Criando Datas e Horários

### LocalDate

Representa apenas **data**, sem horário.

```java
import java.time.LocalDate;

LocalDate hoje = LocalDate.now();
LocalDate data = LocalDate.of(2026, 3, 15);
```

---

### LocalTime

Representa apenas hora.

```java
import java.time.LocalTime;

LocalTime agora = LocalTime.now();
LocalTime hora = LocalTime.of(14, 30);
```

---

### LocalDateTime

Representa data e hora sem timezone.

```java
import java.time.LocalDateTime;

LocalDateTime agora = LocalDateTime.now();
LocalDateTime dataHora = LocalDateTime.of(2026, 3, 15, 14, 30);
```

---

### ZonedDateTime

Representa data e hora com fuso horário.

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

ZonedDateTime agora = ZonedDateTime.now();
ZonedDateTime sp = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
```

---

## Convertendo Data-Hora para Texto

Para converter datas em texto usamos `DateTimeFormatter`.

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

LocalDateTime agora = LocalDateTime.now();
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
String texto = agora.format(formato);

System.out.println(texto); // Saída: 15/03/2026 14:30
```

---

## Convertendo Texto para Data

Também é possível converter texto para data.

```java
String texto = "15/03/2026 14:30";
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
LocalDateTime data = LocalDateTime.parse(texto, formato);
```

---

## Convertendo Hora Global para Local

Em sistemas distribuídos, é comum armazenar horários em UTC e convertê-los para o timezone do usuário.

```java
import java.time.*;

Instant agora = Instant.now();
ZonedDateTime local = agora.atZone(ZoneId.of("America/Sao_Paulo"));
```

---

## Operações com Data e Hora

A API `java.time` permite realizar diversas operações.

### Adicionar tempo

```java
LocalDate hoje = LocalDate.now();
LocalDate futuro = hoje.plusDays(10);
```

### Subtrair tempo

```java
LocalDate passado = hoje.minusDays(5);
```

### Comparar datas

```java
LocalDate d1 = LocalDate.of(2026, 3, 15);
LocalDate d2 = LocalDate.of(2026, 4, 1);

boolean antes = d1.isBefore(d2);
```

---

## Cálculo de Duração

### Duration

Usado para medir tempo entre horas ou instantes.

```java
import java.time.*;

LocalTime inicio = LocalTime.of(10, 0);
LocalTime fim = LocalTime.of(12, 30);

Duration duracao = Duration.between(inicio, fim);
System.out.println(duracao.toMinutes());
```

### Period

Usado para medir diferença entre datas.

```java
import java.time.*;

LocalDate d1 = LocalDate.of(2020, 1, 1);
LocalDate d2 = LocalDate.now();

Period periodo = Period.between(d1, d2);
System.out.println(periodo.getYears());
```

---

## API Antiga: Date e Calendar

Antes do Java 8, as principais classes eram:

- `java.util.Date`
- `java.util.Calendar`

**Exemplo com Date:**

```java
import java.util.Date;

Date agora = new Date();
```

**Exemplo com Calendar:**

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
int ano = cal.get(Calendar.YEAR);
```

**Problemas dessas classes:**

- design confuso
- mutabilidade
- dificuldade para lidar com timezone
- pouca clareza semântica

Por isso foram substituídas pela API `java.time`.

---

## Boas Práticas

Algumas boas práticas ao trabalhar com datas em Java:

- preferir sempre `java.time`
- evitar `Date` e `Calendar` em novos projetos
- armazenar datas em UTC
- converter para timezone local apenas na apresentação
- usar `DateTimeFormatter` para formatação

---

## Conclusão

A manipulação de datas e horários é essencial em sistemas modernos. O Java oferece uma API robusta e segura através do pacote `java.time`, que permite trabalhar com datas, horários, fusos horários, durações e períodos de forma clara e eficiente.

Compreender conceitos como ISO 8601, timezones, conversões de formato e cálculos de duração é fundamental para desenvolver aplicações confiáveis que lidam corretamente com o tempo em diferentes regiões e contextos.