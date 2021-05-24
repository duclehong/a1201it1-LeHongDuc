package abtract_interface_demo;

public class Chicken extends Animals implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cuc ta cục tạ";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
