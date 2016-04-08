package automaton;

public class TransitionImpl implements Transition {

	private State source;

	private State target;

	private Object label;

	public TransitionImpl(State source, State target, Object label) {
		this.source = source;
		this.target = target;
		this.label = label;
	}

	@Override
	public State source() {
		return source;
	}

	@Override
	public State target() {
		return target;
	}

	@Override
	public Object label() {
		return label;
	}

}
