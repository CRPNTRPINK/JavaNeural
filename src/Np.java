import java.util.Arrays;

public class Np {
    public float[] dotH(int[] actions, float[][] weights) {
        float[] arrD = new float[weights.length];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                arrD[i] += weights[i][j] * actions[j];
            }
//            System.out.println(arrD[i]);
        }
        return sigmoid(arrD);
    }

    public float[] dotR(float[] actions, float[][] weights) {
        float[] arrR = new float[1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                arrR[i] += weights[i][j] * actions[j];
            }
//            System.out.println(arrR[i]);
        }
        return sigmoid(arrR);
    }
    public float[][] dotHB(float[][] w_1, float[][] w_2, float delta, float[] output_1, float[] output_2, int[] inputs, float rate){
        for (int i = 0; i < w_1.length; i ++){
            float error = w_2[0][i] * delta;
            float delta_n = error * (output_1[i] * (1 - output_1[i]));
            for (int j = 0; j < w_1[i].length; j++){
                w_1[i][j] -= inputs[j] * delta_n * rate;
            }
        }
        return w_1;
    }

    private float[] sigmoid(float[] s){
        for (int i = 0; i < s.length; i ++){
            s[i] = 1 / (1 + (float) Math.exp(-s[i]));
        }
        return s;
    }

    public static void main(String[] args) {
        Np np = new Np();
        float[] a = {0.77f, 0.78f};
        float[][] b = {{0.5f, 0.52f}};
        System.out.println(Arrays.toString(np.dotR(a, b)));
    }
}
