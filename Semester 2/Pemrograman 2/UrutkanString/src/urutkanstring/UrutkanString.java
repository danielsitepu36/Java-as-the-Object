package urutkanstring;
public class UrutkanString {
    public static void main(String[] args) {
        String[] nama={"Mangga","Anggur","Apel","Jeruk","Nanas","Pepaya"};
        String temp;
        System.out.println("Nama - Nama Buah Sebelum Diurutkan");
        for (int i=0; i<nama.length; i++)
            System.out.println(i+1+" "+nama[i]+" ");

        //Mengurutkan nama buah
        System.out.println("==================================");
        System.out.println("Nama - Nama Buah Setelah Diurutkan");
        for (int i=0; i<(nama.length-1); i++)
          for (int j=0; j<(nama.length-1-i); j++)
             if (nama[j].compareTo(nama[j+1])>0){
                temp=nama[j+1];
                nama[j+1]=nama[j];
                nama[j]=temp;    
            }
        for (int i=0; i<nama.length; i++){
        System.out.println(i+1+" "+nama[i]+" "+nama[i].length());
        }

    }
    
}
