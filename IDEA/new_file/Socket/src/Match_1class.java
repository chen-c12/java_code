import java.util.Random;

public class Match_1class {
    public static void main(String[] args) {
        M m = new M();
        m.ma();
    }
}

class M{
    void ma(){
        Random a = new Random();
        char w;
        char w1;
        RandomChar q1 = new RandomChar();
        for (int i=0;i<8000;i++){
            int a1 = a.nextInt(100);
            int a2 = a.nextInt(100);
            int a3 = a.nextInt(100);
            w = q1.randomChar();
            w1 = q1.randomChar();
            if (a1>a2&&(a1+a2)>a3&&a1+a2+a3<100&&a1-a2-a3>0){
                System.out.println(a1+""+w+""+a2+""+w1+""+a3+"=");
            }
        }
    }
}

class RandomChar{
    public static String str = "+-";
    public char randomChar(){
        char c;
        int index = (int)(Math.random()*2);
        c=str.charAt(index);
        return c;
    }
}