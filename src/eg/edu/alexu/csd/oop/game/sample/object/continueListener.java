package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.world.workspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class continueListener implements ActionListener {
    private World world;

    public continueListener(World world) {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((workspace)this.world).UndoClicked = false;
        ((workspace)this.world).redoClicked = false;
    }
}
