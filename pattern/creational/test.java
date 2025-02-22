package creational;

class OuterClass {
    protected int instanceVariable = 1;
    static int classVariable = 2;

    class InnerClass1 {
        int innerClass1 = 3;

        class InnerClass2 extends InnerClass1 {
            int innerClass2 = 4;

            void display() {
                System.out.println(innerClass1 + innerClass2 + instanceVariable + classVariable);
            }
        }
    }

    static class second extends  OuterClass{
        int a = 10;
    }

    public static void main(String args[]) {
        // Create an instance of OuterClass
        OuterClass outerClass = new OuterClass();
        second s= new second();
        System.out.println(s.instanceVariable);


        // Create an instance of InnerClass1 using the outerClass instance
        OuterClass.InnerClass1 innerClass1 = outerClass.new InnerClass1();

        // Create an instance of InnerClass2 using the innerClass1 instance
        OuterClass.InnerClass1.InnerClass2 innerClass2 = innerClass1.new InnerClass2();

        // Call the display method
        innerClass2.display();
    }
}