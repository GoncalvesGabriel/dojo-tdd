package br.com.dojotdd.leilao.builder;

import br.com.dojotdd.leilao.dominio.Lance;
import br.com.dojotdd.leilao.dominio.Leilao;
import br.com.dojotdd.leilao.dominio.Usuario;

/**
 * @author vitor.alves
 */
public class LeilaoBuilder {

    private Leilao leilao;

    public LeilaoBuilder umLeilao(String name) {
        this.leilao = new Leilao(name);
        return this;
    }

    public LeilaoBuilder comLance(Usuario usuario, double valor) {
        this.leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao build() {
        return this.leilao;
    }

}
