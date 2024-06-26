import java.math.BigDecimal;
import java.time.LocalDate;

import model.ListaDeFuncionarios;

public class Main {
	public static void main(String[] args) {
		ListaDeFuncionarios funcionarios = new ListaDeFuncionarios();
		funcionarios.adicionarFuncionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
		funcionarios.adicionarFuncionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador");
		funcionarios.adicionarFuncionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador");
		funcionarios.adicionarFuncionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
		funcionarios.adicionarFuncionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista");
		funcionarios.adicionarFuncionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
		funcionarios.adicionarFuncionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador");
		funcionarios.adicionarFuncionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente");
		funcionarios.adicionarFuncionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista");
		funcionarios.adicionarFuncionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente");
		funcionarios.removerFuncionarioPorNome("João");
		funcionarios.exibirFuncionarios();
		funcionarios.receberAumento();
		funcionarios.exibirFuncionariosPorFuncao();
		funcionarios.exibirAniversariatesMes10ou12();
		funcionarios.exibirFuncionarioComMaisIdade();
		funcionarios.exibirFuncionariosOrdemAlfabetica();
		funcionarios.exibirTotalSomaSalarios();
		funcionarios.exibirQuantidadeDeSalariosCadaFuncionarioGanha();
	}
}
