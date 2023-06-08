package SortAlgorithmVisualizer;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import static Assignment2.App.arrayListOfUserNumbers;



/*
  Should handle GUI, you can also create other class for GUI to clean up the code.
  Explain your design choice.
*/

public class MyFrame extends JPanel {

    //Declaring JFrame
    JFrame sortingAnimationFrame = new JFrame("Sorting Algorithm Visualiser");

    //Declaring all JPanels
    JPanel primaryPanel = new JPanel();
    JPanel selectionPanel = new JPanel();
    JPanel BubbleSortPanel = new JPanel(new FlowLayout());
    JPanel SelectionSortPanel = new JPanel(new FlowLayout());
    JPanel MergeSortPanel = new JPanel(new FlowLayout());
    JPanel BubbleLogoPanel = new JPanel();
    JPanel SelectionLogoPanel = new JPanel();
    JPanel MergeLogoPanel = new JPanel();
    JPanel instructionsPanel = new JPanel(new FlowLayout());
    JPanel UserNumberInputPanel = new JPanel(new FlowLayout());
    JPanel outputPanel = new JPanel(new FlowLayout());
    JPanel visualizerPanel = new JPanel();
    public static JPanel displayPanel;

    //Declaring all JLabels
    JLabel description;
    JLabel BubbleLogo = new JLabel("Bubble Sort Program");
    JLabel SelectionLogo = new JLabel("Selection Sort Program");
    JLabel MergeLogo = new JLabel("Merge Sort Program");
    JLabel instructions;
    JLabel outputNumbersArray;
    JLabel EnterArrayOfNumbers = new JLabel("Enter Numbers: ");


    public static JTextField UserInputNumbers = new JTextField(19);

    static JButton sortButton = new JButton("Sort");
    static JButton backButton = new JButton("Back");

    static JSlider delaySlider;

    Border whiteBorder = BorderFactory.createLineBorder(Color.white);

    ArrayList<Integer> array = new ArrayList<Integer>();

    static boolean userInBubbleSortPage = false;
    static boolean userInSelectionSortPage = false;
    static boolean userInMergeSortPage = false;
    private static App.SortingAlgorithmConfiguration algorithm;



    //initalization
    public MyFrame() {
        sortingAnimationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sortingAnimationFrame.setSize(800, 800);

        primaryPanel.setPreferredSize(new Dimension(800, 800));


        //initializing the CardLayouts for individual sorting program panels
        MainMenuScreen();
        primaryPanel.add(selectionPanel);

        instructions();
        initializeDelaySlider();
        output();
        UserNumbersPanel();
        displayPanel = new PaintSurface();
        visualizerPanel();


        sortingAnimationFrame.add(primaryPanel);
        sortingAnimationFrame.pack();
        sortingAnimationFrame.setVisible(true);
        sortingAnimationFrame.setResizable(false);
    } //end of initialization





