package minegame159.meteorclient.rendering;

import net.minecraft.client.render.VertexFormat;

public enum DrawMode {
    Triangles,
    Lines;

    public VertexFormat.DrawMode toVertexFormat() {
        if (this == Triangles) return VertexFormat.DrawMode.TRIANGLES;
        return VertexFormat.DrawMode.LINES;
    }
}
