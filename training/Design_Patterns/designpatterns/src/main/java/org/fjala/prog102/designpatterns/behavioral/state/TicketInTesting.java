package org.fjala.prog102.designpatterns.behavioral.state;

public class TicketInTesting implements TicketState {

    private Ticket context;

    public TicketInTesting(Ticket ticket) {
        this.context = ticket;
    }

    @Override
    public void startWorking() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(),
                "Start Working");
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
        String message = String.format("(Transition ticket to %s)", TicketInProgress.class.getSimpleName());
        System.out.println(message);
        context.changeState(new TicketInProgress(context));
    }

    @Override
    public void allTestsPassed() {
        String message = String.format("(Transition ticket to %s)", TicketDone.class.getSimpleName());
        System.out.println(message);
        context.changeState(new TicketDone(context));
    }

    @Override
    public void reopen() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(), "Reopen");
        System.err.println(message);
    }

    @Override
    public void noChangeRequired() {
        String message = String.format("Invalid transition: %s -> %s", this.getClass().getSimpleName(),
                "No Change Required");
        System.err.println(message);
    }

    @Override
    public void edit() {
        System.out.println("Setting fields values related to ticket validation/testing");
    }

    @Override
    public void addTestResults() {
        System.out.println("Adding Test Results");
    }

    @Override
    public void assignTicket() {
        System.out.println("(Re)Assigning QA responsible");
    }

}
