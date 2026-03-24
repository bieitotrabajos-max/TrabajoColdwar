package trabajoColdwar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrabajoColdwar {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		boolean salir = false;
		
		do {
			try {
				opcion = menu(sc);
				
				switch(opcion){
		        case 1: jugar();
		        break;
	
		        case 2: reglas();
		        break;
	
		        case 3: informacion();
		        break;
	
		        case 4: extra();
		        break;
	
		        case 0: salir = true;
		        break;
		        
		        default:
		        	System.out.println("Opción inválida.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Opción inválida.");
				sc.next();
			}
		
		}while (!salir);
		sc.close();
	}
	
	//Imprime el menú. Recibe el Scanner. Devuelve la opción seleccionada
	public static int menu(Scanner sc) {

		// Mostrar el menú
        System.out.println("\n----   COLDWAR   ----");
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1º JUGAR");
        System.out.println("2º REGLAS DEL JUEGO");
        System.out.println("3º INFORMACIÓN");
        System.out.println("4º APARTADO ABIERTO");
        System.out.println("0º SALIR");
        
        //Devuelve la opción seleccionada
        System.out.print("\nSeleccione una opción: ");
        return sc.nextInt();
        
		
	}
	
	public static void jugar() {
		
	}
	
	//Imprime las reglas del juego
	public static void reglas() {
		
		System.out.println("\nReglas del juego:");
        System.out.println("Cada equipo empieza con 200 vidas.");
        System.out.println("Cada ronda tiene 50 misiles al comienzo de cada ronda.");
        System.out.println("Los jugadores atacan a otros equipos.");
        System.out.println("Cuando un equipo llega a 0 vidas queda eliminado.");
        
	}
	
	//Imprime la información del desarrollo.
	public static void informacion() {
		
		System.out.println("\nInformación:");
        System.out.println("Versión: 1.0");
        System.out.println("Autores: ");
        System.out.println("Contacto: ");
		
	}
	
	public static void extra() {
		
	}
	//codigo bieito LogicaMatemática
	static void jugarTurno(Planeta atacante, Planeta[] listaPlanetas, Scanner sc) {
	    
	    // 1. Mostramos la información inicial del jugador que tiene el turno
	    System.out.println("Turno de ataque del equipo " + atacante.nombre);
	    System.out.println("Misiles disponibles: " + atacante.misiles);
	    System.out.println("Vidas restantes: " + atacante.vidas);
	    
	    // Variables para controlar el bucle de búsqueda del planeta
	    boolean planetaEncontrado = false;
	    Planeta planetaObjetivo = null; // Aquí guardaremos el planeta si lo encontramos
	    
	    // 2. BUCLE ANTI-ERRORES: Sigue preguntando hasta que el usuario escriba un nombre válido
	    while (planetaEncontrado == false) {
	
	        System.out.println("¿A qué planeta quieres atacar?");
	        String nombreObjetivo = sc.next(); // Leemos la respuesta del teclado
	            
	        // Recorremos la lista de todos los planetas de la partida
	        for (Planeta objetivo : listaPlanetas) {
	            // Comparamos si el nombre escrito coincide exactamente con algún planeta
	            if (objetivo.nombre.equals(nombreObjetivo)) {
	                planetaEncontrado = true; // ¡Encontrado! Esto romperá el bucle while
	                planetaObjetivo = objetivo; // Guardamos el objetivo para atacarlo después
	                break; // Salimos del bucle for para no seguir buscando
	            }
	        }
	        
	        // Si termina de buscar y no lo ha encontrado, mostramos error y el while se repetirá
	        if (planetaEncontrado == false) {
	            System.out.println("Planeta no encontrado. Asegúrate de escribir bien el nombre.");
	        }
	    }
	
	    // 3. Preguntamos la cantidad de misiles a disparar
	    System.out.println("¿Cuántos misiles quieres usar para atacar? (0 para pasar el turno)");
	    int misilesAtacar = sc.nextInt();
	    
	    // Opción estratégica: el jugador decide no atacar este turno
	    if (misilesAtacar == 0) {
	        System.out.println("Has decidido pasar el turno.");
	        return; // Salimos de la función, terminando el turno sin hacer daño
	    }
	
	    // 4. Ejecutamos el ataque llamando al método del planeta que recibe el impacto
	    planetaObjetivo.combate(misilesAtacar, atacante);
	}
	
	/**
	 * Método que vive dentro de la clase Planeta.
	 * Recibe el daño y gestiona las restricciones matemáticas del combate.
	 */
	void combate(int misilesAtacar, Planeta atacante) {
	    
	    // RESTRICCIÓN 1: Comprobamos si el atacante intenta gastar más misiles de los que tiene
	    if (misilesAtacar > atacante.misiles) {
	        System.out.println("No tienes suficientes misiles para atacar.");
	        
	    // RESTRICCIÓN 2: Evitamos que el jugador se dispare a su propio planeta por error
	    } else if (nombre.equals(atacante.nombre)) {
	        System.out.println("No puedes atacarte a ti mismo.");
	        
	    // RESTRICCIÓN 3: Comprobamos si el planeta objetivo ya está muerto (vidas a 0 o menos)
	    } else if (vidas <= 0) {
	        System.out.println("El planeta " + nombre + " ya ha sido destruido.");
	        
	    // Si pasa todas las restricciones anteriores, el ataque es válido
	    } else {
	        // MATEMÁTICAS: Restamos el daño a las vidas actuales y descontamos la munición al atacante
	        vidas -= misilesAtacar;
	        atacante.misiles -= misilesAtacar;
	        
	        // REGISTRO VISUAL: Imprimimos el resultado del combate en pantalla
	        System.out.println("El equipo " + atacante.nombre + " ha atacado al equipo " + nombre + " con " + misilesAtacar + " misiles.");
	    }
	}

}
