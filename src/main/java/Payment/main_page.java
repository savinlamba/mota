package Payment;

import java.util.*;

public class main_page {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter card number: ");
		String card_num = sc.next();
		if (card_valid.cardvalid(card_num)) {
			System.out.println("Enter the expiration date: ");
			String exp_date = sc.next();
			if (card_valid.expdateval(exp_date)) {
				System.out.println("Enter the CVV: ");
				String cvv = sc.next();
				if (card_valid.cvv(cvv)) {
					System.out.println("Payment Successful");
					System.out.println("Thank You");
				} else {
					System.out.println("CVV not valid");
				}
			} else {
				System.out.println("Expiration date not valid");
			}
		} else {
			System.out.println("Card not valid");
		}
		sc.close();
	}
}
