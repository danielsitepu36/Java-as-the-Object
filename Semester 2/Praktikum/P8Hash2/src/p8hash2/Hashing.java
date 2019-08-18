package p8hash2;

public class Hashing {

    private int size;
    private int datasize;
    private int[] Data;

    public Hashing(int sz) {
        size = sz;
        datasize = 0;
        Data = new int[size];
        for (int i = 0; i < size; i++) {
            Data[i] = -1;
        }
    }

    public boolean isFull() {
        return (datasize == size);
    }

    public int modMethod(int key) {
        return (key % 97);
    }

    public void insertLinear(int key) {
        int indexArr = modMethod(key);
        if (isFull()) {
            System.out.println("Array is full for inserting " + key + " !");
        } else {
            while (Data[indexArr] != -1) {
                indexArr += 1;
                if (indexArr == size) {
                    indexArr = 0;
                }
            }
            Data[indexArr] = key;
            //System.out.println("Insert " + key + " success");
            datasize++;
        }
    }

    public void insertQuadratic(int key) {
        int indexArr = modMethod(key);
        int i = 1;
        if (isFull()) {
            System.out.println("Array is full for inserting " + key + " !");
        } else {
            while (Data[indexArr] != -1) {
                indexArr += (i * i);
                if (indexArr == size) {
                    indexArr = 0;
                } else if (indexArr >= size) {
                    indexArr %= size;
                }
                i++;
            }
            Data[indexArr] = key;
            //System.out.println("Insert " + key + " success");
            datasize++;
        }
    }
    
    public void insertDouble(int key) {
        int c=89;
        int index1 = modMethod(key);
        int index2 = c - (key%c);
        if (isFull()) {
            System.out.println("Array is full for inserting " + key + " !");
        } else {
            int indexNext = index1;
            while (Data[indexNext] != -1) {
                indexNext += index2;
                if (indexNext == size) {
                    indexNext = 0;
                } else if (indexNext >= size) {
                    indexNext %= size;
                }
            }
            Data[indexNext] = key;
            //System.out.println("Insert " + key + " success");
            datasize++;
        }
    }
    
    public void print() {
        System.out.println("Number of data = " + datasize);
        System.out.print("Data = ");
        for (int i = 0; i < size; i++) {
            System.out.print(Data[i] + " ");
        }
        System.out.println();
    }
    
    public void checkCluster(){
        int cluster = 0;                        //Jumlah cluster
        int i;
        if(Data[0]!=-1){                        //Jika data 1 merupakan cluster, maka cluster ditambah 1
            cluster=1;
        }
        for(i=0;i<size;i++){
            while(Data[i]==-1 && i<size-1){     //Looping selama i = -1 dan kurang dari ukuran table
                i++;                            //
                if(Data[i]!=-1){
                    cluster++;
                }
            }
        }
        System.out.println("Cluster size = " + cluster);
    }
}

//
//    public void insertDouble(int key) {
//        int index1 = modMethod(key);
//        int index2 = (key + (key % 10)) % size;
//        int i = 1;
//        if (isFull()) {
//            System.out.println("Array is full for inserting " + key + " !");
//        } else {
//            int indexNext = index1;
//            while (Data[indexNext] != -1) {
//                indexNext = index1 + (i * index2);
//                if (indexNext == size) {
//                    indexNext = 0;
//                } else if (indexNext >= size) {
//                    indexNext %= size;
//                }
//                i++;
//            }
//            Data[indexNext] = key;
//            //System.out.println("Insert " + key + " success");
//            datasize++;
//        }
//    }