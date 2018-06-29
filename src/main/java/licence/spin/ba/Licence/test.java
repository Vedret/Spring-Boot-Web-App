package licence.spin.ba.Licence;

public class test {

	public static void main(String[] args) {
		int [] niz= {1,1,2,3,4,5,5,7,8,9};
		int [] nizex= new int[niz.length];
		
		for (int i : niz) {
			
			nizex[i]=1;
			//System.out.println(i +" "+nizex[i]);
		}

		for (int i=0;i<nizex.length;i++) {
			System.out.println(nizex[i]);
			if(nizex[i]==0) {
				System.out.print("+ "+i);
			}
		}
	}

}
