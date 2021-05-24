package AbtractFruit;

public class FruitMain {
    public static void main(String[] args) {
        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();

        for (Fruit f: fruit) {
            System.out.println(f.howToEat());
        }
    }
}
