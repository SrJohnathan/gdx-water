package br.com.johnathan.gdxwater.desktop;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;


public class TextureLoade {
    private static final int BYTES_PER_PIXEL = 4;//3 for RGB, 4 for RGBA
    public static int loadTexture(String fileName){
        Texture texture = null;
        try {
            texture = TextureLoader.getTexture("PNG", new FileInputStream(fileName));
            GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL14.GL_TEXTURE_LOD_BIAS, -0.4f);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Loader: File not found: " + fileName);
            System.exit(-1);
        }
        int textureID = texture.getTextureID();

        return textureID;
    }



}