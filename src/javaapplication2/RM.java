/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.*;
import java.net.URI;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author 100596f
 */
public class RM {
private int userId ;
    public RM() throws IOException {
        
        userId = -1;
        
    }

    public void StartMonitering() throws IOException
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter User Command $: ");
            String input = null;
            try {
                
                input = bufferRead.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(input.toLowerCase().endsWith("login"))
            {
                System.out.print("User Name : ");
                String user = bufferRead.readLine();
                
                System.out.print("Password : ");
                String pwd = bufferRead.readLine();
                login(user, pwd);
                
            }
            else if(userId==-1)
            {
                System.out.println("Please login fist...");
            }
            else if(input.equals("show"))
            {
                showPrivilagers();
            }
            else if(input.equals("logout"))
            {
                userId =-1;
            }
            
        }
    }
    public void showPrivilagers() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("priviledge.txt"));
        String in =br.readLine();
        while ((in = br.readLine()) != null) {
            java.util.StringTokenizer st =new StringTokenizer(in,":");
            int file = Integer.parseInt(st.nextToken());
            System.out.println("File0"+file);
            while(st.hasMoreTokens())
            {
                java.util.StringTokenizer st1 =new StringTokenizer(st.nextToken());
                if(Integer.parseInt(st1.nextToken())==userId)
                {
                    if(Integer.parseInt(st1.nextToken())==1)
                    {
                        System.out.println("\tYou can Read ");
                    }
                    else
                    {
                        System.out.println("\tYou cannot Read ");
                    }
                    
                    if(Integer.parseInt(st1.nextToken())==1)
                    {
                        System.out.println("\tYou can  Wirte");
                    }
                    else
                    {
                        System.out.println("\tYou cannot  Wirte");
                    }
                    if(Integer.parseInt(st1.nextToken())==1)
                    {
                        System.out.println("\tYou can delete");
                    }
                    else
                    {
                        System.out.println("\tYou cannot delete");
                    }
                    break;
                }
            }
            
        }
    }
    public void login(String user, String pwd) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Login Details.txt"));
        String in;
        while ((in = br.readLine()) != null) {
            
            java.util.StringTokenizer st =new StringTokenizer(in);
            
            if(st.nextToken().toLowerCase().equals(user.toLowerCase()))
            {
                int hold = Integer.parseInt(st.nextToken());
                if(pwd.equals(st.nextToken()))
                {
                    System.out.println("You login as "+user);
                    userId= hold;
                    return;
                }
                
            }
        }
        
        System.out.println("Something wrong...");
                
    }
}
