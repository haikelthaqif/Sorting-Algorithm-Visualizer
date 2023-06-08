package SortAlgorithmVisualizer;

import java.util.ArrayList;

public class MergeSortAlgorithm implements App.SortingAlgorithmConfiguration {

    private int delay = MyFrame.delaySlider.getValue() * 100000;
    static int numberToCompare;
    static int currentNumber;
    static boolean swap;



    @Override
    public void startSort(ArrayList<Integer> arrayListToBubbleSort) throws InterruptedException {
        sort(arrayListToBubbleSort, 0, arrayListToBubbleSort.size() - 1);
    }

    private void merge(ArrayList<Integer> arrayListToBubbleSort, int left, int middleSection, int right) throws InterruptedException {

        MyFrame.backButton.setEnabled(false);
        Thread.sleep(1000);

        int leftSide = middleSection - left + 1;
        int rightSide = right - middleSection;

        int[] Left = new int[leftSide];
        int[] Right = new int[rightSide];

        for(int i = 0; i < leftSide; ++i)
            Left[i] = arrayListToBubbleSort.get(left + i);


        for(int j = 0; j < rightSide; ++j)
            Right[j] = arrayListToBubbleSort.get(middleSection + 1 + j);


        int a = 0, b = 0;

        int temp = left;
        while (a < leftSide && b < rightSide) {
            if (Left[a] <= Right[b]) {

                arrayListToBubbleSort.set(temp, Left[a]);
                a++;

                App.SortingAlgorithmConfiguration.setCurrentBar(b);
                App.SortingAlgorithmConfiguration.sleepFor(delay);

            } else {

                arrayListToBubbleSort.set(temp, Right[b]);
                b++;

                App.SortingAlgorithmConfiguration.setCurrentBar(b);
                App.SortingAlgorithmConfiguration.sleepFor(delay);
            }
            temp++;
        }

        while (a < leftSide) {

            arrayListToBubbleSort.set(temp, Left[a]);
            a++;
            temp++;

            App.SortingAlgorithmConfiguration.setCurrentBar(b);
            App.SortingAlgorithmConfiguration.sleepFor(delay);
        }

        while (b < rightSide) {

            arrayListToBubbleSort.set(temp, Right[b]);
            b++;
            temp++;

            App.SortingAlgorithmConfiguration.setCurrentBar(b);
            App.SortingAlgorithmConfiguration.sleepFor(delay);
        }
        MyFrame.backButton.setEnabled(true);
    }

    private void sort(ArrayList<Integer> arrayListToBubbleSort, int left, int right) throws InterruptedException {
        if (left < right) {
            int m = (left + right) / 2;

            sort(arrayListToBubbleSort, left, m);
            sort(arrayListToBubbleSort, m + 1, right);

            merge(arrayListToBubbleSort, left, m, right);
        }
    }



    public void changeDelay(int delay) {
        this.delay = delay;
    }

}
