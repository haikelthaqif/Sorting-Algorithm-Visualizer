package SortAlgorithmVisualizer;

import java.util.ArrayList;



public class BubbleSortAlgorithm implements App.SortingAlgorithmConfiguration {


   private int delay = MyFrame.delaySlider.getValue() * 100000;

   static int numberToCompare;
   static int currentNumber;
   static boolean swap;




    public void startSort(ArrayList<Integer> arrayListToBubbleSort) throws InterruptedException {

        MyFrame.backButton.setEnabled(false);
        Thread.sleep(1000);

        for (int i = 0; i < arrayListToBubbleSort.size() - 1; i++) {

            for (int arrayPosition = 0; arrayPosition < arrayListToBubbleSort.size() - i - 1; arrayPosition++) {

                if (arrayListToBubbleSort.get(arrayPosition) > arrayListToBubbleSort.get(arrayPosition + 1)) {

                    swap = true;

                    currentNumber = arrayListToBubbleSort.get(arrayPosition);
                    numberToCompare = arrayListToBubbleSort.get(arrayPosition + 1);

                    int temporaryNumberHolder = arrayListToBubbleSort.get(arrayPosition);

                    arrayListToBubbleSort.set(arrayPosition, arrayListToBubbleSort.get(arrayPosition + 1));
                    arrayListToBubbleSort.set(arrayPosition + 1, temporaryNumberHolder);


                    App.SortingAlgorithmConfiguration.setCurrentBar(arrayPosition + 1);
                    App.SortingAlgorithmConfiguration.setNextBar(arrayPosition + 2);
                    App.SortingAlgorithmConfiguration.sleepFor(delay);

                    System.out.println(arrayListToBubbleSort);

                }
                swap = false;
            }

        }
        MyFrame.backButton.setEnabled(true);
        App.SortingAlgorithmConfiguration.setCurrentBar(0);

    }



    public void changeDelay(int delay) {
        this.delay = delay;
    }
}