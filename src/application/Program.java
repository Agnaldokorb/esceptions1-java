package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data do Check-In (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de check-out deve ser após a data de check-in");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Deseja atualizar a reserva? (s/n): ");
			char type = sc.next().charAt(0);
			
			if (type == 's') {
				System.out.println("Entre com a nova data de reserva: ");
				System.out.print("Data do Check-In (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Data do Check-Out (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				
				Date now = new Date();
				if (checkIn.before(now) || checkOut.before(now)) {
					System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras");
				}
				else if (!checkOut.after(checkIn)) {
					System.out.println("Erro na reserva: A data de check-out deve ser após a data de check-in");
				}
				else {			
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
				}
			}
			else {
				System.out.println("Tenha um otimo dia!");
			}
		}
		
		
		
		
		sc.close();

	}

}
