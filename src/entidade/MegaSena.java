package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MegaSena {

	private static final double premiacao = 100000.00;
	private List<Integer> resultado = new ArrayList<>();

	public MegaSena() {
		while (resultado.size() < 6) {
			int random = new Random().nextInt(59) + 1;
			if (!resultado.contains(random)) {
				resultado.add(random);
			}
		}
	}

	public double jogar(int aposta[]) { //
		int contador = 0;
		for (int i = 0; i < resultado.size(); i++) {
			for (int j = 0; j < resultado.size(); j++) {
				if (aposta[j] == resultado.get(j)) {
					contador++;
				}
			}
		}

		int pontos = contador / resultado.size();

		switch (pontos) {

		case 1:
			return 16.6;
		case 2:
			return 33.3;
		case 3:
			return 50.0;
		case 4:
			return 66.6;
		case 5:
			return 83.3;
		case 6:
			return 100.0;
		default:
			return 0;

		}

	}

	public double premio(int aposta[]) {
		return premiacao * (jogar(aposta) / 100);
	}

	public List<Integer> getResultado() {
		return resultado;
	}

	public static double getPremiacao() {
		return premiacao;
	}

}
