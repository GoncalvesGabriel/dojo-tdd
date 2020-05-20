package br.com.dojotdd.leilao.dominio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private static final int LIMITE_DE_LANCE_POR_USUARIO = 5;

	private String descricao;

	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if (lances.isEmpty() || permiteLanceDoUsuario(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	private boolean permiteLanceDoUsuario(Usuario usuario) {
		return verificaSeMesmoUsuarioUltimoLance(usuario) && usuarioNaoEstorouLimiteLances(usuario);
	}

	private boolean verificaSeMesmoUsuarioUltimoLance(Usuario usuario) {
		return !usuario.equals(this.getUltimoLanceAdicionado().getUsuario());
	}

	private boolean usuarioNaoEstorouLimiteLances(Usuario usuario) {
		return countQuantidadeLancesUsuario(usuario) < LIMITE_DE_LANCE_POR_USUARIO;
	}

	private int countQuantidadeLancesUsuario(Usuario usuario) {
		int contDeLanceDeUsuario = 0;
		for (Lance lance : lances) {
			if (usuario.equals(lance.getUsuario())) {
				contDeLanceDeUsuario++;
			}
		}
		return contDeLanceDeUsuario;
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
