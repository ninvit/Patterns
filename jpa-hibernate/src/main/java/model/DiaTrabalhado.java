package model;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class DiaTrabalhado extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private Date data;
	private Instant entrar;
	private Instant comer;
	private Instant voltar;
	private Instant sair;

	public DiaTrabalhado() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DiaTrabalhado that = (DiaTrabalhado) o;
		return Objects.equals(data, that.data) && Objects.equals(entrar, that.entrar)
				&& Objects.equals(comer, that.comer) && Objects.equals(voltar, that.voltar)
				&& Objects.equals(sair, that.sair);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), data, entrar, comer, voltar, sair);
	}

	public void restore(DiaTrabalhado diaTrabalhado) {
		this.data = diaTrabalhado.getData();
		this.entrar = diaTrabalhado.getEntrar();
		this.comer = diaTrabalhado.getComer();
		this.voltar = diaTrabalhado.getVoltar();
		this.sair = diaTrabalhado.getSair();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public Instant getEntrar() {
		return entrar;
	}

	public void setEntrar(Instant entrar) {
		this.entrar = entrar;
	}

	public Instant getComer() {
		return comer;
	}

	public void setComer(Instant comer) {
		this.comer = comer;
	}

	public Instant getVoltar() {
		return voltar;
	}

	public void setVoltar(Instant voltar) {
		this.voltar = voltar;
	}

	public Instant getSair() {
		return sair;
	}

	public void setSair(Instant sair) {
		this.sair = sair;
	}
}