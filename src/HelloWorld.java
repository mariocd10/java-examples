
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dividend = 345;
		int divisor = 234;
		int check = 345;
		int divTotal=0, divValue, subValue,result;
		do{
			divValue = dividend/divisor;
			subValue = divValue * divisor;
			result = dividend-subValue;
			dividend = result;
			divTotal +=divValue;
		}while(dividend>divisor);
		
		System.out.println(divTotal);
	}

}
