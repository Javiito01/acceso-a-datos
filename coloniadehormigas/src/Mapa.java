import java.util.HashMap;

public class Mapa {
  public static final int ANCHO = 40;
  public static final int ALTO  = 20;
  public static final char VACIO = '.';
  public static final char HORMIGUERO = 'H';

  private final Posicion hormiguero;
  private final char[][] matriz;

  public Mapa() {
    //  matriz y hormiguero en el centro
    this.matriz = new char[ALTO][ANCHO];
    for (int y = 0; y < ALTO; y++) {
      for (int x = 0; x < ANCHO; x++) {
        matriz[y][x] = VACIO;
      }
    }
    this.hormiguero = new Posicion(ANCHO / 2, ALTO / 2);
    matriz[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;
  }

  // Complejidad: O(1)
  public Posicion getHormiguero() {
    return hormiguero;
  }

  // límites de la matriz
  // Complejidad: O(1)
  public boolean dentroLimites(Posicion posicion) {
    int x = posicion.getX();
    int y = posicion.getY();
    return x >= 0 && x < ANCHO && y >= 0 && y < ALTO;
  }

  // impresión de la matriz
  public synchronized void mostrarMapa() {
    for (int y = 0; y < ALTO; y++) {
      for (int x = 0; x < ANCHO; x++) {
        System.out.print(matriz[y][x]);
      }
      System.out.println();
    }
    System.out.println("Leyenda: " + HORMIGUERO + "=Hormiguero, o=Obrera, " + VACIO + "=Vacío");
  }

  // preparacion del mapa
  public void prepararMapa(HashMap<String, Hormiga> hormigas) {
    // vaciar la matriz 
    for (int y = 0; y < ALTO; y++) {
      for (int x = 0; x < ANCHO; x++) {
        matriz[y][x] = VACIO;
      }
    }
    // recolocar el hormiguero O(1)
    matriz[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;

    // dibujar hormigas O(m)
    for (Hormiga h : hormigas.values()) {
      Posicion p = h.getPosicion();
      if (dentroLimites(p)) {
        char simbolo = h.getTipo() == TipoHormiga.OBRERA ? 'o' : '?';
        matriz[p.getY()][p.getX()] = simbolo;
      }
    }
  }
}
