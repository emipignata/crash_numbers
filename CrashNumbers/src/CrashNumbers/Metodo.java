package CrashNumbers;
import java.util.*;
public class Metodo {
	
	private static final int EXPERTO = 10;
	private static final int MEDIO = 20;
	private static final int NOVATO = 30;
	
	public static boolean validarNumero(String numero){
		boolean respuesta = false;
			if(validarEntre0y9(numero) && validarCantCifras(numero)){
			int cifra1 = numero.charAt(0);
			int cifra2 = numero.charAt(1);
			int cifra3 = numero.charAt(2);
			int cifra4 = numero.charAt(3);
			
			if(cifra1!=cifra2 && cifra1!=cifra3 && cifra1!=cifra4 && cifra2!=cifra3 && cifra2!=cifra4 && cifra3!=cifra4){
				respuesta = true;
			}
		}
		return respuesta;	
	}
	
	
	public static boolean validarEntre0y9(String num){
		boolean respuesta = false;
		if(num.charAt(0)=='0'|| num.charAt(0)=='1'|| num.charAt(0)=='2'|| num.charAt(0)=='3'|| num.charAt(0)=='4'|| num.charAt(0)=='5'|| num.charAt(0)=='6'|| num.charAt(0)=='7'|| num.charAt(0)=='8'|| num.charAt(0)=='9' ){
			if(num.charAt(1)=='0'|| num.charAt(1)=='1'||num.charAt(1)=='2'|| num.charAt(1)=='3'|| num.charAt(1)=='4'|| num.charAt(1)=='5'|| num.charAt(1)=='6'|| num.charAt(1)=='7'|| num.charAt(1)=='8'|| num.charAt(1)=='9' ){
				if(num.charAt(2)=='0'|| num.charAt(2)=='1'||num.charAt(2)=='2'|| num.charAt(2)=='3'|| num.charAt(2)=='4'|| num.charAt(2)=='5'|| num.charAt(2)=='6'|| num.charAt(2)=='7'|| num.charAt(2)=='8'|| num.charAt(2)=='9' ){
					if(num.charAt(3)=='0'|| num.charAt(3)=='1'||num.charAt(3)=='2'|| num.charAt(3)=='3'|| num.charAt(3)=='4'|| num.charAt(3)=='5'|| num.charAt(3)=='6'|| num.charAt(3)=='7'|| num.charAt(3)=='8'|| num.charAt(3)=='9' ){
						respuesta = true;
					}
				}
			}
		}
		return respuesta;
	}
	
	public static boolean validarCantCifras(String num){
		boolean respuesta = false;
		if (num.length()==4){
			respuesta = true;
		}
		return respuesta;
	}
	
	public static int asignarChances(String nivel){
		int respuesta = NOVATO;
		if(nivel.equals("EXPERTO")){
			respuesta = EXPERTO;
		}else if (nivel.equals("MEDIO")){
			respuesta = MEDIO;
		}
		return respuesta;
	}
	
	public static boolean validarNivel(String nivel){
		boolean respuesta = false;
		if (nivel.equals("EXPERTO")||nivel.equals("MEDIO")|| nivel.equals("NOVATO")){
			respuesta = true;
		}
		return respuesta;
	}
	
	public static boolean adivino(int cifra1, int cifra1Adivinada,int cifra2, int cifra2Adivinada,int cifra3, int cifra3Adivinada,int cifra4, int cifra4Adivinada){
		boolean respuesta=false;
		int contadorPosicion=0;
		int contadorNum=0;
		if (cifra1==cifra1Adivinada){
			contadorPosicion++;
		}else if(cifra1Adivinada == cifra2 || cifra1Adivinada == cifra3 ||cifra1Adivinada == cifra4){
			contadorNum++;
		}
		if (cifra2==cifra2Adivinada){
			contadorPosicion++;
		}else if(cifra2Adivinada == cifra1 || cifra2Adivinada == cifra3 ||cifra2Adivinada == cifra4){
			contadorNum++;
		}
		if (cifra3==cifra3Adivinada){
			contadorPosicion++;
		}else if(cifra3Adivinada == cifra2 || cifra3Adivinada == cifra1 ||cifra3Adivinada == cifra4){
			contadorNum++;
		}
		if (cifra4==cifra4Adivinada){
			contadorPosicion++;
		}else if(cifra4Adivinada == cifra1 || cifra4Adivinada == cifra3 ||cifra4Adivinada == cifra2){
			contadorNum++;
		}
		if (contadorPosicion==4){
			respuesta=true;
		}
		imprimirResultado(contadorNum, contadorPosicion);
		return respuesta;
	}
	
	public static void imprimirResultado(int contadorNum, int contadorPosicion){
		System.out.println("Encontraste "+contadorNum+" numeros correctos sin posición");
		System.out.println("Encontraste "+contadorPosicion+" numeros correctos en la posición correcta");
	}








}
