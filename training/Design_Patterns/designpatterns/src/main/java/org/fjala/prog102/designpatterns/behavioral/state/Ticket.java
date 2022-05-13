package org.fjala.prog102.designpatterns.behavioral.state;

public class Ticket implements TicketState {

    private TicketState state;

    private String key;

    private String title;

    public Ticket(String key, String title) {
        this.key = key;
        this.title = title;
        this.state = new TicketToDo(this);
        System.out.println(String.format("New ticket created: <%s>", this.toString()));
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)", this.key, this.title, ticketStateToString());
    }

    // Change/Setter state method
    public void changeState(TicketState state) {
        this.state = state;
        System.out.println(String.format("Ticket state updated: <%s>", this.toString()));
    }

    private String ticketStateToString() {
        return this.state.getClass().getSimpleName();
    }

    // State transition methods

    public void startWorking() {
        this.state.startWorking();
    }

    public void stopWorking() {
        this.state.stopWorking();
    }

    public void readyForTesting() {
        this.state.readyForTesting();
    }

    public void testsFailed() {
        this.state.testsFailed();
    }

    public void allTestsPassed() {
        this.state.allTestsPassed();
    }

    public void reopen() {
        this.state.reopen();
    }

    public void noChangeRequired() {
        this.state.noChangeRequired();
    }

    // Behavioral methods

    public void edit() {
        this.state.edit();
    }

    public void addTestResults() {
        this.state.addTestResults();
    }

    @Override
    public void assignTicket() {
        this.state.assignTicket();
    }

}
