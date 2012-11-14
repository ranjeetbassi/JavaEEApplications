package sheridan;

public class MathEquation {
	String StudentName;
	String StudentId;
	int FirstNumber;
	String Operand;
	int SecondNumber;
	int FinalAnswer;

	public MathEquation(int firstNumber, String operand, int secondNumber,
			int finalAnswer) {
		FirstNumber = firstNumber;
		Operand = operand;
		SecondNumber = secondNumber;
		FinalAnswer = finalAnswer;
	}

	public int getFirstNumber() {
		return FirstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		FirstNumber = firstNumber;
	}

	public String getOperand() {
		return Operand;
	}

	public void setOperand(String operand) {
		Operand = operand;
	}

	public int getSecondNumber() {
		return SecondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		SecondNumber = secondNumber;
	}

	public int getFinalAnswer() {
		return FinalAnswer;
	}

	public void setFinalAnswer(int finalAnswer) {
		FinalAnswer = finalAnswer;
	}
}
