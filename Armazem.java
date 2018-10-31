/**
 * Armazem
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public final class Armazem {

    private MountainBike[] vetMountainBike;
    private EBike[] vetEBike;

    Armazem() {
        vetMountainBike = new MountainBike[5];
        vetEBike = new EBike[5];
    }

    // MOUNTAIN BIKE
    public boolean inserir(MountainBike mountainBike) {
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

                return true;
            }
            i++;
        }
        
        return false;
    }

    public MountainBike getMountainBike(int index) {
        return vetMountainBike[index];
    }

    public int consultar(MountainBike mountainBike, int codigoX) {
        int i = 0;
        while (i < vetMountainBike.length) {
            if (vetMountainBike[i] != null) {
                if (codigoX == vetMountainBike[i].getFabricacao().getCodFab()) {
                    return i;
                }
            }
            i++;
        }

        return -1;
    }

    public void alterar(MountainBike mountainBike, int index) {
        vetMountainBike[index] = mountainBike;
    }

    public void excluir(MountainBike mountainBike, int index) {
        vetMountainBike[index] = null;
    }
}