package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date chekIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date chekIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.chekIn = chekIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekIn() {
		return chekIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - chekIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates (Date chechIn, Date checkOut) {		
		Date now = new Date();
		if (chechIn.before(now) || checkOut.before(now)) {
			return " as datas de reserva para atualização devem ser datas futuras";
		}
		if (!checkOut.after(chechIn)) {
			return " A data de check-out deve ser após a data de check-in";
		}		
		this.chekIn = chechIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(chekIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " noites.";
		
	}
	
	
}
