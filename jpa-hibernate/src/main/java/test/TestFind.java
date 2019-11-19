package test;

import java.util.Scanner;

import dao.DAO;
import model.DiaTrabalhado;

public class TestFind {

	public static void main(String[] args) {
		DAO<DiaTrabalhado> daoDia = new DAO<DiaTrabalhado>();
		

		System.out.println("informe o id para busca");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();
		
		
		if (daoDia.findById(DiaTrabalhado.class, id)==null){
			System.out.println("id não encontrado " + id);
			Runtime.getRuntime().exit(1);
		}
			System.out.println("dia " + daoDia.findById(DiaTrabalhado.class, id).getData());
			sc.close();

		Runtime.getRuntime().exit(1);
	}
}
