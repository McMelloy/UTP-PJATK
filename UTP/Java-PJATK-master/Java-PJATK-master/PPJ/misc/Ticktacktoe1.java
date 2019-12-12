import java.util.Scanner;
public class Ticktacktoe1{
    public static void main(String[] args){
        int game = 0b0_0000_0000_0_0000_0000;
        boolean play = true;  
        
        int count = 0;
        int pos = 0;
        Scanner scan = new Scanner(System.in);
        while(play){
            int x = 0;
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
           
            if ((game & 0b1_1111_1111) == 0b1_1111_1111){ 
                play = false;
            } else {
                pos = scan.nextInt();
            game += (1 << (pos-1));
            if((count % 2) == 0){
                game += (1 << (pos+8));
            }
            //System.out.println(game);
            count++;
            }
        
        }

        

    
    }
}