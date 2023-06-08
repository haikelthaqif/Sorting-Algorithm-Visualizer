package SortAlgorithmVisualizer;

import java.util.ArrayList;


public class App{


    public static ArrayList<Integer> arrayListOfUserNumbers;
    static boolean isValid;
    public static String[] arrayOfUserInputNumbers;



    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new SortAlgorithmVisualizer.MyFrame();

    }

    /*  Sample integers to input
    * 20,600,10,620,-123,50,40,70,-80,213,223,-256,-321,40,129,52,-402,506,520,-129,632,444,666,555,22,112,333


        100,90,80,70,60,50,40,30,20,10,0,-10,-20,-30,-40,-50,-60,-70,-80,-90,-100,1,2,3,4,5,6
    * */



    //To store user input numbers into an array list
    public static void storingUserInputNumbers(){

        isValid = false;

        arrayOfUserInputNumbers = SortAlgorithmVisualizer.MyFrame.UserInputNumbers.getText().split(",");//converts the numbers of user input into the array list.

        if(arrayValidityChecker(arrayOfUserInputNumbers)){
            isValid =  true;
            arrayListOfUserNumbers = new ArrayList<Integer>();

            for (String num : arrayOfUserInputNumbers) {
                arrayListOfUserNumbers.add(Integer.parseInt(num));
            }
        }

        //This clears the text field UI when the Sort button is clicked
        SortAlgorithmVisualizer.App.clearTextInput();

    }





    //Checks if the array is valid
    public static boolean arrayValidityChecker(String[] nums) {

        boolean validArray = false;

        try {
            for (String num : nums) {
                int inputNumberApproved = Integer.parseInt(num);// change the name later
                validArray =true;
            }
        }

        catch (Exception e) {  //catches the
            validArray = false;
        }

        return validArray;
    }







    //Clears the text field after sort execution
    public static void clearTextInput() {

        SortAlgorithmVisualizer.MyFrame.UserInputNumbers.setText("");
    }






    public interface SortingAlgorithmConfiguration {

         void startSort(ArrayList<Integer> nums) throws InterruptedException;

         static void setCurrentBar(int currentBarIndex) {
            MyFrame.PaintSurface.currentBarIndex = currentBarIndex;
        }



         static void setNextBar(int nextBarIndex){
            MyFrame.PaintSurface.nextBarIndex = nextBarIndex;
        }



        void changeDelay(int delay);


        static void sleepFor(int delay) {
            long timeElapsed;
            final long startTime = System.nanoTime();

            do {
                timeElapsed = System.nanoTime() - startTime;
            } while(timeElapsed < delay);

            MyFrame.displayPanel.repaint();
        }


    }//end of SortingAlgorithmConfiguration






}
