package screensframework.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import java.util.HashMap;

public class PrincipalController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();
    private HashMap<String, ControlledScreen> controller = new HashMap<>();

    public PrincipalController() {
        super();
    }

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public void addController(String name, ControlledScreen screen) {
        controller.put(name, screen);
    }

    public ControlledScreen getController(String name) {
        return controller.get(name);
    }

    public boolean loadScreen(String name, String resource) {

        try {

            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());

            myScreenControler.setScreenParent(this);
            addController(name, myLoader.getController());
            addScreen(name, loadScreen);

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {

        if (screens.get(name) != null) {
            getChildren().add(screens.get(name));
            return true;

        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }

    }
}

