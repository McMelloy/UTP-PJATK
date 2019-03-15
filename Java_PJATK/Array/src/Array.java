public class Array{
    int[] arr;
    Array(){
        arr = new int[10];
        for(int i=0;i<10;i++)
            arr[i]=(int)(Math.random()*100);
    }
    Array(int size){
        arr = new int[size];
        for(int i=0;i<size;i++)
            arr[i]=(int)(Math.random()*100);
    }
    Array(int[] arr1){
        arr = new int[arr1.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=arr1[i];
    }

    public void print() {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public int sum(){
        int res=0;
        for(int i=0;i<arr.length;i++)
            res+=arr[i];
        return res;
    }

    public int[] leastTwo(){
        int min,min2;
        min = min2 = (int)Math.pow(2,63);
        for(int i=0;i<arr.length;i++)
            if(arr[i]<min)
                min=arr[i];
        for(int i=0;i<arr.length;i++)
            if(arr[i]<min2 && arr[i]!=min)
                min2=arr[i];
        int[] res={min, min2};
        return res;
    }

    public void reverse(){
        int l=arr.length;
        int[] res = new int[l];
        for(int i=0;i<l;i++)
            res[i]=arr[l-(i+1)];
        arr=res;
    }

    //Homework
    public void append(Array arr2){
        int[] res = new int[arr.length + arr2.arr.length];
        for(int i=0;i<arr.length;i++)
            res[i]=arr[i];
        for(int j=0;j<arr2.arr.length;j++)
            res[arr.length+j]=arr2.arr[j];
        arr=res;
    }

    public Array intersection(Array arr2){
        int count=0;
        I:for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr2.arr.length;j++)
                if(arr[i]==arr2.arr[j]){
                    count++;
                    continue I;
                }
        }
        int[] temp = new int[count];
        count=0;
        I2:for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr2.arr.length;j++)
                if(arr[i]==arr2.arr[j]){
                    temp[count]=arr[i];
                    count++;
                    continue I2;
                }
        }
        Array res = new Array(temp);
        res.delRepet();
        return res;
    }

    public Array union(Array arr2){
        Array res = new Array(this.arr);
        res.append(arr2);
        res.delRepet();
        return res;
    }

    public void delRepet() {
        int count=arr.length;
        int countres=count;
        I:for(int i=1;i<count;i++)
            for(int j=0;j<i;j++)
                if(arr[i]==arr[j]) {
                    countres--;
                    continue I;
                }
        int[] res = new int[countres];
        countres=0;
        I2:for(int i=0;i<count;i++) {
            for (int j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    continue I2;
            res[countres]=arr[i];
            countres++;
        }
        arr = res;
    }
}
