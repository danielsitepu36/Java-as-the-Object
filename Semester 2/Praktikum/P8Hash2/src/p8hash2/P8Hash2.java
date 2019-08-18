package p8hash2;
public class P8Hash2 {

    public static void main(String[] args) {
        int sizeHash = 100;
        
        Hashing Linear= new Hashing(sizeHash);
        Hashing Quadratic= new Hashing(sizeHash);
        Hashing Double= new Hashing(sizeHash);
        
        int sizeArr = 50;
        int[] Arr = new int[sizeArr];
        
        for(int i=0;i<sizeArr;i++){
            Arr[i]=(int)(Math.random()*10000) + 1;
        }
        
        for(int i=0;i<sizeArr;i++){
            Linear.insertLinear(Arr[i]);
            Quadratic.insertQuadratic(Arr[i]);
            Double.insertDouble(Arr[i]);
        }
        
        System.out.println("Linear Probing :");
        Linear.print();
        Linear.checkCluster();
        System.out.println();
        
        System.out.println("Quadratic Probing :");
        Quadratic.print();
        Quadratic.checkCluster();
        System.out.println();
        
        System.out.println("Double Probing :");
        Double.print();
        Double.checkCluster();
        System.out.println();
    }
}
