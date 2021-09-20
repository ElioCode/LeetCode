public class Test {
    int i = 0;

    public Test() {

    }

    public class TestB{
        TestB() {

        }

        void get() {
            int b = Test.this.i;
        }
    }

//    public TestA get(){
//        return new TestA() {
//            @Override
//            void run() {
//            }
//        };
//    }



    public static void main(String[] args) {

    }
}

abstract class TestA{
    abstract void run();
}



