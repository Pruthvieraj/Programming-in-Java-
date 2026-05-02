import java.time.Year;

public class MainVehicle{
    public static void main(String[] a){
        Vehicle v = new Vehicle(); 
        Vehicle v1 = new Vehicle("Toyota ", "Camry", Year.of(2026), "Purple", 75000.00);
        v1.setMfgCode("CMR8112006");
        v1.setNoOfServices(4);

        Vehicle v2 = new Vehicle(4, 21000.00, 'E', "AKC2026KNYK", 2);

        int newSpeed = v.accelerate(110, 150, 5);
        System.out.println("New Speed: " + newSpeed);


        Vehicle[] garage = new Vehicle[3];
        garage[0] = v;
        garage[1] = v1;
        garage[2] = v2;
        System.out.println("Brand\tModel\tYear\tColor\tFuel\tSeats\tPrice\tMileage\tMfgCode\tServices");

        for(int i = 0; i < garage.length; i++){
            garage[i].accelerate(110, 150, 5);
            
            if (garage[i].fuelType == 'D'){
                float m = garage[i].calcMileage(40, 500);
                printTabular(garage[i], m );
        
            }
            else if (garage[i].fuelType == 'P' || garage[i].fuelType == 'C'){
                float m = garage[i].calcMileage(30, 500);
                printTabular(garage[i], m );
    
            }
            else{
                float m = 0;
                printTabular(garage[i], m );
            }
        } 
    }

    public static void printTabular(Vehicle v, float m){
        System.out.println(v.brandName + "\t" + v.modelName + "\t" + v.year + "\t" + v.color + "\t" + v.fuelType + "\t" + v.seatingCapacity + "\t" + v.price + "\t" + m + "\t" + v.getMfgCode() + "\t" + v.getNoOfServices());
    }
}
