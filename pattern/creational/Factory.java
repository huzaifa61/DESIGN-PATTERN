package creational;

class Factory {

    public  static  void main(String args[]){
        shapeInstanceFactry shapeInstanceFactry = new shapeInstanceFactry();
        ShapeFactory circleObj = shapeInstanceFactry.getInstance("creational.Rectangle");
        circleObj.computeArea();
    }
}

 interface ShapeFactory {
    public  void computeArea();
}

  class shapeInstanceFactry{
    ShapeFactory getInstance(String value){

        if(value.equals("creational.Rectangle")){
            return  new RectangleFactory();
        }else if(value.equals("Square")){
            return new SquareFactory();
        }
        return null;
    }

}

  class RectangleFactory implements ShapeFactory {
     @Override
     public void computeArea() {
         System.out.println("Reactange computer area called");
     }
 }

 class SquareFactory implements ShapeFactory {
     @Override
     public void computeArea() {
         System.out.println("Square computer area called");
     }
 }

