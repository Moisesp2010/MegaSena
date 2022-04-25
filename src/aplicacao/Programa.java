package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.MegaSena;
import util.MyException;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		try {
			int aposta[] = new int[6];

			MegaSena megaSena = new MegaSena(); //

			for (int i = 0; i < megaSena.getResultado().size(); i++) {
				System.out.println(megaSena.getResultado().get(i));
			}

			for (int i = 0; i < megaSena.getResultado().size(); i++) {
				System.out.println("Digite o " + (i + 1) + " n�mero da sua aposta : ");
				int valor = sc.nextInt();
				if (valor <= 0 || valor > 60) {
					throw new MyException("Valor n�o permitido");
				}
				aposta[i] = valor;
			}

			String porcentagem = String.format("%.1f", megaSena.jogar(aposta));
			String valorReais = String.format("%.2f", megaSena.premio(aposta));
			System.out.println("Porcentagem : " + porcentagem + " %, Seu pr�mio � de : R$" + valorReais);
		} catch (MyException e) {
			e.printStackTrace();
		} finally {

			sc.close();
		}

	}

}
