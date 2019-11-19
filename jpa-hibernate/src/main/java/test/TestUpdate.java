package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DAO;
import model.DiaTrabalhado;

public class TestUpdate {

	public static void main(String[] args) {
		DAO<DiaTrabalhado> daoDia = new DAO<DiaTrabalhado>();

		System.out.println("informe o id para busca");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();
		sc.close();

		DiaTrabalhado dia = daoDia.findById(DiaTrabalhado.class, id);

		if (daoDia.findById(DiaTrabalhado.class, id) == null) {
			System.out.println("id não encontrado " + id);
			Runtime.getRuntime().exit(1);
		} else
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Digite uma data: ");
				String dataRecebida = s.nextLine();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				s.close();
				Date dt = df.parse(dataRecebida);
				dia.setData(dt);
				System.out.println("alterada com sucesso!" + dt);
				daoDia.saveOrUpdate(dia);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		Runtime.getRuntime().exit(1);
	}
}
