package net.legiblesleet827.platinum.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> PLATINUM_ORE = register("platinum_ore", () ->
            new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(100, 1200)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = register("deepslate_platinum_ore", () ->
            new OreBlock(BlockBehaviour.Properties.copy(PLATINUM_ORE.get())
                    .color(MaterialColor.DEEPSLATE)
                    .strength(200, 2400)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = register("platinum_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () ->
                new BlockItem(ret.get(), new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
        return ret;
    }
}