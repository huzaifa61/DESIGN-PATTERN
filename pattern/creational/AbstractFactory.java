package creational;

class AbstractFactoryMain{
    public static void main(String args[]){
        AbstractFactoryProducer a = new AbstractFactoryProducer();
        AbstractFactory luxury = a.getInstanceFactory("LUXURY");
       car car= luxury.getInstance(10000000);
        System.out.println(car.getTopSpeed());
    }
}

class AbstractFactoryProducer{
    AbstractFactory getInstanceFactory(String type){
        if(type.equals("LUXURY")){
            return new LuxuryCar();
        }else{
            return new EconomicCar();
        }
    }

}


public interface AbstractFactory  {

    public car getInstance(int price);

}

class  EconomicCar implements AbstractFactory {
    @Override
    public  car getInstance(int price){

        if(price<150000){
            return new WaganoreconomicCar();
        }else if(price> 150000){
            return  new MarutiEconomicCar();
        }

        return  null;
    }
}

class  LuxuryCar implements AbstractFactory{
  public   car getInstance(int price){

        if(price<1500000){
            return new PorcheluxuryCar();
        }else if(price> 1500000){
            return  new BmwluxuryCar();
        }

        return  null;
    }
}

 class PorcheluxuryCar implements car{

    @Override
    public int getTopSpeed() {
        return 1000;
    }
}

class BmwluxuryCar implements car{

    @Override
    public int getTopSpeed() {
        return 15000;
    }
}

class MarutiEconomicCar implements car{

    @Override
    public int getTopSpeed() {
        return 500;
    }
}

class WaganoreconomicCar implements car{

    @Override
    public int getTopSpeed() {
        return 500;
    }
}

interface  car{

    public int getTopSpeed();

}



