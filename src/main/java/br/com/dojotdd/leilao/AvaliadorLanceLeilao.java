package br.com.dojotdd.leilao;

import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;

public class AvaliadorLanceLeilao {

    private Leilao leilao;

    public AvaliadorLanceLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public double getMaiorValorDeLance() {
        double maior = Double.NEGATIVE_INFINITY;
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maior) {
                maior = lance.getValor();
            }
        }
        return maior;
    }

}
