package jp.co.technica.imple.use_instance.deepcopy;

public class HappySet implements Cloneable{
	private Content c = new Content();

	class Content{
		/**ハンバーガー残量*/
		private int hamburgerRemainingAmount = 100;

		/**コーラ残量*/
		private int cokeRemainingAmount = 100;

		private int toy = 1;
	}


	public void eat(){
		c.hamburgerRemainingAmount-=10;
	}

	public void quaff(){
		c.cokeRemainingAmount-=20;
	}

	public void outPrintStatus(String name){
		System.out.println("=== " + name + "==============");
		System.out.println("ハンバーガー残量 : " + c.hamburgerRemainingAmount);
		System.out.println("コーラ残量       : " + c.cokeRemainingAmount);
		System.out.println("=========================");
	}

	@Override
	public HappySet clone(){
		try {
			return (HappySet) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
//		HappySet newHs = new HappySet();
//		//値もコピーしたいのであれば、プリミティブの値を基のほうから引っ張ってくる。
//		newHs.c.hamburgerRemainingAmount = this.c.hamburgerRemainingAmount;
//		newHs.c.cokeRemainingAmount = this.c.cokeRemainingAmount;
//		newHs.c.toy = this.c.toy;
//
//		return newHs;

	}
}
