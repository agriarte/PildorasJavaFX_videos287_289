package pildoras.javafx_estiloscss_videos287_289;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
import emergente.VentanaEmergente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * Solución según el curso. Pizza con ListView video 268
 */
public class Video287_Themes extends Application {
    
    

    Stage miStage;
    TextField cuadroNombre, cuadroTelefono, cuadroDireccion;
    RadioButton radioPeq, radioMed, radioGran;
    RadioButton radioFina, radioNormal;
    ToggleGroup grupoTamano, grupoMasa;
    RadioButton radioCaspian,radioModena;//estilos
    ToggleGroup grupoTheme;//estilos
    ObservableList<String> ingredientes;
    ListView listaIngredientes;

    @Override
    public void start(Stage primaryStage) {
        
         Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);//Theme CSS

        miStage = primaryStage;
        //---------- creación del panel superior -------------------
        Text txtCabecera = new Text("Pide tu pizza ahora");
        txtCabecera.setFont(new Font(20));

        //---------- creación del panel datos del cliente -------------------
        //Label y text field del nombre
        Label lblNombre = new Label("Nombre: ");
        lblNombre.setPrefWidth(100);//ancho en pixeles

        cuadroNombre = new TextField();
        cuadroNombre.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroNombre.setPromptText("Introduce tu nombre");// texto por defecto

        //Label y text field del telefono
        Label lblTelefono = new Label("Telefono: ");
        lblTelefono.setPrefWidth(100);//ancho en pixeles

        cuadroTelefono = new TextField();
        cuadroTelefono.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroTelefono.setPromptText("Introduce tu telefono");// texto por defecto

        //Label y text field de la dirección
        Label lblDirección = new Label("Dirección: ");
        lblDirección.setPrefWidth(100);//ancho en pixeles

        cuadroDireccion = new TextField();
        cuadroDireccion.setPrefColumnCount(20);// ancho en caracteres o columnas
        cuadroDireccion.setPromptText("Introduce tu dirección");// texto por defecto

        // panel de datos con la suma de los 4 anteriores
        //---------- creación del panel de los pedidos -------------------
        // Creación del pane de tamaño
        Label lblTamaño = new Label("Tamaño:");
        radioPeq = new RadioButton("Pequeña");
        radioMed = new RadioButton("Mediana");
        radioGran = new RadioButton("Grande");

        radioMed.setSelected(true);

        grupoTamano = new ToggleGroup();
        radioPeq.setToggleGroup(grupoTamano);
        radioMed.setToggleGroup(grupoTamano);
        radioGran.setToggleGroup(grupoTamano);

        VBox paneTamano = new VBox(10, lblTamaño, radioPeq, radioMed, radioGran);
        paneTamano.setSpacing(10);

        // Creación del pane de Masa
        Label lblMasa = new Label("Masa:");
        radioFina = new RadioButton("Fina");
        radioNormal = new RadioButton("Normal");

        radioFina.setSelected(true);

        grupoMasa = new ToggleGroup();
        radioFina.setToggleGroup(grupoMasa);
        radioNormal.setToggleGroup(grupoMasa);

        VBox paneMasa = new VBox(10, lblMasa, radioFina, radioNormal);
        paneMasa.setSpacing(10);

        // Creación del pane de Ingredientes
        Label lblIngredientes = new Label("Ingredientes");

        //instancia de lista observable arrayList
        ingredientes = FXCollections.observableArrayList("Pepperoni", "Queso", "Pimiento", "Aceitunas", "Champiñones", "Tomate");
        //instancia de listview agregando el arrayList observable
        listaIngredientes = new ListView();
        listaIngredientes.setPrefHeight(125);
        listaIngredientes.getItems().addAll(ingredientes);
        //por defecto solo se permite la selección de un item del ListView. Para cambiarlo a selección múltiple:
        listaIngredientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane paneIngredientes = new FlowPane(Orientation.VERTICAL, listaIngredientes);
        paneIngredientes.setPadding(new Insets(10, 0, 10, 0));
        paneIngredientes.setHgap(20);
        paneIngredientes.setVgap(10);
        paneIngredientes.setPrefWrapLength(100);

        VBox paneIngredientesVertical = new VBox();
        paneIngredientesVertical.getChildren().addAll(lblIngredientes, paneIngredientes);

        //-------------- Crear pane de características de pizza -----------------
        HBox paneOrden = new HBox(50, paneTamano, paneMasa, paneIngredientesVertical);

