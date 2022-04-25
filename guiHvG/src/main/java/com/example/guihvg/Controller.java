package com.example.guihvg;

import com.example.guihvg.datamodel.Goblin;
import com.example.guihvg.datamodel.Human;
import com.example.guihvg.datamodel.Land;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Thread.sleep;


public class Controller {
    private ArrayList<String> mapChar;
    private Human human;
    private Land map;
    private Goblin goblin;
    private String input;
    private AnimationTimer gameloop;
    private boolean combat;

    @FXML
    private Button quitGame;

    @FXML
    private Button newGame;

    @FXML
    private VBox gameMap;

    @FXML
    private Text playerHealth;

    @FXML
    private Text playerStrength;

    public void initialize() {
        newGame();
    }

    private void newGame() {
        map = new Land();
        human = new Human();
        goblin = null;
        combat = false;
        gameloop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (!combat) {
                    gameMap.getChildren().clear();
                    mapChar = map.getCharacterGrid();
                    mapChar.forEach(i -> gameMap.getChildren().add(new Text(i)));
                } else if (goblin != null) {
                    gameMap.getChildren().clear();
                    gameMap.getChildren().add(new Text("Press F to attack!"));
                    gameMap.getChildren().add(new Text("Press R to flee...COWARD!"));
                    combatStart(input.charAt(0));
                }
                playerHealth.setText(String.valueOf(human.getHealth()));
                playerStrength.setText(String.valueOf(human.getStrength()));
            }
        };
        gameloop.start();


        map.buildGrid();
        human.getCoordinates();

        map.setGridLocation(human.getCoordinates(), human.getIdentifier());
        populateMap(map);
        mapChar = map.getCharacterGrid();
        mapChar.forEach(i -> gameMap.getChildren().add(new Text(i)));
    }

    private void combatStart(char input) {
        if (input == 'f') {
            try {
                sleep(3000);

            if (human.getHealth() > 0) {
                gameMap.getChildren().add(new Text(human.attack(goblin)));
            } else {
                gameMap.getChildren().add(new Text("Game over!"));
                combat = false;
            }
            if (goblin.getHealth() > 0) {
                gameMap.getChildren().add(new Text(goblin.attack(human)));
            } else {
                map.move(human, goblin);
                goblin = null;
                combat = false;
            }
            } catch (Exception e) {
                //
            }
        } else if (input == 'r') {
            combat = false;
        }

    }

    @FXML
    private void keyPressed(KeyEvent e) {
        input = e.getCode().toString().toLowerCase();
        if (goblin == null) {
            goblin = map.move(human, input.charAt(0));

        }
        if (goblin != null) {
            combat = true;
        }
    }

    @FXML
    public void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(newGame)) {
//            newGame(); doesn't work need to find out how to reset the map
        } else if (event.getSource().equals(quitGame)) {
            Platform.exit();
        }
    }


    public static void populateMap(Land map) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 25; j++) {
                Long randomRow = Math.round(1 + (Math.random() * 10));
                if (randomRow == 9) {
                    Hashtable<String, Integer> coords = new Hashtable<>();
                    coords.put("row", i);
                    coords.put("column", j);
                    Goblin goblin = new Goblin();
                    goblin.setCoordinates(coords);
                    map.setTileUTF(i, j, goblin.getIdentifier());
                    map.setTileHumanoid(i, j, goblin);

                }

            }
        }
    }


}