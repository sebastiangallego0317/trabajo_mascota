import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procedimiento {
	HashMap<Integer, Mascota> mascotas;
	Mascota mascotica;
	String[] options = { "NOMBRE", "EDAD", "ESPECIE" };
	String name;

	public Procedimiento() {
		String starting;
		do {
			starting = JOptionPane
					.showInputDialog("Bienvenido al registro de mascotas\n¿Desea usar la aplicación? (Si/No)");
		} while (starting == null || starting.equals(""));
		if (starting.equalsIgnoreCase("si")) {
			mascotas = new HashMap<Integer, Mascota>();
			start();
		} else {
			JOptionPane.showMessageDialog(null, "Tenga un buen día");
		}
	}

	private void start() {
		int opc = 0;
		String menu = "-----Bienvenido, ¿qué desea hacer?-----\n1. Registrar una nueva mascota\n2. Ver lista de mascotas registradas\n3. Consultar Mascota\n4. Modificar mascotas\n5. Salir";
		do {

			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			elegirOpcion(opc);
		} while (opc != 5);
	}

	private void registrarMascota() {
		do {
			try {
				mascotica = new Mascota(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"),
						JOptionPane.showInputDialog("Ingrese la Raza de la mascota"),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificación de la mascota")));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingresaste un dato inválido, por favor repite el proceso");
				mascotica = null;
			}
		} while (mascotica == null);

		if (mascotas.containsKey(mascotica.getId())) {
			JOptionPane.showMessageDialog(null, "LA MASCOTA NO FUE REGISTRADA, SU IDENTIFICACIÓN YA EXISTE");
		} else {
			mascotas.put(mascotica.getId(), mascotica);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		}
	}

	public void elegirOpcion(int a) {
		switch (a) {
		case 1:
			registrarMascota();
			break;
		case 2:
			if (mascotas.size() > 0) {
				showList();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 3:
			if (mascotas.size() > 0) {
				searchByName();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 4:
			if (mascotas.size() > 0) {
				modify();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Hasta la próxima");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
		}
	}

	public void showList() {
		for (Mascota mascota : mascotas.values()) {
			System.out.println("--------" + mascota.getNombre() + "--------");
			System.out.println("Identificación: " + mascota.getId());
			System.out.println("Edad: " + mascota.getEdad());
			System.out.println("Especie: " + mascota.getEspecie());
			System.out.println();
		}
	}

	boolean isNot = true;

	public void searchByName() {
		name = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a buscar");
		for (Mascota mascota : mascotas.values()) {
			if (mascota.getNombre().equalsIgnoreCase(name)) {
				System.out.println("--------" + mascota.getNombre() + "--------");
				System.out.println("Identificación: " + mascota.getId());
				System.out.println("Edad: " + mascota.getEdad());
				System.out.println("Especie: " + mascota.getEspecie());
				System.out.println();
				isNot = false;
			}
		}
		if (isNot) {
			JOptionPane.showMessageDialog(null, "No había mascotas con ese nombre");
		}
	}

	public void modify() {
		try {
			changing(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mascota que desea modificar")),
					JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", "Elige una", 0,
							JOptionPane.QUESTION_MESSAGE, null, options, mascotas));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresaste algo inválido, no se pudo completar la acción");
		}
	}

	public void changing(int id, int opc) {
		switch (opc) {
		case 0:
			mascotas.get(id).setNombre(
					JOptionPane.showInputDialog("Ingrese el nombre que tendrá ahora " + mascotas.get(id).getNombre()));
			break;
		case 1:
			try {
				mascotas.get(id).setEdad(Integer.parseInt(JOptionPane
						.showInputDialog("Ingrese la edad que tendrá ahora " + mascotas.get(id).getNombre())));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingresaste algo inválido, no se pudo completar la acción");
			}
			break;
		case 2:
			mascotas.get(id).setEspecie(
					JOptionPane.showInputDialog("Ingrese la especie que tendrá ahora " + mascotas.get(id).getNombre()));
			break;
		}
	}

}