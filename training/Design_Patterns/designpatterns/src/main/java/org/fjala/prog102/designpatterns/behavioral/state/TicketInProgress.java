package org.fjala.prog102.designpatterns.behavioral.state;

public class TicketInProgress implements TicketState {

    private Ticket context;

    public TicketInProgress(Ticket ticket) {
        this.context = ticket;
    }

    @Override
    public void startWorking() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "In Progress");
        System.err.println(message);
    }

    @Override
    public void stopWorking() {
        String message = String.format("(Transition ticket to %s)", TicketToDo.class.getSimpleName());
        System.out.println(message);
        context.changeState(new TicketToDo(context));
    }

    @Override
    public void readyForTesting() {
        String message = String.format("(Transition ticket to %s)", TicketInTesting.class.getSimpleName());
        System.out.println(message);
        context.changeState(new TicketInTesting(context));
    }

    @Override
    public void testsFailed() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "Tests Failed");
        System.err.println(message);
    }

    @Override
    public void allTestsPassed() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "Done");
        System.err.println(message);
    }

    @Override
    public void reopen() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "Reopen");
        System.err.println(message);
    }

    @Override
    public void noChangeRequired() {
        // TODO Auto-generated method stub
    }

    @Override
    public void edit() {
        System.out.println("Setting fields values related to ticket progress");
    }

    @Override
    public void addTestResults() {
        System.err.println("Cannot add test results to a ticket In Progress!");
    }

    @Override
    public void assignTicket() {
        System.out.println("(Re)Assigning Dev or DevOps responsible");
    }

}
