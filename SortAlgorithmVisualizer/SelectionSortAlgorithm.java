package SortAlgorithmVisualizer;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortAlgorithm implements App.SortingAlgorithmConfiguration{

    private int delay = MyFrame.delaySlider.getValue() * 100000;
    static int numberToCompare;
    static int currentNumber;
    static boolean swap;



    public void startSort(ArrayList<Integer> arrayListToBubbleSort) throws InterruptedException {

        MyFrame.backButton.setEnabled(false);
        Thread.sleep(1000);

        for (int i = 0; i < arrayListToBubbleSort.size() - 1; i++) {
            int minIndex = i;
            for (int arrayPosition = i + 1; arrayPosition < arrayListToBubbleSort.size(); arrayPosition++){
                if (arrayListToBubbleSort.get(arrayPosition)  < arrayListToBubbleSort.get(minIndex)) {

                    swap = true;

                    currentNumber = arrayListToBubbleSort.get(arrayPosition);
                    numberToCompare = arrayListToBubbleSort.get(minIndex);

                    minIndex = arrayPosition;

                    App.SortingAlgorithmConfiguration.setCurrentBar(i);
                    App.SortingAlgorithmConfiguration.setCurrentBar(arrayPosition);
                    App.SortingAlgorithmConfiguration.sleepFor(delay);
                }
            }

            swap = false;
            Collections.swap(arrayListToBubbleSort,minIndex, i);
        }

        MyFrame.backButton.setEnabled(true);
    }



    public void changeDelay(int delay) {
        this.delay = delay;
    }

}
