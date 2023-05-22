package efs.task.oop;

public class ExtraordinaryVillager extends Villager{

    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");


        private String skillName;


        Skill(String skillName) {
            this.skillName = skillName;
        }


        public String getSkillName() {
            return skillName;
        }
    }


    private Skill skill;


    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
        this.health = 0;
    }

    
    @Override
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old. " + skill.getSkillName());
    }


    @Override
    public void attack(Fighter victim) {
        // victim.takeHit(0);
    }


    @Override
    public void takeHit(int damage) {
        super.takeHit(getHealth());
    }
}
