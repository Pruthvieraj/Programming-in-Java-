import java.time.Year;

public class Vehicle {
    public String brandName;
    public String modelName;
    public java.time.Year year;
    public String color;
    public char fuelType; //E=Electric, D=Diesel, P=Petrol, C=CNG
    public double price;
    public int seatingCapacity;
    private String mfgCode;
    private int noOfServices;

    public void setMfgCode(String mCode){
        mfgCode=mCode;
    }

    public String getMfgCode(){
        return mfgCode;
    }

    public void setNoOfServices(int noOfServ){
        noOfServices=noOfServ;
    }

    public int getNoOfServices(){
        return noOfServices;
    }

    public void start(){
        System.out.println("Start the vehicle using the key");
        System.out.println("Vehicle Started");
    }

    public void stop(){
        System.out.println("Stop the vehicle using the key");
        System.out.println("Vehicle Stopped");
    }

    public void drive(){
        System.out.println("Use the steering wheel to drive the vehicle");
        System.out.println("Drive Carefully");
    }

    public int accelerate(int initSpeed, int finalSpeed, int time){
        int acceleration=(finalSpeed - initSpeed)/time;
        return acceleration;
    }

    public float calcMileage(float distance, float fuelConsumed){
        float mileage=distance/fuelConsumed;
        return mileage;
    }

    public float calcMileageByFuelType(float distance, float fuelConsumed) {
    float baseMileage = distance / fuelConsumed;
    float factor = 1.0f;

    switch (fuelType) {
        case 'E':
            factor = 1.8f;
            break;
        case 'D':
            factor = 1.2f;
            break;
        case 'C':
            factor = 1.4f;
            break;
        case 'P':
        default:
            factor = 1.0f;
    }

    return baseMileage * factor;
    }


    public Vehicle(){
        brandName = "Toyota";
        modelName = "Corolla";
        year = java.time.Year.of(2020);
        color = "Blue";
        fuelType = 'P';
        price = 30000;
        seatingCapacity = 5;
    }

    public Vehicle(String brandName, String modelName, Year year, String color, double price){
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public Vehicle(int seatingCapacity, double price, char fuelType, String mfgCode, int noOfServices){
        this.seatingCapacity = seatingCapacity;
        this.price = price;
        this.fuelType = fuelType;   
        this.mfgCode = mfgCode;
        this.noOfServices = noOfServices;
    }

    public static void printDetails(Vehicle v){
        System.out.println("=========================================");
        System.out.println("------------Vehicle Details---------------");
        System.out.println("==========================================");
        System.out.println("Brand Name: " + v.brandName);
        System.out.println("Model: " + v.modelName);
        System.out.println("Year of MFG: " + v.year);
        System.out.println("Color of the vehicle: " + v.color);
        System.out.println("Fuel Type: " + v.fuelType);
        System.out.println("Number of seats: " + v.seatingCapacity);
        System.out.println("Price of the vehicle: " + v.price);
        System.out.println("Mfg Code: " + v.getMfgCode());
        System.out.println("Number of Services done: " + v.getNoOfServices());
        System.out.println("-----------------------------------------");
    }
}
