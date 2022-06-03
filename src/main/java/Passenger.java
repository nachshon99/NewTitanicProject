public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    public Passenger(String lineData) {
        String[] dataItem = lineData.split(",");
        this.passengerId = Integer.valueOf(dataItem[0]);
        if(dataItem[1].equals("0")){
            this.survived = false;
        }else {
            this.survived = true;
        }
        this.pClass = Integer.valueOf(dataItem[2]);
        this.name = getFormattedName(dataItem[3] + dataItem[4]);
        this.sex = dataItem[5];
        if(dataItem[6].length() != Constants.INITIALIZE) {
            this.age = Double.valueOf(dataItem[6]);
        }
        if(dataItem[7].length() != Constants.INITIALIZE) {
            this.sibSp = Integer.valueOf(dataItem[7]);
        }
        if(dataItem[8].length() != Constants.INITIALIZE) {
            this.parch = Integer.valueOf(dataItem[8]);
        }
        this.ticket = dataItem[9];
        if(dataItem[10].length() != Constants.INITIALIZE) {
            this.fare = Double.valueOf(dataItem[10]);
        }
        this.cabin = dataItem[11];
        if(dataItem.length > 12){
            this.embarked = dataItem[12];
        }
    }

    public boolean isMale(){
        boolean male = false;
        if(this.sex.equals("male")){
            male = true;
        }
        return male;
    }
    public boolean isFemale(){
        boolean female = false;
        if(this.sex.equals("female")){
            female = true;
        }
        return female;
    }
    public boolean isAboveIdMin(){
        boolean aboveMin = false;
        try{
            int minId = MainPanel.minId;
            if(minId > 0 && this.passengerId >= minId){
                aboveMin = true;
            }
        }catch (NumberFormatException e){
        }
        return aboveMin;
    }
    public boolean isBelowIdMax(){
        boolean aboveMin = false;
        try {
            int maxId = MainPanel.maxId;
            if(maxId < 891 && this.passengerId <= maxId){
                aboveMin = true;
            }
        }catch (NumberFormatException e){
        }
        return aboveMin;
    }
    public boolean isContainsName(){
        boolean contains = false;
        boolean isValid = false;
        if(MainPanel.name.length() != Constants.INITIALIZE){
            for (int i = 0; i < MainPanel.name.length(); i++) {
                if(Character.isAlphabetic(MainPanel.name.charAt(i))){
                    isValid = true;
                }else {
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                if(this.getName().contains(MainPanel.name)){
                    contains = true;
                }
            }
        }
        return contains;
    }
    public boolean isOneClass(){
        boolean oneClass = false;
        if(this.pClass == Constants.INDEX_1){
            oneClass = true;
        }
        return oneClass;
    }
    public boolean isSecondClass(){
        boolean secondClass = false;
        if(this.pClass == Constants.INDEX_2){
            secondClass = true;
        }
        return secondClass;
    }
    public boolean isThirdClass(){
        boolean thirdClass = false;
        if(this.pClass == Constants.INDEX_3){
            thirdClass = true;
        }
        return thirdClass;
    }
    public boolean isEqualsSibSp(){
        boolean equals = false;
        if(this.sibSp == MainPanel.sibSp){
            equals = true;
        }
        return equals;
    }
    public boolean isEqualsParch(){
        boolean equals = false;
        if (this.parch == MainPanel.parch){
            equals = true;
        }
        return equals;
    }
    public boolean isContainsTicket(){
        boolean contains = false;
        if(this.ticket.contains(MainPanel.ticket)){
            contains = true;
        }
        return contains;
    }
    public boolean isAboveMinFare(){
        boolean aboveMin = false;
        double minFare = MainPanel.minFare;
        if(minFare > 0 && this.fare >= minFare){
            aboveMin = true;
        }
        return aboveMin;
    }
    public boolean isBelowMaxFare(){
        boolean belowMax = false;
        double maxFare = MainPanel.maxFare;
        if(this.fare <= maxFare){
            belowMax = true;
        }
        return belowMax;
    }
    public boolean isContainsCabin(){
        boolean contains = false;
        if(MainPanel.cabin.length() != Constants.INITIALIZE){
            if(this.getCabin().contains(MainPanel.cabin)){
                contains = true;
            }
        }
        return contains;
    }
    public boolean isSelectedC(){
        boolean selectedC = false;
        if(this.embarked != null){
            if(this.embarked.equals(Constants.EMBARKED_C)){
                selectedC = true;
            }
        }
        return selectedC;

    }
    public boolean isSelectedQ(){
        boolean selectedQ = false;
        if(this.embarked != null){
            if(this.embarked.equals(Constants.EMBARKED_Q)){
                selectedQ = true;
            }
        }
        return selectedQ;
    }
    public boolean isSelectedS(){
        boolean selectedS = false;
        if(this.embarked != null){
            if(this.embarked.equals(Constants.EMBARKED_S)){
                selectedS = true;
            }
        }
        return selectedS;
    }
    public boolean isSurvived(){
        boolean survived = false;
        if(this.survived){
            survived = true;
        }
        return survived;
    }

    public String getFormattedName(String name){
        String [] partOfName = name.split(" ");
        String lastName = partOfName[0];
        String firstName = partOfName[2];
        String formatName = firstName + lastName;
        return formatName;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public boolean getSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public int getpClass() {
        return pClass;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(boolean sexMale) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}';
    }
}
