import java.util.*;
import java.io.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Pairs{
    String str;
    int time;
    int distance;
    Pairs(String str,int time,int distance){
        this.str = str;
        this.time = time;
        this.distance = distance;
    }
}
public class Main
{
    
    public static void ShortestDistance(int sou,int des,HashMap<String,ArrayList<Pairs>> metro_map,HashMap<String,Integer> str_to_num,HashMap<Integer,String> num_to_str){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first); 
        pq.add(new Pair(0,sou));
        int ar[] = new int[57];
        for(int i = 0;i < 57;i++){
            ar[i] = Integer.MAX_VALUE;
        }
        ar[sou] = 0;
        while(pq.size() != 0){
            Pair pa = pq.remove();
            int dist1 = pa.first;
            int cur1 = pa.second;
            String cur = num_to_str.get(cur1);
            for(int i = 0;i < metro_map.get(cur).size();i++){
                Pairs x1 = metro_map.get(cur).get(i);
                String str5 = x1.str;
                int num9 = str_to_num.get(str5);
                int dis = x1.distance;
                if(dis + dist1 < ar[num9]){
                    ar[num9] = dis + dist1;
                    pq.add(new Pair(ar[num9],num9));
                }
            }
        }
        System.out.println(ar[des] + " meters");
    }
    
    public static void ShortestTime(int sou,int des,HashMap<String,ArrayList<Pairs>> metro_map,HashMap<String,Integer> str_to_num,HashMap<Integer,String> num_to_str){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first); 
        pq.add(new Pair(0,sou));
        int ar[] = new int[57];
        for(int i = 0;i < 57;i++){
            ar[i] = Integer.MAX_VALUE;
        }
        ar[sou] = 0;
        while(pq.size() != 0){
            Pair pa = pq.remove();
            int time1 = pa.first;
            int cur1 = pa.second;
            String cur = num_to_str.get(cur1);
            for(int i = 0;i < metro_map.get(cur).size();i++){
                Pairs x1 = metro_map.get(cur).get(i);
                String str5 = x1.str;
                int num9 = str_to_num.get(str5);
                int ti = x1.time;
                if(ti + time1 < ar[num9]){
                    ar[num9] = ti + time1;
                    pq.add(new Pair(ar[num9],num9));
                }
            }
        }
        System.out.println(ar[des] + " minutes");
    }
