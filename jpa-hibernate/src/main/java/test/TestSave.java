package test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import dao.DAO;
import dao.DAOImpl;
import model.DiaTrabalhado;

public class TestSave extends DAOImpl<DiaTrabalhado, Integer> {


	public static void main(String[] args) {

		DiaTrabalhado dia = new DiaTrabalhado();
		DAO<DiaTrabalhado> daoDia = new DAO<DiaTrabalhado>();

		Instant instant = Instant.now();
		dia.setData(Date.from(instant));
		dia.setEntrar(instant);
		dia.setComer(instant);
		dia.setVoltar(instant);
		dia.setSair(instant);

		daoDia.saveOrUpdate(dia);
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Dia salvo no BD: " + simpleDate.format(dia.getData()) + " Com ID: " + dia.getId());
		Runtime.getRuntime().exit(1);

	}
}