        //-------------- Crear pane de datos cliente + pedido  -----------------
        //-------------- Crear pane inferior: botones  -----------------
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btn_OK_Click());

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setPrefWidth(80);
        btnCancelar.setOnAction(e -> btn_Cancelar_Click());

        //Se usa la clase Region para mejorar el aspecto
        //----------- CREACION DEL GRID ---------------
        GridPane miGridPane = new GridPane();
        miGridPane.setPadding(new Insets(10));
        miGridPane.setHgap(10);
        miGridPane.setVgap(10);
        miGridPane.setMinWidth(500);
        miGridPane.setPrefWidth(500);
        miGridPane.setMaxWidth(800);
        //------ agregando nodos ---------
        miGridPane.addRow(0, txtCabecera);
        miGridPane.addRow(1, lblNombre, cuadroNombre);
        miGridPane.addRow(2, lblDirección, cuadroDireccion);
        miGridPane.addRow(3, lblTelefono, cuadroTelefono);

        miGridPane.addRow(4, paneTamano, paneMasa, paneIngredientes);

        //_
        //Añadir 2 RadioBox para elegir el theme
        Label themeLb = new Label("Theme CSS");
        radioCaspian = new RadioButton("Estilo Caspian");
        radioModena = new RadioButton("Estilo Modena");
        grupoTheme = new ToggleGroup();
        radioCaspian.setToggleGroup(grupoTheme);
        radioModena.setToggleGroup(grupoTheme);
        radioCaspian.setSelected(true);
        //eventos para temaCSS
        radioCaspian.setOnAction((event) -> {
            Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
            System.out.println("caspian");
        });
        radioModena.setOnAction((event) -> {
            Application.setUserAgentStylesheet(STYLESHEET_MODENA);
            System.out.println("modena");
        });
        //disposicición en un VBox
        VBox paneTheme = new VBox(themeLb,radioCaspian,radioModena);
        
        
        
        // Crear un nuevo HBox para los botones
        HBox paneBotones = new HBox(10, btnOK, btnCancelar);
        // Agregar paneBotones a la celda correspondiente y establecer la alineación
        // En lugar de usar addRow que añade filas, uso add() que permite especificar columna y fila
        miGridPane.add(paneTheme,0,5);// agregar selector Theme a la primera columna "0"
        miGridPane.add(paneBotones, 2, 5); // Agregar botones a la tercera columna "2" y fila 5
        //EL ALINEADO NO SE REALIZA, PARECE QUE ALGO ESTA AFECTANDO. MISMO RESULTADO CON LEFT, CENTER Y OMITIENDO
        GridPane.setHalignment(paneBotones, HPos.CENTER);// <- NO FUNCIONA!

        //_
        GridPane.setColumnSpan(txtCabecera, 4);
        GridPane.setHalignment(txtCabecera, HPos.CENTER);
        GridPane.setColumnSpan(cuadroNombre, 2);
        GridPane.setColumnSpan(cuadroDireccion, 2);
        GridPane.setColumnSpan(cuadroTelefono, 2);

        //----------- FINALIZAR LA SCENE ---------------
        Scene scene = new Scene(miGridPane, 600, 400);

        miStage.setTitle("Probando los themes");
        miStage.setScene(scene);
        miStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void btn_OK_Click() {
        //Creación con el String del cliente
        String msg = "Cliente:\n\n";
        msg += "\t" + cuadroNombre.getText() + "\n" + "\t" + cuadroTelefono.getText() + "\n" + "\t" + cuadroDireccion.getText() + "\n";
        msg += "\tHas pedido:\n";
        msg += "\tTamaño: " + ((RadioButton) grupoTamano.getSelectedToggle()).getText() + "\n";
        msg += "\tMasa: " + ((RadioButton) grupoMasa.getSelectedToggle()).getText() + "\n";
        msg += "\tLista de ingredientes: " + obtenerIngredientes() + "\n";

        VentanaEmergente.mostrar(msg, "Tu pedido");

    }

    private void btn_Cancelar_Click() {
        miStage.close();
    }

    private String obtenerIngredientes() {
        String ingredientesString = "\n";

        // Obtener los elementos seleccionados
        ingredientes = listaIngredientes.getSelectionModel().getSelectedItems();

        // Iterar sobre los elementos seleccionados
        for (String topping : ingredientes) {
            ingredientesString += "\t" + topping + "\n";
        }

        return ingredientesString;
    }

}
