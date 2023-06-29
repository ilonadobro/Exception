import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Milk", 60);
    Product item2 = new Product(2, "Bread", 45);
    Product item3 = new Product(3, "Butter", 250);


    @Test
    public void exceptionTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(8);
        });
    }

    @Test
    public void removeTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

      repo.remove(2);

      Product[] expected = {item1, item3};
      Product[] actual = repo.findAll();

      Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);

        Product[] expected = {item1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addExceptionProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item1);
        });
    }
    @Test
    public void productTest() {
        Product product = new Product(5, "Tomato", 80);

        product.setTitle("Eggs");
        Assertions.assertEquals("Eggs", product.getTitle());

        product.setPrice(54);
        Assertions.assertEquals(54, product.getPrice());
    }


}
