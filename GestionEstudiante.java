
public class GestionEstudiante {
    private Estudiante[] estudiantes;
    private int cantidadActual;
    private int capacidad = 0;

    public GestionEstudiante(){ }

    public GestionEstudiante(int capacidad){
        this.capacidad = capacidad;
        estudiantes = new Estudiante[this.capacidad];
        cantidadActual = 0;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void agregarEstudiante(String nombre, int edad, double promedio){

        if(cantidadActual >= capacidad){
            System.out.println("estudiante no ha sido agregado ya que esta lleno el inventario");
            return;
        }

        Estudiante estudiante = new Estudiante();

        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setPromedio(promedio);

        estudiantes[cantidadActual++] = estudiante;
    }

    public void mostrarEstudiantes(){

        for(int i = 0; i < cantidadActual; i++){
            System.out.println(estudiantes[i].toString());
        }
    }

    public void buscarPorNombre(String nombre){

        for(int i = 0; i < cantidadActual; i++){
            if(estudiantes[i].getNombre().equalsIgnoreCase(nombre)){
                System.out.println("El estudiante si existe y estos son sus datos: \n" + estudiantes[i].toString());
            }
        }
    }

    public void calcularPromedioGeneral(){
        double promedio = 0;

         if(cantidadActual == 0){
             System.out.println("No se han ingresado promedios");
             return;
         }

        for(int i = 0; i < cantidadActual; i++){
            promedio += estudiantes[i].getPromedio();
        }
        promedio = promedio / cantidadActual;
        System.out.println("El promedio general es: " + promedio);
    }
}
