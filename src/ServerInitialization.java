





import java.util.LinkedList;
import java.util.List;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;

public class ServerInitialization extends Front{
    private static List<Cloudlet> cloudletList;

	private static List<Vm> vmlist;

	public static List<Vm> createVM(int userId, int vms, int idShift) throws InterruptedException {
		
             
		LinkedList<Vm> list = new LinkedList<Vm>();

		
		long size = 10000; 
		int ram = 512; 
		int mips = 250;
		long bw = 1000;
		int pesNumber = 1; 
		String vmm = "Xen"; 

		
		Vm[] vm = new Vm[vms];

		for(int i=0;i<vms;i++){
                        bw=bw+500;
			vm[i] = new Vm(idShift + i, userId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
			list.add(vm[i]);
    		}

		return list;
	}
	public static List<Cloudlet> createCloudlet(int userId, int cloudlets, int idShift){
		LinkedList<Cloudlet> list = new LinkedList<Cloudlet>();
  		long length = 40000;
		long fileSize = 300;
		long outputSize = 300;
		int pesNumber = 1;
		UtilizationModel utilizationModel = new UtilizationModelFull();

		Cloudlet[] cloudlet = new Cloudlet[cloudlets];

		for(int i=0;i<cloudlets;i++){
			cloudlet[i] = new Cloudlet(idShift + i, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
			cloudlet[i].setUserId(userId);
			list.add(cloudlet[i]);
		}
		return list;
	}
}

    

    

    
  

    


	
	

