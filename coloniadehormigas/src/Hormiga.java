import java.util.Random;

public abstract class Hormiga extends Thread { // O(1)
  protected final String id;                 
  protected final TipoHormiga tipo;          
  protected volatile Posicion posicion;     
  protected volatile boolean activa;         
  protected final Random aleatorio;          
  protected static final int[][] DIRECCIONES = { {1,0}, {-1,0}, {0,1}, {0,-1} }; 

  // Complejidad: O(1)
  public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial) {
    this.id = id;
    this.tipo = tipo;
    this.posicion = posicionInicial;
    this.activa = true;
    this.aleatorio = new Random();
  }

  // Complejidad: O(1)
  public String getIdHormiga() { return id; }

  // Complejidad: O(1)
  public TipoHormiga getTipo() { return tipo; }

  // Complejidad: O(1)
  public Posicion getPosicion() { return posicion; }

  // Complejidad: O(1)
  public void setPosicion(Posicion nuevaPosicion) { this.posicion = nuevaPosicion; }

  // Complejidad: O(1)
  public boolean isActiva() { return activa; }

  // Complejidad: O(1)
  public void detener() {
    activa = false;
    interrupt(); 
  }

  //  O(1)
  @Override
  public void run() {
    while (activa) {
      try {
        Thread.sleep(1000); // O(1) computacional
      } catch (InterruptedException e) {
        break;
      }
    }
  }
}
