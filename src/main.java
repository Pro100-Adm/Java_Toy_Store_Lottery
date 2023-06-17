public class main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        Toy toy1 = new Toy(1, "Конструктор Lego", 5, 10);
        Toy toy2 = new Toy(2, "Трансфомер", 40, 37);
        Toy toy3 = new Toy(3, "Мяч", 32, 17);
        Toy toy4 = new Toy(3, "Кукла Barbie", 50, 30);
        Toy toy5 = new Toy(3, "Пазл", 200, 90);
        Toy toy6 = new Toy(3, "PlayStation 5", 10, 10);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
        store.addToy(toy5);
        store.addToy(toy6);


        store.changeLotteryToyWeight(1, 30);

        store.Lottery();

        Toy lotteryToy = store.getLotteryToy();
        if (lotteryToy != null) {
            System.out.println("You won: " + lotteryToy.getName() + "!");
        }
    }
}
