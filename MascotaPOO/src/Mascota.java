import javax.swing.JOptionPane;

public class Mascota {
    // Atributos
    private String nombre;
    private String especie;
    private int edad;
    private int id;

    public Mascota() {
        id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificación de la mascota"));
    }

    public Mascota(String nombre, String especie, int edad, int id) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }

    public void dormir() {
        System.out.println("Buenas noches!!!");
        JOptionPane.showMessageDialog(null, "La mascota está durmiendo");
    }

    public void despertar() {
        System.out.println("Buenos días!!!");
        JOptionPane.showMessageDialog(null, "La mascota ha despertado");
    }
}
