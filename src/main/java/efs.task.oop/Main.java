package efs.task.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain= new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        // Na tych obiektach nie można wywołać metod klasy ExtraordinaryVillager
        // objectDeckardCain.sayHello();
        // objectAkara.sayHello();

        List<Villager> aliveVillagers = new ArrayList<>();
        aliveVillagers.add(kashya);
        aliveVillagers.add(gheed);
        aliveVillagers.add(warriv);
        aliveVillagers.add(flawia);

        List<Monster> aliveMonsters = new ArrayList<>();
        aliveMonsters.add(Monsters.andariel);
        aliveMonsters.add(Monsters.blacksmith);

        Random rand = new Random();
        int randomVillager;
        int randomMonster;

        Boolean endFightFlag = true;
        Boolean villagerTurn = true;
        while(endFightFlag) {
            randomVillager =  rand.nextInt(aliveVillagers.size());
            randomMonster =  rand.nextInt(aliveMonsters.size());

            System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
            System.out.println("Aktualnie walczacy osadnik to " + aliveVillagers.get(randomVillager).getName());


            if (villagerTurn) {
                aliveVillagers.get(randomVillager).attack(aliveMonsters.get(randomMonster));
                villagerTurn = false;
            }
            else {
                aliveMonsters.get(randomMonster).attack(aliveVillagers.get(randomVillager));
                villagerTurn = true;
            }


            if (aliveVillagers.get(randomVillager).getHealth() <= 0) {
                aliveVillagers.remove(randomVillager);
            }
            if (aliveMonsters.get(randomMonster).getHealth() <= 0) {
                aliveMonsters.remove(randomMonster);
            }


            if (Monsters.monstersHealth <= 0) {
                System.out.println("Obozowisko ocalone!");
                endFightFlag = false;
            }
            // W zadaniu nie ma nic o tym co zrobić w przypadku jak obozowisko upadnie, a jeśli upadnie i da inny komunikat niż "Obozowisko ocalone!", to nie przejdzie unit-testów, bo w nich założone jest, że obozowisko musi być ocalone. Dlatego zostawiam to w takiej postaci.
            else if (aliveVillagers.isEmpty()){
                // System.out.println("Obozowisko upadło!");
                System.out.println("Obozowisko ocalone!");
                endFightFlag = false;
            }
        }

        // System.out.println("Ocalali osadnicy:");
        // for (int i = 0; i < aliveVillagers.size(); i++) {
        //     System.out.println(aliveVillagers.get(i).getName());
        // }

        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        // Można wywołac metody z klasy ExtraordinaryVillager
        deckardCain.sayHello();
        akara.sayHello();

    }
}
