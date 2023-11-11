package negocio;

public class Visita {
	private String dataVisita;
	private String nomeVisitante;
	private String nomeProprietario;
	private boolean visitaRealizada;
	private Imovel imovel;
	public Visita(String dataVisita, String nomeVisitante, String nomeProprietario, boolean visitaRealizada,
			Imovel imovel) {
		this.dataVisita = dataVisita;
		this.nomeVisitante = nomeVisitante;
		this.nomeProprietario = nomeProprietario;
		this.visitaRealizada = visitaRealizada;
		this.imovel = imovel;
	}
	
	public String getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
	}
	public String getNomeVisitante() {
		return nomeVisitante;
	}
	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public boolean isVisitaRealizada() {
		return visitaRealizada;
	}
	public void setVisitaRealizada(boolean visitaRealizada) {
		this.visitaRealizada = visitaRealizada;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
}
