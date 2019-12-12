import java.util.Arrays;
public class Password {
    public static void main (String[] args){
        char[][] passwords =  {
            "AbcDe93".toCharArray(), //{j,j,k,k,l}
            "A1b:A1b>".toCharArray(),
            "Ab:Acb<".toCharArray(), // too few unique 
            "abc123><".toCharArray(),    //{ {}, {}}
            "Zorro@123".toCharArray()
        };    

        for(int i = 0; i < passwords.length; i++ ){ // loops over strings
            System.out.println();
            char[] un = new char[passwords[i].length];
            int a = 0;
            System.out.print("checking ");
            
            for(int y = 0; y < passwords[i].length; y++) {
                System.out.print(passwords[i][y]);
            }
            
            System.out.println();
            boolean digit = false;
            boolean upper = false;
            boolean letter = false;
            boolean lower = false;
            int count = 0;
            boolean ex = false;
            try {
                if (passwords[i].length < 8){
                    throw new IllegalArgumentException();
                }
            } catch (Exception e){
                System.out.println("Too short");
                ex = true;
            }

            for( int k = 0; k < passwords[i].length - 1; k++){//loops over chars
                count = 0;
                for(int h = k+1; h < passwords[i].length-1; h++){
                    if(passwords[i][k]== passwords[i][h]){
                        count++;
                    }
                }
                if(count == 0){
                    un[a] = passwords[i][k];
                    a++;
                }
                
                if (Character.isUpperCase(passwords[i][k])){
                    upper = true;
                }
                if (Character.isLowerCase(passwords[i][k])){
                    lower = true;
                }
                for(char j = 'a'; j <= 'Z'; j++) {
                    if (passwords[i][k] == j){
                        letter = true;
                    }  
                }
                for(char j = '0'; j <= '9'; j++) {
                    if (passwords[i][k] == j) {
                        digit = true;
                    }  
                }
            }
            //System.out.println(Arrays.toString(un));
            try {
                int count2 =0;;
                for(char c: un){
                    if (c !=  '\u0000')
                        count2++;
                        //System.out.println(count2);
                }
                if(count2 < 6){
                    throw new Exception();
                }

            } catch (Exception e){
                System.out.println("Too few different characters");
                ex = true;
            }
            for( int k = 0; k < passwords[i].length; k++){
                
                if (Character.isUpperCase(passwords[i][k])){
                    upper = true;
                }
                if (Character.isLowerCase(passwords[i][k])){
                    lower = true;
                }
                for(char j = 'a'; j <= 'Z'; j++) {
                    if (passwords[i][k] == j) {
                        letter = true;
                    }  
                }
                for(char j = '0'; j <= '9'; j++) {
                    if (passwords[i][k] == j) {
                        digit = true;
                    }  
                }
            }
            try {
                if(!digit && !letter){
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("No non-alphanumeric character");
                ex = true;
            }
            try {
                if(digit == false){
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("No digit");
                ex = true;
            }

            try {
                if(!upper){
                    throw new Exception();
                }
            } catch (Exception l){
                System.out.println("No uppercase letter");
                ex = true;
            }
            try {
                if(!lower){
                    throw new Exception();
                }
            } catch (Exception b){
                System.out.println("No lowercase letter");
                ex = true;
            } 
           if (!ex){
                System.out.println("OK");
           } 
        }

    } 
}