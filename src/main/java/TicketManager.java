import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket)
        ;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if ((ticket.getFrom() == from) & (ticket.getTo() == to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] searchByFromAndTo(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                result = tmp;
            }
        }

        Ticket[] tmp = new Ticket[result.length];
        int copyToIndex = 0;
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
            result = tmp;
        }
        Arrays.sort(result);
        return result;
    }
}
