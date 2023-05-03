import javax.print.attribute.standard.RequestingUserName;

public class Addition implements Chain {

	private Chain nextChain;

	@Override
	public void setNextChain(Chain nextchain) {

		//
		this.nextChain = nextchain;

	}

	@Override
	public void calculation(Numbers number) {
		if (number.getOperations() == "add") {
			System.out.println(number.getNo1() + " + " + number.getNo2() + " = " + (number.getNo1() + number.getNo2()));
		} else {
			nextChain.calculation(number);
		}

	}

}
