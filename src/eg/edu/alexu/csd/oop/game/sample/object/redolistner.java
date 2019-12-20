package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.World;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import eg.edu.alexu.csd.oop.game.sample.world.workspace;

public class redolistner implements ActionListener {
    private World world;
    public redolistner(World world) {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((workspace)world).redoClicked = true;
        ((workspace)world).UndoClicked = false;
    }
}
