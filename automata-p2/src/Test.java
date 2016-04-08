import java.util.Observable;
import java.util.Observer;

import automaton.DeterministicAutomaton;
import automaton.State;
import automaton.StateImpl;
import automaton.Transition;
import automaton.TransitionImpl;
import observable.ObservableAutomaton;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		State[] states3 = new State[2];
		states3[0] = new StateImpl(true, false);
		states3[1] = new StateImpl(false, true);
		Transition<String>[] transitions4 = new Transition[] { new TransitionImpl<String>(states3[0], states3[1], "a"),
				new TransitionImpl<String>(states3[0], states3[0], "b"),
				new TransitionImpl<String>(states3[1], states3[0], "b"),
				new TransitionImpl<String>(states3[1], states3[1], "a") };
		try {
			new DeterministicAutomaton<String>(transitions4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			ObservableAutomaton<String> observable = new ObservableAutomaton<String>(transitions4);
			observable.addObserver(new Observer() {
				public void update(Observable arg0, Object arg1) {
					System.out.println("Recognize " + ((Transition<String>) arg1).label());
				}
			});
			String[] m = { "a", "b", "b", "a" };
			observable.recognize(m);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
