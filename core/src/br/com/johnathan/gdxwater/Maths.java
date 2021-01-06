package br.com.johnathan.gdxwater;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;


public class Maths {
    public static Matrix4 createTransformationMatrix(
            Vector3 translation,
            float rx,
            float ry,
            float rz,
            float scale) {
        Matrix4 matrix = new Matrix4();
        matrix.idt();
        matrix.translate(translation);
        matrix.rotate( new Vector3(1,0,0),(float) Math.toRadians(rx));
        matrix.rotate( new Vector3(0,1,0),(float) Math.toRadians(ry));
        matrix.rotate( new Vector3(0,0,1),(float) Math.toRadians(rz));
        matrix.scale(scale - 0.5f, scale - 0.5f , scale);
        return matrix;
    }

    public static Matrix4 createTransformationMatrixA(Vector3 translation, float rx, float ry, float rz, float scale) {
        Matrix4 matrix = new Matrix4();
        matrix.idt();
        matrix.translate(translation);
        matrix.rotate(rx, 1, 0, 0);
        matrix.rotate(ry, 0, 1, 0);
        matrix.rotate(rz, 0, 0, 1);
        matrix.scale(scale, scale, scale);

        return matrix;
    }



    public static Matrix4 createViewMatrix(Camera35 camera) {
        return camera.getViewMatrix();
    }


}