    // All the GUI components for the Main Menu
    public void MainMenuScreen(){

        selectionPanel.setPreferredSize(new Dimension(800, 800));
        selectionPanel.setBackground(new Color(0x7e7e7e));


        description = new JLabel("Select the following");
        description.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        description.setPreferredSize(new Dimension(500,300));
        description.setForeground(Color.white);
        description.setHorizontalAlignment(JLabel.CENTER);
        selectionPanel.add(description);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 300));
        buttonPanel.setLayout(new GridLayout(3, 1,10,20));
        buttonPanel.setBackground(new Color(0x7e7e7e));


        JButton BubbleSortButton = new JButton("Bubble Sort");
        BubbleSortButton.addActionListener(new SortAlgorithmVisualizer.MyFrame.BubbleSortButtonListener());

        JButton SelectionSortButton = new JButton("Selection Sort");
        SelectionSortButton.addActionListener(new SortAlgorithmVisualizer.MyFrame.SelectionSortButtonListener());

        JButton MergeSortButton = new JButton("Merge Sort");
        MergeSortButton.addActionListener(new SortAlgorithmVisualizer.MyFrame.MergeSortButtonListener());


        buttonPanel.add(BubbleSortButton);
        buttonPanel.add(SelectionSortButton);
        buttonPanel.add(MergeSortButton);
        selectionPanel.add(buttonPanel);

    }






    // All the GUI components for the Bubble Sort Panel
    public void BubbleSortProgram(){

        //to declare that the user is in the Bubble Sorting Panel
        userInBubbleSortPage = true;
        userInSelectionSortPage = false;
        userInMergeSortPage = false;

        BubbleSortPanel.setPreferredSize(new Dimension(800, 800));
        BubbleSortPanel.setBackground(new Color(0x7e7e7e));

        //Logo GUI for Bubble Sort Program
        BubbleLogoPanel.setPreferredSize(new Dimension(800,40));
        BubbleLogoPanel.setBackground(new Color(0x7e7e7e));
        BubbleLogo.setFont(new Font("", Font.BOLD,20));
        BubbleLogo.setForeground(Color.white);
        BubbleLogo.setHorizontalAlignment(JLabel.CENTER);
        BubbleLogo.setBorder(whiteBorder);
        BubbleLogoPanel.add(BubbleLogo);
        BubbleSortPanel.add(BubbleLogoPanel);



        BubbleSortPanel.add(instructionsPanel);
        BubbleSortPanel.add(UserNumberInputPanel);
        BubbleSortPanel.add(visualizerPanel);
    }


    public class BubbleSortButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            primaryPanel.removeAll();
            BubbleSortProgram();
            primaryPanel.add(BubbleSortPanel);
            primaryPanel.repaint();
            primaryPanel.revalidate();
        }
    }






    // All the GUI components for the Selection Sort Panel
    public void SelectionSortProgram(){
        //to declare that the user is in the Bubble Sorting Panel
        userInBubbleSortPage = false;
        userInSelectionSortPage = true;
        userInMergeSortPage = false;

        SelectionSortPanel.setPreferredSize(new Dimension(800, 800));
        SelectionSortPanel.setBackground(new Color(0x7e7e7e));

        //Logo GUI for Selection Sort Program
        SelectionLogoPanel.setPreferredSize(new Dimension(800,40));
        SelectionLogoPanel.setBackground(new Color(0x7e7e7e));
        SelectionLogo.setFont(new Font("", Font.BOLD,20));
        SelectionLogo.setForeground(Color.white);
        SelectionLogo.setHorizontalAlignment(JLabel.CENTER);
        SelectionLogo.setBorder(whiteBorder);
        SelectionLogoPanel.add(SelectionLogo);
        SelectionSortPanel.add(SelectionLogoPanel);



        SelectionSortPanel.add(instructionsPanel);
        SelectionSortPanel.add(UserNumberInputPanel);
        SelectionSortPanel.add(visualizerPanel);

    }

    public class SelectionSortButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            primaryPanel.removeAll();
            SelectionSortProgram();
            primaryPanel.add(SelectionSortPanel);
            primaryPanel.repaint();
            primaryPanel.revalidate();

        }
    }





    // All the GUI components for the Merge Sort Panel
    public void MergeSortProgram(){
        //to declare that the user is in the Bubble Sorting Panel
        userInBubbleSortPage = false;
        userInSelectionSortPage = false;
        userInMergeSortPage = true;

        MergeSortPanel.setPreferredSize(new Dimension(800, 800));
        MergeSortPanel.setBackground(new Color(0x7e7e7e));

        //Logo GUI for Selection Sort Program
        MergeLogoPanel.setPreferredSize(new Dimension(800,40));
        MergeLogoPanel.setBackground(new Color(0x7e7e7e));
        MergeLogo.setFont(new Font("", Font.BOLD,20));
        MergeLogo.setForeground(Color.white);
        MergeLogo.setHorizontalAlignment(JLabel.CENTER);
        MergeLogo.setBorder(whiteBorder);
        MergeLogoPanel.add(MergeLogo);
        MergeSortPanel.add(MergeLogoPanel);


        MergeSortPanel.add(instructionsPanel);
        MergeSortPanel.add(UserNumberInputPanel);
        MergeSortPanel.add(visualizerPanel);

    }

    public class MergeSortButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            primaryPanel.removeAll();
            MergeSortProgram();
            primaryPanel.add(MergeSortPanel);
            primaryPanel.repaint();
            primaryPanel.revalidate();

        }
    }






    //when the 'Sort' button is clicked
    public class SortButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            SortAlgorithmVisualizer.App.storingUserInputNumbers();

            if(SortAlgorithmVisualizer.App.isValid){
                outputNumbersArray.setText("Numbers to be sorted: "+ App.arrayListOfUserNumbers);


                // user select Bubble Sort Program
                if(userInBubbleSortPage){
                    System.out.println("in bubble sort page");

                    // array =  App.bubbleSortAlgorithm(App.arrayListOfUserNumbers);
                    visualizerPanel.add(displayPanel);
                    algorithm = new BubbleSortAlgorithm();

                    new Thread(()
                            -> {
                        try {
                            algorithm.startSort(App.arrayListOfUserNumbers);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    displayPanel.repaint();

                } //end of user select Bubble Sort Program




                // user select Selection Sort Program
                if(userInSelectionSortPage){
                    System.out.println("in selection sort page");

                    visualizerPanel.add(displayPanel);
                    algorithm = new SelectionSortAlgorithm();

                    new Thread(()
                            -> {
                        try {
                            algorithm.startSort(App.arrayListOfUserNumbers);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    displayPanel.repaint();
                }



                // user Merge Sort Program
                if(userInMergeSortPage){
                    System.out.println("in merge sort page");

                    visualizerPanel.add(displayPanel);
                    algorithm = new MergeSortAlgorithm();

                    new Thread(()
                            -> {
                        try {
                            algorithm.startSort(App.arrayListOfUserNumbers);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    displayPanel.repaint();

                }


            }

            else outputNumbersArray.setText("Numbers to be sorted: Invalid input! Please enter numbers only.");
            System.out.println(array);
            array.clear();
        }
    } //end of sortButtonListener







    //goes back to the selection main menu
    public class backButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            outputNumbersArray.setText("Numbers to be sorted: "); //resets the label when the back button is clicked.

            displayPanel.removeAll();
            visualizerPanel.removeAll();
            primaryPanel.removeAll();
            primaryPanel.add(selectionPanel);
            primaryPanel.repaint();
            primaryPanel.revalidate();
        }
    }







    //initialize and prints out the instructions on a JLabel
    public void instructions(){

        instructions = new JLabel("Instructions: Only input at most 40 integers ranging from -100 to 100. Add (,) after every number except the last Example: 13,100,9,-2,-100 "  );
        instructionsPanel.setPreferredSize(new Dimension(800, 40));
        instructionsPanel.add(instructions);

    }


    private static void initializeDelaySlider() {
        delaySlider = new JSlider(JSlider.HORIZONTAL, 0, 10000, 10000 / 2);
        delaySlider.setMajorTickSpacing(3000);
        delaySlider.setMinorTickSpacing(10);
        delaySlider.setPaintLabels(true);
        delaySlider.setSnapToTicks(true);
        delaySlider.setBackground(Color.LIGHT_GRAY);

        delaySlider.addChangeListener((ChangeEvent event) -> {
            if(algorithm != null)
                algorithm.changeDelay(delaySlider.getValue() * 100000);

            displayPanel.validate();
            displayPanel.repaint();

        });
    }



    //outputs the array to be sorted on a JLabel
    public void output(){
        outputPanel.setPreferredSize(new Dimension(800, 20));
        outputPanel.setBackground(Color.yellow);
        outputNumbersArray= new JLabel("Numbers to be sorted: ");
        outputPanel.add(outputNumbersArray);
        UserNumberInputPanel.add(outputPanel);
    }




    //initializing the user interaction panels and
    public void UserNumbersPanel(){

        UserNumberInputPanel.setPreferredSize(new Dimension(800,65));
        UserNumberInputPanel.add(EnterArrayOfNumbers);
        UserNumberInputPanel.add(UserInputNumbers);
        UserNumberInputPanel.add(sortButton);
        sortButton.addActionListener(new SortAlgorithmVisualizer.MyFrame.SortButtonListener());
        UserNumberInputPanel.add(backButton);
        backButton.addActionListener(new SortAlgorithmVisualizer.MyFrame.backButtonListener());
        UserNumberInputPanel.add(delaySlider);
    }



    //to initialize the panels for animation
    public void visualizerPanel(){
        visualizerPanel.setPreferredSize(new Dimension(800,645));
        visualizerPanel.setLayout(new BorderLayout());
        visualizerPanel.setBackground(Color.black);

    }




    //sourcecode for painting the animation component for Sort Algorithms.
    public static class PaintSurface extends JPanel {


        static int currentBarIndex = 0;
         static int nextBarIndex = 0;

        public PaintSurface() {
            this.setPreferredSize(new Dimension(800, 645));

            this.setBackground(Color.GRAY);
        }


        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            super.paintComponent(graphics);

            ArrayList<Integer> arrayListToSort = App.arrayListOfUserNumbers;

            double x = 0;
            double width = (double) 800 / arrayListToSort.size();


            for(int i = 0; i < arrayListToSort.size(); i++) {

                String strnumber = String.valueOf(arrayListToSort.get(i));
                int number = arrayListToSort.get(i);


                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("Monospaced", Font.BOLD, 18));


                //to print the commentary of the BubbleSort steps
                if(userInBubbleSortPage){
                    graphics.drawString("Legend: "  , 10, 20); graphics.drawString("Legend: "  , 10, 20);
                    graphics.drawString("Current Number: " +  BubbleSortAlgorithm.currentNumber + " ->  Number comparing with: " + BubbleSortAlgorithm.numberToCompare, 10, 45);
                    graphics.drawString("Swap numbers? :"  + BubbleSortAlgorithm.swap , 10, 70);
                }

                //to print the commentary of the SelectionSort steps
                if(userInSelectionSortPage){
                    graphics.drawString("Legend: " , 10, 20);
                    graphics.drawString("Current Number: " +  SelectionSortAlgorithm.currentNumber + " ->  Number comparing with: " + SelectionSortAlgorithm.numberToCompare, 10, 45);
                    graphics.drawString("Swap numbers? :"  + SelectionSortAlgorithm.swap , 10, 70);
                }


                //to print the commentary of the mergeSort steps
                if(userInMergeSortPage){

                }





                //if number is s negative
                if(arrayListToSort.get(i) < 0){
                    if(currentBarIndex == i)
                        graphics.setPaint(Color.RED);


                    else
                        graphics.setPaint(Color.BLUE);

                    graphics.fillRect((int) x,  600 + arrayListToSort.get(i)*5, (int) width + 1, (arrayListToSort.get(i)*(-1))*5);
                    graphics.setFont(new Font("Monospaced", Font.BOLD, 14));
                    graphics.drawString(strnumber, ((int) x + (int) width/2)-13, 590 + arrayListToSort.get(i)*5);
                    graphics.setColor(Color.white);
                    graphics.drawRect((int) x, 600 + arrayListToSort.get(i)*5, (int) width + 1, arrayListToSort.get(i)*(-1)*5);

                }


                //if number is a positive
                else {
                    if(currentBarIndex == i)
                        graphics.setPaint(Color.RED);


                    else
                        graphics.setPaint(Color.BLACK);

                    graphics.fillRect((int) x, 600 - arrayListToSort.get(i)*5, (int) width + 1, arrayListToSort.get(i)*5);
                    graphics.setFont(new Font("Monospaced", Font.BOLD, 14));
                    graphics.drawString(strnumber, ((int) x + (int) width/2)-10, 590 - arrayListToSort.get(i)*5);
                    graphics.setColor(Color.white);
                    graphics.drawRect((int) x, 600 - arrayListToSort.get(i)*5, (int) width + 1, arrayListToSort.get(i)*5);

                }
                x += width;
            }

            graphics.dispose();
            g.dispose();
        }
    } //end of paint()



}// end of MyFrame

