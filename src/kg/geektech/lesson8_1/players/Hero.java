package kg.geektech.lesson8_1.players;

public abstract class Hero extends GameEntity
        implements HavingSuperPower {
    private AbilityType abilityType;

    public Hero(int health, int damage,
                AbilityType abilityType) {
        super(health, damage);
        this.setAbilityType(abilityType);
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }
}
