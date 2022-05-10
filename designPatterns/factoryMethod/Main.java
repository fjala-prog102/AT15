public class Main {
    public static void main(String[] args) {
        System.out.println("Order N1_____________________________");
        Restaurant beefResto = new BeefBurgerRestaurant();
        beefResto.orderBurger();

        System.out.println("Order N2_____________________________");
        Restaurant veggieResto = new VeggieBurgerRestaurant();
        veggieResto.orderBurger();

    }
}
