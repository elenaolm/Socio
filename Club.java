/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10.SOCIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Club {
	private ArrayList<Socio> socios;
	private final String archivo = "socios.dat";

	public Club() {
		socios = new ArrayList<>();
		cargarSocios();
	}

	public void alta(Socio socio) {
		socios.add(socio);
	}

	public void baja(String dni) {
		socios.removeIf(socio -> socio.getDni().equals(dni));
	}

	public void modificar(Socio socio) {
		for (int i = 0; i < socios.size(); i++) {
			if (socios.get(i).getDni().equals(socio.getDni())) {
				socios.set(i, socio);
				break;
			}
		}
	}

	public ArrayList<Socio> listarPorDNI() {
		Collections.sort(socios);
		return socios;
	}

	public ArrayList<Socio> listarPorAntiguedad() {
		ArrayList<Socio> sociosOrdenados = new ArrayList<>(socios);
		sociosOrdenados.sort(Comparator.comparingLong(Socio::antiguedad));
		return sociosOrdenados;
	}

	private void cargarSocios() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
			socios = (ArrayList<Socio>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("No se pudo cargar el archivo de socios.");
		}
	}

	public void guardarSocios() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
			out.writeObject(socios);
		} catch (IOException e) {
			System.out.println("No se pudo guardar el archivo de socios.");
		}
	}
}
