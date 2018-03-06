
public class SequentialSearch {

	/**
	 * @param args
	 * @return 
	 */
	
	static int SequentialSearch(int[] A, int n, int x){
		for(int i=n-1; i>0; i--){
			if(A[i]== x){
				return i;
			}
		return i;
		}
		return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tmp = {1,5,93,7,4};
		System.out.println(SequentialSearch(tmp, 5, 7));
	}

}
