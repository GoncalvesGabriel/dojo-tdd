package br.com.dojotdd.leilao.dominio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private static final int LIMITE_DE_LANCE_POR_USUARIO = 6;

	private String descricao;

	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int contDeLanceDeUsuario = 0;
		for (Lance lance1 : lances) {
			if (lance.getUsuario().equals(lance1.getUsuario())) {
				contDeLanceDeUsuario++;
			}
		}
		if (lances.isEmpty() || (!this.getUltimoLanceAdicionado().getUsuario().equals(lance.getUsuario()) && contDeLanceDeUsuario < LIMITE_DE_LANCE_POR_USUARIO)) {
			lances.add(lance);
		}
	}

	private Lance getUltimoLanceAdicionado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}
