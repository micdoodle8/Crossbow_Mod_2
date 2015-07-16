//package micdoodle8.mods.crossbowmod;
//
//import java.util.HashMap;
//import java.util.Map.Entry;
//import java.util.Set;
//import micdoodle8.mods.crossbowmod.item.CrossbowInfo;
//import micdoodle8.mods.crossbowmod.item.CrossbowItems;
//import micdoodle8.mods.crossbowmod.util.CrossbowRecipes;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import codechicken.nei.PositionedStack;
//import codechicken.nei.api.API;
//import codechicken.nei.api.IConfigureNEI;
//
//public class NEICrossbowModConfig implements IConfigureNEI
//{
//    private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> crossbowModRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();
//
//    @Override
//    public void loadConfig()
//    {
//        this.registerRecipes();
//        API.registerRecipeHandler(new CrossbowModRecipeHandler());
//        API.registerUsageHandler(new CrossbowModRecipeHandler());
//    }
//
//    public void registerRecipes()
//    {
//        for (Entry<CrossbowInfo, ItemStack> recipe : CrossbowRecipes.getRecipeMap().entrySet())
//        {
//            HashMap<Integer, PositionedStack> input = new HashMap<Integer, PositionedStack>();
//
//            ItemStack limbStack = null;
//
//            switch(recipe.getKey().getMaterial())
//            {
//            case wooden:
//                limbStack = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 5);
//                break;
//            case stone:
//                limbStack = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 6);
//                break;
//            case iron:
//                limbStack = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 7);
//                break;
//            case gold:
//                limbStack = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 8);
//                break;
//            case diamond:
//                limbStack = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 9);
//                break;
//            default:
//                limbStack = null;
//                continue;
//            }
//
//            if (limbStack != null)
//            {
//                input.put(0, new PositionedStack(limbStack.copy(), 29 + 18, 23));
//                input.put(1, new PositionedStack(limbStack.copy(), 29, 41));
//                input.put(2, new PositionedStack(limbStack.copy(), 29, 59));
//                input.put(3, new PositionedStack(limbStack.copy(), 29, 77));
//                input.put(4, new PositionedStack(limbStack.copy(), 29 + 18, 95));
//            }
//
//            input.put(5, new PositionedStack(new ItemStack(Item.stick), 29 + 18 * 1, 59));
//            input.put(6, new PositionedStack(new ItemStack(Item.stick), 29 + 18 * 2, 59));
//            input.put(7, new PositionedStack(new ItemStack(Item.stick), 29 + 18 * 3, 59));
//
//            ItemStack mechanism = null;
//
//            switch(recipe.getKey().getFireRate())
//            {
//            case none:
//                mechanism = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 10);
//                break;
//            case light:
//                mechanism = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 11);
//                break;
//            case medium:
//                mechanism = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 12);
//                break;
//            case heavy:
//                mechanism = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 13);
//                break;
//            case tri:
//                mechanism = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 23);
//                break;
//            default:
//                mechanism = null;
//                continue;
//            }
//
//            if (mechanism != null)
//            {
//                input.put(8, new PositionedStack(mechanism.copy(), 29 - 18, 59));
//            }
//
//            ItemStack attachment = null;
//
//            switch(recipe.getKey().getAttachment())
//            {
//            case none:
//                attachment = null;
//                break;
//            case shortscope:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 14);
//                break;
//            case longscope:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 15);
//                break;
//            case flame:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 16);
//                break;
//            case explosive:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 17);
//                break;
//            case lava:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 18);
//                break;
//            case ice:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 19);
//                break;
//            case lightning:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 20);
//                break;
//            case torch:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 21);
//                break;
//            case poison:
//                attachment = new ItemStack(CrossbowItems.attachmentLimbBolt, 1, 22);
//                break;
//            default:
//                attachment = null;
//                continue;
//            }
//
//            if (attachment != null)
//            {
//                input.put(9, new PositionedStack(attachment.copy(), 82, 23));
//            }
//
//            crossbowModRecipes.put(input, new PositionedStack(recipe.getValue(), 137, 59));
//        }
//    }
//
//    @Override
//    public String getName()
//    {
//        return "Crossbow Mod NEI Plugin";
//    }
//
//    @Override
//    public String getVersion()
//    {
//        return "1.0";
//    }
//
//    public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getCrossbowModRecipes()
//    {
//        return crossbowModRecipes.entrySet();
//    }
//}
