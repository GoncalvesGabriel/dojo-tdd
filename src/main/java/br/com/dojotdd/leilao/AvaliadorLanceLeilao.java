package br.com.dojotdd.leilao;

import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;

public class AvaliadorLanceLeilao {

    private Leilao leilao;

    private double maior = Double.NEGATIVE_INFINITY;

    private double menor = Double.POSITIVE_INFINITY;

    public AvaliadorLanceLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public double getMaiorValorDeLance() {
        return maior;
    }

    public double getMenorValorDeLance() {
        return menor;
    }

    public void avaliarLance(){
        for(Lance lance : leilao.getLances()){
            if(lance.getValor() > maior){
                maior = lance.getValor();
            }
            if(lance.getValor() < menor){
                menor = lance.getValor();
            }
        }

    }


}
