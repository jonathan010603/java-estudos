# Locale no Java

O `Locale` em Java representa uma região geográfica, idioma ou variantes culturais. Ele é usado para internacionalização (i18n), permitindo que aplicações adaptem formatos de datas, números, moedas e mensagens conforme o idioma/região do usuário.

## Criação de Locale

```java
import java.util.Locale;

// Locale para inglês dos EUA
Locale localeUS = new Locale("en", "US");

// Locale para português do Brasil
Locale localeBR = new Locale("pt", "BR");

// Locale usando constantes pré-definidas
Locale localeFR = Locale.FRANCE;
```

## Uso do Locale

O `Locale` é utilizado em classes como `NumberFormat`, `DateFormat`, e `ResourceBundle`:

```java
import java.text.NumberFormat;

double valor = 12345.67;

// Formatação para o Brasil
NumberFormat nfBR = NumberFormat.getCurrencyInstance(localeBR);
System.out.println(nfBR.format(valor)); // R$ 12.345,67

// Formatação para os EUA
NumberFormat nfUS = NumberFormat.getCurrencyInstance(localeUS);
System.out.println(nfUS.format(valor)); // $12,345.67
```

## Locale.setDefault

O método `Locale.setDefault(Locale locale)` define o locale padrão da aplicação. Isso afeta todas as operações que dependem do locale, caso não seja especificado um explicitamente.

```java
Locale.setDefault(localeBR); // Define português do Brasil como padrão

NumberFormat nf = NumberFormat.getCurrencyInstance();
System.out.println(nf.format(valor)); // R$ 12.345,67
```

> **Resumo:**  
> O `Locale` permite adaptar a aplicação para diferentes idiomas e regiões. O `setDefault` define o locale padrão, influenciando formatações e recursos sem necessidade de especificar o locale em cada operação.
