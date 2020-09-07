/*******************************************************************************
 * Copyright (C) 2020 CraftedMods (see https://github.com/CraftedMods)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package craftedMods.lotr.fa.recipes;

import java.util.*;

import craftedMods.recipes.api.*;
import eoa.lotrfa.common.block.LOTRFABlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

@RegisteredHandler
public class FAItemHidingHandler implements ItemHidingHandler {

	private static final Collection<ItemStack> hiddenStacks = new ArrayList<>();

	@Override
	public Collection<ItemStack> getHiddenStacks() {
		FAItemHidingHandler.hiddenStacks.clear();

		// Slabs

		this.hideItemMeta (LOTRFABlocks.slabSingleBlackstone, 5);
		this.hideItemMeta (LOTRFABlocks.slabSingleDirt, 1);
		this.hideItemMeta (LOTRFABlocks.slabSingleGravel, 2);
		this.hideItemMeta (LOTRFABlocks.slabSingleLithond, 5);
		this.hideItemMeta (LOTRFABlocks.slabSingleLummond, 4);
		this.hideItemMeta (LOTRFABlocks.slabSingleRockAngband, 2);
		this.hideItemMeta(LOTRFABlocks.slabSingleWood, 8);
		this.hideItemMeta(LOTRFABlocks.slabSingleWool, 8);
		this.hideItemMeta(LOTRFABlocks.slabSingleWool2, 8);

		// Double slabs
		this.hideItemAll (LOTRFABlocks.slabDoubleBlackstone);
        this.hideItemAll (LOTRFABlocks.slabDoubleDirt);
        this.hideItemAll (LOTRFABlocks.slabDoubleGravel);
        this.hideItemAll (LOTRFABlocks.slabDoubleLithond);
        this.hideItemAll (LOTRFABlocks.slabDoubleLummond);
        this.hideItemAll (LOTRFABlocks.slabDoubleRockAngband);
		this.hideItemAll(LOTRFABlocks.slabDoubleWood);
		this.hideItemAll(LOTRFABlocks.slabDoubleWool);
		this.hideItemAll(LOTRFABlocks.slabDoubleWool2);
		
		//Beds
		this.hideItemAll (LOTRFABlocks.doriathBed);
		this.hideItemAll (LOTRFABlocks.laegrimBed);
		this.hideItemAll (LOTRFABlocks.falathrimBed);
		this.hideItemAll (LOTRFABlocks.feanorianBed);
		this.hideItemAll (LOTRFABlocks.hithlumBed);
		this.hideItemAll (LOTRFABlocks.nargothrondBed);
		this.hideItemAll (LOTRFABlocks.gondolinBed);

		return FAItemHidingHandler.hiddenStacks;
	}
	
	private void hideItemMeta(ItemStack stack, int min) {
		for (int i = min; i < 16; i++) {
			FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, i));
		}
	}

	private void hideItemMeta(Block block, int min) {
		this.hideItemMeta(new ItemStack(block), min);
	}
	
//	private void hideItemMeta(Block block) {
//        this.hideItemMeta(new ItemStack(block), 8);
//    }

	// private void hideItemMeta(Item item) {
	// this.hideItemMeta(new ItemStack(item));
	// }

	private void hideItemAll(ItemStack stack) {
		FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, 32767));
	}

	private void hideItemAll(Block block) {
		this.hideItemAll(new ItemStack(block));
	}

	// private void hideItemAll(Item item) {
	// this.hideItemAll(new ItemStack(item));
	// }

}
