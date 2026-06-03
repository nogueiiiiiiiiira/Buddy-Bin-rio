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
 256KB: 0 blocos livres
 512KB: 1 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




ALOCAR icone02 12 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [LIVRE]
                    32KB [OCUPADO(thumbnail01)]
                  64KB [OCUPADO(relatorio01)]
                128KB [OCUPADO(fonte01)]
              256KB [OCUPADO(sessao01)]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [LIVRE]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 1 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




ALOCAR icone03 16 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [LIVRE]
                    32KB [OCUPADO(thumbnail01)]
                  64KB [OCUPADO(relatorio01)]
                128KB [OCUPADO(fonte01)]
              256KB [OCUPADO(sessao01)]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 0 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




ALOCAR pixel01 8 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [OCUPADO(thumbnail01)]
                  64KB [OCUPADO(relatorio01)]
                128KB [OCUPADO(fonte01)]
              256KB [OCUPADO(sessao01)]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR relatorio01 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [OCUPADO(thumbnail01)]
                  64KB [LIVRE]
                128KB [OCUPADO(fonte01)]
              256KB [OCUPADO(sessao01)]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 1 blocos livres
  64KB: 2 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR thumbnail01 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [OCUPADO(fonte01)]
              256KB [OCUPADO(sessao01)]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR sessao01 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [OCUPADO(fonte01)]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 1 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR fonte01 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 2 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




ALOCAR modelo3d 8192 -> sucesso



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
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 0 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 2 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR img01 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [OCUPADO(icone01)]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 2 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR icone01 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [LIVRE]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [OCUPADO(icone02)]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 2 blocos livres
  16KB: 0 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 2 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR icone02 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [LIVRE]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [DIVIDIDO]
              256KB [DIVIDIDO]
                128KB [DIVIDIDO]
                  64KB [DIVIDIDO]
                    32KB [DIVIDIDO]
                      16KB [LIVRE]
                      16KB [OCUPADO(icone03)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 2 blocos livres
  16KB: 1 blocos livres
  32KB: 2 blocos livres
  64KB: 2 blocos livres
 128KB: 2 blocos livres
 256KB: 2 blocos livres
 512KB: 0 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR icone03 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [DIVIDIDO]
                        8KB [LIVRE]
                        8KB [OCUPADO(pixel01)]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 2 blocos livres
  16KB: 0 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 1 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR pixel01 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [LIVRE]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [OCUPADO(modelo3d)]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 1 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 1 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 0 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR modelo3d -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [LIVRE]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [OCUPADO(backup01)]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 1 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 1 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 0 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)




LIBERAR backup01 -> sucesso



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
                        8KB [LIVRE]
                        8KB [OCUPADO(img02)]
                      16KB [LIVRE]
                    32KB [LIVRE]
                  64KB [LIVRE]
                128KB [LIVRE]
              256KB [LIVRE]
            512KB [LIVRE]
          1024KB [LIVRE]
        2048KB [LIVRE]
      4096KB [LIVRE]
    8192KB [LIVRE]
  16384KB [LIVRE]


=== Listas de blocos livres ===

   4KB: 0 blocos livres
   8KB: 1 blocos livres
  16KB: 1 blocos livres
  32KB: 1 blocos livres
  64KB: 1 blocos livres
 128KB: 1 blocos livres
 256KB: 1 blocos livres
 512KB: 1 blocos livres
1024KB: 1 blocos livres
2048KB: 1 blocos livres
4096KB: 1 blocos livres
8192KB: 1 blocos livres
16384KB: 1 blocos livres
32768KB: 0 blocos livres


=== Fila de pendentes ===

        (vazia)





=== MENU ===

1. Alocar
2. Liberar
3. Desfazer
4. Exibir árvore
5. Exibir fila de pendentes
6. Exibir listas de blocos livres
7. Carregar dataset
8. Sair

Opção: 
```

Ao final do dataset fornecido, a memória não fica totalmente livre porque o arquivo não contém LIBERAR img02. 

## Análise de fragmentação

### Fragmentação interna

O alocador arredonda cada requisição para a próxima potência de 2 (≥ 4 KB). Quanto maior a diferença entre o solicitado e a potência de 2, maior a fragmentação interna.

### Fragmentação externa

O Buddy System minimiza a fragmentação externa através do merge (fusão) de blocos vizinhos livres (buddies). Ao final, com todas as liberações, ocorre merge em cascata até a raiz, restaurando 32 MB livres contínuos.
