import java.util.Random;


public class ProductArray {

	public static void main(String[] args) {
		Random rn = new Random();
		//creating the arrays
		int[] total = new int[10];
		int[] price = new int[10];
		int[] amount = new int[10];
		
		//for loop to insert values
		for(int i=0; i<10; i++){
			int ran = rn.nextInt(10);
			int ran2 = rn.nextInt(10);
			price[i] = ran;
			amount[i] = ran2;
		}
		
		for(int i=0; i<10; i++){
			total[i] = (price[i] * amount[i]);
		}
		
		System.out.println("total\tprice\tamount");
		for(int i=0;i<10;i++){
			System.out.println(total[i]+"\t"+price[i]+"\t"+amount[i]+"\n");
		}
	}

}
