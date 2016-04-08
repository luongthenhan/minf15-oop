import automaton.DeterministicAutomaton;
import automaton.State;
import automaton.StateImpl;
import automaton.Transition;
import automaton.TransitionImpl;

public class Test {
	public static void main(String[] args) {
		State[] states = new State[2];
		states[0] = new StateImpl(true, false);
		states[1] = new StateImpl(false, true);
		TransitionImpl<String> t1 = new TransitionImpl<String>(states[0], states[1], "a");
		TransitionImpl<String> t2 = new TransitionImpl<String>(states[0], states[0], "b");
		TransitionImpl<String> t3 = new TransitionImpl<String>(states[1], states[0], "b");
		TransitionImpl<String> t4 = new TransitionImpl<String>(states[1], states[1], "a");

		try {
			DeterministicAutomaton<String> a = new DeterministicAutomaton<String>(t1, t2, t3, t4);
			String[] m1 = { "a", "b", "b", "a" };
			String[] m2 = { "a", "b", "b" };
			String[] m3 = { "a", "b", "c" };
			System.out.println("m1 recognized ?" + a.recognize(m1));
			System.out.println("m2 recognized ?" + a.recognize(m2));
			System.out.println("m3 recognized ?" + a.recognize(m3));
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Transition<String>[] transitions2 = new Transition[] { new TransitionImpl<String>(states[0], states[1], "a"),
				new TransitionImpl<String>(states[0], states[0], "b"),
				new TransitionImpl<String>(states[1], states[0], "b"),
				new TransitionImpl<String>(states[1], states[1], "b") };
		try {
			new DeterministicAutomaton<String>(transitions2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		State[] states2 = new State[2];
		states2[0] = new StateImpl(true, false);
		states2[1] = new StateImpl(true, true);
		Transition<String>[] transitions3 = new Transition[] { new TransitionImpl<String>(states2[0], states2[1], "a"),
				new TransitionImpl<String>(states2[0], states2[0], "b"),
				new TransitionImpl<String>(states2[1], states2[0], "b"),
				new TransitionImpl<String>(states2[1], states2[1], "a") };
		try {
			new DeterministicAutomaton<String>(transitions3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		State[] states3 = new State[2];
		states3[0] = new StateImpl(false, false);
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
	}
}
