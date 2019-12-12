import java.util.Scanner;
public class Ticktacktoe{
    public static void main(String[] args){
        int game = 0b0_0000_0100_0_0100_0100;
        boolean play = true;  
        int x = 0;
        while(play){
            for(int i = 0; i < 5; i++){
                if((i % 2) != 0){
                    System.out.println("---------");
                } else {
                    for(int j = 0; j < 5; j++){
                        if(j % 2 != 0){
                            System.out.print(" | "); 
                            
                        } else {
                            if((game & (1 << x)) != 0){
                                if((game & (1 << x+9)) != 0){
                                    System.out.print("x");
                                } else {
                                    System.out.print("0");
                                }
                            } else {
                                System.out.print(" ");
                            }
                            x++;
                        }
                    }
                    System.out.println();
                    
                } 
                
            }        
        play = false;
        }
    }
}