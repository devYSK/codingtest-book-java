package test;

public class Test2 {


    private static final Thread temp = new Thread();

    private static int fac(int n) {
        int ret = 1;

        for (int i = n ; i > 0; i--) {
            ret *= i;
        }

        return ret;
    }


    public static void main(String[] args) {


        Integer num = 99;


        System.out.println(num.toString());


        temp.interrupt();

        System.out.println(fac(10) / (fac(4) * fac(6)));
    }
}
