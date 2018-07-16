package edu.maskleo;

public class TypePromotionTest {

    public static void main(String[] args) {
        // 三元表达式会让类型提升
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
    }
}
