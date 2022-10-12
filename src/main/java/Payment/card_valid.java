package payment;

import java.util.regex.*;

public class card_valid {
	static boolean cardvalid(String card_number) {
		boolean cval = false;
		Pattern cpt=Pattern.compile("\\d{16}");
		Matcher cmt=cpt.matcher(card_number);
		if(cmt.find()) {
			cval=true;
		}
		return cval;
	}
	static boolean expdateval(String exp_date) {
		boolean eval=false;
		Pattern ept=Pattern.compile("[0-9]{2}/[0-9]{2}");
		Matcher emt=ept.matcher(exp_date);
		if(emt.find()) {
			eval=true;
		}
		return eval;
	}
	static boolean cvv(String cvv) {
		boolean cval=false;
		Pattern cpt=Pattern.compile("[0-9]{3}");
		Matcher cmt=cpt.matcher(cvv);
		if(cmt.find()) {
			cval=true;
		}
		return cval;
	}
}
