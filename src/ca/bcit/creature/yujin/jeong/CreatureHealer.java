package ca.bcit.creature.yujin.jeong;

import java.util.Random;

/**
 * This class models a creature healer.
 * <p>
 * healCreature() to heal creature randomly from 1 to 100.
 * <p>
 * * @author Yujin Jeong
 * * @version 1.0
 */
public class CreatureHealer
{

    private int healAmount;

    public CreatureHealer(final int healAmount)
    {
        this.healAmount = healAmount;
    }

    /**
     * Creating a method to heal creature randomly from 1 to 100.
     *
     * @param anotherCreature creature (Dragon, Elf, and Orc)
     *
     * @throws HealingException set healing range to make sure not go below 0 (Check Creature class)
     */
    public void healCreature(Creature anotherCreature) throws HealingException
    {
        Random random;

        random = new Random();

        // Range from 1 to 100
        healAmount = random.nextInt(100) + 1;

        anotherCreature.heal(healAmount);

    }
}
