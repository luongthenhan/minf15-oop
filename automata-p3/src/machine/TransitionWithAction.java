package machine;

import automaton.State;
import automaton.Transition;

public class TransitionWithAction<T> implements Transition<T> {

	private final Transition<T> transition;
	private final Action<T> action;

	public TransitionWithAction(Transition<T> t, Action<T> a) {
		this.transition = t;
		this.action = a;
	}

	@Override
	public State source() {
		// TODO Auto-generated method stub
		return transition.source();
	}

	@Override
	public State target() {
		// TODO Auto-generated method stub
		return transition.target();
	}

	@Override
	public T label() {
		// TODO Auto-generated method stub
		return transition.label();
	}

	public State cross() {
		action.execute(transition.label());
		return transition.target();
	}
}
