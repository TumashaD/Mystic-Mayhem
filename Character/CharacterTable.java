package Character;

import Views.Block;
import Views.Board;

public class CharacterTable {
    public static void characterTable(){
         // Creating the table
        Board board = new Board(120);

        // Title
        Block title = new Block(board, 105, 1, "Characters");
        title.setDataAlign(Block.DATA_CENTER);
        title.allowGrid(false);
        board.setInitialBlock(title);

        //Archers
        Block archers = new Block(board, 20, 1,"ARCHERS");
        title.setBelowBlock(archers.setDataAlign(Block.DATA_CENTER));      
        Block shooter = new Block(board, 20, 6,"NAME: SHOOTER\n" +"PRICE: 80 gc\n" +"ATTACK: 11\n" +"DEFENSE: 4\n" +"HEALTH: 6\n" +"SPEED: 9");
        archers.setBelowBlock(shooter);
        Block ranger = new Block(board, 20, 6,"NAME: RANGER\n" +"PRICE: 115 gc\n" +"ATTACK: 14\n" +"DEFENSE: 5\n" +"HEALTH: 8\n" +"SPEED: 10");
        shooter.setBelowBlock(ranger);
        Block sunfire = new Block(board, 20, 6,"NAME: SUNFIRE\n" +"PRICE: 160 gc\n" +"ATTACK: 15\n" +"DEFENSE: 5\n" +"HEALTH: 7\n" +"SPEED: 14");
        ranger.setBelowBlock(sunfire);
        Block zing = new Block(board, 20, 6,"NAME: ZING\n" +"PRICE: 200 gc\n" +"ATTACK: 16\n" +"DEFENSE: 9\n" +"HEALTH: 11\n" +"SPEED: 14");
        sunfire.setBelowBlock(zing);
        Block saggitarius = new Block(board, 20, 6,"NAME: SAGGITARIUS\n" +"PRICE: 230 gc\n" +"ATTACK: 18\n" +"DEFENSE: 7\n" +"HEALTH: 12\n" +"SPEED: 17");
        zing.setBelowBlock(saggitarius);
        
        //Knights
        Block knights = new Block(board, 20, 1,"KNIGHTS");
        archers.setRightBlock(knights.setDataAlign(Block.DATA_CENTER));
        Block squire = new Block(board, 20, 6,"NAME: SQUIRE\n" +"PRICE: 85 gc\n" +"ATTACK: 8\n" +"DEFENSE: 9\n" +"HEALTH: 7\n" +"SPEED: 8");
        knights.setBelowBlock(squire);
        Block cavalier = new Block(board, 20, 6,"NAME: CAVALIER\n" +"PRICE: 110 gc\n" +"ATTACK: 10\n" +"DEFENSE: 12\n" +"HEALTH: 7\n" +"SPEED: 10");
        squire.setBelowBlock(cavalier);
        Block templar = new Block(board, 20, 6,"NAME: TEMPLAR\n" +"PRICE: 155 gc\n" +"ATTACK: 14\n" +"DEFENSE: 16\n" +"HEALTH: 12\n" +"SPEED: 12");
        cavalier.setBelowBlock(templar);
        Block zoro = new Block(board, 20, 6,"NAME: ZORO\n" +"PRICE: 180 gc\n" +"ATTACK: 17\n" +"DEFENSE: 16\n" +"HEALTH: 13\n" +"SPEED: 14");
        templar.setBelowBlock(zoro);
        Block swiftblade = new Block(board, 20, 6,"NAME: SWIFTBLADE\n" +"PRICE: 250 gc\n" +"ATTACK: 18\n" +"DEFENSE: 20\n" +"HEALTH: 17\n" +"SPEED: 13");
        zoro.setBelowBlock(swiftblade);

        //Mages
        Block mages = new Block(board, 20, 1,"MAGES");
        knights.setRightBlock(mages.setDataAlign(Block.DATA_CENTER));
        Block warlock = new Block(board, 20, 6,"NAME: WARLOCK\n" +"PRICE: 100 gc\n" +"ATTACK: 12\n" +"DEFENSE: 7\n" +"HEALTH: 10\n" +"SPEED: 12");
        mages.setBelowBlock(warlock);
        Block sorcerer = new Block(board, 20, 6,"NAME: ILLUSIONIST\n" +"PRICE: 120 gc\n" +"ATTACK: 13\n" +"DEFENSE: 8\n" +"HEALTH: 12\n" +"SPEED: 14");
        warlock.setBelowBlock(sorcerer);
        Block enchanter = new Block(board, 20, 6,"NAME: ENCHANTER\n" +"PRICE: 160 gc\n" +"ATTACK: 16\n" +"DEFENSE: 10\n" +"HEALTH: 13\n" +"SPEED: 16");
        sorcerer.setBelowBlock(enchanter);
        Block conjurer = new Block(board, 20, 6,"NAME: CONJURER\n" +"PRICE: 195 gc\n" +"ATTACK: 18\n" +"DEFENSE: 15\n" +"HEALTH: 14\n" +"SPEED: 12");
        enchanter.setBelowBlock(conjurer);
        Block eldritch = new Block(board, 20, 6,"NAME: ELDRITCH\n" +"PRICE: 270 gc\n" +"ATTACK: 19\n" +"DEFENSE: 17\n" +"HEALTH: 18\n" +"SPEED: 14");
        conjurer.setBelowBlock(eldritch);

        //Healers
        Block healers = new Block(board, 20, 1,"HEALERS");
        mages.setRightBlock(healers.setDataAlign(Block.DATA_CENTER));
        Block soother = new Block(board, 20, 6,"NAME: SOOTHER\n" +"PRICE: 95 gc\n" +"ATTACK: 10\n" +"DEFENSE: 8\n" +"HEALTH: 9\n" +"SPEED: 6");
        healers.setBelowBlock(soother);
        Block medic = new Block(board, 20, 6,"NAME: MEDIC\n" +"PRICE: 125 gc\n" +"ATTACK: 12\n" +"DEFENSE: 9\n" +"HEALTH: 10\n" +"SPEED: 7");
        soother.setBelowBlock(medic);
        Block alchemist = new Block(board, 20, 6,"NAME: ALCHEMIST\n" +"PRICE: 150 gc\n" +"ATTACK: 13\n" +"DEFENSE: 13\n" +"HEALTH: 13\n" +"SPEED: 13");
        medic.setBelowBlock(alchemist);
        Block saint = new Block(board, 20, 6,"NAME: SAINT\n" +"PRICE: 200 gc\n" +"ATTACK: 16\n" +"DEFENSE: 14\n" +"HEALTH: 17\n" +"SPEED: 9");
        alchemist.setBelowBlock(saint);
        Block lightbringer = new Block(board, 20, 6,"NAME: LIGHTBRINGER\n" +"PRICE: 260 gc\n" +"ATTACK: 17\n" +"DEFENSE: 15\n" +"HEALTH: 19\n" +"SPEED: 12");
        saint.setBelowBlock(lightbringer);
        
        Block mythicalCreatures = new Block(board, 30, 1,"MYTHICAL CREATURES");
        healers.setRightBlock(mythicalCreatures.setDataAlign(Block.DATA_CENTER));
        Block dragon = new Block(board, 30, 6,"NAME: DRAGON\n" +"PRICE: 120 gc\n" +"ATTACK: 12\n" +"DEFENSE: 14\n" +"HEALTH: 15\n" +"SPEED: 8");
        mythicalCreatures.setBelowBlock(dragon);
        Block basilisk = new Block(board, 30, 6,"NAME: BASILISK\n" +"PRICE: 165 gc\n" +"ATTACK: 15\n" +"DEFENSE: 11\n" +"HEALTH: 10\n" +"SPEED: 12");
        dragon.setBelowBlock(basilisk);
        Block hydra = new Block(board, 30, 6,"NAME: HYDRA\n" +"PRICE: 205 gc\n" +"ATTACK: 12\n" +"DEFENSE: 16\n" +"HEALTH: 15\n" +"SPEED: 11");
        basilisk.setBelowBlock(hydra);
        Block phoenix = new Block(board, 30, 6,"NAME: PHOENIX\n" +"PRICE: 275 gc\n" +"ATTACK: 17\n" +"DEFENSE: 13\n" +"HEALTH: 17\n" +"SPEED: 19");
        hydra.setBelowBlock(phoenix);
        Block pegasus = new Block(board, 30, 6,"NAME: PEGASUS\n" +"PRICE: 340 gc\n" +"ATTACK: 14\n" +"DEFENSE: 18\n" +"HEALTH: 20\n" +"SPEED: 20");
        phoenix.setBelowBlock(pegasus);
     
        System.out.println(board.invalidate().build().getPreview());
    }
}
