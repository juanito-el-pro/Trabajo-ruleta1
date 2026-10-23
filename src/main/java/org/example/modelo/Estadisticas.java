package org.example.modelo;

import java.util.List;

public class Estadisticas {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima; // Corregido el typo
	private TipoApuesta tipoMasJugado;

	public Estadisticas(List<Resultado> historial) {
		calcular(historial);
	}

	private void calcular(List<Resultado> historial) {
		this.totalJugadas = historial.size();

		if (totalJugadas == 0) {
			this.victorias = 0;
			this.porcentajeVictorias = 0.0;
			this.rachaMaxima = 0;
			this.tipoMasJugado = null;
			return;
		}

		int aciertos = 0;
		int rachaActual = 0;
		int maxRacha = 0;

		// Arreglo para contar cuántas veces se juega cada tipo de apuesta
		int[] conteoTipos = new int[TipoApuesta.values().length];

		for (Resultado r : historial) {
			// 1. Victorias y porcentaje
			if (r.isAcierto()) {
				aciertos++;
				rachaActual++;
				if (rachaActual > maxRacha) {
					maxRacha = rachaActual;
				}
			} else {
				rachaActual = 0; // Se rompe la racha
			}

			// 2. Conteo de tipos de apuesta
			conteoTipos[r.getTipo().ordinal()]++;
		}

		this.victorias = aciertos;
		this.porcentajeVictorias = ((double) aciertos / totalJugadas) * 100.0;
		this.rachaMaxima = maxRacha;

		// 3. Calcular el tipo más jugado
		int maxConteo = -1;
		TipoApuesta masJugado = TipoApuesta.ROJO;
		for (int i = 0; i < conteoTipos.length; i++) {
			if (conteoTipos[i] > maxConteo) {
				maxConteo = conteoTipos[i];
				masJugado = TipoApuesta.values()[i];
			}
		}
		this.tipoMasJugado = masJugado;
	}

	// ===== Getters =====
	public int getTotalJugadas() {
		return totalJugadas;
	}

	public int getVictorias() {
		return victorias;
	}

	public double getPorcentajeVictorias() {
		return porcentajeVictorias;
	}

	public int getRachaMaxima() {
		return rachaMaxima;
	}

	public TipoApuesta getTipoMasJugado() {
		return tipoMasJugado;
	}
}