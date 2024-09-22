package ca.bcit.creature.yujin.jeong.codes;

/**
 * This class models Elf from a parent class Creature.
 * <p>
 * validateMana() to set range of mana between minMana and maxMana.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, health, and mana.
 * <p>
 * castSpell() to use skill "castSpell". Skill is unavailable to use when low mana.
 * <p>
 * restoreMana() to restore mana for using castSpell skill.
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1.0
 */
public class Elf extends Creature
{

    // Cannot make as final, because mana value changes the value under the conditions
    private       int mana;
    private final int minMana         = 0;
    private final int maxMana         = 50;
    private final int minManaUsage    = 5;
    private final int castSpellDamage = 10;

    /**
     * Creating a constructor. Validating name, date of birth, health, and mana in constructor.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     * @param mana        Elf's mana
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);

        this.mana = mana;

    }

    /**
     * Creating a method to set range of mana between minMana and maxMana.
     *
     * @param mana from elf
     */
    protected void validateMana(final int mana)
    {
        if(mana < minMana || mana > maxMana)
        {
            throw new IllegalArgumentException(String.format("Mana can't go below %d and above %d", minMana, maxMana));
        }
    }

    /**
     * Overrides the super method to prints the creature's name, dateOfBirth, age, health, and mana.
     *
     * @return creature's information in String
     */
    @Override
    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(super.getDetails());
        builder.append("\nMana: ");
        builder.append(mana);
        builder.append("\n");

        return builder.toString();
    }

    /**
     * Creating a method to use skill "castSpell". Skill is unavailable to use when low mana.
     *
     * @param anotherCreature attack another creature
     *
     * @throws LowManaException to make sure mana is enough to use castSpell
     */
    public void castSpell(Creature anotherCreature) throws LowManaException
    {
        if(mana >= minManaUsage)
        {
            mana -= minManaUsage;
            anotherCreature.takeDamage(castSpellDamage);
        }
        else
        {
            throw new LowManaException("Mana is not enough to cast spell :/");
        }
    }

    /**
     * Creating a method to restore mana for using castSpell skill.
     *
     * @param amount restore amount
     */
    protected void restoreMana(final int amount)
    {
        if((mana + amount) > maxMana)
        {
            mana = maxMana;
        }
        else
        {
            mana += amount;
        }

        // If mana go above maxMana set as maxMana
        if(mana > maxMana)
        {
            mana = maxMana;
        }
    }
}
