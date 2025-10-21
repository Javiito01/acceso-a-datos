public class Posicion {
  private final int x;
  private final int y;

  // Complejidad: O(1)
  public Posicion(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Complejidad: O(1)
  public int getX() { return x; }

  // Complejidad: O(1)
  public int getY() { return y; }

  // validaciones
  // Complejidad: O(1)
  public boolean dentroLimites(int maxX, int maxY) {
    return x >= 0 && x < maxX && y >= 0 && y < maxY;
  }

  // devuelve una nueva posición desplazada
  // Complejidad: O(1)
  public Posicion mover(int deltaX, int deltaY) {
    return new Posicion(x + deltaX, y + deltaY);
  }
}
