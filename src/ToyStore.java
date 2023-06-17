import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> lotteryToys;
    private String lotteryListFilePath;

    public ToyStore() {
        toys = new ArrayList<Toy>();
        lotteryToys = new ArrayList<Toy>();
        lotteryListFilePath = "lottery_toys.txt";
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeLotteryToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
            }
        }
    }

    public void Lottery() {
        lotteryToys.clear();

        for (Toy toy : toys) {
            int max = 100;
            double spin = (int) (Math.random() * ++max);
            if (spin < toy.getWeight()) {
                lotteryToys.add(toy);
            }
        }
    }
    public Toy getLotteryToy() {
        if (!lotteryToys.isEmpty()) {
            Toy lotteryToy = lotteryToys.remove(0);
            lotteryToy.setQuantity(lotteryToy.getQuantity() - 1);

            try {
                FileWriter writer = new FileWriter(lotteryListFilePath, true);
                writer.write(lotteryToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл игрушки");
            }

            return lotteryToy;
        } else {
            System.out.println("Все игрушки кончились");
            return null;
        }
    }
}
