package cinema;
import java.util.Scanner;
public class Cinema {
    
    public static void menu(){
    System.out.println();
    System.out.println("1. Show the seats"); 
    System.out.println("2. Buy a ticket"); 
    System.out.println("3. Statistics");
    System.out.println("0. Exit"); 
    }
    

        
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int m = scanner.nextInt();
        

        String[][] kino = new String[n][m];
        for (int i = 0; i < n; ++i) { 
            for (int j = 0; j < m; ++j) { 
                kino [i][j] = "S";
            }
        }
        menu();
        
                    int pom = 0;
                    int a = 0;
                    int b = 0;
        
        boolean e = true;
        while (e) {
            int choice = scanner.nextInt();                 
            switch (choice) {
                case 1: //1. Show the seats
                    System.out.print("Cinema:\n  "); 
                    for (int i = 0; i < m ; i++) {  
                        System.out.print(i + 1 + " ");  
                    }
                    System.out.println();
                    for (int i = 0; i < n; ++i) { 
                        System.out.print(i + 1 + " "); 
                        for (int j = 0; j < m; ++j) { 
                            System.out.print(kino[i][j] + " ");  
                        } 
                        System.out.println();   
                    }
                System.out.println();
                menu();
                break;
                
                case 2: //2. Buy a ticket                 
                    do  {
                        do { 
                            pom = 0;
                            System.out.println(); 
                            System.out.println("Enter a row number:");
                            a = scanner.nextInt();
                            System.out.println("Enter a seat number in that row:");
                            b = scanner.nextInt(); 
                            if (a < 0 || b < 0 || a > n || b > m) {
                                System.out.println("Wrong input!"); 
                            } else  {  
                            pom = 1;
                            }
                        } while (pom == 0 );
                        
                        pom = 0;
                        if ("B".equals(kino[a-1][b-1])) { 
                            System.out.println("That ticket has already been purchased!");
                        } else  {  
                            pom = 1;
                            }
                        
                    } while (pom == 0 );
                      
                    
                    int listok = 0;
                    if ((n*m)<=60) { 
                        listok=10;
                        } else { 
                            if (a > (n / 2)){ 
                                        listok = 8;
                            } else {listok = 10;}
                        }
                    System.out.println();
                    System.out.print("Ticket price: ");
                    System.out.println("$" + listok);
                    System.out.println();
                    kino [a-1][b-1]= "B";
                    
                    
                    System.out.println();
                    menu();
                break;
    
                case 3: // 3. Statistics
                int obsadene = 0;
                int navstupnom = 0;
                int maxzisk = 0;
                for (int i = 0; i < n; ++i) { 
                    for (int j = 0; j < m; ++j) { 
                        if ("B".equals(kino[i][j])) {
                            obsadene += 1;
                            int listokn = 0;
                            if ((n*m)<=60) { 
                                listokn=10;
                                } else { 
                                    if ((n / 2) > i){ 
                                     listokn = 10;
                                    } else {listokn = 8;}
                                }
                            navstupnom += listokn;
                        }
                        int listokm = 0;
                        if ((n*m)<=60) { 
                            listokm=10;
                            } else { 
                                if ((n / 2) > i){ 
                                    listokm = 10;
                                } else {listokm = 8;}
                            }
                        maxzisk += listokm;
                    } 
                }


                System.out.println("Number of purchased tickets: " + obsadene);
                double nd = n;
                double md = m;
                double obsadened = obsadene;
                double percenta =(double) (100 * obsadened * 1 / (nd * md));
                System.out.print("Percentage: ");
                System.out.print(String.format("%.2f", percenta));
                System.out.print("%\n" );
                //System.out.printf("Percentage:% .2f%s", percenta, "%\n");
                System.out.println("Current income: $" + navstupnom);
                System.out.println("Total income: $" + maxzisk); 
                System.out.println();
                break;
                          
                case 0: // 0. Exit
                    e = false;
                    System.out.println("Exit");
                break;

            }
        } 
    

    }
}     