// giving nums to station as our algo deals with nums
    public static void Func1(HashMap<String,Integer> str_to_num,HashMap<String,ArrayList<Pairs>> metro_map){
        int k = 0;
        for(String str:metro_map.keySet()){
             str_to_num.put(str,k);
             k++;
        }
    }
    
    public static void PrintTheStations(HashMap<String,Integer> str_to_num){
        for(String s:str_to_num.keySet()){
            System.out.println(s);
        }
    }
    // nums changing to string for code understanding (konwlwdge)
    public static void Func2(HashMap<Integer,String> num_to_str,HashMap<String,Integer> str_to_num){
        for(String s:str_to_num.keySet()){
            int num = str_to_num.get(s);
            num_to_str.put(num,s);
        }
    }
    
    public static void Add_Map(HashMap<String,ArrayList<Pairs>> metro_map){
        
        //Red line
        metro_map.put("Miyapur",new ArrayList<>());
        metro_map.get("Miyapur").add(new Pairs("JNTU_College",3,1800));
        
        metro_map.put("JNTU_College",new ArrayList<>());
        metro_map.get("JNTU_College").add(new Pairs("Miyapur",3,1800));
        metro_map.get("JNTU_College").add(new Pairs("KPHP_Colony",3,1400));
        
        metro_map.put("KPHP_Colony",new ArrayList<>());
        metro_map.get("KPHP_Colony").add(new Pairs("JNTU_College",3,1400));
        metro_map.get("KPHP_Colony").add(new Pairs("Kukatpally",3,1500));
        
        metro_map.put("Kukatpally",new ArrayList<>());
        metro_map.get("Kukatpally").add(new Pairs("KPHP_Colony",3,1500));
        metro_map.get("Kukatpally").add(new Pairs("Balanagar",2,1500));
        
        metro_map.put("Balanagar",new ArrayList<>());
        metro_map.get("Balanagar").add(new Pairs("Kukatpally",2,1500));
        metro_map.get("Balanagar").add(new Pairs("Moosapet",2,600));
        
        metro_map.put("Moosapet",new ArrayList<>());
        metro_map.get("Moosapet").add(new Pairs("Balanagar",2,600));
        metro_map.get("Moosapet").add(new Pairs("Bharat_Nagar",2,1000));
        
        metro_map.put("Bharat_Nagar",new ArrayList<>());
        metro_map.get("Bharat_Nagar").add(new Pairs("Moosapet",2,1000));
        metro_map.get("Bharat_Nagar").add(new Pairs("Erragadda",2,900));
        
        metro_map.put("Erragadda",new ArrayList<>());
        metro_map.get("Erragadda").add(new Pairs("Bharat_Nagar",2,900));
        metro_map.get("Erragadda").add(new Pairs("ESI_Hospital",2,200));
        
        metro_map.put("ESI_Hospital",new ArrayList<>());
        metro_map.get("ESI_Hospital").add(new Pairs("Erragadda",2,200));
        metro_map.get("ESI_Hospital").add(new Pairs("SR_Nagar",2,1700));
        
        metro_map.put("SR_Nagar",new ArrayList<>());
        metro_map.get("SR_Nagar").add(new Pairs("ESI_Hospital",2,1700));
        metro_map.get("SR_Nagar").add(new Pairs("Ameerpet",2,700));
        
        metro_map.put("Ameerpet",new ArrayList<>());
        metro_map.get("Ameerpet").add(new Pairs("SR_Nagar",2,700));
        metro_map.get("Ameerpet").add(new Pairs("Begumpet",2,1600));
        metro_map.get("Ameerpet").add(new Pairs("Madhura_Nagar",2,700));
        metro_map.get("Ameerpet").add(new Pairs("Panjagutta",3,1300));
        
        metro_map.put("Panjagutta",new ArrayList<>());
        metro_map.get("Panjagutta").add(new Pairs("Ameerpet",3,1300));
        metro_map.get("Panjagutta").add(new Pairs("Irrum_Manzil",2,1000));
        
        metro_map.put("Irrum_Manzil",new ArrayList<>());
        metro_map.get("Irrum_Manzil").add(new Pairs("Panjagutta",2,1000));
        metro_map.get("Irrum_Manzil").add(new Pairs("Khairatabad",3,1200));
        
        metro_map.put("Khairatabad",new ArrayList<>());
        metro_map.get("Khairatabad").add(new Pairs("Irrum_Manzil",3,1200));
        metro_map.get("Khairatabad").add(new Pairs("Lakdi-Ka-Pul",2,1200));
        
        metro_map.put("Lakdi-Ka-Pul",new ArrayList<>());
        metro_map.get("Lakdi-Ka-Pul").add(new Pairs("Khairatabad",2,1200));
        metro_map.get("Lakdi-Ka-Pul").add(new Pairs("Assembly",2,1100));
        
        metro_map.put("Assembly",new ArrayList<>());
        metro_map.get("Assembly").add(new Pairs("Lakdi-Ka-Pul",2,1100));
        metro_map.get("Assembly").add(new Pairs("Nampally",2,700));
        
        metro_map.put("Nampally",new ArrayList<>());
        metro_map.get("Nampally").add(new Pairs("Assembly",2,700));
        metro_map.get("Nampally").add(new Pairs("Gandhi_Bhavan",2,800));
        
        metro_map.put("Gandhi_Bhavan",new ArrayList<>());
        metro_map.get("Gandhi_Bhavan").add(new Pairs("Nampally",2,800));
        metro_map.get("Gandhi_Bhavan").add(new Pairs("Osmania_Medical_College",2,800));
        
        metro_map.put("Osmania_Medical_College",new ArrayList<>());
        metro_map.get("Osmania_Medical_College").add(new Pairs("Gandhi_Bhavan",2,800));
        metro_map.get("Osmania_Medical_College").add(new Pairs("MG_Bus_Station",2,900));
        
        metro_map.put("MG_Bus_Station",new ArrayList<>());
        metro_map.get("MG_Bus_Station").add(new Pairs("Osmania_Medical_College",2,900));
        metro_map.get("MG_Bus_Station").add(new Pairs("Sulthan_Bazaar",3,2100));
        metro_map.get("MG_Bus_Station").add(new Pairs("Malakpet",2,800));
        
        metro_map.put("Malakpet",new ArrayList<>());
        metro_map.get("Malakpet").add(new Pairs("MG_Bus_Station",2,800));
        metro_map.get("Malakpet").add(new Pairs("New_Market",2,1200));
        
        metro_map.put("New_Market",new ArrayList<>());
        metro_map.get("New_Market").add(new Pairs("Malakpet",2,1200));
        metro_map.get("New_Market").add(new Pairs("Musarambagh",2,1000));
        
        metro_map.put("Musarambagh",new ArrayList<>());
        metro_map.get("Musarambagh").add(new Pairs("New_Market",2,1000));
        metro_map.get("Musarambagh").add(new Pairs("Dilsukhnagar",3,1500));
        
        metro_map.put("Dilsukhnagar",new ArrayList<>());
        metro_map.get("Dilsukhnagar").add(new Pairs("Musarambagh",3,1500));
        metro_map.get("Dilsukhnagar").add(new Pairs("Chaitanyapuri",2,1100));
        
        metro_map.put("Chaitanyapuri",new ArrayList<>());
        metro_map.get("Chaitanyapuri").add(new Pairs("Dilsukhnagar",2,1100));
        metro_map.get("Chaitanyapuri").add(new Pairs("Victoria_Memorial",2,1200));
        
        metro_map.put("Victoria_Memorial",new ArrayList<>());
        metro_map.get("Victoria_Memorial").add(new Pairs("Chaitanyapuri",2,1200));
        metro_map.get("Victoria_Memorial").add(new Pairs("LB_Nagar",2,1400));
        
        metro_map.put("LB_Nagar",new ArrayList<>());
        metro_map.get("LB_Nagar").add(new Pairs("Victoria_Memorial",2,1400));
        
        //blue line
        metro_map.put("Raidurg",new ArrayList<>());
        metro_map.get("Raidurg").add(new Pairs("HITEC_City",2,1500));
        
        metro_map.put("HITEC_City",new ArrayList<>());
        metro_map.get("HITEC_City").add(new Pairs("Raidurg",2,1500));
        metro_map.get("HITEC_City").add(new Pairs("Durgam_Cheruvu",2,900));
        
        metro_map.put("Durgam_Cheruvu",new ArrayList<>());
        metro_map.get("Durgam_Cheruvu").add(new Pairs("HITEC_City",2,900));
        metro_map.get("Durgam_Cheruvu").add(new Pairs("Madhapur",3,1600));
        
        metro_map.put("Madhapur",new ArrayList<>());
        metro_map.get("Madhapur").add(new Pairs("Durgam_Cheruvu",3,1600));
        metro_map.get("Madhapur").add(new Pairs("Peddamma_Gudi",2,1200));
        
        metro_map.put("Peddamma_Gudi",new ArrayList<>());
        metro_map.get("Peddamma_Gudi").add(new Pairs("Madhapur",2,1200));
        metro_map.get("Peddamma_Gudi").add(new Pairs("Jubilee_Hills_Check_Post",2,700));
        
        metro_map.put("Jubilee_Hills_Check_Post",new ArrayList<>());
        metro_map.get("Jubilee_Hills_Check_Post").add(new Pairs("Peddamma_Gudi",2,700));
        metro_map.get("Jubilee_Hills_Check_Post").add(new Pairs("Road_No_5_Jubilee_Hills",3,1400));
        
        metro_map.put("Road_No_5_Jubilee_Hills",new ArrayList<>());
        metro_map.get("Road_No_5_Jubilee_Hills").add(new Pairs("Jubilee_Hills_Check_Post",3,1400));
        metro_map.get("Road_No_5_Jubilee_Hills").add(new Pairs("Yusufguda",2,900));
        
        metro_map.put("Yusufguda",new ArrayList<>());
        metro_map.get("Yusufguda").add(new Pairs("Road_No_5_Jubilee_Hills",2,900));
        metro_map.get("Yusufguda").add(new Pairs("Madhura_Nagar",3,1500));
        
        metro_map.put("Madhura_Nagar",new ArrayList<>());
        metro_map.get("Madhura_Nagar").add(new Pairs("Yusufguda",3,1500));
        metro_map.get("Madhura_Nagar").add(new Pairs("Ameerpet",2,700));
        
        metro_map.put("Begumpet",new ArrayList<>());
        metro_map.get("Begumpet").add(new Pairs("Ameerpet",2,1600));
        metro_map.get("Begumpet").add(new Pairs("Prakash_Nagar",2,1400));
        
        metro_map.put("Prakash_Nagar",new ArrayList<>());
        metro_map.get("Prakash_Nagar").add(new Pairs("Begumpet",2,1400));
        metro_map.get("Prakash_Nagar").add(new Pairs("Rasoolpura",2,1100));
        
        metro_map.put("Rasoolpura",new ArrayList<>());
        metro_map.get("Rasoolpura").add(new Pairs("Prakash_Nagar",2,1100));
        metro_map.get("Rasoolpura").add(new Pairs("Paradise",2,1100));
        
        metro_map.put("Paradise",new ArrayList<>());
        metro_map.get("Paradise").add(new Pairs("Rasoolpura",2,1100));
        metro_map.get("Paradise").add(new Pairs("Parade_Ground",2,1200));
        
        metro_map.put("Parade_Ground",new ArrayList<>());
        metro_map.get("Parade_Ground").add(new Pairs("Paradise",2,1200));
        metro_map.get("Parade_Ground").add(new Pairs("Secundherabad_West",2,1000));
        metro_map.get("Parade_Ground").add(new Pairs("Secundherabad_East",3,1500));
        
        metro_map.put("Secundherabad_East",new ArrayList<>());
        metro_map.get("Secundherabad_East").add(new Pairs("Parade_Ground",3,1500));
        metro_map.get("Secundherabad_East").add(new Pairs("Mettuguda",3,1900));
        
        metro_map.put("Mettuguda",new ArrayList<>());
        metro_map.get("Mettuguda").add(new Pairs("Secundherabad_East",3,1900));
        metro_map.get("Mettuguda").add(new Pairs("Tarnaka",2,1300));
        
        metro_map.put("Tarnaka",new ArrayList<>());
        metro_map.get("Tarnaka").add(new Pairs("Mettuguda",2,1300));
        metro_map.get("Tarnaka").add(new Pairs("Habsiguda",3,1600));
        
        metro_map.put("Habsiguda",new ArrayList<>());
        metro_map.get("Habsiguda").add(new Pairs("Tarnaka",3,1600));
        metro_map.get("Habsiguda").add(new Pairs("NGRI",2,800));
        
        metro_map.put("NGRI",new ArrayList<>());
        metro_map.get("NGRI").add(new Pairs("Habsiguda",2,800));
        metro_map.get("NGRI").add(new Pairs("Stadium",2,1200));
        
        metro_map.put("Stadium",new ArrayList<>());
        metro_map.get("Stadium").add(new Pairs("NGRI",2,1200));
        metro_map.get("Stadium").add(new Pairs("Uppal",2,1100));
        
        metro_map.put("Uppal",new ArrayList<>());
        metro_map.get("Uppal").add(new Pairs("Stadium",2,1100));
        metro_map.get("Uppal").add(new Pairs("Nagole",2,1000));
        
        metro_map.put("Nagole",new ArrayList<>());
        metro_map.get("Nagole").add(new Pairs("Uppal",2,1000));
        
        //green line
        metro_map.put("Secundherabad_West",new ArrayList<>());
        metro_map.get("Secundherabad_West").add(new Pairs("Parade_Ground",2,1000));
        metro_map.get("Secundherabad_West").add(new Pairs("Gandhi_Hospital",2,1000));
        
        metro_map.put("Gandhi_Hospital",new ArrayList<>());
        metro_map.get("Gandhi_Hospital").add(new Pairs("Secundherabad_West",2,1000));
        metro_map.get("Gandhi_Hospital").add(new Pairs("Musheerabad",2,1500));
        
        metro_map.put("Musheerabad",new ArrayList<>());
        metro_map.get("Musheerabad").add(new Pairs("Gandhi_Hospital",2,1500));
        metro_map.get("Musheerabad").add(new Pairs("RTC_X_Roads",2,1300));
        
        metro_map.put("RTC_X_Roads",new ArrayList<>());
        metro_map.get("RTC_X_Roads").add(new Pairs("Musheerabad",2,1300));
        metro_map.get("RTC_X_Roads").add(new Pairs("Chikkadpally",3,1900));
        
        metro_map.put("Chikkadpally",new ArrayList<>());
        metro_map.get("Chikkadpally").add(new Pairs("RTC_X_Roads",3,1900));
        metro_map.get("Chikkadpally").add(new Pairs("Narayanaguda",1,900));
        
        metro_map.put("Narayanaguda",new ArrayList<>());
        metro_map.get("Narayanaguda").add(new Pairs("Chikkadpally",1,900));
        metro_map.get("Narayanaguda").add(new Pairs("Sulthan_Bazaar",2,1400));
        
        metro_map.put("Sulthan_Bazaar",new ArrayList<>());
        metro_map.get("Sulthan_Bazaar").add(new Pairs("Narayanaguda",2,1400));
        metro_map.get("Sulthan_Bazaar").add(new Pairs("MG_Bus_Station",3,2100));
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		HashMap<String,ArrayList<Pairs>> metro_map = new HashMap<>();// for graph
		Add_Map(metro_map);
		//str to number
		HashMap<String,Integer> str_to_num = new HashMap<>();// for algo dealing num so station were converted to nums
		Func1(str_to_num,metro_map);
		//num to string
		HashMap<Integer,String> num_to_str = new HashMap<>(); // reconverting our num to strig for understanding to our code
		Func2(num_to_str,str_to_num);
		System.out.println("Press 1 to show the Station Names");
		System.out.println("Press 2 to find minimum distance to reach source to destination");
		System.out.println("Press 3 to find minimum time to reach source to destination");
		int choice = sc.nextInt();
		if(choice == 1){
		    PrintTheStations(str_to_num);
		}
		else if(choice == 2){
		    String source = sc.next();
		    String destination = sc.next();
		    if(!metro_map.containsKey(source) || !metro_map.containsKey(destination)){
		        System.out.println("Enter Valid Stations");
		        System.exit(0);
		    }
		    int v1 = str_to_num.get(source);
		    int v2 = str_to_num.get(destination);
		    ShortestDistance(v1,v2,metro_map,str_to_num,num_to_str);
		}
		else if(choice == 3){
		    String source = sc.next();
		    String destination = sc.next();
		    if(!metro_map.containsKey(source) || !metro_map.containsKey(destination)){
		        System.out.println("Enter Valid Stations");
		        System.exit(0);
		    }
		    int v1 = str_to_num.get(source);
		    int v2 = str_to_num.get(destination);
		    ShortestTime(v1,v2,metro_map,str_to_num,num_to_str);
		}
		else{
		    System.out.println("Enter Valid Choice");
		}
	}
}