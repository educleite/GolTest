package gol.app.hr;

import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

public class TestIntervalDates {

    public static void main(String[] args) {         
        
       getIntervalDate( "2020-04-27T00:00:00", "1978-09-16T00:00:00", "YEARS" );
       //checkSpringsLive( "1978-09-23T00:00:00", "2019", "2019-04-27T00:00:00" );
    }
    
    public static void getIntervalDate(String currentDate, String dateOfBirth, String formatInterval ){
        
        
        System.out.println(">>>> Start of Java Embedding routine");
        String dateFrom = dateOfBirth;       
        String dateTo   = currentDate;       
        String diffCode = formatInterval;      
               
        String dateInit = dateFrom.replace("T", " " );                 
        String dateEnd  = dateTo.replace("T", " " );         
        String interval = null;  
        int currentYear = Integer.parseInt(currentDate.substring(0, 4));
                
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );          
              
        Date d1 = null;         
        Date d2 = null;          
                         
        try{         
                             
            d1 = format.parse( dateInit );                     
            d2 = format.parse( dateEnd );                     
                             
        } catch (ParseException e){         
                             
            System.out.println(e);         
                            
        }          
                
        // Get msec from each, and subtract.         
        long diff = d2.getTime() - d1.getTime();         
        long diffSeconds = diff / 1000;                  
        long diffMinutes = diff / (60 * 1000);                  
        long diffHours = diff / (60 * 60 * 1000);               
        long diffYears = diff / (60 * 60 * 1000) / 24 / 365;           
                
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");                  
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");                  
        System.out.println("Time in hours: " + diffHours + " hours.");                  
        System.out.println("Time in years: " + diffYears + " years.");          
                
        if ( diffCode.equals("SECONDS") ){         
           interval = String.valueOf(diffSeconds);         
        }         
        if ( diffCode.equals("MINUTES") ){         
           interval = String.valueOf(diffMinutes);         
        }         
        if ( diffCode.equals("HOURS") ){         
           interval = String.valueOf(diffHours);         
        }           
        if ( diffCode.equals("YEARS") ){         
           interval = String.valueOf(diffYears);  
            
           for (int i=0; i< Integer.parseInt(interval)+1; i++) 
           { 
                System.out.println( "Spring year:" + (currentYear-i) + " -> " + (i+1) );
           }
        }                 
        
        
        System.out.println("Interval calculated: "+interval);
        
        System.out.println(">>>> End of Java Embedding routine");
        
        
    }
 
    public static void checkSpringsLive(String pdateOfBirth, String pspringYear, String pcurrentDate){
              
        System.out.println(">>>> Start of Java Embedding routine");               
                  
        String dateOfBirth = pdateOfBirth;          
        String springYear  = pspringYear;         
        String currentDate  = pcurrentDate;      

        dateOfBirth        = dateOfBirth.replace("T", " " ); 
        currentDate        = currentDate.replace("T", " " );   
        
        String startSpringDate   = springYear + "-09-23 00:00:00";  
        String endSpringDate     = springYear + "-12-22 00:00:00";  
                   
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );             
                  
        Date dDateOfBirth     = null;                     
        Date dCurrentDate     = null;  
        Date dStartSpringDate = null;
        Date dEndSpringDate   = null;             

        String result = null;
                            
        // Converting to date
        try{            
                                
            dDateOfBirth       = format.parse( dateOfBirth );                                 
            dCurrentDate       = format.parse( currentDate ); 
            dStartSpringDate = format.parse( startSpringDate ); 
            dEndSpringDate   = format.parse( endSpringDate ); 
                                
        } catch (ParseException e){            
                                
            System.out.println(e);            
                               
        }             
                   
          // Check if the person lived between 23-sep and 22-dec     
                   
            if ( dCurrentDate.before(dStartSpringDate) && !dCurrentDate.equals(dStartSpringDate) ){ 
               result = "false"; 
            } 
            else { if (dDateOfBirth.after(dStartSpringDate)){
               result = "false";   
            } 
            else {
               result = "true";  
            }
            }

        System.out.println( result );  
        
        System.out.println(">>>> End of Java Embedding routine");
        
    }
}
