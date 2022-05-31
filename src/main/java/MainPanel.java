import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private JComboBox<String> passengerClassComboBox;
    private JTextField passengerIdTextField;
    private JTextField nameTextField;
    private JComboBox<String> sexComboBox;
    private JTextField sibSpTextField;
    private JTextField parchTextField;
    private JTextField ticketTextField;
    private JTextField fareTextField;
    private JTextField cabinTextField;
    private JTextField embarkedTextField;
    private JButton searchingButton;
    private List<Passenger> passengerList = new ArrayList<>();


    public MainPanel (int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y , width, height);

        //read file into list
        passengerList = readFile();

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

        //PassengerId Label
        JLabel passengerIdLabel = new JLabel("Passenger ID: ");
        passengerIdLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, passengerClassComboBox.getY() + 2 * passengerClassComboBox.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(passengerIdLabel);

        //PassengerId TextField
        this.passengerIdTextField = new JTextField();
        this.passengerIdTextField.setBounds(passengerIdLabel.getX() + passengerIdLabel.getWidth(), passengerIdLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerIdTextField);

        //Name passenger Label
        JLabel namePassengerLabel = new JLabel("Name: ");
        namePassengerLabel.setBounds(passengerIdLabel.getX(), passengerIdLabel.getY() + 2 * passengerIdLabel.getHeight(), Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.add(namePassengerLabel);

        //Name passenger TextField
        this.nameTextField = new JTextField();
        this.nameTextField.setBounds(passengerIdTextField.getX(), namePassengerLabel.getY(), Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
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
        this.sibSpTextField.setBounds(passengerIdTextField.getX(),sibSpLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sibSpTextField);

        //Parch Label
        JLabel parchLabel = new JLabel("Parch: ");
        parchLabel.setBounds(passengerIdLabel.getX(),sibSpLabel.getY() + 2 * sibSpLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(parchLabel);

        //Parch TextField
        this.parchTextField = new JTextField();
        this.parchTextField.setBounds(passengerIdTextField.getX(),parchLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.parchTextField);

        //Ticket Label
        JLabel ticketLabel = new JLabel("Ticket: ");
        ticketLabel.setBounds(passengerIdLabel.getX(),parchLabel.getY() + 2 * parchLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(ticketLabel);

        //Ticket TextField
        this.ticketTextField = new JTextField();
        this.ticketTextField.setBounds(passengerIdTextField.getX(),ticketLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.ticketTextField);

        //Fare Label
        JLabel fareLabel = new JLabel("Fare: ");
        fareLabel.setBounds(passengerIdLabel.getX(),ticketLabel.getY() + 2 * ticketLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(fareLabel);

        //Fare TextField
        this.fareTextField = new JTextField();
        this.fareTextField.setBounds(passengerIdTextField.getX(),fareLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.fareTextField);

        //Cabin Label
        JLabel cabinLabel = new JLabel("Cabin: ");
        cabinLabel.setBounds(passengerIdLabel.getX(),fareLabel.getY() + 2 * fareLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(cabinLabel);

        //Cabin TextField
        this.cabinTextField = new JTextField();
        this.cabinTextField.setBounds(passengerIdTextField.getX(),cabinLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.cabinTextField);

        //Ticket Label
        JLabel embarkedLabel = new JLabel("Embarked: ");
        embarkedLabel.setBounds(passengerIdLabel.getX(),cabinLabel.getY() + 2 * cabinLabel.getHeight(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(embarkedLabel);

        //Ticket TextField
        this.embarkedTextField = new JTextField();
        this.embarkedTextField.setBounds(passengerIdTextField.getX(),embarkedLabel.getY() , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.embarkedTextField);

        //************

        //Searching Button
        this.searchingButton = new JButton("Search");
        this.searchingButton.setBounds(Constants.MIDDLE_WIDTH + 150, Constants.MIDDLE_WIDTH + 220 , Constants.WIDTH_BUTTON, Constants.HEIGHT_BUTTON);
        this.add(searchingButton);
    }

    public static List<Passenger>  readFile(){
        List<Passenger> passengerList = new ArrayList<>();
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                int passengerId = Constants.INITIALIZE;
                int survived = Constants.INITIALIZE;
                int pClass = Constants.INITIALIZE;
                String name = "";
                String sex = "";
                int age = Constants.INITIALIZE;
                int sibSp = Constants.INITIALIZE;
                int parch = Constants.INITIALIZE;
                String ticket = "";
                double fare = Constants.INITIALIZE;
                String cabin = "";
                String embarked = "";
                if(Character.isDigit(line.charAt(0))) {
                    String [] elements = line.split(",");
                    for (int i = 0; i < elements.length; i++){
                        switch (i){
                            case Constants.INDEX_0: {
                                passengerId = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_1: {
                                survived = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_2: {
                                pClass = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_3: {
                            }
                            case Constants.INDEX_4: {
                                name += elements[i];
                                break;
                            }
                            case Constants.INDEX_5: {
                                sex = elements[i];
                                break;
                            }
                            case Constants.INDEX_6: {
                                age = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_7: {
                                sibSp = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_8: {
                                parch = parse(i,elements);
                                break;
                            }
                            case Constants.INDEX_9: {
                                ticket = elements[i];
                                break;
                            }
                            case Constants.INDEX_10: {
                                fare = Double.parseDouble(elements[i]);
                                break;
                            }
                            case Constants.INDEX_11: {
                                cabin = elements[i];
                                break;
                            }
                            case Constants.INDEX_12: {
                                embarked = elements[i];
                                break;
                            }
                        }

                    }
                    Passenger passenger = new Passenger(passengerId,survived,pClass,name,sex,age,sibSp,parch,ticket,fare,cabin,embarked);
                    passengerList.add(passenger);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return passengerList;
    }


    public static int parse(int i, String [] elements){
        int result = 0;
        try {
            result = Integer.parseInt(elements[i]);
        }catch (NumberFormatException e){
        }
        return result;
    }

    public static List<Passenger> sortGender(List<Passenger> passengers, JComboBox comboBox) {
        int item = comboBox.getSelectedIndex();
        switch (item) {
            case 0: {
                return passengers;
            }
            case 1: {
            }
            case 2: {
                //return passengers.stream().filter(Passenger::getSexMale).collect(Collectors.toList());
            }
        }
        return passengers;
    }


}
