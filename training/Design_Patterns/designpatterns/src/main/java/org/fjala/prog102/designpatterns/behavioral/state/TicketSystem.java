package org.fjala.prog102.designpatterns.behavioral.state;

public class TicketSystem {
    public static void main(String[] args) {

        // All tickets are created in the "ToDo" state
        Ticket ticket123 = new Ticket("#123", "Refactor Ticket Workflow to be configurable");

        // Invoke some business methods while at the ToDo state
        ticket123.edit();
        ticket123.addTestResults();
        ticket123.assignTicket();

        // Try some invalid transitions
        ticket123.readyForTesting();
        ticket123.testsFailed();
        ticket123.reopen();

        // Trigger a Valid Transition
        ticket123.startWorking();

        // Invoke some business methods while at the In Progress state
        ticket123.edit();
        ticket123.addTestResults();
        ticket123.assignTicket();

        // Try some invalid transitions
        ticket123.startWorking();
        ticket123.allTestsPassed();
        ticket123.testsFailed();

        // Trigger a Valid Transition
        ticket123.readyForTesting();

        // Invoke some business methods while at the In Testing state
        ticket123.edit();
        ticket123.addTestResults();
        ticket123.assignTicket();

        // Try some invalid transitions
        ticket123.stopWorking();
        ticket123.readyForTesting();
        ticket123.noChangeRequired();

        // Trigger a Valid Transition
        ticket123.allTestsPassed();

        // Invoke some business methods while at the Done state
        ticket123.edit();
        ticket123.addTestResults();
        ticket123.assignTicket();

        // Try some invalid transitions
        ticket123.startWorking();
        ticket123.testsFailed();
        ticket123.allTestsPassed();

        // Trigger a Valid Transition
        ticket123.reopen();
    }
}
