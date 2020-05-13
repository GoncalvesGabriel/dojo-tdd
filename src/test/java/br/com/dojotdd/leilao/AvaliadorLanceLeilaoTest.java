package br.com.dojotdd.leilao;


import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;
import br.com.dojotdd.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author vitor.alves
 */
public class AvaliadorLanceLeilaoTest {

    private Usuario gabes;

    private Usuario vitinho;

    private Usuario leirbag;

    private Leilao leilao;

    @Before
    public void before(){
         gabes = new Usuario("Gabes");
         vitinho = new Usuario("Vitor");
         leirbag = new Usuario("seravat");
         leilao = new Leilao("Dignidade do gabriel");
    }

    @Test
    public void validaLanceComValoresAleatorios() {
        Lance lance1 = new Lance(gabes, -150.0);
        Lance lance2 = new Lance(vitinho, -78);
        Lance lance = new Lance(leirbag, -1000.0);

        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        AvaliadorLanceLeilao avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
        avaliadorLanceLeilao.avaliarLance();
        Assert.assertEquals(-78, avaliadorLanceLeilao.getMaiorValorDeLance(), 0.0001);
        Assert.assertEquals(-1000.0, avaliadorLanceLeilao.getMenorValorDeLance(), 0.0001);
    }

    @Test
    public void validaLanceDecresente() {
        Lance lance = new Lance(gabes, 1000.0);
        Lance lance1 = new Lance(vitinho, 150.0);
        Lance lance2 = new Lance(leirbag, -78);
        Leilao leilao = new Leilao("Dignidade do gabriel");
        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        AvaliadorLanceLeilao avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
        avaliadorLanceLeilao.avaliarLance();
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMaiorValorDeLance(), 0.0001);
        Assert.assertEquals(-78.0, avaliadorLanceLeilao.getMenorValorDeLance(), 0.0001);
    }

    @Test
    public void validaLanceValoresCresente() {
        Lance lance = new Lance(gabes, 1000.0);
        Lance lance1 = new Lance(vitinho, 1500.0);
        Lance lance2 = new Lance(leirbag, 7800.0);
        Leilao leilao = new Leilao("Dignidade do gabriel");
        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        AvaliadorLanceLeilao avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
        avaliadorLanceLeilao.avaliarLance();
        Assert.assertEquals(7800.0, avaliadorLanceLeilao.getMaiorValorDeLance(), 0.0001);
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMenorValorDeLance(), 0.0001);
    }

    @Test
    public void validaLanceComApenasUmValor() {
        Lance lance = new Lance(gabes, 1000.0);
        Leilao leilao = new Leilao("Dignidade do gabriel");
        leilao.propoe(lance);

        AvaliadorLanceLeilao avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
        avaliadorLanceLeilao.avaliarLance();
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMaiorValorDeLance(), 0.0001);
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMenorValorDeLance(), 0.0001);
    }

}
