import automaton.DeterministicAutomaton;
import automaton.State;
import automaton.StateImpl;
import automaton.Transition;
import automaton.TransitionImpl;

public class Test {

	public static void main(String[] args) {

		// Create states
		State s1 = new StateImpl(true, true);
		State s2 = new StateImpl(false, true);
		State s3 = new StateImpl(false, false);

		// Create transitions
		Transition t1 = new TransitionImpl(s1, s1, "a");
		Transition t2 = new TransitionImpl(s1, s2, "b");
		Transition t3 = new TransitionImpl(s2, s3, "a");
		Transition t4 = new TransitionImpl(s3, s2, "a");
		Transition t5 = new TransitionImpl(s3, s1, "b");

		try {
			DeterministicAutomaton a = new DeterministicAutomaton(new Transition[] { t1, t2, t3, t4, t5 });
			Object[] m1 = { "a", "b", "b", "b" };
			Object[] m2 = { "a", "b", "b" };
			Object[] m3 = { "a", "b", "c" };
			System.out.println("m1 recognized ?" + a.recognize(m1));
			System.out.println("m2 recognized ?" + a.recognize(m2));
			System.out.println("m3 recognized ?" + a.recognize(m3));
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		State[] states = new State[2];
		states[0] = new StateImpl(true, false);
		states[1] = new StateImpl(false, true);

		Transition[] transitions = { new TransitionImpl(states[0], states[1], "a"),
				new TransitionImpl(states[0], states[0], "b"), new TransitionImpl(states[1], states[0], "b"),
				new TransitionImpl(states[1], states[1], "a") };

		try {
			DeterministicAutomaton a = new DeterministicAutomaton(transitions);
			Object[] m1 = { "a", "b", "b", "a" };
			Object[] m2 = { "a", "b", "b" };
			Object[] m3 = { "a", "b", "c" };
			System.out.println("m1 recognized ?" + a.recognize(m1));
			System.out.println("m2 recognized ?" + a.recognize(m2));
			System.out.println("m3 recognized ?" + a.recognize(m3));
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Transition[] transitions2 = { new TransitionImpl(states[0], states[1], "a"),
				new TransitionImpl(states[0], states[0], "b"), new TransitionImpl(states[1], states[0], "b"),
				new TransitionImpl(states[1], states[1], "b") };
		try {
			new DeterministicAutomaton(transitions2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		State[] states2 = new State[2];
		states2[0] = new StateImpl(true, false);
		states2[1] = new StateImpl(true, true);
		Transition[] transitions3 = { new TransitionImpl(states2[0], states2[1], "a"),
				new TransitionImpl(states2[0], states2[0], "b"), new TransitionImpl(states2[1], states2[0], "b"),
				new TransitionImpl(states2[1], states2[1], "a") };
		try {
			new DeterministicAutomaton(transitions3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		State[] states3 = new State[2];
		states3[0] = new StateImpl(false, false);
		states3[1] = new StateImpl(false, true);
		Transition[] transitions4 = { new TransitionImpl(states3[0], states3[1], "a"),
				new TransitionImpl(states3[0], states3[0], "b"), new TransitionImpl(states3[1], states3[0], "b"),
				new TransitionImpl(states3[1], states3[1], "a") };
		try {
			new DeterministicAutomaton(transitions4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
