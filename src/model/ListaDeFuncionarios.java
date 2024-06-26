package model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import format.FormatNumber;

public class ListaDeFuncionarios {
	private List<Funcionario> funcionarios;

	public ListaDeFuncionarios() {
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public void adicionarFuncionario(String nome, LocalDate nascimento, BigDecimal salario, String funcao) {
		funcionarios.add(new Funcionario(nome, nascimento, salario, funcao));
	}
	
	public void removerFuncionarioPorNome(String nome) {
		funcionarios = funcionarios.stream().filter(n -> n.nome != nome).toList();
	}
	
	public void exibirFuncionarios() {
		System.out.println("\n-----LISTA DE FUNCIONÁRIOS-----");
		funcionarios.stream().forEach(System.out::println);
	}
	
	public void receberAumento() {
		funcionarios.stream().forEach(f -> {
			BigDecimal porcentagemNovoSalario = new BigDecimal(1.1);
			f.setSalario(f.getSalario().multiply(porcentagemNovoSalario));
		});
	}
	
	public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao() {
		Map<String, List<Funcionario>> map = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
		return map;
	}
	
	public void exibirFuncionariosPorFuncao() {
		Map<String, List<Funcionario>> map = agruparFuncionariosPorFuncao();
		map.forEach((t, u) -> {
			System.out.println("\n----------" + t + "----------");
			u.forEach(System.out::println);
		});
	}
	
	public void exibirAniversariatesMes10ou12() {
		System.out.println("\n-----ANIVERSARIANTES DOS MESES 10 E 12-----");
		funcionarios.stream().filter(f -> f.getDataNascimento().getMonth().getValue() == 10 || f.getDataNascimento().getMonth().getValue() == 12).forEach(System.out::println);
	}
	
	public void exibirFuncionarioComMaisIdade() {
		Funcionario funcionarioMaisVelho = funcionarios.stream().sorted((f1, f2) -> {
			if(f1.getDataNascimento().getYear() != f2.getDataNascimento().getYear()) {
				return Integer.compare(f1.getDataNascimento().getYear(), f2.getDataNascimento().getYear());
			} else if(f1.getDataNascimento().getMonthValue() != f2.getDataNascimento().getMonthValue()){
				return Integer.compare(f1.getDataNascimento().getMonthValue(), f2.getDataNascimento().getMonthValue());
			} else {
				return Integer.compare(f1.getDataNascimento().getDayOfMonth(), f2.getDataNascimento().getDayOfMonth());
			}
		}).toList().get(0);
		System.out.println("\n-----FUNCIONÁRIO MAIS VELHO-----");
		System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", idade: " + Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears() + " anos");
	}
	
	public void exibirFuncionariosOrdemAlfabetica() {
		System.out.println("\n-----LISTA DE FUNCIONÁRIOS EM ORDEM ALFABÉTICA-----");
		funcionarios.stream().sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome())).forEach(System.out::println);
	}
	
	public void exibirTotalSomaSalarios() {
		double soma = 0;
		for(Funcionario f : funcionarios) {
			soma += f.getSalario().doubleValue();
		}
		BigDecimal bigSoma = new BigDecimal(soma);
		System.out.printf("\nSoma do salário de todos funcionarios: " + FormatNumber.formataBigDecimal(bigSoma) + "\n");
	}
	
	public void exibirQuantidadeDeSalariosCadaFuncionarioGanha() {
		System.out.println("\n-----LISTA DE SALÁRIO MÍNIMO-----");
		funcionarios.forEach(f -> {
			double quantidadeSalariosMinimos = f.getSalario().doubleValue() / 1212.00;
			System.out.printf("%s ganha %.2f salários mínimos.\n", f.getNome(), quantidadeSalariosMinimos);
		});
	}
}
