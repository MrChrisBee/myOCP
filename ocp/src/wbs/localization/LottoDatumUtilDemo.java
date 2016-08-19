package wbs.localization;

import java.util.Date;

public class LottoDatumUtilDemo {

	public static void main(String[] args) {
		Date heute =new Date();
		LottoDatumUtil.ersterZiehungstag(heute,true , true ,18, 19);
		
	}

}
