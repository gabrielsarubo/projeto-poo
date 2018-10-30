/**
 * Armazem
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public final class Armazem {

    private Leitura leitura;
    private MountainBike[] vetMountainBike;
    private EBike[] vetEBike;

    Armazem() {
        leitura = new Leitura();
        vetMountainBike = new MountainBike[5];
        vetEBike = new EBike[5];
    }

    // MOUNTAIN BIKE
    public void inserir(MountainBike mountainBike) {
        /** 
         * Funcionamento do metodo: o while ira' percorrer todas as posicoes do vetor procurando
         * por uma posicao vazia (null), se for encontrada, ele fara a insercao da bicicleta
         * que foi passada como argumento naquela posicao e a variavel sucesso sera true.
         * Todos os dados da bicicleta foram inseridos na classe Teste,
         * onde e' passado como parametro a bicicleta,
         * a qual sera inserida atraves dos metodos get e set
         */
        boolean sucesso = false;
        int i = 0;
        while (i < vetMountainBike.length) {
            if (vetMountainBike[i] == null) {
                vetMountainBike[i] = new MountainBike();
                vetMountainBike[i].getFabricacao().setCodFab(mountainBike.getFabricacao().getCodFab());
                vetMountainBike[i].getFabricacao().setMarca(mountainBike.getFabricacao().getMarca());
                vetMountainBike[i].setModelo(mountainBike.getModelo());
                vetMountainBike[i].setCadencia(mountainBike.getCadencia());
                vetMountainBike[i].setVelocidade(mountainBike.getVelocidade());
                vetMountainBike[i].setMarcha(mountainBike.getMarcha());
                vetMountainBike[i].setCorreiaExtra(mountainBike.getCorreiaExtra());

                sucesso = true;
                break;
            }
            i++;
        }
        
        if (sucesso) {
            // System.out.println("Bicicleta inserida com sucesso!");
        } else {
            System.out.println("Espaco insuficiente no Armazem!");
        }
    }

    public int consultar(MountainBike mountainBike) {
        /**
         * Indice:
         * [1] o while percorrera' por todo o vetor
         * [2] o if pergunta se aquela posicao e' diferente de null, ou seja, se existe dados la' dentro,
         * pois caso nao exista nada, nao e' necessario procurar por nada la dentro
         * [3] o if compara o codigo de fabricacao da bicicleta que o usuario quer consultar
         * com o cod de fab da bicicleta que esta guardada naquela posicao do vetor
         * se ambos os codigos forem iguais, um metodo imprimir() sera' chamado e recebera' como argumentos
         * o tipo da bicicleta (mountain ou e-bike) e tambem o index onde a bicicleta se encontra no vetor;
         * por fim, sucesso e' atribuido o valor true e "break" diz para o while para de percorrer o vetor
         */
        boolean sucesso = false;
        int i = 0;
        // [1]
        while (i < vetMountainBike.length) {
            // [2]
            if (vetMountainBike[i] != null) {
                // [3]
                if (mountainBike.getFabricacao().getCodFab() == vetMountainBike[i].getFabricacao().getCodFab()) {
                    imprimir(mountainBike, i);
                    sucesso = true;
                    break;
                }
            }
            i++;
        }

        if (sucesso) {
            // System.out.println("Consulta realizada com sucesso!");
            // retorna o index onde o codigo foi encontrado (para utilizar este mesmo metodo)
            // em outras situacoes, como alterar, onde este metodo e' chamado e retorna o index
            // onde a bicicleta foi encontrada
            return i;
        } else {
            System.out.println("Erro: nao foi encontrada nenhuma bicicleta com o codigo informado.");
            return -1;
        }
    }

    public void alterar(MountainBike mountainBike) {
        // [1] Chamar o metodo consultar() para exibir o dados do objeto na tela
        int i = consultar(mountainBike);
        if (i == -1) {
            return;
        }

        // [2] Perguntar se o usuario gostaria de alterar os valores do objeto
        int resposta = 0;
        System.out.println("\n# Informe 0 para alterar as informacoes e 1 para cancelar a operacao.");
        resposta = leitura.entDadosInt("> Digite aqui sua resposta: ");

        if (resposta == 0) {
            // Usuario gostaria de alterar, chamar alteracao de valores
            // alterar os valores diretamente na posicao do vetor onde
            // esta a bicicleta que eu quero encontrar
            System.out.println("\n# Abaixo, cadastre os novos valores:");
            vetMountainBike[i].getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
            vetMountainBike[i].getFabricacao().setMarca(leitura.entDados("> Informe a marca: "));
            vetMountainBike[i].geraModelo(leitura.entDados("> Informe o modelo: "));
            vetMountainBike[i].mudarCadencia(leitura.entDadosInt("> Informe a cadencia: "));
            vetMountainBike[i].setVelocidade(leitura.entDadosInt("> Informe a velocidade: "));
            vetMountainBike[i].mudarMarcha(leitura.entDadosInt("> Informe a marcha: "));
            vetMountainBike[i].setCorreiaExtra(leitura.entDados("> Informe se existe uma correia extra: "));
        } else {
            // Usuario NAO gostaria de alterar, terminar 
            System.out.println("Operacao cancelada! Nenhum valor foi modificado.");
        }
    }

    public void excluir(MountainBike mountainBike) {
        // [1] Chamar o metodo consultar() para exibir o dados do objeto na tela
        int i = consultar(mountainBike);
        if (i == -1) {
            return;
        }

        // [2] Perguntar se o usuario gostaria de excluir aquele objeto
        int resposta = 0;
        resposta = leitura.entDadosInt("\n> Digite 0 para excluir e 1 para nao excluir o objeto: ");

        if (resposta == 0) {
            // "excluir" o objeto que esta dentro do vetor atribuindo a ele o valor null
            vetMountainBike[i] = null;
            System.out.println("Aviso: Objeto excluido com sucesso!");
        } else {
            System.out.println("Aviso: Voce optou por nao excluir o objeto.");
        }
    }

    public void imprimir(MountainBike mountainBike, int index) {
        System.out.println("Codigo de fabricacao: " + vetMountainBike[index].getFabricacao().getCodFab());
        System.out.println("Marca: " + vetMountainBike[index].getFabricacao().getMarca());
        System.out.println("Modelo: " + vetMountainBike[index].getModelo());
        System.out.println("Cadencia: " + vetMountainBike[index].getCadencia());
        System.out.println("Velocidade: " + vetMountainBike[index].getVelocidade());
        System.out.println("Marcha: " + vetMountainBike[index].getMarcha());
        System.out.println("Correia extra: " + vetMountainBike[index].getCorreiaExtra());
    }

    // E-BIKE (sobrecarregado)
    public void inserir(EBike eBike) {
        boolean sucesso = false;
        int i = 0;
        while (i < vetEBike.length) {
            if (vetEBike[i] == null) {
                vetEBike[i] = new EBike();
                vetEBike[i].getFabricacao().setCodFab(eBike.getFabricacao().getCodFab());
                vetEBike[i].getFabricacao().setMarca(eBike.getFabricacao().getMarca());
                vetEBike[i].setModelo(eBike.getModelo());
                vetEBike[i].setCadencia(eBike.getCadencia());
                vetEBike[i].setVelocidade(eBike.getVelocidade());
                vetEBike[i].setMarcha(eBike.getMarcha());
                vetEBike[i].setBateria(eBike.getBateria());

                sucesso = true;
                break;
            }
            i++;
        }
        
        if (sucesso) {
            // System.out.println("Bicicleta inserida com sucesso!");
        } else {
            System.out.println("Espaco insuficiente no Armazem!");
        }
    }

    public int consultar(EBike eBike) {
        boolean sucesso = false;
        int i = 0;
        while (i < vetEBike.length) {
            if (vetEBike[i] != null) {
                if (eBike.getFabricacao().getCodFab() == vetEBike[i].getFabricacao().getCodFab()) {
                    imprimir(eBike, i);
                    sucesso = true;
                    break;
                }
            }
            i++;
        }

        if (sucesso) {
            return i;
        } else {
            System.out.println("Erro: nao foi encontrada nenhuma bicicleta com o codigo informado.");
            return -1;
        }
    }

    public void alterar(EBike eBike) {
        int i = consultar(eBike);
        if (i == -1) {
            return;
        }

        int resposta = 0;
        System.out.println("\n# Informe 0 para alterar as informacoes e 1 para cancelar a operacao.");
        resposta = leitura.entDadosInt("> Digite aqui sua resposta: ");

        if (resposta == 0) {
            System.out.println("\n# Abaixo, cadastre os novos valores:");
            vetEBike[i].getFabricacao().setCodFab(leitura.entDadosInt("> Informe o codigo de fabricacao: "));
            vetEBike[i].getFabricacao().setMarca(leitura.entDados("> Informe a marca: "));
            vetEBike[i].geraModelo(leitura.entDados("> Informe o modelo: "));
            vetEBike[i].mudarCadencia(leitura.entDadosInt("> Informe a cadencia: "));
            vetEBike[i].setVelocidade(leitura.entDadosInt("> Informe a velocidade: "));
            vetEBike[i].mudarMarcha(leitura.entDadosInt("> Informe a marcha: "));
            vetEBike[i].setBateria(leitura.entDadosInt("> Informe a duracao da bateria (kwh): "));
        } else {
            System.out.println("Operacao cancelada! Nenhum valor foi modificado.");
        }
    }

    public void excluir(EBike eBike) {
        int i = consultar(eBike);
        if (i == -1) {
            return;
        }

        int resposta = 0;
        resposta = leitura.entDadosInt("\n> Digite 0 para excluir e 1 para nao excluir a bicicleta: ");

        if (resposta == 0) {
            vetEBike[i] = null;
            System.out.println("Aviso: Bicicleta excluida com sucesso!");
        } else {
            System.out.println("Aviso: Voce optou por nao excluir a bicicleta.");
        }
    }

    public void imprimir(EBike eBike, int index) {
        System.out.println("Codigo de fabricacao: " + vetEBike[index].getFabricacao().getCodFab());
        System.out.println("Marca: " + vetEBike[index].getFabricacao().getMarca());
        System.out.println("Modelo: " + vetEBike[index].getModelo());
        System.out.println("Cadencia: " + vetEBike[index].getCadencia());
        System.out.println("Velocidade: " + vetEBike[index].getVelocidade());
        System.out.println("Marcha: " + vetEBike[index].getMarcha());
        System.out.println("Bateria (kwh): " + vetEBike[index].getBateria());
    }
}