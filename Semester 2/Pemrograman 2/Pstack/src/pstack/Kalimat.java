package pstack;

public class Kalimat {
 public void balikUTS(String st){
        StackW S=new StackW();
        char[] kal;
        kal=st.toCharArray();
        int i=0;
        while(i<st.length()){ 
           Queue Q=new Queue();
           while ((i<st.length()) && (kal[i]!=' ')) {
             Q.enqueue(kal[i]);i++;
           }
           i++;
           //Q.display();
           String x="";
           while(!Q.isEmpty()){
              char k=Q.dequeue();
              x+=k;
           }
         //  System.out.println(x);
           S.push(x);
        }
        //S.Display();
        String hasil=new String(kal);
        System.out.print("Hasilnya :");
        System.out.print(" ");
        while (!S.isEmpty()){
            System.out.print(S.pop()+" ");
        }
        System.out.println();
        
 }    

    
    
    public void balik(String st){
        Stack S=new Stack();
        char[] kal;
        kal=st.toCharArray();
        for(int i=0;i<st.length();i++){ 
           S.push(kal[i]);
        }
        int i=0;
        while (!S.isEmpty()){
            kal[i++]=S.pop();
        }
        String hasil=new String(kal);
        System.out.print("Hasilnya :");
        System.out.println(hasil);
  }    
   public void balance(String st){
        Stack S=new Stack();
        char kal[],x;
        kal=st.toCharArray();
        int i=0;boolean cek=true;
        while (i<st.length()){ 
            if (kal[i]=='{' || kal[i]=='[' || kal[i]=='(' ) S.push(kal[i]);
            else { 
             if(!S.isEmpty()){
               if ((kal[i]=='}' && S.item[S.top]=='{') ||
                (kal[i]==']' && S.item[S.top]=='[')||
                (kal[i]==')' && S.item[S.top]=='(')
                ) x=S.pop();
             }
             else {
              if ((kal[i]=='}')||(kal[i]==']')||(kal[i]==')')) {cek=false;
              i=st.length();}
             } 
            }
            i++;      
        }
        if ((!S.isEmpty())||(cek==false)){ 
                System.out.println("Tidak valid");}
        else {System.out.println("valid");}     
   }
   
   public boolean palindrom(String st){
        Stack S=new Stack();
        char[] kal;
        kal=st.toCharArray();
        for(int i=0;i<st.length();i++){ 
           S.push(kal[i]);
        }
       // S.Display();
        boolean palin=true;
        int i=0;
        while (!S.isEmpty()){
            char c=S.pop();
            if(c==kal[i]) i++;
            else {
               palin=false;
               break;
            }  
        }
        return palin;
  }  
   
}
