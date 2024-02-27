package application;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import entitiesenums.WorkerLevel;
import entities.Worker;
import entities.Department;
import entities.HourContract;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do Departamento: ");
        String departmentName = sc.nextLine();

        System.out.println("Entre com a data de trabalho: ");

        System.out.print("Qual o nome do trabalhor? ");
        String workerName = sc.nextLine();

        System.out.print("Level? ");
        String workerLevel = sc.nextLine();

        System.out.print("Qual o salario base? ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("Quantos contratos esse trabalhador vai ter?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Entre com o contrato n ° " + i +"data");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por Hora:");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duracação (Horas): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract (contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Entre com o mês e ano para calcular (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("salario para " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }
}
