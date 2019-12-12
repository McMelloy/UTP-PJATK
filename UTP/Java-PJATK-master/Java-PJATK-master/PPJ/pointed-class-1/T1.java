import java.util.Random;
public class T1{
	public static void main(String [] args){
		Random ran = new Random();
    boolean isItRaining = ran.nextBoolean();
		boolean isItShiny = ran.nextBoolean();
		
		if((isItRaining==true) &&(isItShiny==true)){
			System.out.println("It is cloudy");
		}
		else if((isItRaining==false) && (isItShiny==false)){
			System.out.println("Rainbow on the sky");
		}
			
		else if((isItRaining==true) && (isItShiny==false)){
		 	System.out.println("Wet weather");
		}
		else if((isItRaining==false) && (isItShiny==true)){
			System.out.println("The sun Shines");
		}
		}
}