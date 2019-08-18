package tugas4;

import java.util.ArrayList;

public class Bucket {
    
    char key;
    ArrayList<String> data = new ArrayList<> ();
    int i=-1;
    
    public Bucket(){
    }
    
    public Bucket(char key){
        this.key=key;
    }
    
    public void insert (String d){
        //Insert data to the top
        data.add(d);
        i++;
    }
    
    public String getTop(){
        //Return from the top of the Stack
        return data.get(i--);
    }
    
    //Remove Bucket data
    public void remove(){
        i=-1;
        data.removeAll(data);
    }    
}
