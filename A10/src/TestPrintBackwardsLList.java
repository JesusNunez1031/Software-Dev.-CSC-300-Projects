
public class TestPrintBackwardsLList {

	public static void main(String[] args) {
		PrintBackwardsLList list = new PrintBackwardsLList();
		
		for(int i = 0; i < 26;i++) {
			list.add(i);
		}
		
		list.printBackwards(list.size()-1);

	}

}
