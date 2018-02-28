package exabyte.quiz;


public class Quiz {
    private int correct = 0;
    private int missed = 0;

    public int getCorrect() {
        return correct;
    }

    public int getMissed() {
        return missed;
    }

    private String[] dataProcessingQuestion = {
            "1. A data type that creates unique numbers for key columns in Microsoft Access is called: ",
            "2. What modifier do you add to the ORDER BY command to sequence the output in descending order? ",
            "3. An UPDATE Query/Statement: ",
            "4. Which storage device of the computer stores or keeps the operating system and application programs? ",
            "5. Which Of The Following Is Not A Database Object?",
            "6. RDBMS stands for? ",
            "7. The Primary key must be ",
            "8. What is the use of FTP Program?"
    };

    private String[][] dataProcessingOption = {
            {"Autonumber","Boolean", "Sequential key","Sequential number", "NONE"},
            {"DOWN","ZTOA","This is the default ordering","Upside Down", "DESC"},
            {"is used to add new records to a table","is used to change existing value within a table", "is used to change the structure of the database", "is used to determine what has changed in the database since the last benchmark process"},
            {"The flash disk","The Hard disk","The CD ROM", "The Diskette","ZIP Drive"},
            {"Tables", "Queries", "Relationships", "Reports"},
            {"Relational database management system","Relational database management structured", "Relational database management search","NONE"},
            {"Non Null", "Unique", "Option A or B", "Option A and B", "NONE of the Above"},
            {"Connecting to the internet","Designing a website","Transfer files to and from an Internet Server", "None of the above"}
    };
    private String[] dataProcessingAnswer = {
            "Autonumber",
            "DESC",
            "is used to change existing value within a table",
            "The Hard disk",
            "Relationships",
            "Relational database management system",
            "Option A and B",
            "Transfer files to and from an Internet Server"
    };

    public String getQuestion(int queNumber) {
        return dataProcessingQuestion[queNumber];
    }

    public String[] getOption(int queNumber) {
        return dataProcessingOption[queNumber];
    }

    public int numberOfQuestion() {
        return dataProcessingQuestion.length;
    }

    public void checkScore(String[] answer) {
        String[] systemAnswer = getAnswer();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == systemAnswer[i]) {
                correct = correct + 1;
            } else {
                missed = missed + 1;
            }
        }
    }

    private String[] getAnswer() {
        return dataProcessingAnswer;
    }

}
