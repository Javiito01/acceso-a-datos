public enum TipoHormiga {
  // Complejidad de O(1)
  OBRERA("o", "Hormiga obrera"),
  GUERRERA("g", "Hormiga guerrera"),
  REINA("r", "Hormiga reina");

  private final String simbolo;
  private final String nombre;

  // Complejidad de O(1)
  TipoHormiga(String simbolo, String nombre) {
    this.simbolo = simbolo;
    this.nombre = nombre;
  }

  // Complejidad: O(1)
  public String getSimbolo() { return simbolo; }

  // Complejidad: O(1)
  public String getNombre() { return nombre; }
}
