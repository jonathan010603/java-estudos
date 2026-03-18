# Locale no Java

Usado para internacionalização (i18n), permite adaptar formatos de datas, números, moedas e mensagens conforme o idioma/região do usuário.

## Uso do Locale

O `Locale` é utilizado em classes como `NumberFormat`, `DateFormat`, e `ResourceBundle`:

```java
import java.util.Locale;
import java.text.NumberFormat;

Locale localeUS = new Locale("en", "US");
Locale localeBR = new Locale("pt", "BR");
Locale localeFR = Locale.FRANCE;

double valor = 12345.67;

NumberFormat nfBR = NumberFormat.getCurrencyInstance(localeBR);
System.out.println(nfBR.format(valor)); // R$ 12.345,67

NumberFormat nfUS = NumberFormat.getCurrencyInstance(localeUS);
System.out.println(nfUS.format(valor)); // $12,345.67
```

## Locale.setDefault

Define o locale padrão da aplicação. Isso afeta todas as operações que dependem do locale, caso não seja especificado um explicitamente.

```java
Locale.setDefault(localeBR);

NumberFormat nf = NumberFormat.getCurrencyInstance();
System.out.println(nf.format(valor)); // R$ 12.345,67
```