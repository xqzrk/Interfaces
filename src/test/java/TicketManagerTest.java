import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1000, "DME", "GOJ", 60);
    Ticket ticket2 = new Ticket(2, 2500, "DME", "GOJ", 60);
    Ticket ticket3 = new Ticket(3, 2000, "DME", "GOJ", 60);

    Ticket ticket4 = new Ticket(4, 4000, "AER", "SVO", 150);
    Ticket ticket5 = new Ticket(5, 2500, "AER", "SVO", 150);
    Ticket ticket6 = new Ticket(6, 3500, "AER", "SVO", 150);
    Ticket ticket7 = new Ticket(7, 3200, "AER", "SVO", 150);

    Ticket ticket8 = new Ticket(8, 3100, "SVO", "LED", 90);
    Ticket ticket9 = new Ticket(9, 6500, "SVO", "LED", 90);
    Ticket ticket10 = new Ticket(10, 3200, "SVO", "LED", 90);
    Ticket ticket11 = new Ticket(11, 6000, "SVO", "LED", 90);
    Ticket ticket12 = new Ticket(12, 3700, "SVO", "LED", 90);
    Ticket ticket13 = new Ticket(13, 6150, "SVO", "LED", 90);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);
    }

    @Test
    public void shouldFindByFromAndTo() {
        Ticket[] expected = {ticket5, ticket7, ticket6, ticket4};
        Ticket[] actual = manager.searchByFromAndTo("AER", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByOnlyFromMatch() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromAndTo("SVO", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByOnlyToMatch() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromAndTo("AER", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindWithNoMatches() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromAndTo("ROV", "PEZ");

        Assertions.assertArrayEquals(expected, actual);
    }
}
