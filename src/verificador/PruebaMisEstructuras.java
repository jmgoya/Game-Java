package verificador;

import provisorio.ColaProvisoria;
import provisorio.ListaProvisoria;
import provisorio.PilaProvisoria;

public class PruebaMisEstructuras {

    // Punto de entrada
    public static void main(String[] args) {

        // Lista: reemplazar por la implementación propia
        VerificadorEstructuras.verificarLista(new ListaProvisoria<Integer>());

        // Pila: reemplazar por la implementación propia
        VerificadorEstructuras.verificarPila(new PilaProvisoria<Integer>());

        // Cola: reemplazar por la implementación propia
        VerificadorEstructuras.verificarCola(new ColaProvisoria<Integer>());
    }
}
