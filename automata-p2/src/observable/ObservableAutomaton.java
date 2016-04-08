package observable;

import java.util.Observable;
import java.util.Observer;

import automaton.DeterministicAutomaton;
import automaton.NotDeterministInitialStateException;
import automaton.NotDeterministTransitionException;
import automaton.State;
import automaton.Transition;
import automaton.UnknownInitialStateException;

public class ObservableAutomaton<T> extends DeterministicAutomaton<T> {

	public ObservableAutomaton(Transition<T>[] transitions) throws NotDeterministTransitionException,
			UnknownInitialStateException, NotDeterministInitialStateException {
		super(transitions);
		// TODO Auto-generated constructor stub
	}

	private Observable observable = new Observable() {
		@Override
		public void notifyObservers(Object arg) {
			setChanged();
			super.notifyObservers(arg);
		}
	};

	@Override
	protected State changeCurrentState(Transition<T> t) {
		observable.notifyObservers(t);
		return super.changeCurrentState(t);
	}

	public void addObserver(Observer o) {
		observable.addObserver(o);
	}
}
