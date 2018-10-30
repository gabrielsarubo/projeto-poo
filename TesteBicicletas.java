/**
 * TesteBicicletas
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public class TesteBicicletas {

    public static void main(String[] args) {
        Leitura leitura = new Leitura();
        MountainBike mountainBike = new MountainBike();
        EBike eBike = new EBike();
        Armazem armazem = new Armazem();

        // INICIO DO PROGRAMA ---------
        int opcao = 0, chave = 0;
        do {
            System.out.println("\n   # Bem-vindo");
            System.out.println("1) Entrar no sistema de Mountain Bikes");
            System.out.println("2) Entrar no sistema de E-Bikes");
            System.out.println("3) Sair do sistema");
            opcao = leitura.entDadosInt("\n> Escolha uma das opcoes acima: ");

            switch (opcao) {
                case 1:
                    do {
                        System.out.println("\n   # MOUNTAIN BIKES");
                        System.out.println("1) Cadastrar uma nova bicicleta");
                        System.out.println("2) Consultar uma bicicleta");
                        System.out.println("3) Alterar uma bicicleta");
                        System.out.println("4) Excluir uma bicicleta");
                        System.out.println("5) Voltar ao menu principal");
                        chave = leitura.entDadosInt("\n> Escolha uma das opcoes acima: ");
                        
                        switch (chave) {
                            case 1:
                                System.out.println("\n   # Cadastrar uma nova bicicleta");
                                mountainBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                mountainBike.getFabricacao().setMarca(leitura.entDados("> Informe a marca: "));
                                mountainBike.geraModelo(leitura.entDados("> Informe o modelo: "));
                                mountainBike.mudarCadencia(leitura.entDadosInt("> Informe a cadencia (rpm): "));
                                mountainBike.setVelocidade(leitura.entDadosInt("> Informe a velocidade: "));
                                mountainBike.mudarMarcha(leitura.entDadosInt("> Informe a marcha: "));
                                mountainBike.setCorreiaExtra(leitura.entDados("> Informe se existe uma correia extra (sim/nao): "));
                                armazem.inserir(mountainBike);

                                break;

                            case 2:
                                System.out.println("\n   # Consultar uma bicicleta");
                                mountainBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.consultar(mountainBike);
                                break;
                            
                            case 3:
                                System.out.println("\n   # Alterar uma bicicleta");
                                mountainBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.alterar(mountainBike);
                                break;

                            case 4:
                                System.out.println("\n   # Excluir uma bicicleta");
                                mountainBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.excluir(mountainBike);
                                break;

                            case 5:
                                opcao = -1;
                                break;

                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }    

                    if (opcao != -1) {
                        opcao = leitura.entDadosInt("\n> Digite 0 para continuar e 1 para voltar ao menu principal: ");    
                        if (opcao == 1) opcao = -1;
                    }
                    } while (opcao != -1);
                    break;

                case 2:
                    do {
                        System.out.println("\n   # E-BIKES");
                        System.out.println("1) Cadastrar uma nova bicicleta");
                        System.out.println("2) Consultar uma bicicleta");
                        System.out.println("3) Alterar uma bicicleta");
                        System.out.println("4) Excluir uma bicicleta");
                        System.out.println("5) Voltar ao menu principal");
                        chave = leitura.entDadosInt("\n> Escolha uma das opcoes acima: ");
                        
                        switch (chave) {
                            case 1:
                                System.out.println("\n   # Cadastrar uma nova bicicleta");
                                eBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                eBike.getFabricacao().setMarca(leitura.entDados("> Informe a marca: "));
                                eBike.geraModelo(leitura.entDados("> Informe o modelo: "));
                                eBike.mudarCadencia(leitura.entDadosInt("> Informe a cadencia (rpm): "));
                                eBike.setVelocidade(leitura.entDadosInt("> Informe a velocidade: "));
                                eBike.mudarMarcha(leitura.entDadosInt("> Informe a marcha: "));
                                eBike.setBateria(leitura.entDadosInt("> Informe a duracao da bateria (kwh): "));
                                armazem.inserir(eBike);

                                break;

                            case 2:
                                System.out.println("\n   # Consultar uma bicicleta");
                                eBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.consultar(eBike);
                                break;
                            
                            case 3:
                                System.out.println("\n   # Alterar uma bicicleta");
                                eBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.alterar(eBike);
                                break;

                            case 4:
                                System.out.println("\n   # Excluir uma bicicleta");
                                eBike.getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
                                armazem.excluir(eBike);
                                break;

                            case 5:
                                opcao = -1;
                                break;

                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }    

                    if (opcao != -1) {
                        opcao = leitura.entDadosInt("\n> Digite 0 para continuar e 1 para voltar ao menu principal: ");    
                        if (opcao == 1) opcao = -1;
                    }
                    } while (opcao != -1);
                    break;

                case 3:
                    System.out.println("\nAte logo! Saindo do sistema...");
                    return;
            
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        
            if (opcao == -1) opcao = 0;
            else opcao = leitura.entDadosInt("\n> Digite 0 para continuar e 1 para sair: ");
        } while (opcao != 1);
        // FIM DO PROGRAMA ---------
    }
}