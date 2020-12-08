import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {

  @Test
  void testMaria1Regular() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_WAYNES_WORLD,1));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_WAYNES_WORLD, 2.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            2.0,
            1);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testJohn2Regular() {
    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_WAYNES_WORLD,1));
    customer.addRental(new Rental(MOVIE_MEAN_STREETS,1));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_WAYNES_WORLD, 2.0);
    rentals.put(MOVIE_MEAN_STREETS, 2.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            4.0,
            2);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testMaria1Regular3Days() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_WAYNES_WORLD,3));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_WAYNES_WORLD, 3.5);

    String expectedStatement = createStatement(
            customer,
            rentals,
            3.5,
            1);

    assertEquals(expectedStatement, customer.statement());
  }

  @Test
  void testMaria2Regular5Days() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_MEAN_STREETS,5));
    customer.addRental(new Rental(MOVIE_WAYNES_WORLD,2));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_MEAN_STREETS, 6.5);
    rentals.put(MOVIE_WAYNES_WORLD, 2.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            8.5,
            2);

    assertEquals(expectedStatement, customer.statement());
  }

  @Test
  void testNewRelease1Day() {
    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_HOLIDATE, 1));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_HOLIDATE, 3.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            3.0,
            1);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testNewRelease2Days() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_KADAVER, 2));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_KADAVER, 6.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            6.0,
            2);

    assertEquals(expectedStatement, customer.statement());

  }


  @Test
  void testNewRelease10Days() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_KADAVER, 10));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_KADAVER, 30.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            30.0,
            2);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testChildrens1Day() {
    Customer customer = new Customer("Maria C");
    customer.addRental(new Rental(MOVIE_GRINCH, 1));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_GRINCH, 1.5);

    String expectedStatement = createStatement(
            customer,
            rentals,
            1.5,
            1);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testChildrens4Days() {
    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_TOY_STORY, 3));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_TOY_STORY, 1.5);

    String expectedStatement = createStatement(
            customer,
            rentals,
            1.5,
            1);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testChildrens10Days() {
    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_TOY_STORY, 10));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_TOY_STORY, 12.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            12.0,
            1);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testVarious() {

    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_TOY_STORY, 9));
    customer.addRental(new Rental(MOVIE_HOLIDATE, 3));
    customer.addRental(new Rental(MOVIE_MEAN_STREETS, 5));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_TOY_STORY, 10.5);
    rentals.put(MOVIE_HOLIDATE, 9.0);
    rentals.put(MOVIE_MEAN_STREETS, 6.5);

    String expectedStatement = createStatement(
            customer,
            rentals,
            26.0,
            4);

    assertEquals(expectedStatement, customer.statement());

  }

  @Test
  void testVarious2() {

    Customer customer = new Customer("John Doe");
    customer.addRental(new Rental(MOVIE_TOY_STORY, 9));
    customer.addRental(new Rental(MOVIE_GRINCH, 15));
    customer.addRental(new Rental(MOVIE_HOLIDATE, 1));
    customer.addRental(new Rental(MOVIE_KADAVER, 2));
    customer.addRental(new Rental(MOVIE_MEAN_STREETS, 5));
    customer.addRental(new Rental(MOVIE_WAYNES_WORLD, 1));

    LinkedHashMap<Movie, Double> rentals = new LinkedHashMap<>();
    rentals.put(MOVIE_TOY_STORY, 10.5);
    rentals.put(MOVIE_GRINCH, 19.5);
    rentals.put(MOVIE_HOLIDATE, 3.0);
    rentals.put(MOVIE_KADAVER, 6.0);
    rentals.put(MOVIE_MEAN_STREETS, 6.5);
    rentals.put(MOVIE_WAYNES_WORLD, 2.0);

    String expectedStatement = createStatement(
            customer,
            rentals,
            47.5,
            7);

    assertEquals(expectedStatement, customer.statement());

  }

  private String createStatement(Customer customer, LinkedHashMap<Movie, Double> rentals, Double total, Integer frPoints) {

    StringBuilder result = new StringBuilder("Rental Record for ");

    result.append(customer.getName());
    result.append("\n");

    for(Map.Entry<Movie, Double> rental : rentals.entrySet()) {
      result.append("\t");
      result.append(rental.getKey().getTitle());
      result.append("\t");
      result.append(rental.getValue());
      result.append("\n");
    }

    result.append("Amount owed is ");
    result.append(total);
    result.append("\n");

    result.append("You earned ");
    result.append(frPoints);
    result.append(" frequent renter points");

    return result.toString();
  }
  public static final Movie MOVIE_WAYNES_WORLD = new Movie("Wayne's World", Movie.REGULAR);
  public static final Movie MOVIE_MEAN_STREETS = new Movie("Mean Streets", Movie.REGULAR);
  public static final Movie MOVIE_GRINCH = new Movie("Grinch", Movie.CHILDRENS);
  public static final Movie MOVIE_TOY_STORY = new Movie("Toy Story", Movie.CHILDRENS);
  public static final Movie MOVIE_HOLIDATE = new Movie("Holidate", Movie.NEW_RELEASE);
  public static final Movie MOVIE_KADAVER = new Movie("Kadaver", Movie.NEW_RELEASE);

}
