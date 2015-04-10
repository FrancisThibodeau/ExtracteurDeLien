import  java.io.*;

public class Extract
{
StringBuffer buffer = new StringBuffer();

   public void LectureFichier(String File,String FileDestination)
   {
      try
      {
		BufferedReader reader =  reader = new BufferedReader(new FileReader(File));
        String ligne;
		while((ligne = reader.readLine())!= null)
		{
			buffer.append(ligne);
		}
        reader.close();
        EcritureDansNouveauFichier(FileDestination);
       }
       catch(IOException e)
       {
       }
       EcritureDansNouveauFichier(FileDestination);
   }

   private void EcritureDansNouveauFichier(String FileDestination)
   {
   String ligne;
   int i = 0;
     try
     {
       PrintWriter  writer = new PrintWriter(new BufferedWriter(new FileWriter( FileDestination)));
       writer.println("Hyperliens extraits du fichier <b>" + FileDestination + "</b> :" + "<br>");
	   
	   writer.println("<ul>") ;  
			while(i <= buffer.lastIndexOf("/a>"))
			  {
			   writer.println("<li>") ; 
				writer.println(buffer.substring(buffer.indexOf("<a",i),i=buffer.indexOf("/a>",i) + 3));
 writer.println("</li>") ; 
			  }
			  writer.println("</ul>") ; 
           writer.close();
     }
     catch(IOException e)
      {
      }
   }
   public static void main(String []args)
   {
     Extract ExtracteurDeLien = new Extract();
     ExtracteurDeLien.LectureFichier(args[0],args[1]);
   }
}