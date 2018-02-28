

import java.util.List;
import org.cloudbus.cloudsim.Vm;
public class AntColony extends Front{
    static long load[]={450,200,250,150,300,150};
  static Long balancedLoad[]=new Long[6];
      static long pheromone=0;
      static long threshold=250;
      static long temp;

    public static int antColony(List<Vm> vmlist) { 
       int bestNode=0;
       int i;
       for( i=0;i<6;i++)
       {
          if(load[i]>threshold)
          {
              balancedLoad[i]= updatePheromone(load[i],threshold,i);
          }
          else if(load[i]<=threshold)
          {
              
            if(bestNode==0)
              {
              balancedLoad[i]= updatePheromone(load[i],threshold,i);
              bestNode=GreenHeronBird.getNextOptimalNode(vmlist.get(i).getBw());
              }
            else
                balancedLoad[i]= updatePheromone(load[i],threshold,i);
             
             
          }
          else
          {
              if(bestNode==0)
              {
              bestNode=GreenHeronBird.getNextOptimalNode(vmlist.get(i).getBw());
              }
              
          }
   
       }
       return bestNode;
    }

private static long updatePheromone(long ld,long threshold,int i) {
       
        
        if(ld>threshold){
            temp=ld-threshold;
            pheromone=pheromone+temp;
            ld=ld-temp;
            return ld;
        }
        else if(ld<threshold)
        {
            temp=threshold-ld;
            if(pheromone>temp)
            {
            pheromone=pheromone-temp;
            ld=ld+temp;
            }
            else
            {
               ld=ld+pheromone; 
               pheromone=0;
            }
            
            
            return ld;
        }
        else
        {
          return ld;  
        }
        
    }

public static long getLoad(int i)
        {
            return load[i];
        }
public static long getBalancedLoad(int i) {
        return balancedLoad[i];
    }
}
