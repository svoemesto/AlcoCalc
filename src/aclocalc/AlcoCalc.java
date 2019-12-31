package aclocalc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AlcoCalc extends Application {

    Label labelConcentration = new Label("Крепость, %");
    Label labelVolume = new Label("Объем, л.");
    Label labelAC = new Label("АС, л.");
    Label labelH2O = new Label("H2O, л.");

    Label labelSolution1 = new Label("«Спирт»:");
    Label labelSolution2 = new Label("«Вода»:");
    Label labelSolution3 = new Label("«Водка»:");

    TextField fieldSol1Conc = new TextField();
    TextField fieldSol2Conc = new TextField();
    TextField fieldSol3Conc = new TextField();

    TextField fieldSol1Vol = new TextField();
    TextField fieldSol2Vol = new TextField();
    TextField fieldSol3Vol = new TextField();

    TextField fieldSol1AC = new TextField();
    TextField fieldSol2AC = new TextField();
    TextField fieldSol3AC = new TextField();

    TextField fieldSol1H2O = new TextField();
    TextField fieldSol2H2O = new TextField();
    TextField fieldSol3H2O = new TextField();

    //    ToggleButton toggleButtonSol1Conc = new ToggleButton("?");
//    ToggleButton toggleButtonSol2Conc = new ToggleButton("?");
    ToggleButton toggleButtonSol3Conc = new ToggleButton("?");

    ToggleButton toggleButtonSol1Vol = new ToggleButton("?");
    ToggleButton toggleButtonSol2Vol = new ToggleButton("?");
    ToggleButton toggleButtonSol3Vol = new ToggleButton("?");

    public void calc() {

        Double sol1conc=0.0, sol1vol=0.0, sol1ac=0.0, sol1h2o=0.0;
        Double sol2conc=0.0, sol2vol=0.0, sol2ac=0.0, sol2h2o=0.0;
        Double sol3conc=0.0, sol3vol=0.0, sol3ac=0.0, sol3h2o=0.0;

        sol1conc = Double.parseDouble(fieldSol1Conc.getText());
        sol2conc = Double.parseDouble(fieldSol2Conc.getText());

        // дано: крепость и объем водки. Надо: объем спирта и объем воды
        if (toggleButtonSol3Conc.isSelected() && !toggleButtonSol1Vol.isSelected() && !toggleButtonSol2Vol.isSelected() && toggleButtonSol3Vol.isSelected() ) {
            sol3conc = Double.parseDouble(fieldSol3Conc.getText());
            sol3vol = Double.parseDouble(fieldSol3Vol.getText());
            sol3ac = sol3vol * sol3conc / 100;
            sol3h2o = sol3vol - sol3ac;

            // если крепость водки не более крепости любого компонента - можно рассчитать
            if (!(sol3conc > sol1conc && sol3conc > sol2conc)) {
                // если первый раствор - спиртовой, а второй - вода
                if (sol1conc > 0 && sol2conc == 0.0) {
                    sol1ac = sol3ac;
                    sol1vol = sol1ac / (sol1conc / 100);
                    sol1h2o = sol1vol - sol1ac;

                    sol2vol = sol3vol - sol1vol;
                    sol2ac = sol2vol * sol2conc / 100;
                    sol2h2o = sol2vol - sol2ac;
                }
            }

            fieldSol1Vol.setText(sol1vol.toString());
            fieldSol2Vol.setText(sol2vol.toString());

        }

        // дано: крепость водки и объем спитра. Надо: объем воды и объем водки
        if (toggleButtonSol3Conc.isSelected() && toggleButtonSol1Vol.isSelected() && !toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Vol.isSelected() ) {
            sol3conc = Double.parseDouble(fieldSol3Conc.getText());
            sol1vol = Double.parseDouble(fieldSol1Vol.getText());
            sol1ac = sol1vol * sol1conc / 100;
            sol1h2o = sol1vol - sol1ac;

            // если крепость водки не более крепости любого компонента - можно рассчитать
            if (!(sol3conc > sol1conc && sol3conc > sol2conc)) {
                // если первый раствор - спиртовой, а второй - вода
                if (sol1conc > 0 && sol2conc == 0.0) {


                    sol3ac = sol1ac;
                    sol3vol = sol3ac / (sol3conc / 100);
                    sol3h2o = sol3vol - sol3ac;

                    sol2vol = sol3vol - sol1vol;
                    sol2ac = sol2vol * sol2conc / 100;
                    sol2h2o = sol2vol - sol2ac;
                }
            }

            fieldSol2Vol.setText(sol2vol.toString());
            fieldSol3Vol.setText(sol3vol.toString());

        }

        // дано: крепость водки и объем воды. Надо: объем спирта и объем водки
        if (toggleButtonSol3Conc.isSelected() && !toggleButtonSol1Vol.isSelected() && toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Vol.isSelected() ) {
            sol3conc = Double.parseDouble(fieldSol3Conc.getText());
            sol2vol = Double.parseDouble(fieldSol2Vol.getText());
            sol2ac = sol2vol * sol2conc / 100;
            sol2h2o = sol2vol - sol2ac;

            // если крепость водки не более крепости любого компонента - можно рассчитать
            if (!(sol3conc > sol1conc && sol3conc > sol2conc)) {
                // если первый раствор - спиртовой, а второй - вода
                if (sol1conc > 0 && sol2conc == 0.0) {

                    sol1vol = (sol2vol * sol3conc) / (sol1conc - sol3conc);
                    sol1ac = sol1vol * sol1conc / 100;
                    sol1h2o = sol1vol - sol1ac;

                    sol3vol = sol1vol + sol2vol;
                    sol3ac = sol3vol * sol3conc / 100;
                    sol3h2o = sol3vol - sol3ac;

                }
            }

            fieldSol1Vol.setText(sol1vol.toString());
            fieldSol3Vol.setText(sol3vol.toString());

        }

        // дано: объем спирта и воды. Надо: крепость водки и объем водки
        if (!toggleButtonSol3Conc.isSelected() && toggleButtonSol1Vol.isSelected() && toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Vol.isSelected() ) {
            sol1vol = Double.parseDouble(fieldSol1Vol.getText());
            sol1ac = sol1vol * sol1conc / 100;
            sol1h2o = sol1vol - sol1ac;

            sol2vol = Double.parseDouble(fieldSol2Vol.getText());
            sol2ac = sol2vol * sol2conc / 100;
            sol2h2o = sol2vol - sol2ac;

            sol3vol = sol1vol + sol2vol;
            sol3ac = sol1ac + sol2ac;
            sol3h2o = sol1h2o + sol2h2o;

            sol3conc = sol3ac * 100 / sol3vol;

            fieldSol3Conc.setText(sol3conc.toString());
            fieldSol3Vol.setText(sol3vol.toString());

        }

        // дано: объем спирта и водки. Надо: крепость водки и объем воды
        if (!toggleButtonSol3Conc.isSelected() && toggleButtonSol1Vol.isSelected() && !toggleButtonSol2Vol.isSelected() && toggleButtonSol3Vol.isSelected() ) {
            sol1vol = Double.parseDouble(fieldSol1Vol.getText());
            sol1ac = sol1vol * sol1conc / 100;
            sol1h2o = sol1vol - sol1ac;

            sol3vol = Double.parseDouble(fieldSol3Vol.getText());
            sol3ac = sol1ac;
            sol3h2o = sol3vol - sol3ac;

            sol2ac = sol1ac - sol3ac;
            sol2vol = sol3vol - sol1vol;
            sol2h2o = sol2vol;

            sol3conc = sol3ac * 100 / sol3vol;

            fieldSol3Conc.setText(sol3conc.toString());
            fieldSol2Vol.setText(sol2vol.toString());

        }

        // дано: объем воды и водки. Надо: крепость водки и объем спирта
        if (!toggleButtonSol3Conc.isSelected() && !toggleButtonSol1Vol.isSelected() && toggleButtonSol2Vol.isSelected() && toggleButtonSol3Vol.isSelected() ) {
            sol2vol = Double.parseDouble(fieldSol2Vol.getText());
            sol3vol = Double.parseDouble(fieldSol3Vol.getText());

            sol1vol = sol3vol - sol2vol;
            sol1ac = sol1vol * sol1conc / 100;
            sol1h2o = sol1vol - sol1ac;

            sol2ac = sol2vol * sol2conc / 100;
            sol2h2o = sol2vol - sol2ac;

            sol3ac = sol1ac;
            sol3h2o = sol1h2o + sol2h2o;

            sol3vol = Double.parseDouble(fieldSol3Vol.getText());
            sol3ac = sol1ac;
            sol3h2o = sol3vol - sol3ac;

            sol3conc = sol3ac * 100 / sol3vol;

            fieldSol3Conc.setText(sol3conc.toString());
            fieldSol1Vol.setText(sol1vol.toString());

        }

        fieldSol1AC.setText(sol1ac.toString());
        fieldSol2AC.setText(sol2ac.toString());
        fieldSol3AC.setText(sol3ac.toString());

        fieldSol1H2O.setText(sol1h2o.toString());
        fieldSol2H2O.setText(sol2h2o.toString());
        fieldSol3H2O.setText(sol3h2o.toString());

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("aclocalc.AlcoCalc");
        window.setWidth(280);
        window.setHeight(160);
        Pane pane = new Pane();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
//        gridPane.setGridLinesVisible(true);

        pane.getChildren().add(gridPane);

        gridPane.add(labelConcentration,1,0);
        gridPane.add(labelVolume,3,0);
//        gridPane.add(labelAC,5,0);
//        gridPane.add(labelH2O,6,0);

        gridPane.add(labelSolution1,0,1);
        gridPane.add(labelSolution2,0,2);
        gridPane.add(labelSolution3,0,3);

        gridPane.add(fieldSol1Conc,1,1);
//        gridPane.add(fieldSol2Conc,1,2);
        gridPane.add(fieldSol3Conc,1,3);

//        gridPane.add(toggleButtonSol1Conc,2,1);
//        gridPane.add(toggleButtonSol2Conc,2,2);
        gridPane.add(toggleButtonSol3Conc,2,3);

        gridPane.add(fieldSol1Vol,3,1);
        gridPane.add(fieldSol2Vol,3,2);
        gridPane.add(fieldSol3Vol,3,3);

        gridPane.add(toggleButtonSol1Vol,4,1);
        gridPane.add(toggleButtonSol2Vol,4,2);
        gridPane.add(toggleButtonSol3Vol,4,3);

//        gridPane.add(fieldSol1AC,5,1);
//        gridPane.add(fieldSol2AC,5,2);
//        gridPane.add(fieldSol3AC,5,3);

//        gridPane.add(fieldSol1H2O,6,1);
//        gridPane.add(fieldSol2H2O,6,2);
//        gridPane.add(fieldSol3H2O,6,3);


        fieldSol1Conc.setText("96.4");
        fieldSol2Conc.setText("0");
        fieldSol1Vol.setText("2");
        fieldSol2Vol.setText("3");

        toggleButtonSol1Vol.setSelected(true);
        toggleButtonSol2Vol.setSelected(true);
        toggleButtonSol1Vol.setText(toggleButtonSol1Vol.isSelected() ? "X" : "?");
        toggleButtonSol2Vol.setText(toggleButtonSol2Vol.isSelected() ? "X" : "?");

        int width = 70;

        labelConcentration.setPrefWidth(width);
        fieldSol1Conc.setPrefWidth(width);
        fieldSol2Conc.setPrefWidth(width);
        fieldSol3Conc.setPrefWidth(width);

        labelVolume.setPrefWidth(width);
        fieldSol1Vol.setPrefWidth(width);
        fieldSol2Vol.setPrefWidth(width);
        fieldSol3Vol.setPrefWidth(width);

        calc();

        fieldSol2Conc.setEditable(false);
        fieldSol3Conc.setEditable(false);
        fieldSol3Vol.setEditable(false);

        fieldSol3Conc.setStyle("-fx-background-color:LIGHTGREEN");
        fieldSol3Vol.setStyle("-fx-background-color:LIGHTGREEN");

        fieldSol1Conc.setOnAction(e -> calc());
        fieldSol2Conc.setOnAction(e -> calc());
        fieldSol3Conc.setOnAction(e -> calc());

        fieldSol1Vol.setOnAction(e -> calc());
        fieldSol2Vol.setOnAction(e -> calc());
        fieldSol3Vol.setOnAction(e -> calc());

        toggleButtonSol3Conc.setOnAction(e -> {
            if (toggleButtonSol3Conc.isSelected()) {

                toggleButtonSol3Conc.setText("X");
                fieldSol3Conc.setStyle("-fx-background-color:WHITE");
                fieldSol3Conc.setEditable(true);

                if (toggleButtonSol1Vol.isSelected() && toggleButtonSol2Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                } else if (toggleButtonSol1Vol.isSelected() && toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol1Vol.setSelected(false);
                    toggleButtonSol1Vol.setText("?");
                    fieldSol1Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol1Vol.setEditable(false);
                } else if (toggleButtonSol2Vol.isSelected() && toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                }
            } else {

                toggleButtonSol3Conc.setText("?");
                fieldSol3Conc.setStyle("-fx-background-color:LIGHTGREEN");
                fieldSol3Conc.setEditable(false);

                if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol2Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                } else if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol1Vol.setSelected(true);
                    toggleButtonSol1Vol.setText("X");
                    fieldSol1Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol1Vol.setEditable(true);
                } else if (!toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                }
            }

            calc();

        });

        toggleButtonSol1Vol.setOnAction(e -> {

            if (toggleButtonSol1Vol.isSelected()) {

                toggleButtonSol1Vol.setText("X");
                fieldSol1Vol.setStyle("-fx-background-color:WHITE");
                fieldSol1Vol.setEditable(true);

                if (toggleButtonSol2Vol.isSelected() && toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                } else if (toggleButtonSol2Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                } else if (toggleButtonSol3Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol3Vol.setSelected(false);
                    toggleButtonSol3Vol.setText("?");
                    fieldSol3Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol3Vol.setEditable(false);
                }
            } else {

                toggleButtonSol1Vol.setText("?");
                fieldSol1Vol.setStyle("-fx-background-color:LIGHTGREEN");
                fieldSol1Vol.setEditable(false);

                if (!toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                } else if (!toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                } else if (!toggleButtonSol3Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol3Vol.setSelected(true);
                    toggleButtonSol3Vol.setText("X");
                    fieldSol3Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol3Vol.setEditable(true);
                }
            }

            calc();

        });

        toggleButtonSol2Vol.setOnAction(e -> {

            if (toggleButtonSol2Vol.isSelected()) {

                toggleButtonSol2Vol.setText("X");
                fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                fieldSol2Vol.setEditable(true);

                if (toggleButtonSol1Vol.isSelected() && toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol3Vol.setSelected(false);
                    toggleButtonSol3Vol.setText("?");
                    fieldSol3Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol3Vol.setEditable(false);
                } else if (toggleButtonSol1Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol1Vol.setSelected(false);
                    toggleButtonSol1Vol.setText("?");
                    fieldSol1Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol1Vol.setEditable(false);
                } else if (toggleButtonSol3Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol3Vol.setSelected(false);
                    toggleButtonSol3Vol.setText("?");
                    fieldSol3Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol3Vol.setEditable(false);
                }
            } else {

                toggleButtonSol2Vol.setText("?");
                fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                fieldSol2Vol.setEditable(false);

                if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol3Vol.isSelected()) {
                    toggleButtonSol3Vol.setSelected(true);
                    toggleButtonSol3Vol.setText("X");
                    fieldSol3Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol3Vol.setEditable(true);
                } else if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol1Vol.setSelected(true);
                    toggleButtonSol1Vol.setText("X");
                    fieldSol1Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol1Vol.setEditable(true);
                } else if (!toggleButtonSol3Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol3Vol.setSelected(true);
                    toggleButtonSol3Vol.setText("X");
                    fieldSol3Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol3Vol.setEditable(true);
                }
            }

            calc();

        });
        toggleButtonSol3Vol.setOnAction(e -> {

            if (toggleButtonSol3Vol.isSelected()) {

                toggleButtonSol3Vol.setText("X");
                fieldSol3Vol.setStyle("-fx-background-color:WHITE");
                fieldSol3Vol.setEditable(true);

                if (toggleButtonSol1Vol.isSelected() && toggleButtonSol2Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                } else if (toggleButtonSol1Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol1Vol.setSelected(false);
                    toggleButtonSol1Vol.setText("?");
                    fieldSol1Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol1Vol.setEditable(false);
                } else if (toggleButtonSol2Vol.isSelected() && toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol2Vol.setSelected(false);
                    toggleButtonSol2Vol.setText("?");
                    fieldSol2Vol.setStyle("-fx-background-color:LIGHTGREEN");
                    fieldSol2Vol.setEditable(false);
                }
            } else {

                toggleButtonSol3Vol.setText("?");
                fieldSol3Vol.setStyle("-fx-background-color:LIGHTGREEN");
                fieldSol3Vol.setEditable(false);

                if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol2Vol.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                } else if (!toggleButtonSol1Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol1Vol.setSelected(true);
                    toggleButtonSol1Vol.setText("X");
                    fieldSol1Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol1Vol.setEditable(true);
                } else if (!toggleButtonSol2Vol.isSelected() && !toggleButtonSol3Conc.isSelected()) {
                    toggleButtonSol2Vol.setSelected(true);
                    toggleButtonSol2Vol.setText("X");
                    fieldSol2Vol.setStyle("-fx-background-color:WHITE");
                    fieldSol2Vol.setEditable(true);
                }
            }

            calc();

        });

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
