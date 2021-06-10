package leetcode_0517;

import java.util.Arrays;
import java.util.Scanner; 
public class Five {
	
	private static char[][] Five =new char[15][15];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(Five);//初始化
		ininin(Five);
	}
	public static void init(char[][] Five) {
		for(int i=0;i<Five.length;i++) {
			Arrays.fill(Five[i], '0');
		}
	
	}
	public static void show(char[][] Five) {
		System.out.print("   ");
		for(int i=0;i<Five.length;i++) {
			if(i<10) {
				System.out.print(i+"  ");
			}else {
				System.out.print(i+" ");
			}
		}
		System.out.println("");
		int k=0;
		for(char[] i:Five) {
			if(k<10) {
				System.out.print(k++ +"  ");
			}else System.out.print(k++ +" ");
			
			for(char j:i)System.out.print(j+"  ");
			System.out.println("");
		}
	}

	public static char[][] ScaNner(char[][] Five) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			if (scan.hasNextInt()) {
				int a = scan.nextInt();

				if (scan.hasNextInt()) {
					int b = scan.nextInt();
					if (text(b) && text(a)) {
						Five[a][b] = 'x';
						break;
					}
					System.out.println("输入-250退出");
					if (a == -250 || b == -250)
						break;
					continue;

				}
			}

		}
		return Five;
	}
	public static boolean text (int a) {
		if(a<0||a>14) {
			System.out.println("请输入0~14的数字");
			return false;
		}return true;
	}
	public static void ininin(char[][] Five) {
		boolean out = true;
		while(out) {
			System.out.println("准备好下一步 Y or N");
			Scanner scan = new Scanner(System.in);
			if(scan.hasNext()) {
				String sc = scan.next();
				if(sc.equals("Y")) {
					show(Five);
					Five = ScaNner(Five);
				}else if(sc.equals("N")){
					out = false;
					continue;
				}
			}
		}
	}
	
	public static void win(char[][] Five,int a, int b) {
		char temp = Five[a][b];
		
	}
}
