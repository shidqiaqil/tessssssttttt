/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulated.anealing;

/**
 *
 * @author ASUS
 */
public class SimulatedAnealing {

    /**
     * @param args the command line arguments
     */
    public static double generate() {
        return -10+20*Math.random();
    }
    public static double ans(double x1,double x2){
        return -Math.abs(Math.sin(x1)*Math.cos(x2)*Math.exp(Math.abs(1-Math.sqrt(Math.pow(x1,2)+ Math.pow(x2,2))/Math.PI))); 
    }
    public static double p(double E, double T){
        return Math.exp(-E/T) ;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        double x1 , x2, T, current, next, a1, a2, E, Tawal,T2;
        T=200;
        T2=0.000385;
        Tawal=T;
        x1= generate();
        x2= generate();
        current= ans(x1,x2);
        while (T> 0.00538){
            a1= generate();
            a2= generate();
            next= ans(a1,a2);
            if (next < current){
                x1=a1;
                x2=a2;
                current=next;
            } else{
                E= next-current;
                if (p(E,T)>Math.random()){
                    x1=a1;
                    x2=a2;
                    current=next;
                }
            }
           T= T-T2;
        };
        System.out.println("x1 = "+x1);
        System.out.println("x2 = " + x2);
        System.out.println("Hasil = "+ current);
        System.out.println("T awal= "+ Tawal);
        System.out.println("T akhir= "+ T);
    }
    
}
