// 3 – Deve conter uma classe Principal para executar as seguintes ações:

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        // • informação de data deve ser exibido no formato dd/mm/aaaa;
        // • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.

        System.out.println("\n=-=-=-=-=-Lista de Funcionários-=-=-=-=-=\n");
        funcionarios.forEach(f -> f.Imprimir());

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarios.forEach(f -> f.setSalario(f.getSalario().add(f.getSalario().multiply(BigDecimal.valueOf(0.1)))));

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionarioFuncaoMap = funcionarios.stream()
            .collect(Collectors.groupingBy(f -> f.getFuncao()));

        // 3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("\n=-=-=-=-=-Funcionários Agrupados-=-=-=-=-=");
        funcionarioFuncaoMap.forEach((funcao, lista) -> {
            System.out.println("\n" + funcao);
            lista.forEach(f -> System.out.println("\t- " + f.getNome()));
        });

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\n=-=-=-=-=-Aniversariantes Out/Dez-=-=-=-=-=\n");
        funcionarios.stream()
            .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
            .forEach(f -> f.Imprimir());

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(f -> f.getDataNascimento()));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("\n=-=-=-=-=-Funcionário Mais Velho-=-=-=-=-=\n");
        System.out.printf("%s (%d anos)%n", maisVelho.getNome(), idade);

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("\n=-=-=-=-=-Funcionários - Alfabético-=-=-=-=-=\n");
        funcionarios.stream()
            .sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome()))
            .forEach(f -> f.Imprimir());

        // 3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal totalSalarios = funcionarios.stream()
            .map(f -> f.getSalario())
            .reduce(BigDecimal.ZERO, (acumulador, salario) -> acumulador.add(salario));
        System.out.println("\n=-=-=-=-=-Total dos Salários-=-=-=-=-=\n");
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(totalSalarios));

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        BigDecimal salarioMin = new BigDecimal("1212.00");
        System.out.println("\n=-=-=-=-=-Salário Min/Func-=-=-=-=-=\n");
        funcionarios.forEach(f -> {
            BigDecimal qtdSalarioMin = f.getSalario().divide(salarioMin, 2, RoundingMode.HALF_UP);
            System.out.printf("- %s: %s salários mínimos%n", f.getNome(), qtdSalarioMin);
        });

    }
}