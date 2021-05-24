public class main {
    public static void main(String[] args) {
        /*Пойду ли я покупать одежду? Да, если у меня есть деньги, мне нужна одежда и на улице хорошая погода,
            Я точно не пойду, если у меня нет денег,
            Я не пойду, если на улице плохая погода и мне не нужна одежда
            Я пойду, если мне нужна одежда и у меня есть деньги, даже если на улице плохая погода
            Я пойду, если у меня есть деньги и на улице хорошая погода, даже если одежда мне не нужна
         */
        int[][] values = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}, {1, 0, 0}};
        int[] expected = {0, 0, 0, 0, 1, 1, 1, 0};
        Neural neural = new Neural(0.2f);
        for (int e = 0; e != 500000; e ++){
            for (int i = 0; i < values.length; i ++){
                neural.learn(values[i], expected[i]);
            }
        }
        for (int i = 0; i < values.length; i ++){
            System.out.println(neural.go(values[i]));
        }
        System.out.println("Истина ли, что я пойду в магазин за одеждой?");
        for (int i = 0; i < values.length; i ++){
            for (int j = 0; j < values[i].length; j ++){
                if (j == 0 & values[i][j] == 1) {
                    System.out.print("У меня есть деньги! ");
                }
                else if (j == 0 & values[i][j] == 0){
                    System.out.print("У меня нет денег! ");
                    }
                if (j == 1 & values[i][j] == 1){
                    System.out.print("Мне нужна одежда! ");
                }
                else if (j == 1 & values[i][j] == 0){
                    System.out.print("Мне не нужна одежда! ");
                }
                if (j == 2 & values[i][j] == 1){
                    System.out.print("На улице хорошая погода! - ");
                }
                else if (j == 2 & values[i][j] == 0){
                    System.out.print("На улице плохая погода! - ");
                }
            }
            System.out.println((neural.go(values[i]) > 0.5)? "Я пойду." + " Ожидаемый результат - " + ((expected[i] == 1)? "Я пойду" : "Я не пойду") : "Я не пойду." + " ожидаем результат  - " + ((expected[i] == 1)? "Я пойду" : "Я не пойду"));

        }
    }
}