package net.mauchin.ma_hud.compornents;

public abstract class AbstractHUDComponent {
    public static class Alignment{
        public enum VerticalAlignment{
            TOP, BOTTOM, CENTER
        }
        public enum HorizontalAlignment{
            LEFT, RIGHT, CENTER
        }
        public VerticalAlignment verticalAlignment;
        public HorizontalAlignment horizontalAlignment;
        public Alignment(VerticalAlignment verticalAlignment, HorizontalAlignment horizontalAlignment){
            this.verticalAlignment = verticalAlignment;
            this.horizontalAlignment = horizontalAlignment;
        }
    }
    public int x;
    public int y;
    public Alignment screenAlignment;
    public Alignment componentAlignment;

    public AbstractHUDComponent(int x, int y, Alignment screenAlignment, Alignment componentAlignment){
        this.x = x;
        this.y = y;
        this.screenAlignment = screenAlignment;
        this.componentAlignment = componentAlignment;
    }
    public abstract void render();
    public abstract void tick();
}
