package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	private String numero;
	private String titular;
	private double saldo;
	private List<Movimiento> historialMov = new ArrayList<>();
	
	public Cuenta(double saldoInicial) {
		saldo = saldoInicial;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Movimiento> devolverMov() {
		return historialMov;
	}

	public void ingreso(double dinero) {
		saldo = saldo + dinero;
		historialMov.add(new Movimiento(dinero, Movimiento.Signo.INGRESO, "Ingreso de "+ dinero + " $"));
	}

	public void reintegro(double dinero) {
		if (saldo-dinero < -500) {
			return;
		}
		saldo = saldo - dinero;
		historialMov.add(new Movimiento(dinero, Movimiento.Signo.REINTEGRO, "Reintegro de "+ dinero + " $"));
	}
}
