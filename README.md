# Simulador de Autômatos Finitos

Um simulador de autômatos finitos determinísticos (AFD) implementado em Java que permite verificar se uma palavra é aceita por diferentes linguagens regulares.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Linguagens Implementadas](#linguagens-implementadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
- [Formato dos Arquivos CSV](#formato-dos-arquivos-csv)
- [Exemplo de Uso](#exemplo-de-uso)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## 🎯 Sobre o Projeto

Este projeto implementa um simulador de autômatos finitos determinísticos que pode processar diferentes linguagens regulares. O sistema carrega as transições de estado a partir de arquivos CSV e verifica se uma palavra fornecida pelo usuário é aceita pela linguagem selecionada.

## ⚡ Funcionalidades

- ✅ Simulação de múltiplos autômatos finitos determinísticos
- ✅ Interface de linha de comando intuitiva
- ✅ Carregamento dinâmico de transições via arquivos CSV
- ✅ Visualização da tabela de transições
- ✅ Rastreamento do processamento palavra por palavra
- ✅ Verificação de aceitação de palavras

## 🔤 Linguagens Implementadas

O simulador inclui 5 linguagens regulares pré-configuradas:

1. **L₁**: `{w | w possui "aa" ou "bb" como subpalavra}`
   - Aceita palavras que contêm pelo menos dois 'a's consecutivos ou dois 'b's consecutivos

2. **L₂**: `{w | entre dois 'a's de w, há quantidade par de 'b's}`
   - Aceita palavras onde entre qualquer par de 'a's existe um número par de 'b's

3. **L₃**: `{w | w tenha "aa" ou "aba" como subpalavra}`
   - Aceita palavras que contêm "aa" ou "aba" como subsequência

4. **L₄**: `{w | entre dois 'b's de w, há quantidade ímpar de 'a's}`
   - Aceita palavras onde entre qualquer par de 'b's existe um número ímpar de 'a's

5. **L₅**: Autômato para teste
   - Configuração personalizada para testes

## 📁 Estrutura do Projeto

```
automato/
├── src/
│   ├── automato/
│   │   └── Automato.java          # Classe principal com interface
│   ├── classes/
│   │   └── Transicao.java         # Lógica de transições e processamento
│   └── transicoes/
│       ├── subPalavraaabb.csv     # L₁: Subpalavras "aa" ou "bb"
│       ├── doisaParb.csv          # L₂: Par de b's entre a's
│       ├── subPalavraaaaba.csv    # L₃: Subpalavras "aa" ou "aba"
│       ├── doisbImpara.csv        # L₄: Ímpar de a's entre b's
│       └── testeEntrega.csv       # L₅: Teste personalizado
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos

- Java 8 ou superior
- Lombok (para anotações @Data, @NoArgsConstructor)

### Execução

1. **Clone o repositório:**
   ```bash
   git clone "https://github.com/StephanyeCunto/Automato_Finito_Deterministico"
   cd automato
   ```

2. **Compile o projeto:**
   ```bash
   javac -cp ".:lombok.jar" src/automato/*.java src/classes/*.java
   ```

3. **Execute o programa:**
   ```bash
   java -cp ".:lombok.jar:src" automato.Automato
   ```

4. **Siga as instruções na tela:**
   - Escolha uma das 5 linguagens disponíveis
   - Digite uma palavra para verificar
   - Veja o resultado da simulação

## 📄 Formato dos Arquivos CSV

Os arquivos de transição seguem o formato:

```csv
Origem,Letra,Destino
q0,a,q1
q0,b,q0
q1,a,qf
q1,b,q2
```

**Convenções:**
- Estados são representados como `q0`, `q1`, `q2`, etc.
- Estados finais são marcados como `qf`
- Cada linha representa uma transição: `estado_origem,símbolo,estado_destino`
- A primeira linha (cabeçalho) é ignorada durante o processamento

## 💡 Exemplo de Uso

```
Escolha uma das opcoes para o conjunto L:

1. L = {w | w possua aa ou bb como subpalavra }
2. L = {w | entre dois a's de w, ha quantidade par de b's }
3. L = {w | w tenha aa ou aba, como subpalavra }
4. L = {w | entre dois b's de w, ha quantidade impar de a's }
5. L = {Automato para teste}

Digite a opcao escolhida: 1

Lista de transicoes:
+------------+------------+------------+
|   Origem   |   Letra    |  Destino   |
+------------+------------+------------+
| q0         |          a | q1         |
+------------+------------+------------+
| q0         |          b | q2         |
+------------+------------+------------+
| q1         |          a | qf         |
+------------+------------+------------+

Digite uma palavra: aab
Estado inicial: 0
Caractere: 'a' -> Estado: 1
Caractere: 'a' -> Estado: -1
Caractere: 'b' -> Estado: -1
Palavra aceita
```

## 🛠️ Tecnologias Utilizadas

- **Java 8+**: Linguagem principal
- **Lombok**: Redução de boilerplate code
- **CSV**: Formato de dados para definição de transições
- **Scanner**: Interface de entrada do usuário

---

**Desenvolvido como projeto acadêmico para estudo de Linguagens Formais e Âutomatos.**