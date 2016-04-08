import automaton.State;
import automaton.StateImpl;
import automaton.Transition;
import automaton.TransitionImpl;
import machine.Action;
import machine.FiniteStateMachine;
import machine.TransitionWithAction;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		State[] states = new State[2];
		states[0] = new StateImpl(true, false);
		states[1] = new StateImpl(false, true);

		Transition<String>[] transitions = new Transition[] { 
				new TransitionImpl<String>(states[0], states[1], "a"),
				new TransitionImpl<String>(states[0], states[0], "b"),
				new TransitionImpl<String>(states[1], states[0], "b"),
				new TransitionImpl<String>(states[1], states[1], "a") };

		try {
			Action<String> print = new Action<String>() {
				@Override
				public void execute(String arg) {
					System.out.println("Read " + arg);
				}
			};

			TransitionWithAction<String>[] transitions5 = new TransitionWithAction[] {
					new TransitionWithAction<String>(transitions[0], print),
					new TransitionWithAction<String>(transitions[1], print),
					new TransitionWithAction<String>(transitions[2], print),
					new TransitionWithAction<String>(transitions[3], print) };
			FiniteStateMachine<String> machine = new FiniteStateMachine<String>(
					(TransitionWithAction<String>[]) transitions5);
			String[] m = { "a", "b", "b", "a" };
			machine.recognize(m);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
