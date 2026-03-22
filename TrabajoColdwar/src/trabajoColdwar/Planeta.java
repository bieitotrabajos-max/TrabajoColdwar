package trabajoColdwar;

public class Planeta {
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
	        System.out.println("El equipo " + nombre + " ya ha sido destruido.");
	        
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
