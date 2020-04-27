import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class BinarySearch.
 * Generates a random list, sorts it.
 * User inputs a number to the list.
 * User enters a number to searchNumber.
 * Program finds location of number.
 * @author  BenHilderman
 * @version 1.0
 * @since   2020-04-26
 */

public class BinarySearch {
  
  // Variables
  public ArrayList<Integer> list = new ArrayList<Integer>();
  
  /**
  * User inputs a number, searches for 
  * the number. Then prints the position of the value.
  */

  public static void main(String[] args) {
    
    // Variables
    BinarySearch app = new BinarySearch();
    app.generateList();

    // list gets printed
    System.out.println("The list is being printed now:");
    System.out.println(app.list.toString() + " \n");
  
    app.organizeList();
  
    // OrganizeList gets printed
    System.out.println("The list is sorted and being printed now:");
    System.out.println(app.list.toString() + " \n");

    app.addNumber();
    app.findNumber();
      
  }

  public void userInput(int userNumber) {
        
    // Add user number to the list
    this.list.add(userNumber);
      
    // Runs function organizeList
    organizeList();
  }

  public void generateList() {
      
    Random randomizedList = new Random();

    for (int amount = 0; amount < 250; amount++) {
        
      // 250 numbers and numbers between 1-500
      list.add(randomizedList.nextInt(499) + 1);
    }

  }

  public void organizeList() {
   
    // Variables
    int i;
    int j;
  
    // Used list.size() instead of hardcoding because size changes when user adds a number
    int size = this.list.size();
      
    for (i = 0; i < size; i++) {
      for (j = 0; j < (size - i - 1); j++) {
        
        // if number to the left is greater than the number on the right    
        if (list.get(j) > list.get(j + 1)) {
              
          // temp and temp2 swap the numbers
          Integer temp = list.get(j);
          Integer temp2 = list.get(j + 1);
              
          list.set(j, temp2);
          list.set((j + 1), temp);
            
        } 
      }
    }
  }

  public void addNumber() {
    
    // Instances
    Scanner scanner = new Scanner(System.in);
       
    // User inputs number to add
    System.out.println("Enter an integer to add to the list:");
    int addedNumber = scanner.nextInt();
    
    // Skips line after input
    System.out.println("");
    this.userInput(addedNumber);
    
    System.out.println("The number is added and the list is being printed");
    System.out.println(this.list.toString() + " \n");
    
  }
  
  public void findNumber() {
    
    // Instances
    Scanner scanner = new Scanner(System.in);

    // User inputs number they want to find
    System.out.println("Enter the number you want to find here:");
    int srch = scanner.nextInt();
    
    // Skips line after input
    System.out.println("");
    System.out.println(list.toString() + " \n");
    
    // Runs searchNumber function with user input (srch)
    int position = this.searchNumber(srch);
    
    // If position is valid, print it
    if (position > 0) {
      System.out.printf("The position of " + srch + " is #%d \n", position);
      
    }
    scanner.close();         
  }
  
  public int searchNumber(int srch) {
    
    // Variables
    int loIndex = 0;
    // Used list.size() instead of hardcoding because size changes when user adds a number
    int hiIndex = this.list.size();
    int midIndex = 0;
    int done = 0;
    
    // When position is found (done = 1) or invalid, exit loop
    while (done == 0) {
        
      if (loIndex <= hiIndex) {
        midIndex = (loIndex + hiIndex) / 2;

        // if user input (srch) greater than midIndex
        if (this.list.get(midIndex) < srch) {

          loIndex = midIndex + 1;
        
          continue;
  
        // if user input (srch) less than midIndex
        } else if (this.list.get(midIndex) > srch) {

          hiIndex = midIndex - 1;
          
        } else {
          
          // When done ≠ 0, it leaves loop
          done = 1;
          
        }
        
      } else {
        
        // When done ≠ 0, it leaves loop
        done = 1;

      }
    }
  
    if (loIndex > hiIndex) {
      
      System.out.println("Not found");
      
      return -1;
        
    } else {
      System.out.println("Found");
        
      return midIndex;
    }
  }
}