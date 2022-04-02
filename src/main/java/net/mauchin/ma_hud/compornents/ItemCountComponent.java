package net.mauchin.ma_hud.compornents;

import net.mauchin.ma_hud.MaHUD;
import net.mauchin.ma_hud.alignments.Alignment;
import net.mauchin.ma_hud.grids.GridLocation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.text.DecimalFormat;

public class ItemCountComponent extends AbstractHUDComponent{
    public Item item;
    public ItemCountComponent(Item item) {
        this.item = item;
    }

    public int getCount(){
        int count = 0;
        if (MinecraftClient.getInstance().player != null) {
            for (ItemStack itemStack :MinecraftClient.getInstance().player.getInventory().main){
                if (itemStack.getItem() == item){
                    count += itemStack.getCount();
                }
            }
        }
        return count;
    }
    public double getRate(){
        if (MaHUD.time > 0) {
            return (double) this.getCount() * 20 * 60 / MaHUD.time;
        }
        return 0D;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return 2;
    }

    @Override
    public void render(MatrixStack matrices, int x, int y) {
        MinecraftClient.getInstance().getItemRenderer().renderInGuiWithOverrides(item.getDefaultStack(),x,y,0,-1);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        Text count = new LiteralText(String.valueOf(getCount()));
        Text rate = new LiteralText(new DecimalFormat("0.00").format(this.getRate())+"/min");
        matrices.translate(0.0D, 0.0D, 200.0D);
        textRenderer.drawWithShadow(matrices, count,(float) x+getRenderWidth()/2,(float) y+9, 0xffffff);
        textRenderer.drawWithShadow(matrices, rate,(float) x+getRenderWidth()/2,(float) y+1, 0xffffff);
    }
    @Override
    public void tick() {

    }
}
