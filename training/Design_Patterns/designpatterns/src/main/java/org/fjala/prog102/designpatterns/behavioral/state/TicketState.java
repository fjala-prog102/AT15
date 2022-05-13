package org.fjala.prog102.designpatterns.behavioral.state;

public interface TicketState {

    // State transition methods

    void startWorking();

    void stopWorking();

    void readyForTesting();

    void testsFailed();

    void allTestsPassed();

    void reopen();

    void noChangeRequired();

    // Behavioral methods

    void edit();

    void addTestResults();

    void assignTicket();
}
