import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
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

    public static int maxId;
    public static int minId;
    public static String name;
    public static int sibSp;
    public static int parch;
    public static String ticket;
    public static double minFare;
    public static double maxFare;
    public static String cabin;
    public static String embarked;


    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        passengerList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()){
                String passenger = scanner.nextLine();
                if(i != 0){
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
        this.add(title);

        // Passenger class label
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y+ Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(passengerClassLabel);

        // Passenger class comboBox
        this.passengerClassComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerClassComboBox.setBounds(passengerClassLabel.getX() + passengerClassLabel.getWidth() , passengerClassLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerClassComboBox);
        this.passengerClassComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

        //PassengerId Min Label
        JLabel passengerIdLabel = new JLabel("Passenger ID: Min");
        passengerIdLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, passengerClassComboBox.getY() + 2 * passengerClassComboBox.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(passengerIdLabel);
        //PassengerId Label

        //PassengerId Min TextField
        this.passengerIdMinTextField = new JTextField();
        this.passengerIdMinTextField.setBounds(passengerIdLabel.getX() + passengerIdLabel.getWidth(), passengerIdLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerIdMinTextField);

        //PassengerId Max Label
        JLabel maxIdLabel = new JLabel("Max ");
        maxIdLabel.setBounds(passengerIdMinTextField.getX() + Constants.COMBO_BOX_WIDTH, passengerClassComboBox.getY() + 2 * passengerClassComboBox.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(maxIdLabel);

        //PassengerId Max TextField
        this.passengerIdMaxTextField = new JTextField();
        this.passengerIdMaxTextField.setBounds(maxIdLabel.getX() + 30, passengerIdLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerIdMaxTextField);

        //Name passenger Label
        JLabel namePassengerLabel = new JLabel("Name: ");
        namePassengerLabel.setBounds(passengerIdLabel.getX(), passengerIdLabel.getY() + 2 * passengerIdLabel.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(namePassengerLabel);

        //Name passenger TextField
        this.nameTextField = new JTextField();
        this.nameTextField.setBounds(passengerIdMinTextField.getX(), namePassengerLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.nameTextField);

        //Sex Label
        JLabel sexLabel = new JLabel("Sex: ");
        sexLabel.setBounds(passengerIdLabel.getX(), namePassengerLabel.getY() + 2 * namePassengerLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(sexLabel);

        //sex TextField
        this.sexComboBox = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        this.sexComboBox.setBounds(nameTextField.getX(), sexLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sexComboBox);
        this.sexComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

        //SibSp Label
        JLabel sibSpLabel = new JLabel("SibSp: ");
        sibSpLabel.setBounds(passengerIdLabel.getX(),sexLabel.getY() + 2 * sexLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(sibSpLabel);

        //sibSp TextField
        this.sibSpTextField = new JTextField();
        this.sibSpTextField.setBounds(passengerIdMinTextField.getX(),sibSpLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sibSpTextField);

        //Parch Label
        JLabel parchLabel = new JLabel("Parch: ");
        parchLabel.setBounds(passengerIdLabel.getX(),sibSpLabel.getY() + 2 * sibSpLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(parchLabel);

        //Parch TextField
        this.parchTextField = new JTextField();
        this.parchTextField.setBounds(passengerIdMinTextField.getX(),parchLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.parchTextField);

        //Ticket Label
        JLabel ticketLabel = new JLabel("Ticket: ");
        ticketLabel.setBounds(passengerIdLabel.getX(),parchLabel.getY() + 2 * parchLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(ticketLabel);

        //Ticket TextField
        this.ticketTextField = new JTextField();
        this.ticketTextField.setBounds(passengerIdMinTextField.getX(),ticketLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.ticketTextField);

        //Fare Label
        JLabel fareLabel = new JLabel("Fare:                Min");
        fareLabel.setBounds(passengerIdLabel.getX(),ticketLabel.getY() + 2 * ticketLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(fareLabel);

        //Fare TextField
        this.fareMinTextField = new JTextField();
        this.fareMinTextField.setBounds(passengerIdMinTextField.getX(),fareLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.fareMinTextField);

        //Fare Max Label
        JLabel maxFareLabel = new JLabel("Max ");
        maxFareLabel.setBounds(passengerIdMinTextField.getX() + Constants.COMBO_BOX_WIDTH, ticketTextField.getY() + 2 * ticketTextField.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(maxFareLabel);

        //Fare Max TextField
        this.fareMaxTextField = new JTextField();
        this.fareMaxTextField.setBounds(maxFareLabel.getX() + 30, fareLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.fareMaxTextField);

        //Cabin Label
        JLabel cabinLabel = new JLabel("Cabin: ");
        cabinLabel.setBounds(passengerIdLabel.getX(),fareLabel.getY() + 2 * fareLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(cabinLabel);

        //Cabin TextField
        this.cabinTextField = new JTextField();
        this.cabinTextField.setBounds(passengerIdMinTextField.getX(),cabinLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.cabinTextField);

        //Embarked Label
        JLabel embarkedLabel = new JLabel("Embarked: ");
        embarkedLabel.setBounds(passengerIdLabel.getX(),cabinLabel.getY() + 2 * cabinLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(embarkedLabel);

        //Embarked ComboBox
        this.embarkedComboBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedComboBox.setBounds(passengerIdMinTextField.getX(),embarkedLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.embarkedComboBox);

        //************

        //Searching Button
        this.searchingButton = new JButton("Search");
        this.searchingButton.setBounds(Constants.MIDDLE_WIDTH + 150, Constants.MIDDLE_WIDTH + 180 , Constants.WIDTH_BUTTON, Constants.HEIGHT_BUTTON);
        this.add(searchingButton);
        this.searchingButton.addActionListener((event) -> {

            List<Passenger> sortGenderList = sortGender(this.passengerList, this.sexComboBox);
            sortGenderList = sortPassengerId(this.passengerList, this.passengerIdMaxTextField, this.passengerIdMinTextField);
            sortGenderList = sortFare(this.passengerList, this.fareMinTextField,this.fareMaxTextField);
            sortGenderList = sortCabin(this.passengerList, this.cabinTextField);
            sortGenderList = sortEmbarked(this.passengerList, this.embarkedComboBox);
            //List<Passenger> sortGenderList = sortName(this.passengerList,this.nameTextField);
            //List<Passenger> sortGenderList = sortClass(this.passengerList,this.passengerClassComboBox);
            //sortGenderList = sortSibSp(this.passengerList, this.sibSpTextField);
            //sortGenderList = sortParch(this.passengerList, this.parchTextField);
            //sortGenderList = sortTicket(this.passengerList, this.ticketTextField);
            long survived = sortGenderList.stream().filter(Passenger::isSurvived).count();
            System.out.println("Total Rows: " + sortGenderList.size() +" (" + survived + " survived, " + (sortGenderList.size() - survived) + " did not)");
        });

        //Statistics Button
        this.statisticsButton = new JButton("Create statistics file");
        this.statisticsButton.setBounds(searchingButton.getX(), searchingButton.getY() + searchingButton.getHeight() + 50, Constants.WIDTH_BUTTON + 50, Constants.HEIGHT_BUTTON);
        this.add(statisticsButton);
        this.statisticsButton.addActionListener((event) -> {
            try {
                File output = new File("src/main/resources/Statistic.txt");
                FileWriter fileWriter = new FileWriter(output);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println("By Class: ");
                printWriter.println("By Sex: ");
                printWriter.println("By Age: ");
                printWriter.println("By Sib and Parch: ");
                printWriter.println("By Fare: ");
                printWriter.println("By Embarked: ");
                printWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
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
        MainPanel.name = name.getText();
        if(name.getText().length() == Constants.INITIALIZE){
            return passengers;
        }
        else{
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
        MainPanel.sibSp = Integer.valueOf(sibSp.getText());
        if(sibSp.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else{
            return passengers.stream().filter(Passenger::isEqualsSibSp).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortParch(List<Passenger> passengers, JTextField parch){
        MainPanel.parch = Integer.valueOf(parch.getText());
        if(parch.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
            return passengers.stream().filter(Passenger::isEqualsParch).collect(Collectors.toList());
        }
    }
    public static List<Passenger> sortTicket(List<Passenger> passengers, JTextField ticket){
        MainPanel.ticket = ticket.getText();
        if(ticket.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
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
        MainPanel.cabin = cabin.getText();
        if(cabin.getText().length() == Constants.INITIALIZE){
            return passengers;
        }else {
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
