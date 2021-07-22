package CrashNumbers;
import java.util.*;
public class CrashNumber {
	private static Scanner input= new Scanner(System.in);

	public static void main(String[] args) {
		
		//Numeros_OK:
		//Posicion_Ok:
		//1984
		//1562
		//Cantidad_SOLO_Numeros_OK:0
		//Cantidad_Numero_y_Posicion_Ok:1
		//1 pedimos un string de 4 cifras
		//2 lo separamos x char en 4 variables ej cifra1= char(0), cifra2= char(1)
		//3 add(cifra1,etc)
		
		System.out.println("Bienvenido a Crash Numbers! ---> elegi tu NIVEL: EXPERTO, MEDIO, NOVATO");// aca hay un tema de usabilidad tenemos que pedir que ingresen algo facil como 1, 2 o 3...
		String nivel = input.nextLine();
		boolean estaOk = Metodo.validarNivel(nivel);
		while (estaOk == false){
			System.out.println("HEy elegi tu NIVEL: EXPERTO, MEDIO, NOVATO!!");
			nivel = input.nextLine();
			estaOk = Metodo.validarNivel(nivel);
		}
		int chances = Metodo.asignarChances(nivel);
		
		System.out.println("hhmm parece que tienes: "+chances+" chances.");// personalizzar el mensaje dependiendo de el level elegido.
		
		
		System.out.println("Ingresa un numero de 4 cifras (Ojo! no podes repetir las cifras)");
		String numero = input.nextLine();
		//validamos que el numero este OK (Que tenga 4 cifras que sean numeros y que no se repitan )
		boolean valido = Metodo.validarNumero(numero);
		while(valido == false){
			System.out.println("Hola Ami! Ingresá un numero de 4 cifras y recordá que los numeros NO se pueden repetir");
			numero = input.nextLine();
			valido = Metodo.validarNumero(numero);
		}
		//OK RECIEN AHORA TENEMOS EL NUMERO VALIDADO
		System.out.println("Genial! tu numero esta perfecto, COMENCEMOS!!");
		
		//aca asignamos los numeros a las variables
		 
		int	cifra1 = Character.getNumericValue(numero.charAt(0));
		int cifra2 = Character.getNumericValue(numero.charAt(1));
		int cifra3 = Character.getNumericValue(numero.charAt(2));
		int cifra4 = Character.getNumericValue(numero.charAt(3));
		
		int cont=0;
		boolean intento = false;
	
		do{
			cont++;
			System.out.println("Es tiempo de encontrar ese number! ---> Cuidado! te quedan "+(chances - cont)+" chances");
			System.out.println("Intentá adivinar el numero de 4 cifras (Ojo! no podes repetir las cifras)");
			String numeroAdivinado = input.nextLine();
			valido = Metodo.validarNumero(numeroAdivinado);
			while(valido == false){
				System.out.println("Intentá adivinar el numero de 4 cifras (Ojo! no podes repetir las cifras)");
				numeroAdivinado = input.nextLine();
				valido = Metodo.validarNumero(numeroAdivinado);
			}
			int	cifra1Adivinado = Character.getNumericValue(numeroAdivinado.charAt(0));
			int cifra2Adivinado = Character.getNumericValue(numeroAdivinado.charAt(1));
			int cifra3Adivinado = Character.getNumericValue(numeroAdivinado.charAt(2));
			int cifra4Adivinado = Character.getNumericValue(numeroAdivinado.charAt(3));
			
			intento = Metodo.adivino(cifra1,cifra1Adivinado,cifra2,cifra2Adivinado,cifra3,cifra3Adivinado,cifra4,cifra4Adivinado);
			
		}while(cont < chances && !intento);
		
		if(cont == chances){
			System.out.println("YOU LOSE! se te acabaron las chances...");
		}else if(intento){
			System.out.println("YOU WIN! te ganaste un viaje a la BASE MARAMBIO con NICO KEENAN e HILDA..Felicitaciones CRASH NUMBERS");
		}
		
		// generar 3 constantes EXPERTO, MEDIO, NOVATO el jugador tiene que elegir la modalidad al inicio para setear el contador que te saca del while 
		// el desarrollo del juego o la evaluacion de cada intento tiene que estar en un while(evaluarRespuesta()==false && contadorDeChances < EXPERTO )
		// evaluarRespuesta() es un boolean que se pone en true cuando el contador evaluarPosicion==4 PERO adentro tiene otro metodo imprimirTablero() 
		// imprimirTablero() le pasamos los dos contadores NUMERO y aparte el de NUM_y_POSICION.... imprimirTablero() resta NUMERO a NUM_y_POSICION e imprime el resultado de ambos en un tablero.
		// OJO cada vez que se ingresa una CHANCE() son los intentos de adivinar del jugador)...HAY QUE VALIDAR!! 
		// while con contador 
		
		
		
		
		input.close();
	}

}
