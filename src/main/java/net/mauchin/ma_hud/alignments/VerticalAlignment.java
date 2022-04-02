package net.mauchin.ma_hud.alignments;

public enum VerticalAlignment{
    TOP(0), CENTER(1), BOTTOM(2);
    private final int id;
    VerticalAlignment(int id) { this.id = id; }
    public int getValue() { return id; }
    public float getMultiplier() {return (float)id/2;}
}
