package br.com.dojotdd.leilao;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;
import br.com.dojotdd.leilao.dominio.Usuario;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste de
 * dado - quando - entao
 *
 * @author vitor.alves
 */
public class AvaliadorLanceLeilaoTest {

    private Usuario gabes;

    private Usuario vitinho;

    private Usuario leirbag;

    private Leilao leilao;

    private AvaliadorLanceLeilao avaliadorLanceLeilao;

    @Before
    public void before() {
        // given
        gabes = new Usuario("Gabes");
        vitinho = new Usuario("Vitor");
        leirbag = new Usuario("seravat");
        leilao = new Leilao("Dignidade do gabriel");
        avaliadorLanceLeilao = new AvaliadorLanceLeilao(leilao);
    }

    @Test
    public void validaLanceComValoresAleatorios() {
        // given
        Lance lance1 = new Lance(gabes, -150.0);
        Lance lance2 = new Lance(vitinho, -78);
        Lance lance = new Lance(leirbag, -1000.0);

        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        // when
        avaliadorLanceLeilao.avaliarLance();

        // then
        assertThat(avaliadorLanceLeilao.getMaiorValorDeLance(), equalTo(-78D));
        assertThat(avaliadorLanceLeilao.getMenorValorDeLance(), equalTo(-1000D));
    }

    @Test
    public void validaLanceDecresente() {
        Lance lance = new Lance(gabes, 1000.0);
        Lance lance1 = new Lance(vitinho, 150.0);
        Lance lance2 = new Lance(leirbag, -78);
        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        avaliadorLanceLeilao.avaliarLance();
        assertThat(avaliadorLanceLeilao.getMaiorValorDeLance(), equalTo(1000D));
        assertThat(avaliadorLanceLeilao.getMenorValorDeLance(), equalTo(-78D));
    }

    @Test
    public void validaLanceValoresCresente() {
        Lance lance = new Lance(gabes, 1000.0);
        Lance lance1 = new Lance(vitinho, 1500.0);
        Lance lance2 = new Lance(leirbag, 7800.0);
        leilao.propoe(lance);
        leilao.propoe(lance1);
        leilao.propoe(lance2);

        avaliadorLanceLeilao.avaliarLance();
        assertThat(avaliadorLanceLeilao.getMaiorValorDeLance(), equalTo(7800D));
        assertThat(avaliadorLanceLeilao.getMenorValorDeLance(), equalTo(1000D));
    }

    @Test
    public void validaLanceComApenasUmValor() {
        Lance lance = new Lance(gabes, 1000.0);
        leilao.propoe(lance);

        avaliadorLanceLeilao.avaliarLance();
        assertThat(avaliadorLanceLeilao.getMaiorValorDeLance(), equalTo(1000D));
        assertThat(avaliadorLanceLeilao.getMenorValorDeLance(), equalTo(1000D));
    }

}
