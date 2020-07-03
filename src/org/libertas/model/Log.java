package org.libertas.model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public void gravarLog(String model) {
		
		
		try {
			 
			 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			 String data = sdf.format(new Date());
			 
			 System.out.println("Gravando Log " + data + " - " + model);
			
			 File f = new File("log.txt");
			 System.out.println(f.getAbsolutePath());
			 FileWriter arq = new FileWriter(f, true);
			 PrintWriter gravarArq = new PrintWriter(arq);
			 gravarArq.println(data + " - " + model);
			 gravarArq.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
