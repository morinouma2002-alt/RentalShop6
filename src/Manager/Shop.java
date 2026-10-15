package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DVD.DVDPrice;
import Guest.Guest;

//データの集まり
public class Shop {

	private long assets = 0;

	// has-aの関係 Shop　Employee(社員リスト)を持つ
	private List<Employee> listEmployee = new ArrayList<>();

	private List<Guest> registerGuest = new ArrayList<>();//会員登録者をためる

	private ZaikoKanri zaiko;

	public Scanner sc;

	public Shop(ZaikoKanri zaiko, Scanner sc) {

		this.zaiko = zaiko;
		this.sc = sc;
	}

	public List<Guest> getRegisterGuest() {
		return registerGuest;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public long getAssets() {
		return assets;
	}

	public void checkAssets() {
		System.out.println("資産は" + getAssets() + "円です");
	}

	//社員を登録する。社員に「あなたの店長は私」と教えろ
	public void setEmployee(Employee employee) {

		listEmployee.add(employee);
	}

	public void setRegisterGuest(Guest guest) {
		registerGuest.add(guest);
	}

	public void setAssets(int money) {
		assets += money;
	}

	public void postAssets() {
		assets += 500;
	}

	public void cal(DVDPrice type, boolean register) {

		int money = type.getPrice();

		if (type == DVDPrice.NEW && register) {
			System.out.println("会員なので、新作は20%オフ");
			money = money * 80 / 100;
		} else if (type == DVDPrice.OlD && !register) {
			System.out.println("非会員なので、旧作は20%オフ");
			money = money * 80 / 100;
		}

		setAssets(money);
		System.out.println("商品の値段は" + money + "円です");
	}
}
