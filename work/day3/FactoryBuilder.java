package work.day3;

/**
 * @ClassName FactoryBuilder
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/13 11:53
 * @Version 1.0
 */
public class FactoryBuilder {

    public static void getFactory(int id) {
        switch (id) {
            case 1:
                Factory1 factory1 = new Factory1();
                factory1.builder();
                break;
            case 2:
                Factory2 factory2 = new Factory2();
                factory2.builder();
                break;
            case 3:
                Factory3 factory3 = new Factory3();
                factory3.builder();
                break;
            case 4:
                Factory4 factory4 = new Factory4();
                factory4.builder();
                break;
        }
    }

    public static void main(String[] args) {

        FactoryBuilder.getFactory(1);
    }

}
