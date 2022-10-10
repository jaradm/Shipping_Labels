/*
Authur: Muhammad J. Jarad
 */
package shipping_labels;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Shipping_Labels extends Application {

    private final Label lbTitle = new Label("SHIPPING");
    private final Label lbFullName = new Label("      Full Name: ");
    private final TextField tfFullName = new TextField();
    private final Label lbPhoneNum1 = new Label("       Phone #1: ");
    private final TextField tfPhoneNum1 = new TextField();
    private final Label lbPhoneNum2 = new Label("   Phone #2: ");
    private final TextField tfPhoneNum2 = new TextField();

    // ComboBox for the city option
    private final Label lbCity = new Label("\t       City: ");
    private final String City[] = {"Ramallah", "Nablus", "Hebron",
        "Jenin", "Bethlehem", "Jerico"};
    private final ComboBox cbCity = new ComboBox(
            FXCollections.observableArrayList(City));

    private final Label lbTown = new Label("\t  Town: ");
    private final TextField tfTown = new TextField();
    private final Label lbBoxes = new Label("Number of\n       Boxes: ");
    private final TextField tfBoxes = new TextField();

    // CheckBox for paid question
    private final CheckBox cbPaid = new CheckBox("Paid");

    private final Label lbNotes = new Label("\t     Notes: ");
    private final TextArea taNotes = new TextArea();
    private final Button btPrint = new Button("Print");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        VBox main = new VBox();
        main.setAlignment(Pos.TOP_CENTER);

        /*--------------------------Customer Info Window------------------------------*/
        //Vbox that orginizes nodes for layout
        VBox organizer = new VBox();
        organizer.setAlignment(Pos.TOP_CENTER);

        // Title Hbox
        HBox titleBox = new HBox();
        titleBox.getChildren().add(lbTitle);
        organizer.getChildren().add(titleBox);
        // Properties
        titleBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(titleBox, new Insets(10));
        lbTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 55));

        // FullName Hbox
        HBox nameBox = new HBox();
        nameBox.getChildren().add(lbFullName);
        nameBox.getChildren().add(tfFullName);
        organizer.getChildren().add(nameBox);
        // Properties
        nameBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(nameBox, new Insets(10, 10, 10, 13));
        tfFullName.setPrefWidth(635);
        lbFullName.setFont(Font.font("Verdana", 25));
        tfFullName.setFont(Font.font("Verdana", 25));

        // Phones Hbox
        HBox phonesBox = new HBox();
        phonesBox.getChildren().add(lbPhoneNum1);
        phonesBox.getChildren().add(tfPhoneNum1);
        phonesBox.getChildren().add(lbPhoneNum2);
        phonesBox.getChildren().add(tfPhoneNum2);
        organizer.getChildren().add(phonesBox);
        // Properties
        phonesBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(phonesBox, new Insets(10));
        tfPhoneNum1.setPrefWidth(225);
        lbPhoneNum2.setPadding(new Insets(0, 0, 0, 10));
        tfPhoneNum2.setPrefWidth(225);
        lbPhoneNum1.setFont(Font.font("Verdana", 25));
        tfPhoneNum1.setFont(Font.font("Verdana", 25));
        lbPhoneNum2.setFont(Font.font("Verdana", 25));
        tfPhoneNum2.setFont(Font.font("Verdana", 25));

        // Address Hbox
        HBox addressBox = new HBox();
        addressBox.getChildren().add(lbCity);
        addressBox.getChildren().add(cbCity);
        addressBox.getChildren().add(lbTown);
        addressBox.getChildren().add(tfTown);
        organizer.getChildren().add(addressBox);
        // Properties
        addressBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(addressBox, new Insets(10));
        lbTown.setPadding(new Insets(0, 0, 0, 5));
        tfTown.setPrefWidth(225);
        cbCity.setPrefSize(225, 50);
        lbTown.setFont(Font.font("Verdana", 25));
        tfTown.setFont(Font.font("Verdana", 25));
        lbCity.setFont(Font.font("Verdana", 25));

        // Items Info Hbox
        HBox itemsBox = new HBox();
        itemsBox.getChildren().add(lbBoxes);
        itemsBox.getChildren().add(tfBoxes);
        itemsBox.getChildren().add(cbPaid);
        organizer.getChildren().add(itemsBox);
        // Properties
        itemsBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(itemsBox, new Insets(10));
        lbBoxes.setPadding(new Insets(0, 8, 0, 45));
        tfBoxes.setPrefWidth(100);
        HBox.setMargin(cbPaid, new Insets(0, 0, 0, 15));
        lbBoxes.setFont(Font.font("Verdana", 25));
        tfBoxes.setFont(Font.font("Verdana", 25));
        cbPaid.setFont(Font.font("Verdana", 25));

        // Notes Hbox
        HBox notesBox = new HBox();
        notesBox.getChildren().add(lbNotes);
        notesBox.getChildren().add(taNotes);
        organizer.getChildren().add(notesBox);
        // Properties
        notesBox.setAlignment(Pos.TOP_LEFT);
        VBox.setMargin(notesBox, new Insets(10));
        taNotes.setPrefWidth(625);
        taNotes.setWrapText(true);
        lbNotes.setFont(Font.font("Verdana", 25));
        taNotes.setFont(Font.font("Verdana", 25));

        main.getChildren().add(organizer);

        // Submit Button Properties
        main.getChildren().add(btPrint);
        VBox.setMargin(btPrint, new Insets(10));
        btPrint.setPrefWidth(100);
        btPrint.setFont(Font.font("Verdana", 25));
