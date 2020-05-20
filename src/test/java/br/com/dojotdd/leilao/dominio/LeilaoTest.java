package br.com.dojotdd.leilao.dominio;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import br.com.dojotdd.leilao.builder.LeilaoBuilder;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

    private Usuario gabes;

    private Usuario vitinho;

    private Usuario leirbag;

    @Before
    public void setUp() {
        gabes = new Usuario("Gabes");
        vitinho = new Usuario("Vitor");
        leirbag = new Usuario("seravat");
    }

    @Test
    public void deveAceitarLancesAlternados() {
        Leilao leilaoDaMaps = new LeilaoBuilder().umLeilao("teste")
            .comLance(gabes, 1000.0)
            .comLance(vitinho, 2000.0)
            .comLance(leirbag, 1500.0)
            .comLance(gabes, 3000.0)
            .comLance(vitinho, 4000.0)
            .comLance(leirbag, 3500.0).build();

        List<Lance> lances = leilaoDaMaps.getLances();
        assertThat(lances.size(), equalTo(6));
        assertThat(lances, contains(new Lance(gabes, 1000.0),
            new Lance(vitinho, 2000.0),
            new Lance(leirbag, 1500.0),
            new Lance(gabes, 3000.0),
            new Lance(vitinho, 4000.0),
            new Lance(leirbag, 3500.0)));
    }

    @Test
    public void testeLanceSeguidos() {
        leilaoDaMaps.propoe(new Lance(gabes, 1000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 3000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 2000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 4000.0));
        leilaoDaMaps.propoe(new Lance(leirbag, 1500.0));
        leilaoDaMaps.propoe(new Lance(leirbag, 3500.0));

        List<Lance> lances = leilaoDaMaps.getLances();
        assertThat(lances.size(), equalTo(3));
        assertThat(lances, contains(new Lance(gabes, 1000.0),
            new Lance(vitinho, 2000.0),
            new Lance(leirbag, 1500.0)));
    }

    @Test
    public void naoDeveAceitarMaisQueCincoLancesPorUsuario() {
        leilaoDaMaps.propoe(new Lance(gabes, 1000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 2000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 3000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 4000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 6000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 7000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 8000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 9000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 10000.0));
        leilaoDaMaps.propoe(new Lance(vitinho, 11000.0));
        leilaoDaMaps.propoe(new Lance(gabes, 12000.0));

        List<Lance> lances = leilaoDaMaps.getLances();
        assertThat(lances.size(), equalTo(10));
        assertThat(lances, contains(new Lance(gabes, 1000.0),
            new Lance(vitinho, 2000.0),
            new Lance(gabes, 3000.0),
            new Lance(vitinho, 4000.0),
            new Lance(gabes, 6000.0),
            new Lance(vitinho, 7000.0),
            new Lance(gabes, 8000.0),
            new Lance(vitinho, 9000.0),
            new Lance(gabes, 10000.0),
            new Lance(vitinho, 11000.0)));
    }
}