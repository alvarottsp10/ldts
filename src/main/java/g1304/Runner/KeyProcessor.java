package g1304.Runner;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.MovingObjects.MainCharacter;

import java.util.ArrayList;
import java.util.List;

public class KeyProcessor {
    List<KeyStroke> actionsToProcess = new ArrayList<>();


    public void recieveKey(KeyStroke key) {
        if (key != null) {
            if (actionsToProcess.isEmpty()) {
                actionsToProcess.add(key);
                actionsToProcess.add(key);
                actionsToProcess.add(key);
                actionsToProcess.add(key);
                actionsToProcess.add(key);
            }
            else {
                if(key.getKeyType() == actionsToProcess.get(0).getKeyType()) {
                    if (actionsToProcess.size() < 10) {
                        actionsToProcess.add(key);
                        actionsToProcess.add(key);
                        actionsToProcess.add(key);
                        actionsToProcess.add(key);
                        actionsToProcess.add(key);
                    }
                }
                else{
                    actionsToProcess.clear();
                    actionsToProcess.add(key);
                    actionsToProcess.add(key);
                    actionsToProcess.add(key);
                    actionsToProcess.add(key);
                    actionsToProcess.add(key);
                    actionsToProcess.add(key);
                }
            }
        }
    }
    public void processKey( MainCharacter character) {
        if(!actionsToProcess.isEmpty()) {
            switch (actionsToProcess.get(0).getKeyType()) {
                case ArrowUp -> {
                    character.MoveHeroUp();
                    actionsToProcess.remove(0);
                }
                case ArrowDown -> {
                    character.MoveHeroDown();
                    actionsToProcess.remove(0);
                }
                case ArrowLeft -> {
                    character.MoveHeroLeft();
                    actionsToProcess.remove(0);
                }
                case ArrowRight -> {
                    character.MoveHeroRight();
                    actionsToProcess.remove(0);
                }
            }
        }

    }
}

