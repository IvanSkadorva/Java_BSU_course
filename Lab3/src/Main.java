import java.time.LocalDate;

public class Main {
    public static void getBusesOnRoute(Bus[] buses, int route_number) {
        for (Bus bus : buses) {
            if (route_number == bus.getRoute_number()) {
                System.out.println(bus);
            }
        }
    }

    public static void getBusesInUsageMoreThan(Bus[] buses, int usage_term) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        for (Bus bus : buses) {
            if ((currentYear - bus.getYear_operation()) > usage_term) {
                System.out.println(bus);
            }
        }
    }

    public static void getBusesWithMileageMoreThan(Bus[] buses, int mileage_condition) {
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage_condition) {
                System.out.println(bus);
            }
        }
    }


    public static void main(String[] args) {
        Bus bus1 = new Bus("Oleg", 24423, 3, "Volvo", 2012, 100500);
        Bus bus2 = new Bus("Arthur", 34423, 3, "Peugeot", 2015, 102340);
        Bus bus3 = new Bus("Artyom", 2349, 1, "Lada", 2021, 2343253);
        Bus[] busesCompany = {bus1, bus2, bus3};

        System.out.println("1.List of buses on a route: ");
        getBusesOnRoute(busesCompany, 3);

        System.out.println("2.List of buses in usage more than X years: ");
        getBusesInUsageMoreThan(busesCompany, 4);

        System.out.println("3.List of buses with mileage more than X miles: ");
        getBusesWithMileageMoreThan(busesCompany, 102000);
    }
}

class Bus {

    private String driver;
    private int bus_number;
    private int route_number;
    private String mark;
    private int year_operation;
    private int mileage;

    public Bus() {
        this.driver = "";
        this.bus_number = 0;
        this.route_number = 0;
        this.mark = "";
        this.year_operation = 0;
        this.mileage = 0;
    }

    public Bus(String driver, int bus_number, int route_number, String mark, int year_operation, int mileage) {
        this.driver = driver;
        this.bus_number = bus_number;
        this.route_number = route_number;
        this.mark = mark;
        this.year_operation = year_operation;
        this.mileage = mileage;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String surname) {
        this.driver = surname;
    }

    public int getNumber_bus() {
        return bus_number;
    }

    public void setNumber_bus(int bus_number) {
        this.bus_number = bus_number;
    }

    public int getRoute_number() {
        return route_number;
    }

    public void setRoute_number(int route_number) {
        if (route_number > 0) {
            this.route_number = route_number;
        } else System.out.println("Route number cannot be negative or zero!");
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear_operation() {
        return year_operation;
    }

    public void setYear_operation(int year_operation) {
        if (year_operation > 0) {
            this.year_operation = year_operation;
        } else System.out.println("The year of operation start cannot be negative or zero!");
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (mileage >= 0) {
            this.mileage = mileage;
        } else System.out.println("Mileage cannot be negative!");
    }

    @Override
    public String toString() {
        return "Bus --- " +
                "Driver: " + driver +
                ", Bus number: " + bus_number +
                ", Route number:" + route_number +
                ", Brand:" + mark +
                ", Year of commencement of operation:" + year_operation +
                ", Car mileage:" + mileage;
    }
}