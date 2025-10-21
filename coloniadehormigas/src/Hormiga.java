import java.util.Random;

public abstract class Hormiga extends Thread {
  protected final String id;                 // Identificador único
  protected final TipoHormiga tipo;          // Tipo de hormiga
  protected volatile Posicion posicion;      // Posición actual
  protected volatile boolean activa;         // Estado del hilo/hormiga
  protected final Random aleatorio;          // Aleatoriedad local
  protected static final int[][] DIRECCIONES = { {1,0}, {-1,0}, {0,1}, {0,-1} };

  public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial) {
    this.id = id;
    this.tipo = tipo;
    this.posicion = posicionInicial;
    this.activa = true;
    this.aleatorio = new Random();
  }

  public String getIdHormiga() { return id; }
  public TipoHormiga getTipo() { return tipo; }
  public Posicion getPosicion() { return posicion; }
  public void setPosicion(Posicion nuevaPosicion) { this.posicion = nuevaPosicion; }
  public boolean isActiva() { return activa; }

  // Señal de parada segura del hilo
  public void detener() {
    activa = false;
    interrupt();
  }

  // Bucle pasivo: el simulador coordina el movimiento
  @Override
  public void run() {
    while (activa) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        break;
      }
    }
  }
}
