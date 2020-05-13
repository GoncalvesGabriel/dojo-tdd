package br.com.dojotdd.leilao;


import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;
import br.com.dojotdd.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author vitor.alves
 */
public class AvaliadorLanceLeilaoTest {

    @Test
    public void validaLanceComValoresAleatorios() {
        Usuario usuario = new Usuario("Gabes");
        Lance lance1 = new Lance(usuario, -150.0);
        Lance lance2 = new Lance(usuario, -78);
        Lance lance = new Lance(usuario, -1000.0);
        Leilao leilao = new Leilao("Dignidade do gabriel");
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
        Usuario usuario = new Usuario("Gabes");
        Lance lance = new Lance(usuario, 1000.0);
        Lance lance1 = new Lance(usuario, 150.0);
        Lance lance2 = new Lance(usuario, -78);
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
        Usuario usuario = new Usuario("Gabes");
        Lance lance = new Lance(usuario, 1000.0);
        Lance lance1 = new Lance(usuario, 1500.0);
        Lance lance2 = new Lance(usuario, 7800.0);
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
        Usuario usuario = new Usuario("Gabes");
        Lance lance = new Lance(usuario, 1000.0);
        Leilao leilao = new Leilao("Dignidade do gabriel");
        leilao.propoe(lance);

        AvaliadorLanceLeilao avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
        avaliadorLanceLeilao.avaliarLance();
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMaiorValorDeLance(), 0.0001);
        Assert.assertEquals(1000.0, avaliadorLanceLeilao.getMenorValorDeLance(), 0.0001);
    }

}
