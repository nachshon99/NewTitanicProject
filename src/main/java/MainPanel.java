import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private static int countFiles = 1;
    public static final String PATH_TO_DATA_SEARCHING_FILE = "src/main/resources/" + countFiles + ".csv";

    private JComboBox<String> passengerClassComboBox;
    private JTextField passengerIdMinTextField;
    private JTextField passengerIdMaxTextField;
    private JTextField nameTextField;
    private JComboBox<String> sexComboBox;
    private JTextField sibSpTextField;
    private JTextField parchTextField;
    private JTextField ticketTextField;
    private JTextField fareMinTextField;
    private JTextField fareMaxTextField;
    private JTextField cabinTextField;
    private JComboBox<String> embarkedComboBox;
    private JButton searchingButton;
    private JButton statisticsButton;
    private List<Passenger> passengerList;
    private ImageIcon background;
    private JLabel backgroundLabel;

    public static int maxId;
    public static int minId;
    public static String name;
    public static int sibSp;
    public static int parch;
    public static String ticket;
    public static double minFare;
    public static double maxFare;
    public static String cabin;


    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        passengerList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int i = Constants.INITIALIZE;
            while (scanner.hasNextLine()){
                String passenger = scanner.nextLine();
                if(i != Constants.INITIALIZE){
                    Passenger passengerObject = new Passenger(passenger);
                    passengerList.add(passengerObject);
                }
                i++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        this.setLayout(null);
        this.setBounds(x, y , width, height);

        //Title
        JLabel title = new JLabel("Titanic passenger Searching: ");
        title.setBounds(Constants.MIDDLE_WIDTH, Constants.MARGIN_TITLE_FROM_TOP,Constants.TITLE_WIDTH,Constants.TITLE_HEIGHT);
        title.setFont(new Font("Arial", Font.BOLD,24));
        title.setForeground(Color.CYAN);
        this.add(title);

        // Passenger class label
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y+ Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        passengerClassLabel.setForeground(Color.CYAN);
        this.add(passengerClassLabel);

        // Passenger class comboBox
        this.passengerClassComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerClassComboBox.setBounds(passengerClassLabel.getX() + passengerClassLabel.getWidth() , passengerClassLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerClassComboBox);

        //PassengerId Min Label
        JLabel passengerIdLabel = new JLabel("Passenger ID: Min");
        passengerIdLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, passengerClassComboBox.getY() + 2 * passengerClassComboBox.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        passengerIdLabel.setForeground(Color.CYAN);
        this.add(passengerIdLabel);

        //PassengerId Min TextField
        this.passengerIdMinTextField = new JTextField();
        this.passengerIdMinTextField.setBounds(passengerIdLabel.getX() + passengerIdLabel.getWidth(), passengerIdLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerIdMinTextField);

        //PassengerId Max Label
        JLabel maxIdLabel = new JLabel("Max ");
        maxIdLabel.setBounds(passengerIdMinTextField.getX() + Constants.COMBO_BOX_WIDTH, passengerClassComboBox.getY() + 2 * passengerClassComboBox.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        maxIdLabel.setForeground(Color.CYAN);
        this.add(maxIdLabel);

        //PassengerId Max TextField
        this.passengerIdMaxTextField = new JTextField();
        this.passengerIdMaxTextField.setBounds(maxIdLabel.getX() + 30, passengerIdLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerIdMaxTextField);

        //Name passenger Label
        JLabel namePassengerLabel = new JLabel("Name: ");
        namePassengerLabel.setBounds(passengerIdLabel.getX(), passengerIdLabel.getY() + 2 * passengerIdLabel.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        namePassengerLabel.setForeground(Color.CYAN);
        this.add(namePassengerLabel);

        //Name passenger TextField
        this.nameTextField = new JTextField();
        this.nameTextField.setBounds(passengerIdMinTextField.getX(), namePassengerLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.nameTextField);

        //Sex Label
        JLabel sexLabel = new JLabel("Sex: ");
        sexLabel.setBounds(passengerIdLabel.getX(), namePassengerLabel.getY() + 2 * namePassengerLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        sexLabel.setForeground(Color.CYAN);
        this.add(sexLabel);

        //sex TextField
        this.sexComboBox = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        this.sexComboBox.setBounds(nameTextField.getX(), sexLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sexComboBox);


        //SibSp Label
        JLabel sibSpLabel = new JLabel("SibSp: ");
        sibSpLabel.setBounds(passengerIdLabel.getX(),sexLabel.getY() + 2 * sexLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        sibSpLabel.setForeground(Color.CYAN);
        this.add(sibSpLabel);

        //sibSp TextField
        this.sibSpTextField = new JTextField();
        this.sibSpTextField.setBounds(passengerIdMinTextField.getX(),sibSpLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sibSpTextField);

        //Parch Label
        JLabel parchLabel = new JLabel("Parch: ");
        parchLabel.setBounds(passengerIdLabel.getX(),sibSpLabel.getY() + 2 * sibSpLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        parchLabel.setForeground(Color.CYAN);
        this.add(parchLabel);

        //Parch TextField
        this.parchTextField = new JTextField();
        this.parchTextField.setBounds(passengerIdMinTextField.getX(),parchLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.parchTextField);

        //Ticket Label
        JLabel ticketLabel = new JLabel("Ticket: ");
        ticketLabel.setBounds(passengerIdLabel.getX(),parchLabel.getY() + 2 * parchLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        ticketLabel.setForeground(Color.CYAN);
        this.add(ticketLabel);

        //Ticket TextField
        this.ticketTextField = new JTextField();
        this.ticketTextField.setBounds(passengerIdMinTextField.getX(),ticketLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.ticketTextField);

        //Fare Label
        JLabel fareLabel = new JLabel("Fare:                Min");
        fareLabel.setBounds(passengerIdLabel.getX(),ticketLabel.getY() + 2 * ticketLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        fareLabel.setForeground(Color.CYAN);
        this.add(fareLabel);

        //Fare TextField
        this.fareMinTextField = new JTextField();
        this.fareMinTextField.setBounds(passengerIdMinTextField.getX(),fareLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.fareMinTextField);

        //Fare Max Label
        JLabel maxFareLabel = new JLabel("Max ");
        maxFareLabel.setBounds(passengerIdMinTextField.getX() + Constants.COMBO_BOX_WIDTH, ticketTextField.getY() + 2 * ticketTextField.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        maxFareLabel.setForeground(Color.CYAN);
        this.add(maxFareLabel);

        //Fare Max TextField
        this.fareMaxTextField = new JTextField();
        this.fareMaxTextField.setBounds(maxFareLabel.getX() + 30, fareLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.fareMaxTextField);

        //Cabin Label
        JLabel cabinLabel = new JLabel("Cabin: ");
        cabinLabel.setBounds(passengerIdLabel.getX(),fareLabel.getY() + 2 * fareLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        cabinLabel.setForeground(Color.CYAN);
        this.add(cabinLabel);

        //Cabin TextField
        this.cabinTextField = new JTextField();
        this.cabinTextField.setBounds(passengerIdMinTextField.getX(),cabinLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.cabinTextField);

        //Embarked Label
        JLabel embarkedLabel = new JLabel("Embarked: ");
        embarkedLabel.setBounds(passengerIdLabel.getX(),cabinLabel.getY() + 2 * cabinLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        embarkedLabel.setForeground(Color.CYAN);
        this.add(embarkedLabel);

        //Embarked ComboBox
        this.embarkedComboBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedComboBox.setBounds(passengerIdMinTextField.getX(),embarkedLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.embarkedComboBox);

        //Searching Button
        this.searchingButton = new JButton("Search");
        this.searchingButton.setBounds(Constants.MIDDLE_WIDTH + 150, Constants.MIDDLE_WIDTH + 180 , Constants.WIDTH_BUTTON, Constants.HEIGHT_BUTTON);
        this.add(searchingButton);
        this.searchingButton.addActionListener((event) -> {
            List<Passenger> sortList = sortGender(this.passengerList, this.sexComboBox);
            sortList = sortPassengerId(sortList, this.passengerIdMaxTextField, this.passengerIdMinTextField);
            sortList = sortFare(sortList, this.fareMinTextField,this.fareMaxTextField);
            sortList = sortCabin(sortList, this.cabinTextField);
            sortList = sortEmbarked(sortList, this.embarkedComboBox);
            sortList = sortName(sortList,this.nameTextField);
            sortList = sortClass(sortList,this.passengerClassComboBox);
            sortList = sortSibSp(sortList, this.sibSpTextField);
            sortList = sortParch(sortList, this.parchTextField);
            sortList = sortTicket(sortList, this.ticketTextField);
            long survived = sortList.stream().filter(Passenger::isSurvived).count();
            JOptionPane.showMessageDialog(this, "Total Rows: " + sortList.size() +" (" + survived + " survived, " + (sortList.size() - survived) + " did not)");
            System.out.println("Total Rows: " + sortList.size() +" (" + survived + " survived, " + (sortList.size() - survived) + " did not)");
            try {
                File csvFile = new File("src/main/resources/" + countFiles + ".csv");
                FileWriter fileWriter = new FileWriter(csvFile);
                PrintWriter writer = new PrintWriter(fileWriter);
                for (int i = 0; i < sortList.size(); i++) {
                    String printLine = sortList.get(i).getPassengerId() +",";
                    if(sortList.get(i).getSurvived()){
                        printLine += Constants.INDEX_1 +",";
                    }else {
                        printLine += Constants.INDEX_0 +",";
                    }
                    printLine += sortList.get(i).getpClass() + "," +
                            sortList.get(i).getName() + "," +
                            sortList.get(i).getSex() + "," +
                            sortList.get(i).getAge() + "," +
                            sortList.get(i).getSibSp() + "," +
                            sortList.get(i).getParch() + "," +
                            sortList.get(i).getTicket() + "," +
                            sortList.get(i).getFare() + "," +
                            sortList.get(i).getCabin() + "," +
                            sortList.get(i).getEmbarked()
                            ;
                    writer.println(printLine);
                }
                writer.close();
                countFiles++;

            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Statistics Button
        this.statisticsButton = new JButton("Create statistics file");
        this.statisticsButton.setBounds(searchingButton.getX(), searchingButton.getY() + searchingButton.getHeight() + 50, Constants.WIDTH_BUTTON + 50, Constants.HEIGHT_BUTTON);
        this.add(statisticsButton);
        this.statisticsButton.addActionListener((event) -> {
            try {
                File output = new File(Constants.PATH_TO_STATISTICS);
                FileWriter fileWriter = new FileWriter(output);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println("By Class: ");
                printWriter.println("Class 1: " + (double)(this.passengerList.stream().filter(Passenger::isOneClass).filter(Passenger::isSurvived).count() * 100  / (this.passengerList.stream().filter(Passenger::isOneClass).count())));
                printWriter.println("Class 2: " + (double)(this.passengerList.stream().filter(Passenger::isSecondClass).filter(Passenger::isSurvived).count() * 100  / (this.passengerList.stream().filter(Passenger::isSecondClass).count())));
                printWriter.println("Class 3: " + (double)(this.passengerList.stream().filter(Passenger::isThirdClass).filter(Passenger::isSurvived).count() * 100  / (this.passengerList.stream().filter(Passenger::isThirdClass).count())));

                printWriter.println("By Sex: ");
                printWriter.println("Male: " + (double)(this.passengerList.stream().filter(Passenger::isMale).filter(Passenger::isSurvived).count() * 100) / (this.passengerList.stream().filter(Passenger::isMale).count()));
                printWriter.println("Female: " + (double)(this.passengerList.stream().filter(Passenger::isFemale).filter(Passenger::isSurvived).count() * 100) / (this.passengerList.stream().filter(Passenger::isFemale).count()));
                printWriter.println("By Age: ");
                printWriter.println("0-10: " + (double)((this.passengerList.stream().filter(Passenger::inRangeZeroToTen).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeZeroToTen).count()))));
                printWriter.println("11-20: " + (double)(this.passengerList.stream().filter(Passenger::inRangeElevenToTwenty).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeElevenToTwenty).count())));
                printWriter.println("21-30: " + (double)(this.passengerList.stream().filter(Passenger::inRangeTwentyOneToThirty).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeTwentyOneToThirty).count())));
                printWriter.println("31-40: " + (double)(this.passengerList.stream().filter(Passenger::inRangeThirtyOneToForty).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeThirtyOneToForty).count())));;
                printWriter.println("41-50: " + (double)(this.passengerList.stream().filter(Passenger::inRangeFortyOneToFifty).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeFortyOneToFifty).count())));;
                printWriter.println("51+: " + (double)(this.passengerList.stream().filter(Passenger::aboveFifthOne).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::aboveFifthOne).count())));;
                printWriter.println("By Sib and Parch: ");
                printWriter.println("Sum above one: " + (double)(this.passengerList.stream().filter(Passenger::isSumParchAndSibAtLeastOne).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::isSumParchAndSibAtLeastOne).count())));
                printWriter.println("Sum below one: " + (double)((this.passengerList).stream().filter(Passenger::isNotSumParchAndSibAtLeastOne).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::isNotSumParchAndSibAtLeastOne).count())));
                printWriter.println("By Fare: ");
                printWriter.println("0-10 pounds: " + (double)(this.passengerList.stream().filter(Passenger::isBelowTenPounds).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::isBelowTenPounds).count())));
                printWriter.println("11-30 pounds: " + (double)(this.passengerList.stream().filter(Passenger::isBelowTenPounds).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::isBelowTenPounds).count())));
                printWriter.println("30+ pounds: " + (double)((this.passengerList).stream().filter(Passenger::inRangeTwelveToThirtyPounds).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::inRangeTwelveToThirtyPounds).count())));
                printWriter.println("By Embarked: " + (double)(this.passengerList.stream().filter(Passenger::isAboveThirtyPounds).filter(Passenger::isSurvived).count() * 100 / (this.passengerList.stream().filter(Passenger::isAboveThirtyPounds).count())));
                printWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        background = new ImageIcon(this.getClass().getResource(Constants.SOURCE_JPG));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        this.add(backgroundLabel);
        this.setVisible(true);
    }

    public static List<Passenger> sortGender(List<Passenger> passengers, JComboBox comboBox) {
        int selectIndex = comboBox.getSelectedIndex();
        switch (selectIndex) {
            case Constants.INDEX_0: {
                break;
            }
            case Constants.INDEX_1: {
                return passengers.stream().filter(Passenger::isMale).collect(Collectors.toList());
            }
            case Constants.INDEX_2: {
                return passengers.stream().filter(Passenger::isFemale).collect(Collectors.toList());
            }
        }
        return passengers;
    }
    public static List<Passenger> sortPassengerId(List<Passenger> passengers, JTextField max, JTextField min) {
        if(max.getText().length() != Constants.INITIALIZE){
            MainPanel.maxId = Integer.parseInt(max.getText());
        }
        if(min.getText().length() != Constants.INITIALIZE){
            MainPanel.minId = Integer.parseInt(min.getText());
        }
        if(max.getText().length() == Constants.INITIALIZE && min.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else if(min.getText().length() != Constants.INITIALIZE && max.getText().length() == Constants.INITIALIZE){
            return passengers.stream().filter(Passenger::isAboveIdMin).collect(Collectors.toList());
        }else if(min.getText().length() == Constants.INITIALIZE && max.getText().length() != Constants.INITIALIZE){
            return passengers.stream().filter(Passenger::isBelowIdMax).collect(Collectors.toList());
        }else {
            return passengers.stream().filter(Passenger::isAboveIdMin).filter(Passenger::isBelowIdMax).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortName(List<Passenger> passengers, JTextField name){
        if(name.getText().length() == Constants.INITIALIZE){
            return passengers;
        }
        else{
            MainPanel.name = name.getText();
            return passengers.stream().filter(Passenger::isContainsName).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortClass(List<Passenger> passengers, JComboBox pClass){
        int selectIndex = pClass.getSelectedIndex();
        switch (selectIndex) {
            case Constants.INDEX_0: {
                break;
            }
            case Constants.INDEX_1: {
                return passengers.stream().filter(Passenger::isOneClass).collect(Collectors.toList());
            }
            case Constants.INDEX_2: {
                return passengers.stream().filter(Passenger::isSecondClass).collect(Collectors.toList());
            }
            case Constants.INDEX_3: {
                return passengers.stream().filter(Passenger::isThirdClass).collect(Collectors.toList());
            }
        }
        return passengers;
    }
    public static List<Passenger> sortSibSp(List<Passenger> passengers, JTextField sibSp){
        if(sibSp.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else{
            MainPanel.sibSp = Integer.valueOf(sibSp.getText());
            return passengers.stream().filter(Passenger::isEqualsSibSp).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortParch(List<Passenger> passengers, JTextField parch){
        if(parch.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
            MainPanel.parch = Integer.valueOf(parch.getText());
            return passengers.stream().filter(Passenger::isEqualsParch).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortTicket(List<Passenger> passengers, JTextField ticket){
        if(ticket.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
            MainPanel.ticket = ticket.getText();
            return passengers.stream().filter(Passenger::isContainsTicket).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortFare(List<Passenger> passengers, JTextField fareMin, JTextField fareMax){
        if(fareMax.getText().length() != Constants.INITIALIZE) {
            MainPanel.maxFare = Integer.valueOf(fareMax.getText());
        }
        if(fareMin.getText().length() != Constants.INITIALIZE){
            MainPanel.minFare = Integer.parseInt(fareMin.getText());
        }
        if(fareMin.getText().length() == Constants.INITIALIZE && fareMin.getText().length() == Constants.INITIALIZE){
            return passengers;
        }
        else if(fareMin.getText().length() != Constants.INITIALIZE && fareMax.getText().length() == Constants.INITIALIZE){
            return passengers.stream().filter(Passenger::isAboveMinFare).collect(Collectors.toList());
        }else if(fareMin.getText().length() == Constants.INITIALIZE && fareMax.getText().length() != Constants.INITIALIZE){
            return passengers.stream().filter(Passenger::isBelowMaxFare).collect(Collectors.toList());
        }else {
            return passengers.stream().filter(Passenger::isAboveMinFare).filter(Passenger::isBelowMaxFare).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortCabin(List<Passenger> passengers, JTextField cabin){
        if(cabin.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
            MainPanel.cabin = cabin.getText();
            return passengers.stream().filter(Passenger::isContainsCabin).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortEmbarked(List<Passenger> passengers, JComboBox embarked){
        int selectIndex = embarked.getSelectedIndex();
        switch (selectIndex){
            case Constants.INDEX_0: {
                break;
            }
            case Constants.INDEX_1: {
                return passengers.stream().filter(Passenger::isSelectedC).collect(Collectors.toList());
            }
            case Constants.INDEX_2: {
                return passengers.stream().filter(Passenger::isSelectedQ).collect(Collectors.toList());
            }
            case Constants.INDEX_3: {
                return passengers.stream().filter(Passenger::isSelectedS).collect(Collectors.toList());
            }
        }
        return passengers;
    }


}
