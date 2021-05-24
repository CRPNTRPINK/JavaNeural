public class Neural {
    float rate;
    Np np = new Np();
    float[][] weights_1 = {{0.7491429f, 0.05202492f, -0.08062766f},
            {-0.35095611f, 0.77516409f, 0.26167366f}};
    float[][] weights_2 = {{-0.45092554f, -0.68026399f}};
    public Neural(float rate){
        this.rate = rate;
    }

    public static void main(String[] args) {
        float hide = 1 * 0.79f + 1 * 0.44f + 0 * 0.43f;
        float sigmoid = 1 / (1 + (float) Math.exp(-hide));
        System.out.println(hide);
        System.out.println(sigmoid);
    }

    public float go(int[] x){
        float[] output_1 = np.dotH(x, weights_1);
        float[] output_2 = np.dotR(output_1, weights_2);
        return output_2[0];
    }
    public void learn(int[] x, int expected){
        float[] output_1 = np.dotH(x, weights_1);
        float[] output_2 = np.dotR(output_1, weights_2);
        float error_2 = output_2[0] - expected;
        float delta_2 = error_2 * (output_1[0] * (1 - output_1[0]));
        weights_2[0][0] -= output_1[0] * delta_2 * rate;
        weights_2[0][1] -= output_1[1] * delta_2 * rate;
        weights_1 = np.dotHB(weights_1, weights_2, delta_2, output_1, output_2, x, rate);
    }
}
