package org.fjala.prog102.designpatterns.behavioral.state;

public class TicketDone implements TicketState {

    private Ticket context;

    public TicketDone(Ticket ticket) {
        this.context = ticket;
    }

    @Override
    public void startWorking() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "In Progress");
        System.err.println(message);
    }

    @Override
    public void stopWorking() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "To Do");
        System.err.println(message);
    }

    @Override
    public void readyForTesting() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "In Testing");
        System.err.println(message);
    }

    @Override
    public void testsFailed() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "Tests Failed");
        System.err.println(message);
    }

    @Override
    public void allTestsPassed() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(),
                "All Tests Passed");
        System.err.println(message);
    }

    @Override
    public void reopen() {
        String message = String.format("(Transition ticket to %s)", TicketToDo.class.getSimpleName());
        System.out.println(message);
        context.changeState(new TicketToDo(context));
    }

    @Override
    public void noChangeRequired() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(),
                "No Change Required");
        System.err.println(message);
    }

    @Override
    public void edit() {
        System.out.println("Setting only informational fields values related to mark the ticket as completed");
    }

    @Override
    public void addTestResults() {
        System.err.println("Cannot add test results to a ticket completed! (they should be already added)");
    }

    @Override
    public void assignTicket() {
        System.out.println("Assigning Dev or DevOps responsible again in case it needs to be reopened in the future");
    }

}
