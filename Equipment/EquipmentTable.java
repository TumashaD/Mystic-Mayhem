package Equipment;

import Views.Block;
import Views.Board;

public class EquipmentTable {
    public static void equipmentTable(){
         // Creating the table
        Board board = new Board(100);

        // Title
        Block title = new Block(board, 60, 1, "Equipment");
        title.setDataAlign(Block.DATA_CENTER);
        title.allowGrid(false);
        board.setInitialBlock(title);

        //Armour
        Block armour = new Block(board, 30, 1,"ARMOUR");
        title.setBelowBlock(armour.setDataAlign(Block.DATA_CENTER));
        Block chainmail = new Block(board, 30, 6,"NAME: CHAINMAIL\n" +"PRICE: 70 gc\n" +"ATTACK: NO CHANGE\n"+"DEFENSE: +1\n" +"HEALTH: NO CHANGE\n"+"SPEED: -1");
        armour.setBelowBlock(chainmail);
        Block regalia = new Block(board, 30, 6,"NAME: REGALIA\n" +"PRICE: 105 gc\n"+"ATTACK: NO CHANGE\n" +"DEFENSE: +1\n"+"HEALTH: NO CHANGE\n"+"SPEED: NO CHANGE");
        chainmail.setBelowBlock(regalia);
        Block fleece = new Block(board, 30, 6,"NAME: FLEECE\n" +"PRICE: 150 gc\n"+"ATTACK: NO CHANGE\n" +"DEFENSE: +2\n" +"HEALTH: +1\n" +"SPEED: -1");
        regalia.setBelowBlock(fleece);

        //Artifacts
        Block artifacts = new Block(board, 30, 1,"ARTIFACTS");
        armour.setRightBlock(artifacts.setDataAlign(Block.DATA_CENTER));
        Block excalibur = new Block(board, 30, 6,"NAME: EXCALIBUR\n" +"PRICE: 150 gc\n" +"ATTACK: +2\n"+"DEFENCE: NO CHANGE\n" +"HEALTH: NO CHANGE\n" +"SPEED: NO CHANGE");
        artifacts.setBelowBlock(excalibur);
        Block amulet = new Block(board, 30, 6,"NAME: AMULET\n" +"PRICE: 200 gc\n" +"ATTACK: +1\n" +"DEFENSE: -1\n" +"HEALTH: +1\n" +"SPEED: +1");
        excalibur.setBelowBlock(amulet);
        Block crystal = new Block(board, 30, 6,"NAME: CRYSTAL\n" +"PRICE: 210 gc\n" +"ATTACK: +2\n" +"DEFENSE: +1\n" +"HEALTH: -1\n" +"SPEED: -1");
        amulet.setBelowBlock(crystal);

        System.out.println(board.invalidate().build().getPreview());
    }
}
