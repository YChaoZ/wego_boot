package algorithm;

/**
 * @author YanC
 * @description 二分法 开2的平方根并精确到后十位
 * @date 2019/8/1
 */
public class Bisection {
    public static void main(String[] args) {
        Double exact = 0.0000000001;

        double low = 1.4, hight = 1.5;

        double mide = (low + hight) / 2;

        while (hight - low > exact) {
            if (mide * mide > 2) {
                hight = mide;
            } else {
                low = mide;
            }

            mide = (low + hight) / 2;
        }

        System.out.println(mide);
    }
}
