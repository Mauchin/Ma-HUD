package net.mauchin.ma_hud.alignments;

public enum HorizontalAlignment{
    LEFT(0), CENTER(1), RIGHT(2);
    private final int id;
    HorizontalAlignment(int id) { this.id = id; }
    public int getValue() { return id; }
    public float getMultiplier() {return (float)id/2;}
}