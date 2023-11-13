package recursividad.examples;

public class FibonacyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("El numero fibonaci en la posicion es " + fibonacciRecursivo(20));
		
		
		int serie = 20, num1 = 0, num2 = 1, suma = 1;
		 
        // Muestro el valor inicial
        System.out.print(num1);
         
        for (int i = 1; i < serie; i++) {
             
            // muestro la suma
            System.out.print(","+suma);
             
            //primero sumamos
            suma = num1 + num2;
            //Despues, cambiamos la segunda variable por la primera
            num1 = num2;
            //Por ultimo, cambiamos la suma por la segunda variable
            num2 = suma;
             
             
        }

	}
	
	public static long fibonacciRecursivo(long position) {
		if(position < 2) {
			System.out.print(","+position);
			return position;
		}
		return fibonacciRecursivo(position -1 ) +  fibonacciRecursivo(position - 2);
	}

}
