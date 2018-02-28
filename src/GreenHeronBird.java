
public class GreenHeronBird extends AntColony{
     protected static int getNextOptimalNode(long bw) {
        int i;
        long bait=3000;
        long maxbw=0;
        long[][] bandwd=new long[2][3];
       bandwd[0][0]=vmlist.get(0).getBw();
       bandwd[0][1]=vmlist.get(1).getBw();
       bandwd[0][2]=vmlist.get(2).getBw();
       bandwd[1][0]=vmlist.get(3).getBw();
       bandwd[1][1]=vmlist.get(4).getBw();
       bandwd[1][2]=vmlist.get(5).getBw();
        for(i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(bw==bandwd[i][j])
                {
                    for(int k=0;k<3;k++)
                    {
                        if(bandwd[i][k]>=bait)
                        {
                            maxbw=bandwd[i][k];
                            break;
                        }
                    }
                }
            }
        }
        
        for(i=0;i<6;i++)
        {
            if(maxbw==vmlist.get(i).getBw())
            {
                break;
            }
        }
        if(maxbw==0)
        {
            return (int)maxbw;
        }
        return i;
    }
}
