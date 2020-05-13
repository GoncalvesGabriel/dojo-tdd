package br.com.dojotdd.leilao.dominio;


import org.junit.Assert;
import org.junit.Test;

public class LeilaoTest {

    @Test
    public void deveAceitarLancesAlternados(){
        Usuario gabes = new Usuario("Gabes");
        Usuario vitinho = new Usuario("Vitor");
        Usuario leirbag = new Usuario("seravat");

        Leilao leilaoDaMaps = new Leilao("dignidade de seravat-leirbag");

        leilaoDaMaps.propoe(new Lance(gabes,1000.0));
        leilaoDaMaps.propoe(new Lance(vitinho,2000.0));
        leilaoDaMaps.propoe(new Lance(leirbag,1500.0));
        leilaoDaMaps.propoe(new Lance(gabes,3000.0));
        leilaoDaMaps.propoe(new Lance(vitinho,4000.0));
        leilaoDaMaps.propoe(new Lance(leirbag,3500.0));

        Assert.assertEquals(leilaoDaMaps.getLances().size(),6);
        Assert.assertEquals(leilaoDaMaps.getLances().get(0), new Lance(gabes,1000.0));
        Assert.assertEquals(leilaoDaMaps.getLances().get(1), new Lance(vitinho,2000.0));
        Assert.assertEquals(leilaoDaMaps.getLances().get(2), new Lance(leirbag,1500.0));
        Assert.assertEquals(leilaoDaMaps.getLances().get(3), new Lance(gabes,3000.0));
        Assert.assertEquals(leilaoDaMaps.getLances().get(4), new Lance(vitinho,4000.0));
        Assert.assertEquals(leilaoDaMaps.getLances().get(5), new Lance(leirbag,3500.0));

    }

    @Test
    public void
}