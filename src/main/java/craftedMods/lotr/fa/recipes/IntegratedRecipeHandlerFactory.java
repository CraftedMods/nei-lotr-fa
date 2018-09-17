/*******************************************************************************
 * Copyright (C) 2018 CraftedMods (see https://github.com/CraftedMods)
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

import craftedMods.lotr.fa.recipes.recipeHandlers.*;
import craftedMods.recipes.api.*;
import lotr.common.entity.npc.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityList;
import net.minecraft.item.crafting.IRecipe;
import valiec.lotrfa.FARecipes;
import valiec.lotrfa.entities.*;

@RegisteredHandler
public class IntegratedRecipeHandlerFactory implements RecipeHandlerFactory {

	private static final String FACTION_BELEGOST = "belegost";
	private static final String FACTION_BOR = "bor";
	private static final String FACTION_BRETHIL = "brethil";
	private static final String FACTION_DOR_DAEDELOTH = "dor_daedeloth";
	private static final String FACTION_DOR_LOMIN = "dor_lomin";
	private static final String FACTION_DORIATH = "doriath";
	private static final String FACTION_GONDOLIN = "gondolin";
	private static final String FACTION_GULDAR = "guldar";
	private static final String FACTION_HITHLUM = "hithlum";
	private static final String FACTION_LADROS = "ladros";
	private static final String FACTION_LAIQUENDIN = "laiquendin";
	private static final String FACTION_NARGOTHROND = "nargothrond";
	private static final String FACTION_NOGROD = "nogrod";
	private static final String FACTION_RED_DWARF = "red_dwarf";
	private static final String FACTION_TORMENTED_ELF = "tormented_elf";
	private static final String FACTION_ULFANG = "ulfang";

	private static final Set<RecipeHandler<?>> recipeHandlers = new HashSet<>();

	static {
		// FA crafting tables
		IntegratedRecipeHandlerFactory.registerFACTHandler("ladros", FARecipes.LadrosGui.class, FARecipes.ladrosRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("dor_lomin", FARecipes.DorLominGui.class, FARecipes.dorLominRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("brethil", FARecipes.BrethilGui.class, FARecipes.brethilRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("falas", FARecipes.FalasGui.class, FARecipes.falasRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("nargothrond", FARecipes.NargothrondGui.class, FARecipes.nargothrondRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("feanorean", FARecipes.FeanoreanGui.class, FARecipes.feanoreanRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("valinor", FARecipes.ValinorGui.class, FARecipes.valinorRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("red_dwarf", FARecipes.RedDwarvenGui.class, FARecipes.redDwarvenRecipes);

		// FA traders
		registerTraderHandler(LOTREntityBelegostGoldsmith.class, FACTION_BELEGOST, LOTRFATrades.belegost_goldsmith_sell, LOTRFATrades.belegost_goldsmith_buy);
		registerTraderHandler(LOTREntityBorBartender.class, FACTION_BOR, LOTRFATrades.bor_bartender_sell, LOTRFATrades.bor_bartender_buy);
		registerTraderHandler(LOTREntityBorFarmer.class, FACTION_BOR, LOTRFATrades.bor_farmer_sell, LOTRFATrades.bor_farmer_buy);
		registerTraderHandler(LOTREntityBorGreengrocer.class, FACTION_BOR, LOTRFATrades.bor_greengrocer_sell, LOTRFATrades.bor_greengrocer_buy);
		registerTraderHandler(LOTREntityBrethilButcher.class, FACTION_BRETHIL, LOTRFATrades.brethil_butcher_sell, LOTRFATrades.brethil_butcher_buy);
		registerTraderHandler(LOTREntityBrethilLumberman.class, FACTION_BRETHIL, LOTRFATrades.brethil_lumberman_sell, LOTRFATrades.brethil_lumberman_buy);
		registerTraderHandler(LOTREntityBrethilSmith.class, FACTION_BRETHIL, LOTRFATrades.brethil_smith_sell, LOTRFATrades.brethil_smith_buy);
		registerTraderHandler(LOTREntityDorDaedelothHuntsman.class, FACTION_DOR_DAEDELOTH, LOTRFATrades.dor_daedeloth_huntsman_sell,
				LOTRFATrades.dor_daedeloth_huntsman_buy);
		registerTraderHandler(LOTREntityDorDaedelothScavenger.class, FACTION_DOR_DAEDELOTH, LOTRFATrades.dor_daedeloth_scavenger_sell,
				LOTRFATrades.dor_daedeloth_scavenger_buy);
		registerTraderHandler(LOTREntityDorLominBrewer.class, FACTION_DOR_LOMIN, LOTRFATrades.dor_lomin_brewer_sell, LOTRFATrades.dor_lomin_brewer_buy);
		registerTraderHandler(LOTREntityDorLominSmith.class, FACTION_DOR_LOMIN, LOTRFATrades.dor_lomin_smith_sell, LOTRFATrades.dor_lomin_smith_buy);
		registerTraderHandler(LOTREntityDoriathBaker.class, FACTION_DORIATH, LOTRFATrades.doriath_baker_sell, LOTRFATrades.doriath_baker_buy);
		registerTraderHandler(LOTREntityDoriathHuntsman.class, FACTION_DORIATH, LOTRFATrades.doriath_huntsman_sell, LOTRFATrades.doriath_huntsman_buy);
		registerTraderHandler(LOTREntityDoriathLumberman.class, FACTION_DORIATH, LOTRFATrades.doriath_lumberman_sell, LOTRFATrades.doriath_lumberman_buy);
		registerTraderHandler(LOTREntityFeanoreanSmith.class, "feanorean", LOTRFATrades.feanorean_smith_sell, LOTRFATrades.feanorean_smith_buy);
		registerTraderHandler(LOTREntityFeanorianStablemaster.class, "feanorian", LOTRFATrades.feanorian_stablemaster_sell,
				LOTRFATrades.feanorian_stablemaster_buy);
		registerTraderHandler(LOTREntityGondolinFlorist.class, FACTION_GONDOLIN, LOTRFATrades.gondolin_florist_sell, LOTRFATrades.gondolin_florist_buy);
		registerTraderHandler(LOTREntityGondolinSmith.class, FACTION_GONDOLIN, LOTRFATrades.gondolin_smith_sell, LOTRFATrades.gondolin_smith_buy);
		registerTraderHandler(LOTREntityGondolinStonemason.class, FACTION_GONDOLIN, LOTRFATrades.gondolin_stonemason_sell,
				LOTRFATrades.gondolin_stonemason_buy);
		registerTraderHandler(LOTREntityGuldarLumberman.class, FACTION_GULDAR, LOTRFATrades.guldar_lumberman_sell, LOTRFATrades.guldar_lumberman_buy);
		registerTraderHandler(LOTREntityHithlumFlorist.class, FACTION_HITHLUM, LOTRFATrades.hithlum_florist_sell, LOTRFATrades.hithlum_florist_buy);
		registerTraderHandler(LOTREntityHithlumGreengrocer.class, FACTION_HITHLUM, LOTRFATrades.hithlum_greengrocer_sell, LOTRFATrades.hithlum_greengrocer_buy);
		registerTraderHandler(LOTREntityHithlumVinekeeper.class, FACTION_HITHLUM, LOTRFATrades.hithlum_vinekeeper_sell, LOTRFATrades.hithlum_vinekeeper_buy);
		registerTraderHandler(LOTREntityHithlumVintnerElf.class, FACTION_HITHLUM, LOTRTradeEntries.DORWINION_VINTNER_SELL,
				LOTRFATrades.hithlum_vintner_elf_buy);
		registerTraderHandler(LOTREntityLadrosBrewer.class, FACTION_LADROS, LOTRFATrades.ladros_brewer_sell, LOTRFATrades.ladros_brewer_buy);
		registerTraderHandler(LOTREntityLadrosFarmer.class, FACTION_LADROS, LOTRFATrades.ladros_farmer_sell, LOTRFATrades.ladros_farmer_buy);
		registerTraderHandler(LOTREntityLadrosSmith.class, FACTION_LADROS, LOTRFATrades.ladros_smith_sell, LOTRFATrades.ladros_smith_buy);
		registerTraderHandler(LOTREntityLadrosVinekeeper.class, FACTION_LADROS, LOTRFATrades.ladros_vinekeeper_sell, LOTRFATrades.ladros_vinekeeper_buy);
		registerTraderHandler(LOTREntityLaiquendinFlorist.class, FACTION_LAIQUENDIN, LOTRFATrades.laiquendin_florist_sell, LOTRFATrades.laiquendin_florist_buy);
		registerTraderHandler(LOTREntityLaiquendinHuntsman.class, FACTION_LAIQUENDIN, LOTRFATrades.laiquendin_huntsman_sell,
				LOTRFATrades.laiquendin_huntsman_buy);
		registerTraderHandler(LOTREntityLaiquendinLumberman.class, FACTION_LAIQUENDIN, LOTRFATrades.laiquendin_lumberman_sell,
				LOTRFATrades.laiquendin_lumberman_buy);
		registerTraderHandler(LOTREntityNargothrondGoldsmith.class, FACTION_NARGOTHROND, LOTRFATrades.nargothrond_goldsmith_sell,
				LOTRFATrades.nargothrond_goldsmith_buy);
		registerTraderHandler(LOTREntityNargothrondStonemason.class, FACTION_NARGOTHROND, LOTRFATrades.nargothrond_stonemason_sell,
				LOTRFATrades.nargothrond_stonemason_buy);
		registerTraderHandler(LOTREntityNogrodStonemason.class, FACTION_NOGROD, LOTRFATrades.nogrod_stonemason_sell, LOTRFATrades.nogrod_stonemason_buy);
		registerTraderHandler(LOTREntityRedDwarfSmith.class, FACTION_RED_DWARF, LOTRFATrades.red_dwarf_smith_sell, LOTRFATrades.red_dwarf_smith_buy);
		registerTraderHandler(LOTREntityTormentedElfSmith.class, FACTION_TORMENTED_ELF, LOTRFATrades.tormented_elf_smith_sell,
				LOTRFATrades.tormented_elf_smith_buy);
		registerTraderHandler(LOTREntityTormentedElfStonemason.class, FACTION_TORMENTED_ELF, LOTRFATrades.tormented_elf_stonemason_sell,
				LOTRFATrades.tormented_elf_stonemason_buy);
		registerTraderHandler(LOTREntityUlfangBrewer.class, FACTION_ULFANG, LOTRFATrades.ulfang_brewer_sell, LOTRFATrades.ulfang_brewer_buy);
		registerTraderHandler(LOTREntityUlfangButcher.class, FACTION_ULFANG, LOTRFATrades.ulfang_butcher_sell, LOTRFATrades.ulfang_butcher_buy);
		registerTraderHandler(LOTREntityUlfangFarmer.class, FACTION_ULFANG, LOTRFATrades.ulfang_farmer_sell, LOTRFATrades.ulfang_farmer_buy);
		registerTraderHandler(LOTREntityUlfangHuntsman.class, FACTION_ULFANG, LOTRFATrades.ulfang_huntsman_sell, LOTRFATrades.ulfang_huntsman_buy);
		registerTraderHandler(LOTREntityUlfangLumberman.class, FACTION_ULFANG, LOTRFATrades.ulfang_lumberman_sell, LOTRFATrades.ulfang_lumberman_buy);
		registerTraderHandler(LOTREntityUlfangSmith.class, FACTION_ULFANG, LOTRFATrades.ulfang_smith_sell, LOTRFATrades.ulfang_smith_buy);

		// FA alloy forges
		IntegratedRecipeHandlerFactory.recipeHandlers
				.add(new FAAlloyForgeRecipeHandler("fa.redDwarven", new FAAlloyForgeRecipeHandler.RedDwarvenAlloyForgeAccess()));
	}

	private static void registerFACTHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, Collection<IRecipe> recipes) {
		IntegratedRecipeHandlerFactory.recipeHandlers.add(new FACraftingTableRecipeHandler(unlocalizedName, guiClass, recipes));
	}

	private static void registerTraderHandler(Class<? extends LOTRTradeable> entityClass, String faction, LOTRTradeEntries itemsBought,
			LOTRTradeEntries itemsSold) {
		IntegratedRecipeHandlerFactory.recipeHandlers.add(
				new FATraderRecipeHandler(EntityList.classToStringMapping.get(entityClass).toString().replace("lotr.", ""), faction, itemsBought, itemsSold));
	}

	@Override
	public Set<RecipeHandler<?>> getRecipeHandlers() {
		return IntegratedRecipeHandlerFactory.recipeHandlers;
	}

}
