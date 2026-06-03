# Alocador Buddy Binário

**Autor:** Karen Cristini Nogueira

## Descrição

Simulador de alocação de memória baseado no algoritmo Buddy System, implementado em Java como trabalho acadêmico. O sistema gerencia blocos de memória usando divisão (split), fusão (merge), fila de requisições pendentes (FIFO) e histórico de operações (pilha LIFO para desfazer).

## Estruturas implementadas

- Árvore binária: representação da memória RAM
- Lista encadeada: blocos livres separados por tamanho (buddyinfo)
- Fila FIFO: requisições pendentes
- Pilha LIFO: histórico de operações (undo)

## Funcionalidades

- Alocação com ajuste para potência de 2 (buddy mínimo = 4 KB)
- Liberação com fusão automática de blocos (merge recursivo)
- Fila de requisições que não puderam ser atendidas
- Processamento automático da fila após cada liberação
- Desfazer última operação (alocar ou liberar)
- Exibição da árvore hierárquica, fila de pendentes e blocos livres
- Menu interativo com 8 opções
- Carregamento de arquivo dataset com comandos

## Exemplo de execução com dataset

Abaixo trecho da execução com o dataset.txt fornecido:

```text
ALOCAR img01 8 -> sucesso

=== Árvore Buddy ===
32768KB [DIVIDIDO]
  16384KB [DIVIDIDO]
    8192KB [DIVIDIDO]
      4096KB [DIVIDIDO]
        2048KB [DIVIDIDO]
          1024KB [DIVIDIDO]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(img01)]
                        8KB [LIVRE]
                      16KB [LIVRE]
                    32KB [LIVRE]
                  ...
=== Listas de blocos livres (buddyinfo) ===
   4KB: 0
   8KB: 1
  16KB: 1
  32KB: 1
  64KB: 1
 128KB: 1
 256KB: 1
 512KB: 1
1024KB: 1
2048KB: 1
4096KB: 1
8192KB: 0
16384KB: 0
32768KB: 0
=== Fila de pendentes ===
(vazia)
------------------------------------------------------
ALOCAR log01 16 -> sucesso
...
ALOCAR backup01 12288 -> falha (enfileirado)
...
LIBERAR video01 -> sucesso
LIBERAR cache01 -> sucesso
... (fila processada, backup01 alocado)
...
LIBERAR backup01 -> sucesso
------------------------------------------------------
```

Ao final do dataset fornecido, a memória não fica totalmente livre porque o arquivo não contém LIBERAR img02. Contudo, o algoritmo de merge funciona corretamente: se todas as alocações fossem liberadas, a árvore retornaria a um único bloco 32768KB.

## Análise de fragmentação

### Fragmentação interna

O alocador arredonda cada requisição para a próxima potência de 2 (≥ 4 KB). Quanto maior a diferença entre o solicitado e a potência de 2, maior a fragmentação interna.

### Fragmentação externa

O Buddy System minimiza a fragmentação externa através do merge (fusão) de blocos vizinhos livres (buddies). Ao final, com todas as liberações, ocorre merge em cascata até a raiz, restaurando 32 MB livres contínuos.
