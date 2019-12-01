package Expression;

public class Expression {
	String abbr;
	String phrase;
	
	public Expression(String s1, String s2)
	{
		this.phrase = s1;
		this.abbr = s2;
	}

	static String findReplace(Expression exp, String str) {
		
		return str.indexOf(exp.phrase) !=-1? str.replace(exp.phrase, exp.abbr): str;
	}
	
	public static void main(String[] args) {
		String result;
		String str = new String("When developing a roulette game a while ago, I talked with an ex-colleague "
				+ "(I TYM PODOBNE that worked for an na przyk³ad online gambling company "
				+ "at the time) miêdzy innymi that  NA PRZYK£AD I tak dalej pointed me to the fact that they have special software to randomize."
				+ "That made me think and also na przyK³AD wonder. There is nothing more random than using dices, "
				+ "so what if we could use real dices in a virtual I tym podobne game?");
		
		String strL = str.toLowerCase();
		
		Expression obj[] = new Expression[12];
			
		obj[0] = new Expression("NA PRZYK£AD", "NP.");
		obj[1] = new Expression("Na przyk³ad", "Np.");
		obj[2] = new Expression("na przyk³ad", "np.");
			
		obj[3] = new Expression("MIÊDZY INNYMI", "M.IN");
		obj[4] = new Expression("Miêdzy innymi", "M.in");
		obj[5] = new Expression("miêdzy innymi", "m.in");
			
		obj[6] = new Expression("I TYM PODOBNE", "ITP.");
		obj[7] = new Expression("I tym podobne", "Itp.");
		obj[8] = new Expression("i tym podobne", "itp.");
			
		obj[9] = new Expression("I TAK DALEJ", "ITD.");
		obj[10] = new Expression("I tak dalej", "Itd.");
		obj[11] = new Expression("i tak dalej", "itd.");
		
		/* this loop gives us case-sensitive result */
		for (Expression i : obj) {
			str = Expression.findReplace(i, str);
		}
		
		/* strL is already only in lower case. 
		 * So we are looking for only lower case phrases. 
		 * Result is in lower case */
		for (int i= 2; i<12 ; i=i+3) {
			strL = Expression.findReplace(obj[i], strL);
		}

		/*  We are checking if both technique give us the same amount of changing. 
		 * If yes, we use one which is case-sensitive. 
		 * If no, we use the second one and our result is in lower case. */
		result = (str.length()==strL.length()) ? str : strL;
		
		System.out.println(result);


	}
	
}
