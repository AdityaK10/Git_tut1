import java.util.Scanner;

public class fifo {
   
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
       
        int num_page, num_frame;
        num_page = scanner.nextInt();
        num_frame = scanner.nextInt();
       
        int[] pageReference = new int[num_page];
        int[] frame = new int[num_frame];
        boolean[] pageHit = new boolean[num_page];
       
        for (int i = 0; i < frame.length; i++){
            frame[i] = -1;
        }
       
        for (int i = 0, j = 0; i < pageReference.length; i++) {
            pageReference[i] = scanner.nextInt();
            pageHit[i] = false;
           
            if(j == frame.length)
            {
                j = 0;
            }
           
            for(int it = 0; it < frame.length; it++)
            {
                if(frame[it] == pageReference[i])
                {
                    pageHit[i] = true;
                    break;
                }
            }
           
            if(!pageHit[i])
            {
                frame[j] = pageReference[i];
                j++;
            }
           
           
        }
       
        int num_pagehit = 0, num_pagefault = 0; 
        
        for(int i =  0; i < pageHit.length; i++ )
        {
        	if(pageHit[i])
        	{
        		num_pagehit++;
        		System.out.print("1 ");
        	}
        	else 
        	{
        		num_pagefault++;
        		System.out.print("0 ");	

        	}
        }
       
        System.out.println("\n\nNumber of page faults : " + num_pagefault);
        System.out.println("Page hit percentage   : " + 100*((1.0*num_pagehit)/(1.0*(num_pagefault+num_pagehit))));
        System.out.println("Page Fault percentage : " + 100*((1.0*num_pagefault)/(1.0*(num_pagefault+num_pagehit))));
      
       
       
      scanner.close(); 
    }
   

}