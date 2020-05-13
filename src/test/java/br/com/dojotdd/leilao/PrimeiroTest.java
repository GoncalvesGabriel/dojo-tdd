package br.com.dojotdd.leilao;


import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;
import br.com.dojotdd.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author vitor.alves
 */
public class PrimeiroTest {

    @Test
    public void validaMaiorLance() {
        Usuario usuario = new Usuario("Gabes");
        Lance lance = new Lance(usuario, 1000.0);
        Lance lance1 = new Lance(usuario, 150.0);
        Lance lance2 = new Lance(usuario, -78);
        Leilao leilao = new Leilao("Dignidade do gabriel");
        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        AvaliadorLanceLeilao leilaoService = new AvaliadorLanceLeilao(leilao);

        Assert.assertEquals(1000.0,leilaoService.getMaiorLance());
    }

}
