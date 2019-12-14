package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.sample.world.workspace;
public class ButtonListener implements ActionListener {
    private int ones =0;
    private  World world;
    public ButtonListener(World world) {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((workspace)this.world).Clicked = true;
    }
}
