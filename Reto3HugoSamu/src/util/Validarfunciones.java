package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Validarfunciones {

	public static int dimeEntero(String texto, Scanner sc) {
		do {
			try {
				System.out.println(texto);
				String s=sc.nextLine();
				int numero1=Integer.parseInt(s);
				return numero1;
			} catch (Exception e) {
				// TODO: handle 
				System.out.println("Mete un numero");
			}
		} while (true);
		
	}
	
	public static double dimeDouble(String texto, Scanner sc) {
		do {
			try {
				System.out.println(texto);
				String s=sc.nextLine();
				double numero1=Double.parseDouble(s);
				return numero1;
			} catch (Exception e) {
				// TODO: handle 
				System.out.println("Mete un numero");
			}
		} while (true);
		
	}
		
		public static String dimeString(String texto, Scanner sc) {
			do {
				try {	
					System.out.println(texto);
					String s=sc.nextLine();
					return s;
				} catch (Exception e) {
					// TODO: handle 
					System.out.println("Mete un string valido");
				}
			} while (true);

	}
		
		public static LocalDate dimeFecha(String fecha, Scanner sc) {
			do {
				try {
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
					System.out.println(fecha);
					String s=sc.nextLine();
					LocalDate fecha1 = LocalDate.parse(s, formato);
					return fecha1;
				} catch (Exception e) {
					// TODO: handle 
					System.out.println("Mete una fecha valida");
				}
			} while (true);

	}
		
		public static void primo(int num) {
		    boolean primo = true; 
		    for(int i = 2; i < num; i++) {
		        if (num % i == 0) {
		            primo = false;
		            break;
		        }
		    }
		    if (primo)
		       System.out.println("es primo");
		    else
		       System.out.println("no es primo");
		}
		
		public static void comas(int num) { //esta mal
			for (int i = 0; i < num; i++) {
				System.out.print(i == 0 ? i : ", " + i);
			}
		}
		
		public static void muestraArrayInt(int[] array) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(i == 0 ? array[i] : ", " + array[i]);
			}
		}
		
		public static void muestraArrayString(String[] array) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(i == 0 ? array[i] : ", " + array[i]);
			}
			
		}
			public static void muestraArrayListaINT(List<Integer> lista) {
				for (int i = 0; i < lista.size(); i++) {
					System.out.print(i == 0 ? lista.get(i) : ", " + lista.get(i));
				
				}
			
}
			public static double redondear(double presupuesto) {
				return Math.round(presupuesto*100)/100;
			}
			
			//de String a Date 
			public static Date convierte_String_a_Date(String fecha)
			    {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.setLenient(false);
			    		return sdf.parse(fecha);
					} catch (Exception e) {
						return null;
					}
			    }
				
				
				//de Date a String
				public static String convierte_Date_a_String(Date fDate)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					return sdf.format(fDate);
				}
				
				//de Date a LocalDate
				public static LocalDate convierte_Date_a_LocalDate(Date fDate)
				{
					return fDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				}
				//de LocalDate a Date
				public static Date convierte_LocalDate_a_Date(LocalDate fLocalDate)
				{
					java.util.Date d = Date.from(fLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					return new Date(d.getTime());
				}
				
				public static Date fechaNacRandom(Random r)
				{
					String fecha = r.nextInt(1,29)+ "/" + r.nextInt(1,13) + "/" + r.nextInt(1980,2020);
					return Validarfunciones.convierte_String_a_Date(fecha);
				}
				
				public static Date dimeFechaDate(String texto, Scanner sc)
				{
					do {
						try {
							System.out.println(texto + " (dd/mm/yyyy)");
							String s = sc.nextLine();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							sdf.setLenient(false);
							return sdf.parse(s);
						} catch (Exception e) {
							System.out.println("Formato incorrecto");
						}
					} while (true);
				}
				
				public static java.sql.Date convierteFechaASQL(Date fecha)
				{
					return new java.sql.Date(fecha.getTime());
				}
			}