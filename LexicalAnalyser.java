import java.util.Collections;
import java.util.List;
import java.util.*;

public class LexicalAnalyser {

	private enum State {
		START, NUMBER, SPACE, OPERATOR, ZERO, DECIMAL
	};

	public static List<Token> analyse(String input) throws NumberException, ExpressionException {

		State state = State.START;
		List<Token> tokens = new ArrayList<Token>();
		String buffer = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
				buffer += c;
				switch(state) {
					case START:
						state = State.NUMBER;
						break;
					case NUMBER:
						state = State.NUMBER;
						break;
					case SPACE:
						throw new ExpressionException();
					case OPERATOR:
						state = State.NUMBER;
						break;
					case ZERO:
						throw new NumberException();
					case DECIMAL:
						state = State.NUMBER;
						break;
				}
			}

			else if (c == ' ') {
				switch(state) {
					case START:
						throw new ExpressionException();
					case NUMBER:
						state = State.SPACE;
						break;
					case SPACE:
						state = State.SPACE;
						Token t = new Token(Double.parseDouble(buffer));
						tokens.add(t);
						buffer = "";
						break;
					case OPERATOR:
						state = State.OPERATOR;
						break;
					case ZERO:
						state = State.SPACE;
						break;
					case DECIMAL:
						throw new NumberException();
				}
			}

			else if (c == '+' || c == '-' || c == '/' || c == '*') {
				switch(state) {
					case START:
						throw new ExpressionException();
					case NUMBER:
						state = State.OPERATOR;
						break;
					case SPACE:
						state = State.OPERATOR;
						break;
					case OPERATOR:
						throw new ExpressionException();
					case ZERO:
						state = State.OPERATOR;
						break;
					case DECIMAL:
						throw new NumberException();
				}
				Token t = new Token(Double.parseDouble(buffer));
				tokens.add(t);
				buffer = "";
				t = new Token(Token.typeOf(c));
				tokens.add(t);
			}

			else if (c == '.') {
				buffer += c;
				switch(state) {
					case START:
						throw new NumberException();
					case NUMBER:
						throw new NumberException();
					case SPACE:
						throw new NumberException();
					case OPERATOR:
						throw new NumberException();
					case ZERO:
						state = State.DECIMAL;
						break;
					case DECIMAL:
						throw new ExpressionException();
				}
			}

			else if (c == '0') {
				buffer += c;
				switch(state) {
					case START:
						state = State.ZERO;
						break;
					case NUMBER:
						state = State.NUMBER;
						break;
					case SPACE:
						throw new ExpressionException();
					case OPERATOR:
						state = State.ZERO;
						break;
					case ZERO:
						throw new NumberException();
					case DECIMAL:
						state = State.NUMBER;
				}
			}

		}
		if (state == State.NUMBER || state == State.ZERO) {
			Token t = new Token(Double.parseDouble(buffer));
			tokens.add(t);
			buffer = "";
			return tokens;
		}
		throw new NumberException();
	}
}

