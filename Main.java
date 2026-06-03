import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlocadorBuddy alocador = new AlocadorBuddy();
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== MENU ===\n");
            System.out.println("1. Alocar");
            System.out.println("2. Liberar");
            System.out.println("3. Desfazer");
            System.out.println("4. Exibir árvore");
            System.out.println("5. Exibir fila de pendentes");
            System.out.println("6. Exibir listas de blocos livres");
            System.out.println("7. Carregar dataset");
            System.out.println("8. Sair");
            System.out.print("\nOpção: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("\nEntrada inválida. Digite um número");
                sc.nextLine();
                continue;
            }

            int opcao = sc.nextInt();
            sc.nextLine();
            

            if (opcao == 1) {
                System.out.print("\nID: ");
                String id = sc.nextLine();
                System.out.print("\nTamanho (KB): ");
                int tam = sc.nextInt(); sc.nextLine();

                if (alocador.alocar(id, tam))
                    System.out.println("\nAlocado com sucesso");
                else
                    System.out.println("\nFalha na alocação. Requisição enfileirada (se tamanho válido)");
            
            } else if (opcao == 2) {
                System.out.print("\nID: ");
                String id = sc.nextLine();

                if (alocador.liberar(id))
                    System.out.println("\nLiberado com sucesso");
                else
                    System.out.println("\nID não encontrado");
            
            } else if (opcao == 3) {

                if (alocador.desfazer())
                    System.out.println("\nÚltima operação desfeita");
                else
                    System.out.println("\nNada para desfazer ou falha ao desfazer");
            
            } else if (opcao == 4) {
                alocador.exibirArvore();
            
            } else if (opcao == 5) {
                alocador.exibirFila();
            
            } else if (opcao == 6) {
                alocador.exibirListasLivres();
            
            } else if (opcao == 7) {
                System.out.print("\nCaminho do arquivo: ");
                String caminho = sc.nextLine();
                alocador.carregarDataset(caminho);
            
            } else if (opcao == 8) {
                sair = true;
                System.out.println("\nEncerrando..");
            
            } else {
                System.out.println("\nOpção inválida");
            }
        }

        sc.close();
    }
}

