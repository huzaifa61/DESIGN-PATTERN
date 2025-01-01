package creational;

abstract class Shape {

    int x ,y;

    public Shape(int x,int y){
        this.x = x;
        this.y = y;
    }
    public abstract Shape clone();

     @Override
     public String toString() {
         return "creational.Shape[x=" + x + ", y=" + y + "]";
     }

}

class Rectangle extends Shape{
   // int length;
    //int breadth;

    public Rectangle(int x, int y) {
        super(x, y);
      //  this.breadth = breadth;
       // this.length = length;
    }

    @Override
    public Shape clone() {
        return  new Rectangle(this.x,this.y);// length*breadth;
    }


}
class Prototype {
    public  static  void main(String args[]){
        Rectangle rec = new Rectangle(1,2);
        Rectangle cloned = (Rectangle) rec.clone();

        System.out.println(cloned);


    }

}

