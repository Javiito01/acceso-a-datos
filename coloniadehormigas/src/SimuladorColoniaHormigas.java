import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimuladorColoniaHormigas {

  private static final int NUMERO_OBRERAS = 20;
  private static final int INTERVALO_ACTUALIZACION = 2000;
  private static final int[][] DIRECCIONES = { {1,0}, {-1,0}, {0,1}, {0,-1} };

  private final Mapa mapa;
  private final HashMap<String, Hormiga> hormigas;
  private volatile boolean simulacionActiva;
  private final Random aleatorio;

  public SimuladorColoniaHormigas() {
    // Complejidad: O(1)
    this.mapa = new Mapa();                    // Matriz visual con hormiguero centrado
    this.hormigas = new HashMap<>();           // Colección de hilos/hormigas
    this.aleatorio = new Random();             
    this.simulacionActiva = false;            
  }

  // Complejidad: O(n)
  public void generarHormigaObrera() {
    for (int i = 0; i < NUMERO_OBRERAS; i++) {
      String id = "OBR-" + i;
      Posicion posicion = posicionAleatoriaValida();
      HormigaObrera obrera = new HormigaObrera(id, posicion);
      hormigas.put(id, obrera);
      obrera.start();
    }
  }

  // Complejidad esperada: O(1)
  private Posicion posicionAleatoriaValida() {
    Posicion hormiguero = mapa.getHormiguero();
    Posicion p;
    do {
      int x = aleatorio.nextInt(Mapa.ANCHO);
      int y = aleatorio.nextInt(Mapa.ALTO);
      p = new Posicion(x, y);
    } while (p.getX() == hormiguero.getX() && p.getY() == hormiguero.getY());
    return p;
  }


  public void ejecutar() {
    simulacionActiva = true;
    generarHormigaObrera(); // O(n)
    while (simulacionActiva) {
      moverTodasLasHormigas();     
      actualizarVisualizacion();   
      try {
        Thread.sleep(INTERVALO_ACTUALIZACION); // O(1)
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    detenerSimulacion();
  }

  // Complejidad: O(m)
  public void detenerSimulacion() {
    simulacionActiva = false;
    for (Hormiga h : hormigas.values()) {
      h.detener();
    }
  }

  private void actualizarVisualizacion() {
    limpiarConsola();            // O(1)
    mapa.prepararMapa(hormigas); 
    mapa.mostrarMapa();         
    mostrarEstadisticas();       
  }

  // Complejidad: O(m)
  private synchronized void moverTodasLasHormigas() {
    for (Hormiga h : hormigas.values()) {
      moverHormigaAleatoriamente(h);
    }
  }

  // Complejidad: O(1)
  private synchronized void moverHormigaAleatoriamente(Hormiga hormiga) {
    int[] d = DIRECCIONES[aleatorio.nextInt(DIRECCIONES.length)];
    Posicion candidata = hormiga.getPosicion().mover(d[0], d[1]);

    if (mapa.dentroLimites(candidata)) { // O(1)
      Posicion hive = mapa.getHormiguero(); // O(1)
      boolean esHormiguero = candidata.getX() == hive.getX() && candidata.getY() == hive.getY(); // O(1)
      if (!esHormiguero) {
        hormiga.setPosicion(candidata); // O(1)
      }
    }
  }

  // Complejidad: O(1)
  private void limpiarConsola() {
    for (int i = 0; i < 10; i++) System.out.println();
  }

  // Complejidad: O(1)
  private void mostrarEstadisticas() {
    System.out.println("Hormigas activas: " + hormigas.size());
    System.out.println("Hormiguero en: (" + mapa.getHormiguero().getX() + "," + mapa.getHormiguero().getY() + ")");
    System.out.println("Actualización cada: " + INTERVALO_ACTUALIZACION + " ms");
  }
}
