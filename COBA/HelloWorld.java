class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World");
        int i=0;
        i++;
        if(i==1){
            i=(i+1)*(i+9);
        }
        for(;i<25;i++){
            i+=i;
        }
        System.out.println(i);
    }
}