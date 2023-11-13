package com.rocha.thread.conditional.variable;

public class TestConditionalVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 2; i++) {
			new HungryPersonUngradated(i).start();
		}

	}

}
