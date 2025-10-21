public class Main {
  public static void main(String[] args) {
    System.out.println(" Simulador de Colonia de Hormigas");
    System.out.println("Pulsa enter");
    try { System.in.read(); } catch (Exception e) {}

    // controla los hilos los movimientos y la visualizacion
    SimuladorColoniaHormigas simulador = new SimuladorColoniaHormigas();
    simulador.ejecutar();
  }
}
