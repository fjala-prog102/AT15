package org.fjala.prog102.designpatterns.behavioral.chainOfResponsibility;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);
}