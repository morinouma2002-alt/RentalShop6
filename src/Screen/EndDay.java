package Screen;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import DVD.DVD;
import Guest.Guest;
import Guest.GuestStatus;

public class EndDay implements Menu {

	private Guest guest;
	private LocalDate today;

	public EndDay(Guest guest,LocalDate today) {
		this.guest = guest;
		this.today=today;
	}

	@Override
	public void display(Scanner sc) {
		List<DVD> dvdSave = guest.getDvdSave();

		if (dvdSave.size() == 0) {
			System.out.println("一日が終了しました");
			return;
		}

		System.out.println("借りている商品があるので返却日をカウントします");

		//まだ通常客だったかを覚えておく（延滞客になった瞬間だけ知らせるため）
		boolean wasNormal = guest.getStatus() == GuestStatus.NORMAL;

		for (DVD dvd : dvdSave) {
			dvd.setOneDay(today);
			guest.checkOverDay(dvd);//延滞なら同じ客の状態が延滞客に変わる
		}

		if (wasNormal && guest.getStatus() == GuestStatus.POSTPONE) {
			System.out.println("あなたは延滞客に分類されました");
		}
	}

	@Override
	public Guest productGuest(List<Guest> list) {
		return null;
	}
}
