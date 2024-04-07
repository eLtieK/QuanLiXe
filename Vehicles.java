
import static java.lang.Math.abs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Vehicles {  
    enum Type{ //add some type of vehicles
        truck,
        coach, //xe khach
        car,
        container
    }
    enum Fuel{ //add some fuel for vehicles
        diesel,
        gasoline,
        ethanol,
    }
    enum Status{ //add some status for drivers
        ready,
        on_duty,
        under_maintenance //dang bao duong
    }
    private int weight;
    private int size;
    private Fuel fuel;
    private Type type;
    private Status status;
    private int id;
    private long all_km;
    private long km_before_maintenace;
    //private String nickname; bonus feature :)) 

    Vehicles() {
        this.km_before_maintenace = Long.MAX_VALUE;
    }
    Vehicles(int weight, int size, Fuel fuel, Type type, int id) {
        this.weight = weight;
        this.size = size;
        this.fuel = fuel;
        this.type = type;
        this.status = Status.ready;
        this.id = id;
        this.all_km = 0;
        this.km_before_maintenace = 0;
    }
    Vehicles(Vehicles vehicle) {
        this.weight = vehicle.getWeight();
        this.size = vehicle.getSize();
        this.fuel = vehicle.getFuel();
        this.type = vehicle.getType();
        this.status = vehicle.getStatus();
        this.id = vehicle.getId();
        this.all_km = vehicle.getAll_km();
        this.km_before_maintenace = vehicle.getKm_before_maintenace();
    }
    
    public int getWeight() {
        return this.weight;
    }
    public int getSize() {
        return this.size;
    }
    public Vehicles.Fuel getFuel() {
        return this.fuel;
    }
    public Vehicles.Type getType() {
        return this.type;
    }
    public Vehicles.Status getStatus() {
        return this.status;
    }    
    public int getId() {
        return this.id;
    }
    public long getAll_km() {
        return this.all_km;
    }
    public long getKm_before_maintenace() {
        return this.km_before_maintenace;
    }
    
    public Drivers.License get_suitable_license () {
        if(this.type.equals(Vehicles.Type.car)) {
            return Drivers.License.B2;
        }
        else if(this.type.equals(Vehicles.Type.coach)) {
            return Drivers.License.C;
        }
        else if(this.type.equals(Vehicles.Type.truck)) {
            return Drivers.License.D;
        }
        else {
            return Drivers.License.E;
        }
    }
    
    public boolean is_need_maintenace () {
        if(this.km_before_maintenace >= 10000) {
            return true;
        }
        return false;
    }
    
    public void maintenace() {
        Thread updateThread = new Thread(() -> {
            long km = this.km_before_maintenace;
            while (this.km_before_maintenace > 0) {
                // Cập nhật dữ liệu hoặc thực hiện các tác vụ cần thiết ở đây
                this.km_before_maintenace -= 1000;
                System.out.println("Vehicle's id: " + this.id + " is under maintenace ... " + (int)(abs((km - this.km_before_maintenace) * 100) / km) + "%");
                try {
                    // Tạm ngừng luồng cập nhật trong 1 giây
                    Thread.sleep(1000); // milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        updateThread.start();
        this.km_before_maintenace = 0;
        this.status = Vehicles.Status.under_maintenance;
    }
    public static int get_price_fuel(Vehicles.Fuel fuel) throws Exception {
        switch (fuel) {
            case Vehicles.Fuel.diesel:
                return 22;
            case Vehicles.Fuel.ethanol:
                return 20;
            case Vehicles.Fuel.gasoline:
                return 15;
        }
        throw new Exception("Error: Unable to get price_fuel");
    }
    
    public static int get_fuel_cosumption_rate(Vehicles.Type type, Vehicles.Fuel fuel) throws Exception { //1h di ton bao nhieu li xang
        switch (type) {
            case Vehicles.Type.car:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 4;
                    case Vehicles.Fuel.ethanol:
                        return 8;
                    case Vehicles.Fuel.gasoline:
                        return 6    ;
                }
           case Vehicles.Type.truck:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 7;
                    case Vehicles.Fuel.ethanol:
                        return 10;
                    case Vehicles.Fuel.gasoline:
                        return 9;
                }
            case Vehicles.Type.coach:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 5;
                    case Vehicles.Fuel.ethanol:
                        return 9;
                    case Vehicles.Fuel.gasoline:
                        return 7;
                }
            case Vehicles.Type.container:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 12;
                    case Vehicles.Fuel.ethanol:
                        return 22;
                    case Vehicles.Fuel.gasoline:
                        return 18;
                }
        }
        throw new Exception("Error: Unable to get fuel_cosumption_rate");
    }
    
    public void increase_km(int distance) {
        this.all_km += distance;
        this.km_before_maintenace += distance;
    }
}
