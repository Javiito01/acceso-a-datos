public enum TipoHormiga {
  OBRERA("o", "Hormiga obrera"),
  GUERRERA("g", "Hormiga guerrera"),
  REINA("r", "Hormiga reina");

  private final String simbolo;
  private final String nombre;

  TipoHormiga(String simbolo, String nombre) {
    this.simbolo = simbolo;
    this.nombre = nombre;
  }

  public String getSimbolo() { return simbolo; }
  public String getNombre() { return nombre; }
}