/*----------------------------------------------------------------------------*/

        // User File Process events
        btPrint.setOnAction(e -> {
            for (int i = 1; i <= new Integer(tfBoxes.getText()); ++i) {
                printLabel(i);
            }
        });

/*----------------------------Window Properties-------------------------------*/
        // Create a scene and place it in the stage
        Scene scene = new Scene(main, 900, 875);
        primaryStage.setTitle("Shipping Labels"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
/*----------------------------------------------------------------------------*/
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void printLabel(Integer boxNum) {
        VBox organizer2 = new VBox();
        organizer2.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(organizer2, new Insets(10));
        organizer2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        organizer2.setPrefWidth(250);
        organizer2.setPrefSize(270, 400);

        Label lbPrintTitle = new Label("SHIPPING");
        Label lbPrintName = new Label("\t  Full Name: ");
        Label lbPrintPhone1 = new Label("\t   Phone #1: ");
        Label lbPrintPhone2 = new Label("  Phone #2: ");
        Label lbPrintCity = new Label("\t\t     City: ");
        Label lbPrintTown = new Label("\t  Town: ");
        Label lbPrintBoxes = new Label(" Box:");
        Label lbPrintNotes = new Label("\t\t   Notes: ");

        Label name = new Label(tfFullName.getText());
        Label phone1 = new Label(tfPhoneNum1.getText());
        Label phone2 = new Label(tfPhoneNum2.getText());
        Label city = new Label((String) cbCity.getValue());
        Label town = new Label(tfTown.getText());
        Label numOfBoxes = new Label(boxNum.toString() + " OF "
                + tfBoxes.getText());
        Label lbPaymentStatus = new Label("Payement\n     Status:");
        lbPaymentStatus.setFont(Font.font("Verdana", 12));
        Label paymentStatus = new Label();
        if (cbPaid.isSelected()) {
            paymentStatus.setText("PAID");
        } else {
            paymentStatus.setText("UNPAID");
        }
        TextArea notes = new TextArea(taNotes.getText());
        notes.setPrefSize(150, 100);
        VBox.setMargin(notes, new Insets(5, 5, 5, 40));
        notes.setEditable(false);
        notes.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

        // Hbox that alignes vbox orginizer2 to top left for printing purposes
        HBox printerScaler = new HBox();
        printerScaler.setAlignment(Pos.TOP_LEFT);

        // Hbox that seperates the labels column and info column
        HBox seperator = new HBox();

        VBox labels = new VBox();
        labels.setAlignment(Pos.CENTER_LEFT);

        lbPrintTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        lbPrintName.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintPhone1.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintPhone2.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintCity.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintTown.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintBoxes.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPaymentStatus.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        lbPrintNotes.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

        lbPrintName.setPadding(new Insets(15, 5, 5, -36));
        lbPrintPhone1.setPadding(new Insets(5, 5, 5, -38));
        lbPrintPhone2.setPadding(new Insets(5, 5, 5, 0));
        lbPrintCity.setPadding(new Insets(5, 5, 5, -42));
        lbPrintTown.setPadding(new Insets(5, 5, 5, -4));
        lbPrintBoxes.setPadding(new Insets(5, 5, 5, 50));
        lbPaymentStatus.setPadding(new Insets(5, 5, 5, 10));
        lbPrintNotes.setPadding(new Insets(5, 5, 5, -46));

        labels.getChildren().add(lbPrintName);
        labels.getChildren().add(lbPrintPhone1);
        labels.getChildren().add(lbPrintPhone2);
        labels.getChildren().add(lbPrintCity);
        labels.getChildren().add(lbPrintTown);
        labels.getChildren().add(lbPrintBoxes);
        labels.getChildren().add(lbPaymentStatus);
        labels.getChildren().add(lbPrintNotes);

        seperator.getChildren().add(labels);

        VBox info = new VBox();

        name.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        phone1.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        phone2.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        city.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        town.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        numOfBoxes.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        paymentStatus.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        notes.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

        name.setPadding(new Insets(15, 0, 0, 0));
        phone1.setPadding(new Insets(10, 0, 0, 0));
        phone2.setPadding(new Insets(10, 0, 0, 0));
        city.setPadding(new Insets(10, 0, 0, 0));
        town.setPadding(new Insets(10, 0, 0, 0));
        numOfBoxes.setPadding(new Insets(10, 0, 0, 0));
        paymentStatus.setPadding(new Insets(25, 0, 0, 0));

        info.getChildren().add(name);
        info.getChildren().add(phone1);
        info.getChildren().add(phone2);
        info.getChildren().add(city);
        info.getChildren().add(town);
        info.getChildren().add(numOfBoxes);
        info.getChildren().add(paymentStatus);
        seperator.getChildren().add(info);

        printerScaler.getChildren().add(organizer2);
        organizer2.getChildren().add(lbPrintTitle);
        organizer2.getChildren().add(seperator);
        organizer2.getChildren().add(notes);

        PrinterJob job = PrinterJob.createPrinterJob();
        Printer printer = job.getPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A5,
                PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        job.printPage(pageLayout, organizer2); // myNode is the node to be printed 
        job.endJob();

    }

}
