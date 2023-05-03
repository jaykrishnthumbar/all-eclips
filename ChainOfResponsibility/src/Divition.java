
public class Divition implements Chain {

	private Chain nextChain;

	@Override
	public void setNextChain(Chain nextchain) {
		// TODO Auto-generated method stub
		this.nextChain = nextchain;

	}

	@Override
	public void calculation(Numbers number) {
		// TODO Auto-generated method stub
		if (number.getOperations() == "div") {
			System.out.println(number.getNo1() + " / " + number.getNo2() + " = " + (number.getNo1() / number.getNo2()));
		} else {
			nextChain.calculation(number);
		}

	}

}
