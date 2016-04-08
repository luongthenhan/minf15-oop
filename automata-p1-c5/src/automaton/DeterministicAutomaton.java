package automaton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class DeterministicAutomaton {

	private State initialState = null;

	/*
	 * In the map transitions, at each state s we associate a map m where the
	 * values are the transitions having s as source and the corresponding key
	 * the labels of the transitions.
	 * 
	 */
	private final Map<State, Map<Object, Transition>> transitions;

	public DeterministicAutomaton(Transition... transitions) throws NotDeterministTransitionException,
			UnknownInitialStateException, NotDeterministInitialStateException {
		this.transitions = new HashMap<State, Map<Object, Transition>>();
		for (Transition t : transitions) {
			addState(t.source());
			addState(t.target());

			Map<Object, Transition> map = this.transitions.get(t.source());
			if (map.containsKey(t.label())) {
				throw new NotDeterministTransitionException(t, map.get(t.label()));
			} else {
				map.put(t.label(), t);
			}
		}
		if (initialState == null) {
			throw new UnknownInitialStateException();
		}
	}

	protected final void addState(State s) throws NotDeterministInitialStateException {
		if (!transitions.containsKey(s)) {
			transitions.put(s, new HashMap<Object, Transition>());
			if (s.initial()) {
				if (initialState == null) {
					initialState = s;
				} else {
					throw new NotDeterministInitialStateException(s, initialState);
				}
			}
		}
	}

	public State initialState() {
		return initialState;
	}

	public Transition transition(State s, Object label) {
		if (!transitions.containsKey(s)) {
			throw new NoSuchElementException();
		}
		return transitions.get(s).get(label);
	}

	public boolean recognize(Object[] word) {
		return recognize(Arrays.asList(word).iterator());
	}

	public boolean recognize(Iterator<Object> word) {
		State s = initialState;
		while (word.hasNext()) {
			Transition t = transition(s, word.next());
			if (t == null) {
				return false;
			} else {
				s = t.target();
			}
		}
		return s.terminal();
	}
}