package negocio;

public class Proposta {
	private String data;
	private double valorProposta;
	private String autor;
	private Imovel imovel;
	private ArrayListPersonalizado<Proposta> propostasRegistradas = new ArrayListPersonalizado<>();
	private ArrayListPersonalizado<Visita> visitasRegistradas = new ArrayListPersonalizado<>();
	public Proposta(String data, double valorProposta, String autor, Imovel imovel) {
		super();
		this.data = data;
		this.valorProposta = valorProposta;
		this.autor = autor;
		this.imovel = imovel;
	}
	
	
}
