public
    class Rev {

    public static void main(String[] args) {
    	int x=131657954;
    	System.out.println("ARGB: "+Integer.toBinaryString(x));
    	int x1=x<<16;
    	x1=x1>>>16;// 00GB

    	x1=~x1;//reverse 11GB

    	x1=x1<<16;
    	x1=x1>>>16; // 00 reverse GB

    	x=x>>>16; 
    	x=x<<16; //AR00
    	int x2=x+x1;
    	System.out.println("ARGB: "+Integer.toBinaryString(x2));
    }
}