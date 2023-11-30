package g1304.Runner;

import g1304.Runner.MovingObjects.MainCharacter;
import g1304.Runner.MovingObjects.Monsters.Slime;

import java.util.List;

public class SlimeCollision {
    List<Slime> slimes;
    MainCharacter mainCharacter;

    public  boolean SlimeHitsCharacter(Slime slime) {
        if (mainCharacter.HeroX() == slime.getX() && mainCharacter.HeroY() == slime.getY()) {
            return true;
        }
        return false;
    }

    public void SlimeAttack(Slime slime) {
        if (slime.getLastMovement() == "Down") {
            mainCharacter.MoveHeroDown();
            mainCharacter.MoveHeroDown();
            mainCharacter.MoveHeroDown();
            mainCharacter.MoveHeroDown();
        }
        else if (slime.getLastMovement() == "Up") {
            mainCharacter.MoveHeroUp();
            mainCharacter.MoveHeroUp();
            mainCharacter.MoveHeroUp();
            mainCharacter.MoveHeroUp();
        }
    }

    public void CheckCollisions() {
        for (Slime slime: slimes) {
            if (SlimeHitsCharacter(slime)) {
                SlimeAttack(slime);
            }
        }
    }

    SlimeCollision(MainCharacter mainCharacter_, List<Slime> slimes_) {
        mainCharacter = mainCharacter_;
        slimes = slimes_;
    }
}
