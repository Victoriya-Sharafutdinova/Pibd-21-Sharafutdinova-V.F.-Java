package lab3;

import java.util.ArrayList;

public class MultiLevelWharf {
	ArrayList<Wharf<ITransport>> parkingStages;
    private  int countPlaces = 20; 
    public MultiLevelWharf(int countStages, int pictureWidth, int pictureHeight)
    {
        parkingStages = new ArrayList<Wharf<ITransport>>();
        for(int i =0; i< countStages; ++i)
        {
            parkingStages.add(new Wharf<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }
   

    public Wharf<ITransport> getWharf(int ind){
   	 if((ind>-1) && (ind < parkingStages.size()))
        {
            return parkingStages.get(ind);
        }
        return null;
    }
}
