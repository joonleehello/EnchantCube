package com.joonseo.cubeenchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChangeOption implements CommandExecutor {

    private final Random random = new Random();

    private static class EnchantLevel{
        public final Enchantment enchant;
        public final int min;
        public final int max;

        public EnchantLevel(Enchantment enchant, int min, int max){
            this.enchant = enchant;
            this.min = min;
            this.max = max;
        }

        public int EnchantRandomLevel(Random a){
            return min + a.nextInt(max-min+1);
        }
    }

    private static final Map<String, EnchantLevel[]> EnchantTable = new HashMap<>();

    static {

        EnchantTable.put("SWORD", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.SHARPNESS, 1, 5),
                new EnchantLevel(Enchantment.SMITE, 1, 5),
                new EnchantLevel(Enchantment.BANE_OF_ARTHROPODS, 1, 5),
                new EnchantLevel(Enchantment.KNOCKBACK, 1, 2),
                new EnchantLevel(Enchantment.FIRE_ASPECT, 1, 2),
                new EnchantLevel(Enchantment.SWEEPING_EDGE, 1, 3),
                new EnchantLevel(Enchantment.LOOTING, 1, 3)
        });

        EnchantTable.put("TOOL", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.EFFICIENCY, 1, 5),
                new EnchantLevel(Enchantment.SILK_TOUCH, 1, 1),
                new EnchantLevel(Enchantment.FORTUNE, 1, 3)

        });

        EnchantTable.put("HELMET", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.FIRE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.BLAST_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.PROJECTILE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.THORNS, 1, 3),           //Armor Common Enchant(갑옷 공통 인첸트)
                new EnchantLevel(Enchantment.RESPIRATION, 1, 3),
                new EnchantLevel(Enchantment.AQUA_AFFINITY, 1, 1)
        });

        EnchantTable.put("CHESTPLATE", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.FIRE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.BLAST_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.PROJECTILE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.THORNS, 1, 3)        //Armor Common Enchant(갑옷 공통 인첸트)
        });

        EnchantTable.put("LEGGINGS", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.FIRE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.BLAST_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.PROJECTILE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.THORNS, 1, 3),           //Armor Common Enchant(갑옷 공통 인첸트)
                new EnchantLevel(Enchantment.SWIFT_SNEAK, 1, 3),
        });

        EnchantTable.put("BOOTS", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.FIRE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.BLAST_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.PROJECTILE_PROTECTION, 1, 4),
                new EnchantLevel(Enchantment.THORNS, 1, 3),           //Armor Common Enchant(갑옷 공통 인첸트)
                new EnchantLevel(Enchantment.FEATHER_FALLING, 1, 4),
                new EnchantLevel(Enchantment.DEPTH_STRIDER, 1, 3),
                new EnchantLevel(Enchantment.FROST_WALKER, 1, 2),
                new EnchantLevel(Enchantment.SOUL_SPEED, 1, 3)
        });

        EnchantTable.put("BOW", new EnchantLevel[]{
                new EnchantLevel(Enchantment.UNBREAKING, 1, 3),
                new EnchantLevel(Enchantment.MENDING, 1, 1),
                new EnchantLevel(Enchantment.BINDING_CURSE, 1, 1),
                new EnchantLevel(Enchantment.VANISHING_CURSE, 1, 1),   // Common Enchant(공통 인첸트)
                new EnchantLevel(Enchantment.POWER, 1, 5),
                new EnchantLevel(Enchantment.PUNCH, 1, 2),
                new EnchantLevel(Enchantment.FLAME, 1, 1),
                new EnchantLevel(Enchantment.INFINITY, 1, 2),
        });

    }

    private String getType(Material stuff){

        String name = stuff.name();

        if (name.endsWith("_SWORD")) return "SWORD";
        if (name.endsWith("_PICKAXE") || name.endsWith("_AXE") || name.endsWith("_SHOVEL") || name.endsWith("_PICKAXE") || name.endsWith("_HOE")) return "TOOL";
        if (name.endsWith("_HELMET")) return "HELMET";
        if (name.endsWith("_CHESTPLATE")) return "CHESTPLATE";
        if (name.endsWith("_LEGGINGS")) return "LEGGINGS";
        if (name.endsWith("_BOOTS")) return "BOOTS";
        if (name.endsWith("BOW")) return "BOW";

        return null;

    }




    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("플레이어만 이 명령어를 쓸 수 있습니다.");
            return true;
        }

        Player player = (Player) commandSender;

        if (player.getLevel() < 10) {

            player.sendMessage(ChatColor.LIGHT_PURPLE+"10 레벨이 필요합니다.");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()) {
            player.sendMessage(ChatColor.LIGHT_PURPLE+ "손에 아이템이 없습니다.");
            return true;
        }

        String type = getType(item.getType());

        if(type == null) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "이 아이템은 큐브 가능 아이템이 아닙니다.");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "가능 품목 : 검, 곡괭이, 삽, 도끼, 괭이, 갑옷류, 활");

            return true;
        }

        player.setLevel(player.getLevel() - 10);

        EnchantLevel[] list = EnchantTable.get(type);
        item.getEnchantments().keySet().forEach(item::removeEnchantment);

        int EnchantNum = 1+ random.nextInt(5);

        for (int i=0; i<EnchantNum; i++){
            EnchantLevel magic = list[random.nextInt(list.length)];
            int level = magic.EnchantRandomLevel(random);
            item.addUnsafeEnchantment(magic.enchant, level);

        }

        player.sendMessage(ChatColor.AQUA + "아이템의 옵션이 설정되었습니다.");
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 1.0f, 1.2f);

        return true;

    }
}
