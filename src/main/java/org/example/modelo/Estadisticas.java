package org.example.modelo;

public class Estadisticas {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;
	private TipoApuesta tipoMasJugado;

	/**
	 * 
	 * @param historial
	 */
	public Estadisticas(List<Resultado> historial) {
		// TODO - implement Estadisticas.Estadisticas
		throw new UnsupportedOperationException();
	}

	public int getTotalJugadas() {
		return this.totalJugadas;
	}

	public int getVictorias() {
		return this.victorias;
	}

	public double getPorcentajeVictorias() {
		return this.porcentajeVictorias;
	}

	public int getRachaMaxima() {
		return this.rachaMaxima;
	}

	public TipoApuesta getTipoMasJugado() {
		return this.tipoMasJugado;
	}

}