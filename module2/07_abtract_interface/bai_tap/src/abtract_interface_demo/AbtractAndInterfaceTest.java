package abtract_interface_demo;

public class AbtractAndInterfaceTest {
    public static void main(String[] args) {
        Animals[] animals = new Animals[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animals animal : animals) {
            System.out.println(animal.makeSound());
            if(animal instanceof Chicken){
                System.out.println(((Chicken) animal).howToEat());
            }
        }

    }
}
