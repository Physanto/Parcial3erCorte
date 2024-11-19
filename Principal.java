import java.util.Scanner;

public class Principal {

    static Scanner stdin = new Scanner(System.in);

    public static void pedirDatosEstudiantes(GestionEstudiante gestionEstudiante){

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = stdin.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = stdin.nextInt();
        stdin.nextLine();

        double promedio;

        do{
            System.out.print("Ingrese el promedio del estudiante: ");
            promedio = stdin.nextDouble();
            stdin.nextLine();
        }
        while(promedio < 0 || promedio > 5);


        gestionEstudiante.agregarEstudiante(nombre, edad, promedio);

    }

    public static void mostrarEstudiantes(GestionEstudiante gestionEstudiante){
        gestionEstudiante.mostrarEstudiantes();
    }

    public static void buscarEstudiantes(GestionEstudiante gestionEstudiante){
        System.out.print("Ingresa el nombre del estudiante que quieres buscar: ");
        String nombre = stdin.nextLine();

        gestionEstudiante.buscarPorNombre(nombre);
    }

    public static void calcularPromedioGeneral(GestionEstudiante gestionEstudiante){
        gestionEstudiante.calcularPromedioGeneral();
    }

    public static void menuPrincipal(Estudiante estudiante, GestionEstudiante gestionEstudiante){

        char option;

        do{
            System.out.println("\n********** EduPilo S.A **********");
            System.out.println("********** MENU GESTION DE ESTUDIANTES **********\n");
            System.out.println("1._ Agregar Estudiante.");
            System.out.println("2._ Mostrar todos los estudiantes.");
            System.out.println("3._ Buscar Estudiante por Nombre.");
            System.out.println("4._ Calcular Promedio General.");
            System.out.println("5._ Salir.");
            System.out.print("Ingresa una opcion: ");
            option = stdin.next().charAt(0);

            stdin.nextLine();

            switch (option){

                case '1':
                    pedirDatosEstudiantes(gestionEstudiante);
                    break;

                case '2':
                    mostrarEstudiantes(gestionEstudiante);
                    break;

                case '3':
                    buscarEstudiantes(gestionEstudiante);
                    break;

                case '4':
                    calcularPromedioGeneral(gestionEstudiante);
                    break;

                case '5':
                    break;
            }
        }
        while(option != '5');
    }

    public static void main(String[] args){

        System.out.print("Cuantos Estudiantes deseas agregar: ");
        int cantidadEstudiantes = stdin.nextInt();

        Estudiante estudiante = new Estudiante();
        GestionEstudiante gestionEstudiante = new GestionEstudiante(cantidadEstudiantes);

        menuPrincipal(estudiante, gestionEstudiante);
    }
}
