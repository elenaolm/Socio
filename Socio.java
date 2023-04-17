/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10.SOCIO;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio implements Serializable, Comparable<Socio> {
	private final String dni;
	private final String nombre;
	private final LocalDate fechaAlta;

	public Socio(String dni, String nombre, LocalDate fechaAlta) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Socio) {
			Socio otroSocio = (Socio) obj;
			return this.dni.equals(otroSocio.dni);
		}
		return false;
	}

	@Override
	public int compareTo(Socio otroSocio) {
		return this.dni.compareTo(otroSocio.dni);
	}

	public long antiguedad() {
		return ChronoUnit.DAYS.between(fechaAlta, LocalDate.now());
	}
}
