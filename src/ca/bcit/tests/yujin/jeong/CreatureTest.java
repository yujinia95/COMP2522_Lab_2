package ca.bcit.tests.yujin.jeong;

import ca.bcit.creature.yujin.jeong.*;

/**
 * Test class
 *
 * @author Yujin Jeong
 * @version 1.0
 */
public class CreatureTest
{

    public static void main(final String[] args)
    {

        final Date dragonBirth;
        final Date elfBirth;
        final Date orcBirth;

        final Creature       dragon;
        final Creature       elf;
        final Creature       orc;
        final CreatureHealer healer;

        dragonBirth = new Date(1150, 7, 25);
        elfBirth    = new Date(1300, 2, 2);
        orcBirth    = new Date(1400, 10, 18);

        dragon = new Dragon("Vermithor", dragonBirth, 100, 100);
        elf    = new Elf("Elfie", elfBirth, 100, 5);
        orc    = new Orc("Rachad ", orcBirth, 100, 25);
        // The reason why I set 0 is, method healCreature will randomly heal creatures 1 to 100.
        healer = new CreatureHealer(0);

        // Printing detail information of each creature.
        System.out.println(dragon.getDetails());
        System.out.println(elf.getDetails());
        System.out.println(orc.getDetails());

        System.out.println();

        // Determining exact class of each creature objects.
        System.out.println(dragon.getClass());
        System.out.println(elf.getClass());
        System.out.println(orc.getClass());

        // Dragon attack elf (Using checked)
        try
        {
            ((Dragon) dragon).breatheFire(elf);
        }
        catch(LowFirePowerException e)
        {
            System.out.println(e.getMessage());
        }

        // Dragon attack elf (Using checked)
        try
        {
            ((Dragon) dragon).breatheFire(elf);
        }
        catch(LowFirePowerException e)
        {
            System.out.println(e.getMessage());
        }

        // Elf attack orc (Using checked)
        try
        {
            ((Elf) elf).castSpell(orc);
        }
        catch(LowManaException e)
        {
            System.out.println(e.getMessage());
        }

        // Orc attack Dragon
        ((Orc) orc).berserk(dragon);

        System.out.println();
        // Printing new health statuses for creatures
        System.out.println("Updated health and power after attack");
        System.out.println();

        System.out.println(dragon.getDetails());
        System.out.println(elf.getDetails());
        System.out.println(orc.getDetails());

        // CreatureHealer heals elf (Using checked)
        try
        {
            healer.healCreature(elf);
        }
        catch(HealingException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println();
        // Printing new health statuses for creatures
        System.out.println("Updated health after healing");
        System.out.println();

        System.out.println(dragon.getDetails());
        System.out.println(elf.getDetails());
        System.out.println(orc.getDetails());

    }
}