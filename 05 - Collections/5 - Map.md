## Map
Diferente das outras, aqui trabalhamos com Pares (Entry) de Chave e Valor. Pense como um dicionário ou uma lista de contatos.
- **Cada chave é única**: Funcionam como o Set. Se tentar colocar uma chave que já existe, o Java simplesmente sobrescreve o valor antigo e te retorna o valor que foi substituído.
- **Aceita** valores duplicados
- **Não** herda de Collection
- **Pode ou não manter** ordem de inserção

#### Métodos importantes
- **put(K, V)**: Adiciona ou atualiza.
- **get(K)**: Busca o valor. Se não achar a chave, retorna null.
- **getOrDefault(K, V)**: (Bônus Java 8+) Se não achar a chave, retorna um valor padrão que você escolher.
- **keySet()**: Retorna um Set com todas as chaves.
- **values()**: Retorna uma Collection com todos os valores.
- **entrySet()**: Retorna um Set com os pares (Chave + Valor). É o melhor para fazer loops.
- **remove(Object key)** → remove pela chave
- **containsKey(Object key)** → verifica chave
- **containsValue(Object value)** → verifica valor
- **size()** → quantidade de pares
- **isEmpty()** → verifica se está vazio
- **clear()** → remove tudo

---

## HashMap
O padrão da indústria.
#### Características
- **Performance**: $O(1)$ para quase tudo. É imbatível em velocidade.
- **Não mantém ordem**: $O(1)$ para quase tudo. É imbatível em velocidade
- **Permite** chave null
- **Uso**: quando você quer desempenho e não se importa com ordem

#### Exemplo HashMap:
```java
public class HashMapExemplo {
    public static void main(String[] args) {
        Map<String, Integer> idades = new HashMap<>();

        idades.put("Ana", 20);
        idades.put("Carlos", 25);
        idades.put("Ana", 30); // sobrescreve

        System.out.println(idades);
        // saída: {Ana=30, Carlos=25}
    }
}
```

---

## LinkedHashMap
O meio-termo entre organização e velocidade.
#### Características
- **Mantém ordem de inserção**: Se você salvou o contato do "Bruno" depois da "Ana", ele vai aparecer depois no mapa.
- **Performance**: Mais lento que HashMap
- **Permite** chave null
- **Uso**: quando precisa de ordem + chave única
- **Bônus**: Muito útil para criar caches (onde o item mais antigo inserido precisa ser identificado).

#### Exemplo LinkedHashMap:
```java
public class LinkedHashMapExemplo {
    public static void main(String[] args) {
        Map<String, Integer> idades = new LinkedHashMap<>();

        idades.put("Ana", 20);
        idades.put("Carlos", 25);

        System.out.println(idades);
        // saída: {Ana=20, Carlos=25}
    }
}
```

---

## TreeMap
O organizador obsessivo.
#### Características
- **Performance**: $O(\log n)$. Mais lento, pois reequilibra a árvore a cada inserção.
- **Ordena pelas chaves automaticamente**
- **Restrição**: Não aceita chave null (porque ele precisa comparar a chave nova com as que já estão lá para saber onde colocá-la).
- **Uso**: utilizado quando precisa de ordenação por chave

#### Exemplo TreeMap:
```java
public class TreeMapExemplo {
    public static void main(String[] args) {
        Map<Integer, String> mapa = new TreeMap<>();

        mapa.put(3, "C");
        mapa.put(1, "A");
        mapa.put(2, "B");

        System.out.println(mapa);
        // saída: {1=A, 2=B, 3=C}
    }
}
```

---

## Percorrendo um Map
Muita gente tenta percorrer só as chaves e depois dar um get(), mas isso é ineficiente. O jeito mais performático é usar o **entrySet()**:

```java
Map<String, Double> produtos = new HashMap<>();
produtos.put("Café", 15.50);
produtos.put("Açúcar", 5.00);

// Jeito moderno com Lambda
produtos.forEach((chave, valor) -> System.out.println(chave + " custa " + valor));

// Jeito tradicional (EntrySet)
for (Map.Entry<String, Double> entry : produtos.entrySet()) {
    System.out.println("Chave: " + entry.getKey() + " | Valor: " + entry.getValue());
}
```

---

## RImportantes
- Chave não pode repetir
- put() sobrescreve valor da mesma chave

**Nunca esqueça**: se você usar um objeto personalizado como Chave ***(ex: Map<Pessoa, Salario>)***, você PRECISA implementar o equals() e hashCode() na classe Pessoa. Se não fizer isso, você nunca vai conseguir dar um get() no objeto, pois o Java não vai reconhecer que é a mesma pessoa.

Se você coloca um objeto num HashMap ou HashSet, o Java não olha o nome das variáveis; ele olha o HashCode (o endereço do balde) e o Equals (a prova real).

```java
class Usuario {
    String nome;
    String cpf;

    Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // 1. HashCode: Gera o "número do balde" baseado no CPF
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // 2. Equals: A prova real se os CPFs são idênticos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Se for o mesmo endereço de memória, é igual
        if (o == null || getClass() != o.getClass()) return false; // Se for nulo ou classes diferentes, tchau
        Usuario usuario = (Usuario) o;
        return Objects.equals(cpf, usuario.cpf); // Compara os CPFs
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', cpf='" + cpf + "'}";
    }
}
```

Se você não implementasse os métodos acima, o código abaixo aceitaria dois usuários com o mesmo CPF, porque o Java acharia que são objetos totalmente diferentes na memória.

```java
public class TesteEqualsHash {
    public static void main(String[] args) {
        Set<Usuario> usuarios = new HashSet<>();

        Usuario u1 = new Usuario("Ana", "123.456.789-00");
        Usuario u2 = new Usuario("Ana Silva", "123.456.789-00"); // Mesmo CPF, nome diferente

        usuarios.add(u1);
        usuarios.add(u2); // O HashSet vai barrar esse aqui!

        // Resultado: Apenas 1 usuário no Set
        System.out.println("Total de usuários únicos: " + usuarios.size());
        System.out.println(usuarios);
    }
}
```

- **Consistência**: Se x.equals(y) é verdadeiro, então x.hashCode() tem que ser igual a y.hashCode().

- **Imutabilidade**: Tente usar campos que não mudam (como cpf, id) para gerar o HashCode. Se você mudar o CPF de um objeto que já está dentro de um Map, você "perde" o objeto lá dentro porque o Hash dele mudou.

- **Performance**: Não coloque campos pesados no hashCode. O ideal é usar Objects.hash(campo1, campo2).