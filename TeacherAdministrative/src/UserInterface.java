import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application {

    private final ObservableList<Student> studentsData = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }
    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Calculator");

        TableView<Student> table = new TableView<>();
        table.setEditable(false);

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(200);

        TableColumn<Student, Double> gradeNumberCol = new TableColumn<>("Grade (Number)");
        gradeNumberCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        gradeNumberCol.setPrefWidth(200); 

        TableColumn<Student, String> gradeCol = new TableColumn<>("Grade (Letter)");
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("gradeWithSign"));
        gradeCol.setPrefWidth(200); 

        TableColumn<Student, Integer> attendanceCol = new TableColumn<>("Attendance Percentage");
        attendanceCol.setCellValueFactory(new PropertyValueFactory<>("attendancePercentage"));
        attendanceCol.setPrefWidth(200); 

        table.getColumns().addAll(idCol, gradeNumberCol, gradeCol, attendanceCol);

        VBox vbox = new VBox(); 
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

        Scene scene = new Scene(new ScrollPane(vbox), 800, 550);
        primaryStage.setScene(scene);
        primaryStage.show();


       
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Number of Students");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter the number of students to register:");
        dialog.showAndWait().ifPresent(numStudentsStr -> {
            int numStudents = Integer.parseInt(numStudentsStr);

            for (int i = 1; i <= numStudents; i++) {
                TextInputDialog idDialog = new TextInputDialog();
                idDialog.setTitle("Student ID");
                idDialog.setHeaderText(null);
                idDialog.setContentText("Student " + i + " ID:");
                idDialog.showAndWait().ifPresent(idStr -> {
                    int id = Integer.parseInt(idStr);

                    double firstExamScore = Double.parseDouble(getInput("Enter score for the first exam:"));
                    double secondExamScore = Double.parseDouble(getInput("Enter score for the second exam:"));
                    double homeworkScore = Double.parseDouble(getInput("Enter score for homework:"));
                    double projectScore = Double.parseDouble(getInput("Enter score for project:"));
                    double finalExamScore = Double.parseDouble(getInput("Enter score for the final exam:"));
                    int totalClasses = Integer.parseInt(getInput("Enter total number of classes:"));
                    int attendedClasses = Integer.parseInt(getInput("Enter number of classes attended:"));

                    Student student = new Student(id, firstExamScore, secondExamScore, homeworkScore, projectScore,
                            finalExamScore, totalClasses, attendedClasses);
                    studentsData.add(student);
                });
            }
        });

        table.setItems(studentsData);
    }

    private String getInput(String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input");
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);
        return dialog.showAndWait().orElse(null);
    }
}
